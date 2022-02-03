package org.fundaciobit.instanciagenerica.back.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalField;
import org.fundaciobit.instanciagenerica.back.controller.AbstractInstanciaGenericaController;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaFilterForm;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaForm;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;
import org.fundaciobit.instanciagenerica.model.fields.InstanciaGenericaFields;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping(value = "/admin/instanciagenericaproves")
@SessionAttributes(types = { InstanciaGenericaForm.class, InstanciaGenericaFilterForm.class })
public class InstanciaGenericaProvesAdminController extends InstanciaGenericaAdminController {

	public static final int NOU_TELEFON_COLUMN = 1;
	public static final int CALCULAT_COLUMN = -1;

	@Override
	public String getSessionAttributeFilterForm() {
		return "InstanciaGenericaProves_FilterForm";
	}

	@Override
	public InstanciaGenericaFilterForm getInstanciaGenericaFilterForm(Integer pagina, ModelAndView mav,
			HttpServletRequest request) throws I18NException {
		InstanciaGenericaFilterForm instanciaGenericaFilterForm;

		instanciaGenericaFilterForm = super.getInstanciaGenericaFilterForm(pagina, mav, request);

		if (instanciaGenericaFilterForm.isNou()) {

			// Telefon columna final
			AdditionalField<Long, String> adfield5 = new AdditionalField<Long, String>();
			adfield5.setPosition(NOU_TELEFON_COLUMN);
			adfield5.setValueField(InstanciaGenericaFields.SOLICITANTTELEFON);
			adfield5.setEscapeXml(true); // Convertira caracter XML en texto, si fuera false, el tractaria com XML
			adfield5.setCodeName(InstanciaGenericaFields.SOLICITANTTELEFON.fullName);
			adfield5.setOrderBy(InstanciaGenericaFields.SOLICITANTTELEFON);// Lo des +43

			instanciaGenericaFilterForm.addAdditionalField(adfield5);

			AdditionalField<Long, String> adfield4 = new AdditionalField<Long, String>();
			adfield4.setCodeName("calculat");
			adfield4.setPosition(CALCULAT_COLUMN);

			// Els valors s'ompliran al mètode postList()
			adfield4.setValueMap(new HashMap<Long, String>());
			instanciaGenericaFilterForm.addAdditionalField(adfield4);

			instanciaGenericaFilterForm.setVisibleMultipleSelection(true);
			instanciaGenericaFilterForm.setDeleteSelectedButtonVisible(false);

			instanciaGenericaFilterForm.addAdditionalButton(
					new AdditionalButton("fas fa-star", "mostrarinstancies", "javascript:ferSubmit()", "btn-primary"));
			// new AdditionalButton("class del icono de fontawesome5", "codigo del boton
			// (traducciones)" , "javascript:funcion definida en el jsp modificable()",
			// "class de bootstrap 4 (color)"));

			instanciaGenericaFilterForm.setAttachedAdditionalJspCode(true);

			// feralgunacosaambseleccionats

			instanciaGenericaFilterForm.setDeleteButtonVisible(true);

		}

		return instanciaGenericaFilterForm;
	}

	@Override
	public InstanciaGenericaForm getInstanciaGenericaForm(InstanciaGenericaJPA _jpa, boolean __isView,
			HttpServletRequest request, ModelAndView mav) throws I18NException {

		InstanciaGenericaForm instanciaGenericaForm = super.getInstanciaGenericaForm(_jpa, __isView, request, mav);

		if (instanciaGenericaForm.isNou()) {
			log.info("ADMIN PRV: Formulari per nou element");

		} else {
			log.info("ADMIN PRV: Formulari per editar un element:"
					+ instanciaGenericaForm.getInstanciaGenerica().getInstanciaGenericaID());
		}

		return instanciaGenericaForm;
	}

	@Override
	public void postList(HttpServletRequest request, ModelAndView mav, InstanciaGenericaFilterForm filterForm,
			List<InstanciaGenerica> list) throws I18NException {

		Map<Long, String> map;
		map = (Map<Long, String>) filterForm.getAdditionalField(CALCULAT_COLUMN).getValueMap();
		map.clear();

		long key;
		String value;
		for (InstanciaGenerica ig : list) {
			key = ig.getInstanciaGenericaID();
			value = ig.getSolicitantNom() + " - " + ig.getSolicitantEmail();

			map.put(key, value);
		}
	}

	@RequestMapping(value = "/feralgunacosaambseleccionats", method = RequestMethod.POST)
	public String feralgunacosaambseleccionats(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute InstanciaGenericaFilterForm filterForm) throws Exception {

		String[] seleccionats = filterForm.getSelectedItems();

		if (seleccionats != null && seleccionats.length != 0) {
			for (int i = 0; i < seleccionats.length; i++) {
				// fer coses per cada element dels seleccionats

				HtmlUtils.saveMessageError(request, "Has seleccionat la instancia: ID=" + seleccionats[i]);
//				redirect = eliminarInstanciaGenerica(stringToPK(seleccionats[i]), request, response);
			}
		}
		String redirect = getRedirectWhenDelete(request, null, null);

		return redirect;
	}

	@Override
	public void delete(HttpServletRequest request, InstanciaGenerica instanciaGenerica)
			throws Exception, I18NException {
		log.info("Inici delete web");

		instanciaGenericaLogicEjb.deleteFull(instanciaGenerica);

		log.info("Final delete web");
	}
	
	@Override
	public boolean isActiveDelete() {
		return true;
	}

}
