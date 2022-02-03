package org.fundaciobit.instanciagenerica.back.controller.all;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.instanciagenerica.back.controller.AbstractInstanciaGenericaController;
import org.fundaciobit.instanciagenerica.back.controller.InstanciaGenericaFilesFormManager;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaFilterForm;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaForm;
import org.fundaciobit.instanciagenerica.commons.utils.Constants;
import org.fundaciobit.instanciagenerica.model.entity.Fitxer;
import org.fundaciobit.instanciagenerica.model.fields.InstanciaGenericaFields;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
@RequestMapping(value = "/public/instanciagenerica")
@SessionAttributes(types = { InstanciaGenericaForm.class, InstanciaGenericaFilterForm.class })
public class InstanciaGenericaPublicController extends AbstractInstanciaGenericaController {

	@EJB(mappedName = org.fundaciobit.instanciagenerica.logic.FitxerLogicService.JNDI_NAME)
	protected org.fundaciobit.instanciagenerica.logic.FitxerLogicService fitxerLogicEjb;

	@Override
	protected FilesFormManager<Fitxer> getFilesFormManager() {
		return new InstanciaGenericaFilesFormManager(fitxerLogicEjb);
	}

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

		if (__isView) {
			InstanciaGenericaJPA ig = instanciaGenericaForm.getInstanciaGenerica();
			log.info("PUBLIC: Vista de la InstanciaGenerica ID=" + ig.getInstanciaGenericaID());
			Set<Field<?>> hidden = new HashSet(Arrays.asList(InstanciaGenericaFields.ALL_INSTANCIAGENERICA_FIELDS));

//			hidden.remove(INSTANCIAGENERICAID);
			hidden.remove(NUMREGISTRE);
//			hidden.remove(UUID);
			hidden.remove(DATACREACIO);

			hidden.remove(SOLICITANTTIPUSADMINID);
			hidden.remove(SOLICITANTADMINID);
			hidden.remove(SOLICITANTPERSONAFISICA);

			if (ig.isSolicitantPersonaFisica()) {
				hidden.remove(SOLICITANTNOM);
				hidden.remove(SOLICITANTLLINATGE1);
				hidden.remove(SOLICITANTLLINATGE2);
			} else {
				hidden.remove(SOLICITANTRAOSOCIAL);
			}

			hidden.remove(SOLICITANTDIRECCIO);
			hidden.remove(SOLICITANTEMAIL);
			hidden.remove(SOLICITANTTELEFON);

			hidden.remove(IDIOMAID);
			hidden.remove(EXPOSA);
			hidden.remove(SOLICITA);

			hidden.remove(FITXER1ID);
			hidden.remove(FITXER2ID);
			hidden.remove(FITXER3ID);
			hidden.remove(FITXER4ID);
			hidden.remove(FITXER5ID);
			hidden.remove(FITXER6ID);
			hidden.remove(FITXER7ID);
			hidden.remove(FITXER8ID);
			hidden.remove(FITXER9ID);

			boolean developer = false;
			if (developer && ig.getEstat() == Constants.ESTAT_ERROR) {
				hidden.remove(ESTAT);
				hidden.remove(ERROR);
				hidden.remove(EXCEPTION);
			}
			hidden.remove(DATAFINALITZACIO);

			instanciaGenericaForm.setHiddenFields(hidden);
		}

		if (instanciaGenericaForm.isNou()) {
			log.info("PUBLIC: Formulari per nou element");
			// TODO: Modificar tema cost

			String[] nombres = { "Paco", "Alex", "Toni", "Joan", "Marilen", "Oscar", "Pau", "Mateu", "Xavi", "Leo",
					"Giovanni", "Aragorn", "Naruto", "Sasuke", "Rafa" };
			String[] apellidos = { "Garcia", "Perez", "Gaita", "Macia", "Gonzalez", "Ronaldo", "Nadal", "Trobat",
					"Hernandez", "Messi", "Lo Celso", "Guiterrez del Alamo", "Sureda", "Martin", "Pernia", "Uzumaki",
					"Uchiha" };

			InstanciaGenericaJPA ig = instanciaGenericaForm.getInstanciaGenerica();

			Random rnd = new Random();
			String valorDado = rnd.nextInt(1000) + "";
			ig.setNumRegistre(valorDado);

			ig.setSolicitantTipusAdminID(rnd.nextInt(4)); // DNI i hope

			char[] c = { (char) ('A' + rnd.nextInt(26)) };
			String s = "" + c[0] + "";
			ig.setSolicitantAdminID((10000000 + rnd.nextInt(90000000)) + s);

			ig.setSolicitantPersonaFisica(true);

			String nom = nombres[rnd.nextInt(nombres.length)];
			String llinatge = apellidos[rnd.nextInt(apellidos.length)];
			String llinatge2 = apellidos[rnd.nextInt(apellidos.length)];
			ig.setSolicitantNom(nom);
			ig.setSolicitantLlinatge1(llinatge);
			ig.setSolicitantLlinatge2(llinatge2);

			ig.setSolicitantDireccio("Casa den " + nom);
//			ig.setSolicitantRaoSocial("INDRA");
			ig.setSolicitantTelefon(900000000 + rnd.nextInt(100000000) + "");
			ig.setSolicitantEmail(nom.toLowerCase() + "." + llinatge.toLowerCase() + "@common.com");

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

	// Despres de crear, a on ha d'anar
	@Override
	public String getRedirectWhenCreated(HttpServletRequest request, InstanciaGenericaForm instanciaGenericaForm) {
		return "redirect:" + getContextWeb() + "/v/" + instanciaGenericaForm.getInstanciaGenerica().getUuid();
	}

	@Override
	public boolean isActiveList() {
		return false;
	}

	@Override
	public boolean isActiveFormView() {
		return true;
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

	@Override
	@RequestMapping(value = "/view/{instanciaGenericaID}", method = RequestMethod.GET)
	public ModelAndView veureInstanciaGenericaGet(
			@PathVariable("instanciaGenericaID") java.lang.Long instanciaGenericaID, HttpServletRequest request,
			HttpServletResponse response) throws I18NException {
		// return editAndViewInstanciaGenericaGet(instanciaGenericaID, request,
		// response, true);
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}

	@RequestMapping(value = "/v/{uuid}", method = RequestMethod.GET)
	public ModelAndView veureInstanciaGenericaUuidGet(@PathVariable("uuid") String uuid, HttpServletRequest request,
			HttpServletResponse response) throws I18NException {

		long instanciaGenericaID = instanciaGenericaLogicEjb
				.executeQueryOne(InstanciaGenericaFields.INSTANCIAGENERICAID, InstanciaGenericaFields.UUID.equal(uuid));

		return editAndViewInstanciaGenericaGet(instanciaGenericaID, request, response, true);
	}

	@Override
	public InstanciaGenericaJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long instanciaGenericaID)
			throws I18NException {
		return (InstanciaGenericaJPA) instanciaGenericaLogicEjb.findByPrimaryKey(instanciaGenericaID);
	}

}
