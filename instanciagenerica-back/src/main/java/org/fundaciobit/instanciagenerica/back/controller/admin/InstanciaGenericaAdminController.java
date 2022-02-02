package org.fundaciobit.instanciagenerica.back.controller.admin;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.instanciagenerica.back.controller.AbstractInstanciaGenericaController;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaFilterForm;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaForm;
import org.fundaciobit.instanciagenerica.model.fields.InstanciaGenericaFields;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author ptrias
 *
 */

@Controller
@RequestMapping(value = "/admin/instanciagenerica")
@SessionAttributes(types = { InstanciaGenericaForm.class, InstanciaGenericaFilterForm.class })
public class InstanciaGenericaAdminController extends AbstractInstanciaGenericaController {

	@Override
	public InstanciaGenericaFilterForm getInstanciaGenericaFilterForm(Integer pagina, ModelAndView mav,
			HttpServletRequest request) throws I18NException {
		InstanciaGenericaFilterForm instanciaGenericaFilterForm;

		instanciaGenericaFilterForm = super.getInstanciaGenericaFilterForm(pagina, mav, request);

		if (instanciaGenericaFilterForm.isNou()) {
			instanciaGenericaFilterForm.addHiddenField(InstanciaGenericaFields.SOLICITANTTIPUSADMINID); // TIPO DE
			instanciaGenericaFilterForm.setOrderBy(_TABLE_MODEL);
		
		}

		return instanciaGenericaFilterForm;
	}

	@Override
	public InstanciaGenericaForm getInstanciaGenericaForm(InstanciaGenericaJPA _jpa, boolean __isView,
			HttpServletRequest request, ModelAndView mav) throws I18NException {

		InstanciaGenericaForm instanciaGenericaForm = super.getInstanciaGenericaForm(_jpa, __isView, request, mav);

		if (instanciaGenericaForm.isNou()) {
			log.info("ADMIN: Formulari per nou element");

			String valorDado = new Random().nextInt(1000) + "";
			instanciaGenericaForm.getInstanciaGenerica().setNumRegistre(valorDado);

			instanciaGenericaForm.getInstanciaGenerica().setSolicitantTipusAdminID(0);
			instanciaGenericaForm.getInstanciaGenerica().setSolicitantAdminID("12345678W"); // DNI

			instanciaGenericaForm.getInstanciaGenerica().setSolicitantNom("Paco");
			instanciaGenericaForm.getInstanciaGenerica().setSolicitantLlinatge1("Gaita");
			instanciaGenericaForm.getInstanciaGenerica().setSolicitantLlinatge2("Sureda");

			instanciaGenericaForm.getInstanciaGenerica().setSolicitantDireccio("Casa den Paco");
			instanciaGenericaForm.getInstanciaGenerica().setSolicitantRaoSocial("INDRA");
			instanciaGenericaForm.getInstanciaGenerica().setSolicitantTelefon("971971971");
			instanciaGenericaForm.getInstanciaGenerica().setSolicitantEmail("paco.gaita@admin.com");

			instanciaGenericaForm.getInstanciaGenerica().setExposa("Exposo les meves circunstancies");
			instanciaGenericaForm.getInstanciaGenerica().setSolicita("Solicit el seguent");

		} else {
			log.info("ADMIN: Formulari per editar un element:"
					+ instanciaGenericaForm.getInstanciaGenerica().getInstanciaGenericaID());
		}

		return instanciaGenericaForm;
	}

	@Override
	public boolean isAdmin() {
		return true;
	}

	@Override
	public boolean isActiveFormNew() {
		return false;
	}

	@Override
	public boolean isActiveFormView() {
		return true;
	}

}
