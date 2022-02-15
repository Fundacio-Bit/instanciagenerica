package org.fundaciobit.instanciagenerica.back.preparer;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import org.fundaciobit.instanciagenerica.back.security.LoginInfo;

import org.fundaciobit.instanciagenerica.commons.utils.Constants;
import org.fundaciobit.instanciagenerica.logic.InstanciaGenericaLogicService;
import org.fundaciobit.instanciagenerica.logic.utils.EjbManager;
import org.fundaciobit.instanciagenerica.model.fields.InstanciaGenericaFields;

/**
 * @author anadal
 *
 */
@RunAs(Constants.IGE_USER)
@Component
public class BasePreparer implements ViewPreparer, Constants {

	protected final Logger log = Logger.getLogger(getClass());

	@EJB(mappedName = org.fundaciobit.instanciagenerica.logic.InstanciaGenericaLogicService.JNDI_NAME)
	protected org.fundaciobit.instanciagenerica.logic.InstanciaGenericaLogicService instanciaGenericaLogicEjb;

	@Override
	public void execute(Request tilesRequest, AttributeContext attributeContext) throws PreparerException {

		Map<String, Object> request = tilesRequest.getContext("request");

		// Informació de Login
		try {
			LoginInfo loginInfo = LoginInfo.getInstance();
			// Posa dins la sessió la informació de Login
			request.put("loginInfo", loginInfo);
		} catch (Exception e) {
			// Anònim
		}

		// URL
		// TODO ficarho dins cache (veure Capperpare.java)
		HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		{

			request.put("urlActual", httpRequest.getServletPath());

			// Compatibilitat IE8
			String userAgent = httpRequest.getHeader("User-Agent");
			if (userAgent != null) {
				int index = userAgent.toUpperCase().indexOf("MSIE");
				if (index != -1) {
					try {
						String ieversion = userAgent.substring(index + 4, userAgent.indexOf(";", index + 4));
						if (Float.parseFloat(ieversion) < 9.0f) {
							request.put("IE8", true);
						}
					} catch (Throwable e) {
						log.debug(e);
					}
				}
			}
		}

		// Language
		Locale loc = LocaleContextHolder.getLocale();
		request.put("lang", loc.toString()); // LANG i si es necessari el country
		request.put("onlylang", loc.getLanguage()); // només el LANG

		// Pipella

		request.put("pipella", attributeContext.getAttribute("pipella"));

		// TODO GENAPP
		// Warning for each ROLE

		// AVIS ERRORS REGISTRE

		// Avisos Back
		try {
			Attribute at = attributeContext.getAttribute("pipella");
			log.info("Preparer: at=" + at);

			if (at != null && "admin".equals(at.toString())) {
				// Consulta per obtenir el numero d'errors
				log.info("Preparer: som ADMIN");
				// CONSULTA

				InstanciaGenericaLogicService instanciaGenericaLogicEjb = EjbManager.getInstanciaGenericaLogicEJB();

				log.info("instanciaGenericaLogicEjb: " + instanciaGenericaLogicEjb);

				Long numAvisos = instanciaGenericaLogicEjb
						.count(InstanciaGenericaFields.ESTAT.equal(Constants.ESTAT_ERROR));

				log.info("Preparer: numAvisos=" + numAvisos);

				httpRequest.getSession().setAttribute("numAvisos", numAvisos);
			}
		} catch (Throwable e) {
			log.error("Preparer:: Error fent la consulta de instancies no registrades: " + e.getMessage(), e);
		}

		// Avisos
		Map<String, Long> avisos = new HashMap<String, Long>();
		// avisos.put(rol, <<Number of warnings>>);
		request.put("avisos", avisos);

		if (attributeContext.getAttribute("menu") != null) {
			request.put("menu_tile", attributeContext.getAttribute("menu").toString());
		}

		// attributeContext.putAttribute("menu", new
		// Attribute("/WEB-INF/jsp/moduls/menu_inici.jsp"));

		request.put("contingut_tile", attributeContext.getAttribute("contingut").toString());

	}

}
