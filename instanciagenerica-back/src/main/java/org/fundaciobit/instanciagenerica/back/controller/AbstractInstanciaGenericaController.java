package org.fundaciobit.instanciagenerica.back.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.instanciagenerica.back.controller.webdb.InstanciaGenericaController;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaFilterForm;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaForm;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;
import org.fundaciobit.instanciagenerica.model.fields.IdiomaFields;
import org.fundaciobit.instanciagenerica.model.fields.InstanciaGenericaFields;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.caib.regweb3.ws.api.v3.AsientoRegistralWs;
import es.caib.regweb3.ws.api.v3.AsientoWs;
import es.caib.regweb3.ws.api.v3.InteresadoWs;

/**
 * 
 * @author ptrias
 *
 */

public abstract class AbstractInstanciaGenericaController extends InstanciaGenericaController {

	@EJB(mappedName = org.fundaciobit.instanciagenerica.logic.InstanciaGenericaLogicService.JNDI_NAME)
	protected org.fundaciobit.instanciagenerica.logic.InstanciaGenericaLogicService instanciaGenericaLogicEjb;

	@Override
	public String getTileForm() {
		return "instanciaGenericaForm" + (isAdmin() ? "Admin" : "Common");
	}

	@Override
	public String getTileList() {
		return "instanciaGenericaList" + (isAdmin() ? "Admin" : "Common");
	}

	@Override
	public String getSessionAttributeFilterForm() {
		return "InstanciaGenerica" + (isAdmin() ? "Admin" : "Common") + "_FilterForm";
	}

	public abstract boolean isAdmin();

	@Override
	public InstanciaGenericaFilterForm getInstanciaGenericaFilterForm(Integer pagina, ModelAndView mav,
			HttpServletRequest request) throws I18NException {
		InstanciaGenericaFilterForm instanciaGenericaFilterForm;

		instanciaGenericaFilterForm = super.getInstanciaGenericaFilterForm(pagina, mav, request);

		if (instanciaGenericaFilterForm.isNou()) {

			instanciaGenericaFilterForm.addHiddenField(INSTANCIAGENERICAID);

			instanciaGenericaFilterForm.addHiddenField(NUMREGISTRE);
			instanciaGenericaFilterForm.addHiddenField(UUID);

			instanciaGenericaFilterForm.addHiddenField(SOLICITANTDIRECCIO);
			instanciaGenericaFilterForm.addHiddenField(SOLICITANTTIPUSADMINID); // TIPO DE DOCUMENT
			instanciaGenericaFilterForm.addHiddenField(SOLICITANTPERSONAFISICA);

			instanciaGenericaFilterForm.addHiddenField(EXPOSA);
			instanciaGenericaFilterForm.addHiddenField(SOLICITA);

			instanciaGenericaFilterForm.addHiddenField(FITXER1ID);
			instanciaGenericaFilterForm.addHiddenField(FITXER2ID);
			instanciaGenericaFilterForm.addHiddenField(FITXER3ID);
			instanciaGenericaFilterForm.addHiddenField(FITXER4ID);
			instanciaGenericaFilterForm.addHiddenField(FITXER5ID);
			instanciaGenericaFilterForm.addHiddenField(FITXER6ID);
			instanciaGenericaFilterForm.addHiddenField(FITXER7ID);
			instanciaGenericaFilterForm.addHiddenField(FITXER8ID);
			instanciaGenericaFilterForm.addHiddenField(FITXER9ID);

			instanciaGenericaFilterForm.addHiddenField(InstanciaGenericaFields.ESTAT);
			instanciaGenericaFilterForm.addHiddenField(InstanciaGenericaFields.ERROR);
			instanciaGenericaFilterForm.addHiddenField(InstanciaGenericaFields.EXCEPTION);
			instanciaGenericaFilterForm.addHiddenField(InstanciaGenericaFields.DATAFINALITZACIO);

			instanciaGenericaFilterForm.setAddButtonVisible(false);
			instanciaGenericaFilterForm.setDeleteButtonVisible(false);
			instanciaGenericaFilterForm.setDeleteSelectedButtonVisible(false);
			instanciaGenericaFilterForm.setEditButtonVisible(false);
			instanciaGenericaFilterForm.setVisibleMultipleSelection(false);

			instanciaGenericaFilterForm.setOrderBy(InstanciaGenericaFields.DATACREACIO.javaName);
			instanciaGenericaFilterForm.setOrderAsc(false);

			instanciaGenericaFilterForm.setVisibleExportList(true);
		}

		return instanciaGenericaFilterForm;
	}

	@Override
	public List<StringKeyValue> getReferenceListForSolicitantPersonaFisica(HttpServletRequest request, ModelAndView mav,
			Where where) throws I18NException {
		List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
		__tmp.add(new StringKeyValue("true", I18NUtils.tradueix("personafisica.true")));
		__tmp.add(new StringKeyValue("false", I18NUtils.tradueix("personafisica.false")));
		return __tmp;
	}

	@Override
	public List<StringKeyValue> getReferenceListForSolicitantTipusAdminID(HttpServletRequest request, ModelAndView mav,
			Where where) throws I18NException {
		List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

		for (int i = 1; i <= 4; i++) {
			__tmp.add(new StringKeyValue((String.valueOf(i)), I18NUtils.tradueix("tipusadminid." + i)));
		}
		return __tmp;
	}

