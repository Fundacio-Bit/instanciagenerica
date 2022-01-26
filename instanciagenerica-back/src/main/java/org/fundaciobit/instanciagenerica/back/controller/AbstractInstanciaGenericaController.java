package org.fundaciobit.instanciagenerica.back.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.LongField;
import org.fundaciobit.genapp.common.query.StringField;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.form.AdditionalField;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.instanciagenerica.back.controller.webdb.InstanciaGenericaController;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaFilterForm;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaForm;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;
import org.fundaciobit.instanciagenerica.model.fields.IdiomaFields;
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

public abstract class AbstractInstanciaGenericaController extends InstanciaGenericaController {

	public static final int NOU_TELEFON_COLUMN = 1;
	public static final int CALCULAT_COLUMN = -1;

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

			List <LongField> longFields = new ArrayList<LongField>();
			longFields.add(FITXER1ID);
			longFields.add(FITXER2ID);
			longFields.add(FITXER3ID);
			longFields.add(FITXER4ID);
			longFields.add(FITXER5ID);
			longFields.add(FITXER6ID);
			longFields.add(FITXER7ID);
			longFields.add(FITXER8ID);
			longFields.add(FITXER9ID);
			
			longFields.add(INSTANCIAGENERICAID);
			
			List <StringField> stringFields = new ArrayList<StringField>();
			stringFields.add(EXPOSA);
			stringFields.add(SOLICITA);
			
			stringFields.add(NUMREGISTRE);
			stringFields.add(UUID);

			stringFields.add(SOLICITANTDIRECCIO);

		
			for (int i = 0; i < longFields.size(); i++) {
				instanciaGenericaFilterForm.addHiddenField(longFields.get(i));
			}

			for (int i = 0; i < stringFields.size(); i++) {
				instanciaGenericaFilterForm.addHiddenField(stringFields.get(i));
			}

			instanciaGenericaFilterForm.addHiddenField(SOLICITANTTIPUSADMINID); // TIPO DE DOCUMENT
			instanciaGenericaFilterForm.addHiddenField(SOLICITANTPERSONAFISICA);

//			instanciaGenericaFilterForm.addHiddenField(InstanciaGenericaFields.);

			instanciaGenericaFilterForm.setAddButtonVisible(false);
			instanciaGenericaFilterForm.setDeleteButtonVisible(false);
			instanciaGenericaFilterForm.setDeleteSelectedButtonVisible(false);
			instanciaGenericaFilterForm.setEditButtonVisible(false);
			instanciaGenericaFilterForm.setVisibleMultipleSelection(false);

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

			instanciaGenericaFilterForm.setOrderBy(InstanciaGenericaFields.DATACREACIO.javaName);

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

		InstanciaGenericaForm instanciaGenericaForm = super.getInstanciaGenericaForm(_jpa, __isView, request, mav);

		if (instanciaGenericaForm.isNou()) {
			log.info("Formulari per nou element");

			instanciaGenericaForm.addHelpToField(SOLICITANTPERSONAFISICA,
					I18NUtils.tradueix("solicitantpersonafisica.ajuda"));

			// Per afegir codi adicional:
			// /instanciagenerica-back/src/main/webapp/WEB-INF/jsp/webdbmodificable/instanciaGenericaFormModificable.jsp
			instanciaGenericaForm.setAttachedAdditionalJspCode(true);

			instanciaGenericaForm.addHiddenField(NUMREGISTRE);
			instanciaGenericaForm.addHiddenField(UUID);

			instanciaGenericaForm.getInstanciaGenerica().setDataCreacio(new Timestamp(System.currentTimeMillis()));
			instanciaGenericaForm.addReadOnlyField(DATACREACIO);

			instanciaGenericaForm.getInstanciaGenerica().setSolicitantEmail("hola.bones@abstract.com");

		} else {
			log.info("Formulari per editar un element:"
					+ instanciaGenericaForm.getInstanciaGenerica().getInstanciaGenericaID());
		}

		instanciaGenericaForm.addHiddenField(INSTANCIAGENERICAID);

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

}
