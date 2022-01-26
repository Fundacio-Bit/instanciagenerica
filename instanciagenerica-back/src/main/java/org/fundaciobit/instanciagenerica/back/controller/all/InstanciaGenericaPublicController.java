package org.fundaciobit.instanciagenerica.back.controller.all;

import java.util.Random;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.instanciagenerica.back.controller.AbstractInstanciaGenericaController;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaFilterForm;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaForm;
import org.fundaciobit.instanciagenerica.model.fields.InstanciaGenericaFields;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author ptrias
 *
 */

@Controller
@RequestMapping(value = "/public/instanciagenerica")
@SessionAttributes(types = { InstanciaGenericaForm.class, InstanciaGenericaFilterForm.class })
public class InstanciaGenericaPublicController extends AbstractInstanciaGenericaController {

	@EJB(mappedName = org.fundaciobit.instanciagenerica.logic.InstanciaGenericaLogicService.JNDI_NAME)
	protected org.fundaciobit.instanciagenerica.logic.InstanciaGenericaLogicService instanciaGenericaLogicEjb;

	@Override
	public InstanciaGenericaFilterForm getInstanciaGenericaFilterForm(Integer pagina, ModelAndView mav,
			HttpServletRequest request) throws I18NException {
		InstanciaGenericaFilterForm instanciaGenericaFilterForm;

		instanciaGenericaFilterForm = super.getInstanciaGenericaFilterForm(pagina, mav, request);

		if (instanciaGenericaFilterForm.isNou()) {
			instanciaGenericaFilterForm.addHiddenField(InstanciaGenericaFields.SOLICITANTTIPUSADMINID); // TIPO DE
		}

		return instanciaGenericaFilterForm;
	}

	@Override
	public InstanciaGenericaForm getInstanciaGenericaForm(InstanciaGenericaJPA _jpa, boolean __isView,
			HttpServletRequest request, ModelAndView mav) throws I18NException {

		InstanciaGenericaForm instanciaGenericaForm = super.getInstanciaGenericaForm(_jpa, __isView, request, mav);

		mav.addObject("mostrarScript", true);

		if (instanciaGenericaForm.isNou()) {
			log.info("PUBLIC: Formulari per nou element");
			// TODO: Modificar tema cost

			InstanciaGenericaJPA ig = instanciaGenericaForm.getInstanciaGenerica();
			
			String valorDado = new Random().nextInt(1000) + "";
			ig.setNumRegistre(valorDado);

			ig.setSolicitantTipusAdminID(2); // DNI i hope
			ig.setSolicitantAdminID("87654323A");

			ig.setSolicitantPersonaFisica(true);

			ig.setSolicitantNom("Alex");
			ig.setSolicitantLlinatge1("Macià");
			ig.setSolicitantLlinatge2("Martín");

			ig.setSolicitantDireccio("Casa den Alex");
			ig.setSolicitantRaoSocial("INDRA");
			ig.setSolicitantTelefon("123654879");
			ig.setSolicitantEmail("alex.macia@common.com");

			ig.setExposa("Expongo mis circunstancias");
			ig.setSolicita("Solicito que se cumplan mis demandas");

		} else {
			log.info("PUBLIC: Formulari per editar un element:"
					+ instanciaGenericaForm.getInstanciaGenerica().getInstanciaGenericaID());
		}

		return instanciaGenericaForm;
	}

	@Override
	public boolean isAdmin() {
		return false;
	}

	@Override
	public InstanciaGenericaJPA create(HttpServletRequest request, InstanciaGenericaJPA instanciaGenerica)
			throws Exception, I18NException, I18NValidationException {
		return (InstanciaGenericaJPA) instanciaGenericaLogicEjb.create(instanciaGenerica);
	}

	@Override
	public boolean isActiveList() {
		return false;
	}

	@Override
	public boolean isActiveFormView() {
		return false;
	}

	// Despres de crear, a on ha d'anar
	@Override
	public String getRedirectWhenCreated(HttpServletRequest request, InstanciaGenericaForm instanciaGenericaForm) {
		return "redirect:/";
	}

	
	@Override
	public void postValidate(HttpServletRequest request, InstanciaGenericaForm instanciaGenericaForm,
			BindingResult result) throws I18NException {

		InstanciaGenericaJPA ig = instanciaGenericaForm.getInstanciaGenerica();

		if (ig.isSolicitantPersonaFisica()) {
			
			ig.setSolicitantRaoSocial(null);
			
			if (ig.getSolicitantNom() == null || ig.getSolicitantNom().trim().length() == 0) {
				result.rejectValue(get(InstanciaGenericaFields.SOLICITANTNOM), "genapp.validation.required",
						new String[] { I18NUtils.tradueix(get(InstanciaGenericaFields.SOLICITANTNOM)) }, null);
			}

			if (ig.getSolicitantLlinatge1() == null || ig.getSolicitantLlinatge1().trim().length() == 0) {
				result.rejectValue(get(InstanciaGenericaFields.SOLICITANTLLINATGE1), "genapp.validation.required",
						new String[] { I18NUtils.tradueix(get(InstanciaGenericaFields.SOLICITANTLLINATGE1)) }, null);
			}

		} else { // persona juridica

			ig.setSolicitantNom(null);
			ig.setSolicitantLlinatge1(null);
			ig.setSolicitantLlinatge2(null);
			
			if (ig.getSolicitantRaoSocial() == null || ig.getSolicitantRaoSocial().trim().length() == 0) {
				result.rejectValue(get(InstanciaGenericaFields.SOLICITANTRAOSOCIAL), "genapp.validation.required",
						new String[] { I18NUtils.tradueix(get(InstanciaGenericaFields.SOLICITANTRAOSOCIAL)) }, null);
			}
		}
	}

}