	@Override
	public InstanciaGenericaForm getInstanciaGenericaForm(InstanciaGenericaJPA _jpa, boolean __isView,
			HttpServletRequest request, ModelAndView mav) throws I18NException {
//
//		Boolean initialized = (Boolean) session.getAttribute("inicialitzat");
//
//		if (initialized == null) {
//			HtmlUtils.saveMessageInfo(request, "MessageInfo : Benvingut a InstanciaGenerica");
//			session.setAttribute("inicialitzat", true);
//		}

		InstanciaGenericaForm instanciaGenericaForm = super.getInstanciaGenericaForm(_jpa, __isView, request, mav);
		instanciaGenericaForm.setAttachedAdditionalJspCode(true);

		if (__isView) {
			log.info("ABSTRACT: Vista de Instancia Generica amb id="
					+ instanciaGenericaForm.getInstanciaGenerica().getInstanciaGenericaID());
			// Ocultar campos que sean de la vista
		}

		if (instanciaGenericaForm.isNou()) {
			log.info("ABSTRACT: Formulari per nou element");

			instanciaGenericaForm.addHelpToField(SOLICITANTPERSONAFISICA,
					I18NUtils.tradueix("solicitantpersonafisica.ajuda"));

			// Per afegir codi adicional:
			// /instanciagenerica-back/src/main/webapp/WEB-INF/jsp/webdbmodificable/instanciaGenericaFormModificable.jsp
			instanciaGenericaForm.setAttachedAdditionalJspCode(true);

			instanciaGenericaForm.addHiddenField(NUMREGISTRE);
			instanciaGenericaForm.addHiddenField(UUID);

			instanciaGenericaForm.getInstanciaGenerica().setDataCreacio(new Timestamp(System.currentTimeMillis()));
			instanciaGenericaForm.addReadOnlyField(DATACREACIO);

			instanciaGenericaForm.addHiddenField(InstanciaGenericaFields.ESTAT);
			instanciaGenericaForm.addHiddenField(InstanciaGenericaFields.ERROR);
			instanciaGenericaForm.addHiddenField(InstanciaGenericaFields.EXCEPTION);
			instanciaGenericaForm.addHiddenField(InstanciaGenericaFields.DATAFINALITZACIO);

			instanciaGenericaForm.getInstanciaGenerica().setSolicitantTipusAdminID(2);
			instanciaGenericaForm.getInstanciaGenerica().setSolicitantPersonaFisica(true);

		} else {
			log.info("Formulari per editar un element:"
					+ instanciaGenericaForm.getInstanciaGenerica().getInstanciaGenericaID());
		}

		instanciaGenericaForm.addHiddenField(INSTANCIAGENERICAID);

		return instanciaGenericaForm;
	}

	@Override
	public List<StringKeyValue> getReferenceListForIdiomaID(HttpServletRequest request, ModelAndView mav, Where where)
			throws I18NException {

		return idiomaRefList.getReferenceList(IdiomaFields.IDIOMAID,
				Where.AND(where, IdiomaFields.SUPORTAT.equal(true)));
	}

	@Override
	public boolean isActiveFormEdit() {
		return false;
	}

	@Override
	public boolean isActiveDelete() {
		return false;
	}

	@RequestMapping(value = "/veureDetallsRegistre/{instanciaGenericaID}", method = RequestMethod.GET)
	public ModelAndView veureDetallsRegistre(@PathVariable("instanciaGenericaID") java.lang.Long instanciaGenericaID,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			InstanciaGenerica ig = instanciaGenericaLogicEjb.findByPrimaryKey(instanciaGenericaID);

			String numRegF = ig.getNumRegistre();
			String idioma = ig.getIdiomaID();
			String document = ig.getSolicitantAdminID();

			if (numRegF == null) {
				HtmlUtils.saveMessageError(request, "Error. Numero de registre no pot ser null.");

			} else {

				AsientoRegistralWs ar = instanciaGenericaLogicEjb.obtenerAsiento(numRegF);
				AsientoWs as = instanciaGenericaLogicEjb.obtenerAsientoCiudadano(numRegF, document, idioma);

				// TODO XXXXXXXXXXX GESIONAR NULL
				// log.error("\" -> Ha habido un error");

				log.info("		-> Número de registro: " + ar.getNumeroRegistroFormateado());

				ModelAndView mav = new ModelAndView("detallsregistre");
				mav.addObject("ar", ar);
				mav.addObject("presencial", ar.isPresencial());

				mav.addObject("as", as);
				mav.addObject("contexte", getContextWeb());

				int countPF = 0;
				int countPJ = 0;
				for (InteresadoWs item : as.getInteresados()) {
					if (item.getRepresentante() == null) {
						countPF++;
					} else {
						countPJ++;
					}
				}
				mav.addObject("countPF", countPF);
				mav.addObject("countPJ", countPJ);

				return mav;
			}
		} catch (I18NException e) {
			// TODO XXXXXXXXXXX Provar aquest tros de codi
			HtmlUtils.saveMessageError(request,
					"Error intentant obtennir informació d'un registre: " + I18NUtils.getMessage(e));
		}

		ModelAndView mav = new ModelAndView(new RedirectView(getContextWeb() + "/list", true));
		return mav;

	}
}
