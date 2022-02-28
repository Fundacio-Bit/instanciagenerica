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

	public static String encriptar(Long msg) {
		return HibernateFileUtil.encryptString(String.valueOf(msg));
	}

	public static Long desencriptar(String msg) {
		return Long.parseLong(HibernateFileUtil.decryptString(msg));
	}

	@RequestMapping("/descarregarJustificant/{InstanciaGenericaID}")
	public void descarregarJustificant(@PathVariable("InstanciaGenericaID") Long InstanciaGenericaID,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			InstanciaGenerica ig = instanciaGenericaLogicEjb.findByPrimaryKey(InstanciaGenericaID);

			String numRegF = ig.getNumRegistre();

			if (numRegF == null) {
				HtmlUtils.saveMessageError(request, "Error. Numero de registre no pot ser null.");

			} else {
				JustificanteWs just = instanciaGenericaLogicEjb.getJustificant(numRegF);
				byte[] contingut = just.getJustificante();
				OutputStream output = null;

				String filename = "Justificant registra InstanciaGenerica-" + InstanciaGenericaID;

				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline; filename=\"" + filename + "\"");
				response.setContentLength((int) contingut.length);

				output = response.getOutputStream();

				output.write(contingut);
				output.close();
			}
		} catch (I18NException e) {
			// TODO XXXXXXXXXXX Provar aquest tros de codi
			HtmlUtils.saveMessageError(request, "Error intentant obtennir Justificant: " + I18NUtils.getMessage(e));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			HtmlUtils.saveMessageError(request, "Error intentant obtennir Justificant: " + e.getMessage());
		}
	}

	@RequestMapping("/descarregarFitxer/{idFitxer}")
	public void fullDownloadByte(@PathVariable("idFitxer") String idFitxerEnc, HttpServletRequest request,
			HttpServletResponse response) {
		log.info("\nEmpieza descarregarFitxer");

		try {
			Long idFitxer = desencriptar(idFitxerEnc);
			String idioma = LocaleContextHolder.getLocale().getLanguage();

			FileContentWs anexe = instanciaGenericaLogicEjb.getAnexe(idFitxer, idioma);

			String filename = anexe.getFileInfoWs().getFilename();
			String contentType = anexe.getFileInfoWs().getMime();

			byte[] contingut = anexe.getData();
			OutputStream output = null;

			log.info("\nEstamos en el try");

			if (filename == null) {
				filename = "file"; // arxiu.getNombre()
			}

			response.setContentType(contentType);
			response.setHeader("Content-Disposition", "inline; filename=\"" + filename + "\"");
			response.setContentLength((int) contingut.length);

			output = response.getOutputStream();

			output.write(contingut);

			log.info("\nCerramos todo");
			output.close();

			log.info("\nTerminamos Try");
		} catch (Exception e) {
			String msg = "Error descarregant el fitxer (" + e.getMessage() + ")";
			log.error(msg, e);
			response.setHeader("MsgInstanciaGenerica", msg);
			try {
				response.sendError(response.SC_NOT_FOUND);
			} catch (IOException e1) {
				response.setStatus(response.SC_NOT_FOUND);
			}
		} catch (I18NException e) {
			log.error("Error WsI18NException ");
			HtmlUtils.saveMessageError(request, "Error intentant descarregar el fitxer: " + I18NUtils.getMessage(e));

			try {
				response.sendRedirect(request.getContextPath() + getContextWeb() + "/list");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		log.info("\nSe acabó descarregarFitxer");
	}

}
