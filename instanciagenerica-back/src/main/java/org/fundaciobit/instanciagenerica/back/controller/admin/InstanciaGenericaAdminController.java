package org.fundaciobit.instanciagenerica.back.controller.admin;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.instanciagenerica.back.controller.AbstractInstanciaGenericaController;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaFilterForm;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaForm;
import org.fundaciobit.instanciagenerica.hibernate.HibernateFileUtil;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;
import org.fundaciobit.instanciagenerica.model.fields.InstanciaGenericaFields;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.caib.regweb3.ws.api.v3.AsientoRegistralWs;
import es.caib.regweb3.ws.api.v3.AsientoWs;
import es.caib.regweb3.ws.api.v3.FileContentWs;
import es.caib.regweb3.ws.api.v3.FileInfoWs;
import es.caib.regweb3.ws.api.v3.InteresadoWs;
import es.caib.regweb3.ws.api.v3.JustificanteWs;

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
