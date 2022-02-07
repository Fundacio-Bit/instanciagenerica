package org.fundaciobit.instanciagenerica.back.controller.admin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalField;
import org.fundaciobit.instanciagenerica.back.controller.AbstractInstanciaGenericaController;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaFilterForm;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaForm;
import org.fundaciobit.instanciagenerica.commons.utils.Constants;
import org.fundaciobit.instanciagenerica.model.IInstanciaGenericaDaoManagers;
import org.fundaciobit.instanciagenerica.model.dao.IInstanciaGenericaManager;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;
import org.fundaciobit.instanciagenerica.model.fields.IdiomaFields;
import org.fundaciobit.instanciagenerica.model.fields.InstanciaGenericaFields;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author ptrias
 *
 */

@Controller
@RequestMapping(value = "/admin/instanciagenericaerrors")
@SessionAttributes(types = { InstanciaGenericaForm.class, InstanciaGenericaFilterForm.class })
public class InstanciaGenericaErrorsAdminController extends InstanciaGenericaAdminController {

	@Override
	public String getSessionAttributeFilterForm() {
		return "InstanciaGenericaErrors_FilterForm";
	}

	@Override
	public InstanciaGenericaFilterForm getInstanciaGenericaFilterForm(Integer pagina, ModelAndView mav,
			HttpServletRequest request) throws I18NException {

		InstanciaGenericaFilterForm instanciaGenericaFilterForm;

		instanciaGenericaFilterForm = super.getInstanciaGenericaFilterForm(pagina, mav, request);

		if (instanciaGenericaFilterForm.isNou()) {

			Set<Field<?>> hidden = new HashSet(Arrays.asList(InstanciaGenericaFields.ALL_INSTANCIAGENERICA_FIELDS));
			hidden.remove(InstanciaGenericaFields.INSTANCIAGENERICAID);
			hidden.remove(InstanciaGenericaFields.DATACREACIO);
			hidden.remove(InstanciaGenericaFields.DATAFINALITZACIO);
			hidden.remove(InstanciaGenericaFields.ERROR);
			hidden.remove(InstanciaGenericaFields.NUMREGISTRE);
			hidden.remove(InstanciaGenericaFields.UUID);
			hidden.remove(InstanciaGenericaFields.SOLICITANTEMAIL);
			hidden.remove(InstanciaGenericaFields.ERROR);

			instanciaGenericaFilterForm.setHiddenFields(hidden);

			instanciaGenericaFilterForm.addAdditionalButtonForEachItem(new AdditionalButton("fas fa-redo",
					"regisitre.reintentar", getContextWeb() + "/reintentarregistre/{0}", "btn-primary"));
			// new AdditionalButton("class del icono de fontawesome5", "codigo del boton
			// (traducciones)" , "javascript:funcion definida en el jsp modificable()",
			// "class de bootstrap 4 (color)"));

		}

		return instanciaGenericaFilterForm;
	}

	@Override
	public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
		return InstanciaGenericaFields.ESTAT.equal(Constants.ESTAT_ERROR);
	}

	@Override
	public String getEntityNameCode() {
		return "instancesnoregistrades";
	}

	@Override
	public String getEntityNameCodePlural() {
		return "instancesnoregistrades.plural";
	}

	@RequestMapping(value = "/reintentarregistre/{instanciaGenericaID}", method = RequestMethod.GET)
	public String reintentarRegistre(@PathVariable("instanciaGenericaID") java.lang.Long instanciaGenericaID,
			HttpServletRequest request, HttpServletResponse response) throws I18NException {

		InstanciaGenerica ig = instanciaGenericaLogicEjb.findByPrimaryKey(instanciaGenericaID);

		ig = instanciaGenericaLogicEjb.registrarInstanciaGenerica(ig);

		if (ig.getEstat() == Constants.ESTAT_ERROR) {
			HtmlUtils.saveMessageError(request, "No s'ha pogut registrar la seva Instancia Genèrica (ID="
					+ ig.getInstanciaGenericaID() + "). Error:" + ig.getError());
		} else {
			HtmlUtils.saveMessageSuccess(request,
					"La instancia ID=" + ig.getInstanciaGenericaID() + " s'ha registrat correctament");
		}

		return "redirect:" + getContextWeb() + "/list";
	}

}
