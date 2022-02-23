
package org.fundaciobit.instanciagenerica.logic;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Status;
import javax.transaction.TransactionSynchronizationRegistry;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;

import javax.xml.ws.BindingProvider;

import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.instanciagenerica.model.entity.Fitxer;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;

import es.caib.regweb3.ws.api.v3.AnexoWs;
import es.caib.regweb3.ws.api.v3.AsientoRegistralWs;
import es.caib.regweb3.ws.api.v3.AsientoWs;
import es.caib.regweb3.ws.api.v3.DatosInteresadoWs;
import es.caib.regweb3.ws.api.v3.FileContentWs;
import es.caib.regweb3.ws.api.v3.InteresadoWs;
import es.caib.regweb3.ws.api.v3.RegWebAsientoRegistralWs;
import es.caib.regweb3.ws.api.v3.RegWebAsientoRegistralWsService;

import es.caib.regweb3.ws.api.v3.WsI18NException;
import es.caib.regweb3.ws.api.v3.WsValidationException;

import org.fundaciobit.instanciagenerica.commons.utils.Configuracio;
import org.fundaciobit.instanciagenerica.commons.utils.Constants;
import org.fundaciobit.instanciagenerica.ejb.InstanciaGenericaEJB;

/**
 * 
 * @author ptrias
 *
 */
@Stateless
public class InstanciaGenericaLogicEJB extends InstanciaGenericaEJB implements InstanciaGenericaLogicService {

	@EJB(mappedName = org.fundaciobit.instanciagenerica.ejb.FitxerService.JNDI_NAME)
	protected org.fundaciobit.instanciagenerica.ejb.FitxerService fitxerEjb;

	@Resource(mappedName = "java:comp/TransactionSynchronizationRegistry")
	protected TransactionSynchronizationRegistry transactionSynchronizationRegistry;

	@Override
	@PermitAll
	public InstanciaGenerica create(InstanciaGenerica instance) throws I18NException {

		String uuid = java.util.UUID.randomUUID().toString();

		instance.setUuid(uuid.replace("-", ""));

		InstanciaGenerica ig = super.create(instance);

		registrarInstanciaGenerica(ig);

		return ig;
	}

	@Override
	public InstanciaGenerica registrarInstanciaGenerica(InstanciaGenerica ig) throws I18NException {

		String codiDir3 = Configuracio.getRegistreEntidad();

		String oficinaCodi = Configuracio.getRegistreOficinaDestiCodi();
		String unitatTramitacioCodi = Configuracio.getRegistreUnitatTramitacioDestiCodi();

		boolean justificant = false;
		boolean distribuir = false;

		InfoRegistre ir = cridadaRegistre(codiDir3, justificant, distribuir, oficinaCodi, unitatTramitacioCodi, ig);

		if (ir.getEstat() == InfoRegistre.ESTAT_ERROR) {
			ig.setEstat(Constants.ESTAT_ERROR);
			ig.setError(ir.getError());
			ig.setException(ir.getExccepcio());

			// Aqui habría que añadir un mensaje de "Error con llamada a registro"
		} else {
			ig.setEstat(Constants.ESTAT_FINALITZAT);
			ig.setNumRegistre(ir.getNumRegistre());
		}
		ig.setDatafinalitzacio(new Timestamp(System.currentTimeMillis()));

		this.update(ig);
		return ig;
	}

	public InfoRegistre cridadaRegistre(String codiDir3, boolean justificant, boolean distribuir, String oficinaCodi_,
			String unitatCodi_, InstanciaGenerica ig) {

		String entitatCodi = codiDir3;

		String entitatRegistralIniciCodi = oficinaCodi_;
		String entitatRegistralOrigenCodi = oficinaCodi_;
		String entitatRegistralDestiCodi = oficinaCodi_;

		String unitatTramitacioOrigenCodi = unitatCodi_;
		String unitatTramitacioDestiCodi = unitatCodi_;

		try {

			log.info("Cridam API per REGISTRAR INSTANCIA");

			RegWebAsientoRegistralWs asientoApi = getApiRegistre();
			log.info("JA TENIM API per REGISTRAR INSTANCIA");

			// Codi dir3 de l'entitat de registre.fundaciobit.org
			Long idSesion = asientoApi.obtenerSesionRegistro(entitatCodi);
			log.info("	->	idSession: " + idSesion);

			// TODO Posar tots els camps.
			AsientoRegistralWs asientoRegistral = new AsientoRegistralWs();
			asientoRegistral.setAplicacion(null);
			asientoRegistral.setAplicacionTelematica(null);
			asientoRegistral.setCodigoAsunto(null);
			asientoRegistral.setCodigoAsuntoDenominacion(null);

			asientoRegistral.setCodigoEntidadRegistralProcesado(null);
			asientoRegistral.setCodigoSia(null);// Codi del tràmit administratiu corresponent a l’assentament registral.
												// https://administracionelectronica.gob.es/ctt/sia

			asientoRegistral.setCodigoUsuario(Configuracio.getRegistreUser());

			asientoRegistral.setDecodificacionEntidadRegistralProcesado(codiDir3);
			asientoRegistral.setEntidadCodigo(entitatCodi);
			asientoRegistral.setEntidadDenominacion(null);

			asientoRegistral.setEntidadRegistralDestinoCodigo(entitatRegistralDestiCodi);
			asientoRegistral.setEntidadRegistralDestinoDenominacion(null);

			asientoRegistral.setEntidadRegistralInicioCodigo(entitatRegistralIniciCodi);
			asientoRegistral.setEntidadRegistralInicioDenominacion(null);

			asientoRegistral.setEntidadRegistralOrigenCodigo(entitatRegistralOrigenCodi);
			asientoRegistral.setEntidadRegistralOrigenDenominacion(null);

			asientoRegistral.setExpone(ig.getExposa());

			final Long idioma = ig.getIdiomaID().equals("ca") ? 1L : 2L;
			asientoRegistral.setIdioma(idioma);// Vol un long, el nostre idioma es un String

			asientoRegistral.setLibroCodigo(null); // Codi del llibre a on es vol fer l’assentament.
			asientoRegistral.setNumeroExpediente(null);// Número de l'expedient a que fa referència l'assentament.
			asientoRegistral.setNumeroTransporte(null);// Número del transport d'entrada.
			asientoRegistral.setObservaciones(null);

			asientoRegistral.setPresencial(false);

			asientoRegistral.setReferenciaExterna(ig.getInstanciaGenericaID() + "");// Referència externa del tràmit
																					// (matrícula de
			// cotxe, rebut,...)
			asientoRegistral.setResumen("Registre de una instancia genèrica a al registre de la fundació bit");
			asientoRegistral.setSolicita(ig.getSolicita());

			asientoRegistral.setTipoEnvioDocumentacion(null);// Indica si la documentació adjunta al registre s’envia
																// embebida dins el propi missatge SICRES o a traves del
																// «Sistema de Referencia Única de Documentación».

			asientoRegistral.setTipoDocumentacionFisicaCodigo(3L);// 3: Documentació adjunta digitalitzada
			asientoRegistral.setTipoRegistro(1L);// 1: Registre d'entrada
			asientoRegistral.setTipoTransporte(null); // Forma d'arribada de l’assentament de tipus «Entrada»

			asientoRegistral.setUnidadTramitacionDestinoCodigo(unitatTramitacioDestiCodi);
			asientoRegistral.setUnidadTramitacionDestinoDenominacion(null);

			asientoRegistral.setUnidadTramitacionOrigenCodigo(unitatTramitacioOrigenCodi);
			asientoRegistral.setUnidadTramitacionOrigenDenominacion(null);

			// TODO XXXXXXXXXXXXXX if isPersonaFisica, tratarlo de una manera, else, de
			// otra.
			String[] tipus = { "", "N", "E", "P", "X", "C", "0" };

			InteresadoWs i = new InteresadoWs();

			if (ig.isSolicitantPersonaFisica()) {
				DatosInteresadoWs interesado = new DatosInteresadoWs();

				interesado.setTipoInteresado(2L);
				interesado.setApellido1(ig.getSolicitantLlinatge1());
				interesado.setApellido2(ig.getSolicitantLlinatge2());

				interesado.setCanal(null);
				interesado.setCodigoDire(null);
				interesado.setCp(null);

				interesado.setDireccion(ig.getSolicitantDireccio());
				interesado.setDireccionElectronica(ig.getSolicitantEmail());
				interesado.setDocumento(ig.getSolicitantAdminID());
				interesado.setEmail(ig.getSolicitantEmail());

				interesado.setLocalidad(null);
				interesado.setNombre(ig.getSolicitantNom());

				interesado.setObservaciones(null);
				interesado.setPais(null);
				interesado.setProvincia(null);

				interesado.setRazonSocial(ig.getSolicitantRaoSocial());
				interesado.setTelefono(ig.getSolicitantTelefon());

				String tipusAdminId = tipus[ig.getSolicitantTipusAdminID()];
				interesado.setTipoDocumentoIdentificacion(tipusAdminId);

				i.setInteresado(interesado);
				i.setRepresentante(null);
			} else {
				DatosInteresadoWs interesado = new DatosInteresadoWs();
				DatosInteresadoWs representante = new DatosInteresadoWs();

				interesado.setTipoInteresado(3L);
				interesado.setApellido1(null);
				interesado.setApellido2(null);

				interesado.setCanal(null);
				interesado.setCodigoDire(null);
				interesado.setCp(null);

				interesado.setDireccion(ig.getSolicitantDireccio());
				interesado.setDireccionElectronica(null);
				interesado.setDocumento(ig.getSolicitantCif());
				interesado.setEmail(null);

				interesado.setLocalidad(null);
				interesado.setNombre(null);

				interesado.setObservaciones(null);
				interesado.setPais(null);
				interesado.setProvincia(null);

				interesado.setRazonSocial(ig.getSolicitantRaoSocial());
				interesado.setTelefono(ig.getSolicitantTelefon());
				interesado.setTipoDocumentoIdentificacion("C");

				////////////////////////////////////////////////////////////////////////////

				representante.setTipoInteresado(2L);
				representante.setApellido1(ig.getSolicitantLlinatge1());
				representante.setApellido2(ig.getSolicitantLlinatge2());

				representante.setCanal(null);
				representante.setCodigoDire(null);
				representante.setCp(null);

				representante.setDireccion(ig.getSolicitantDireccio());
				representante.setDireccionElectronica(ig.getSolicitantEmail());
				representante.setDocumento(ig.getSolicitantAdminID());
				representante.setEmail(ig.getSolicitantEmail());

				representante.setLocalidad(null);
				representante.setNombre(ig.getSolicitantNom());

				representante.setObservaciones(null);
				representante.setPais(null);
				representante.setProvincia(null);

				representante.setRazonSocial(null);
				representante.setTelefono(null);

				String tipusAdminId2 = tipus[ig.getSolicitantTipusAdminID()];
				representante.setTipoDocumentoIdentificacion(tipusAdminId2);

				i.setInteresado(interesado);// Empresa
				i.setRepresentante(representante);// Persona
			}

			asientoRegistral.getInteresados().add(i);

			Fitxer[] fitxers = new Fitxer[] { ig.getFitxer1(), ig.getFitxer2(), ig.getFitxer3(), ig.getFitxer4(),
					ig.getFitxer5(), ig.getFitxer6(), ig.getFitxer7(), ig.getFitxer8(), ig.getFitxer9() };

			int idx = 0;
			for (Fitxer f : fitxers) {
				if (f != null) {
					idx++;
					AnexoWs anex = new AnexoWs();

					byte[] fichero = FileSystemManager.getFileContent(f.getFitxerID());

					anex.setConfidencial(false);
					anex.setCsv(null);
					anex.setFechaCaptura(new Timestamp(System.currentTimeMillis()));

					anex.setFicheroAnexado(fichero);

					anex.setFirmaAnexada(null);
					anex.setHash(null);
					anex.setJustificante(false);
					anex.setModoFirma(0); // 0: Document sense firmar
					anex.setNombreFicheroAnexado(f.getNom());
					anex.setNombreFirmaAnexada(null);
					anex.setObservaciones(null);
					anex.setOrigenCiudadanoAdmin(0);
					anex.setTamanoFichero(0);
					anex.setTipoDocumental("TD99");
					anex.setTipoDocumento("02");
					anex.setTipoMIMEFicheroAnexado(f.getMime());
					anex.setTipoMIMEFirmaAnexada(null);
					anex.setTitulo(f.getNom());
					anex.setValidezDocumento("01");

					log.info("	-> Afegirem el fitxer numero " + idx);
					asientoRegistral.getAnexos().add(anex);
					log.info("	-> Hem afegit el fitxer numero (" + idx + "): "
							+ asientoRegistral.getAnexos().get(idx - 1));

				}
			}

			asientoRegistral.setVersion(null); // Versió de la aplicació que fa l’assentament. Camp intern que es omplit
												// per REGWEB3.

			log.info("REGISTRAM AMB API");

			final Long tipoOperacion = null;
			AsientoRegistralWs asiento = asientoApi.crearAsientoRegistral(idSesion, codiDir3, asientoRegistral,
					tipoOperacion, justificant, distribuir);

			log.info("HA RETORNAT AIXÓ: " + asiento);

			String numRegF = asiento.getNumeroRegistroFormateado();

			if (numRegF == null) {
				return new InfoRegistre("El numero de registre retornat es null", null);
			}

			AsientoRegistralWs as = asientoApi.obtenerAsientoRegistral(codiDir3, numRegF, 1L, false);

			if (as.getEstado() == 1) {
				return new InfoRegistre(asiento.getNumeroRegistroFormateado());
			} else {
				return new InfoRegistre(asiento.getCodigoError(), asiento.getDescripcionError());
			}

		} catch (Throwable e) {

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sStackTrace = sw.toString(); // stack trace as a string
			String msg = "Error no contrrolat fent cridada a registre: " + e.getMessage();
			log.error(msg, e);
			return new InfoRegistre(msg, sStackTrace);
		}

	}
//	public InfoRegistre cridarAPIRegistre(InstanciaGenerica ig) {
//		// Pot pasar 3 coses: Ok, Error, Exception
//
//		try {
//			// Simulam cridada a registre amb error
//
//			Random rand = new Random();
//			int int_random = rand.nextInt(1000);
//
//			if (int_random < 500) {
//				return new InfoRegistre("Error numeric, " + int_random + " ha de ser major que 500", null);
//			} else {
//				return new InfoRegistre("" + int_random);
//			}
//
//		} catch (Exception e) {
//
//			StringWriter sw = new StringWriter();
//			PrintWriter pw = new PrintWriter(sw);
//			e.printStackTrace(pw);
//			String sStackTrace = sw.toString(); // stack trace as a string
//
//			return new InfoRegistre(e.getMessage(), sStackTrace);
//
//		}
//
//	}

	public static class InfoRegistre {

		/* Valors possibles de estat */

		public static final int ESTAT_OK = 0;
		public static final int ESTAT_ERROR = -1;

		int estat;
		String error;
		String numRegistre;
		String exccepcio;

		public String getExccepcio() {
			return exccepcio;
		}

		public void setExccepcio(String exccepcio) {
			this.exccepcio = exccepcio;
		}

		public InfoRegistre(String numRegistre) {
			super();
			this.estat = ESTAT_OK;
			this.error = null;
			this.numRegistre = numRegistre;
			this.exccepcio = null;
		}

		public InfoRegistre(String error, String excepcio) {
			super();
			this.estat = ESTAT_ERROR;
			this.error = error;
			this.numRegistre = null;
			this.exccepcio = excepcio;
		}

		public int getEstat() {
			return estat;
		}

		public void setEstat(int estat) {
			this.estat = estat;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		public String getNumRegistre() {
			return numRegistre;
		}

		public void setNumRegistre(String numRegistre) {
			this.numRegistre = numRegistre;
		}

	}

	@Override
	@PermitAll
	public InstanciaGenericaJPA findByPrimaryKey(Long _ID_) {
		return (InstanciaGenericaJPA) super.findByPrimaryKey(_ID_);
	}

	@Override
	@PermitAll
	public void deleteFull(InstanciaGenerica instanciaGenerica) throws I18NException {
		log.info("Comença deleteFull");

		// Borram instancia a BD
		delete(instanciaGenerica);

		Long[] fitxers = new Long[] { instanciaGenerica.getFitxer1ID(), instanciaGenerica.getFitxer2ID(),
				instanciaGenerica.getFitxer3ID(), instanciaGenerica.getFitxer4ID(), instanciaGenerica.getFitxer5ID(),
				instanciaGenerica.getFitxer6ID(), instanciaGenerica.getFitxer7ID(), instanciaGenerica.getFitxer8ID(),
				instanciaGenerica.getFitxer9ID() };

		Set<Long> fitxersEsborrar = new HashSet<Long>();

		// Borram fitxers a BD
		for (Long f : fitxers) {
			if (f != null) {

				fitxerEjb.delete(f);
				fitxersEsborrar.add(f);
			}
		}

		// Borram fitxers fisic
		transactionSynchronizationRegistry
				.registerInterposedSynchronization(new CleanFilesSynchronization(fitxersEsborrar));

		log.info("Final deleteFull");
	}

	public class CleanFilesSynchronization implements javax.transaction.Synchronization {

		protected final Set<Long> filesToDelete;

		public CleanFilesSynchronization(Set<Long> filesToDelete) {
			super();
			this.filesToDelete = filesToDelete;
		}

		@Override
		public void beforeCompletion() {
		}

		@Override
		public void afterCompletion(int status) {

			log.info("Inici CleanFilesSynchronization::afterCompletion()");
			if (status == Status.STATUS_COMMITTED) {
				if (!FileSystemManager.eliminarArxius(filesToDelete)) {
					log.error("No s'ha pogut esborrar alguns dels següents fitxers: "
							+ Arrays.toString(filesToDelete.toArray()));
				}
			}
			log.info("Final CleanFilesSynchronization::afterCompletion()");
		}
	}

	@Override
	public InstanciaGenericaJPA generarInstanciaGenericaAleatoria(InstanciaGenericaJPA ig) {
		String[] nombres = { "Paco", "Alex", "Toni", "Joan", "Marilén", "Óscar", "Pau", "Mateu", "Xavi", "Leo",
				"Giovanni", "Aragorn", "Naruto", "Sasuke", "Rafa", "Guillem", "Miquel", "Xisco", "David", "Kakashi" };
		String[] apellidos = { "García", "Pérez", "Gaita", "Macià", "Gonzalez", "Ronaldo", "Nadal", "Trobat", "Trias",
				"Segura", "Zidane", "Hernandez", "Messi", "LoCelso", "Guiterrez", "Sureda", "Martín", "Pernia",
				"Uzumaki", "Rodriguez", "Garí", "Soriano", "Mascaró", "Bennasar", "Uchiha", "Hatake", "López" };

		Random rnd = new Random();

		ig.setSolicitantTipusAdminID(1); // DNI

		char[] c = { (char) ('A' + rnd.nextInt(26)) };
		String s = "" + c[0] + "";
		ig.setSolicitantAdminID((10000000 + rnd.nextInt(90000000)) + s);

		ig.setSolicitantAdminID("12345678Z");

		ig.setSolicitantPersonaFisica(true);

		String nom = nombres[rnd.nextInt(nombres.length)];
		String llinatge = apellidos[rnd.nextInt(apellidos.length)];
		String llinatge2 = apellidos[rnd.nextInt(apellidos.length)];
		ig.setSolicitantNom(nom);
		ig.setSolicitantLlinatge1(llinatge);
		ig.setSolicitantLlinatge2(llinatge2);

		ig.setIdiomaID("ca");

		ig.setSolicitantDireccio("Casa den " + nom);

		String[] empresas = { "INDRA", "Apple", "Amazon", "Google", "Fundacio BIT", "Gambas Angulo",
				"Colchones Rivolvo", "Tonys", "Suministros Lomar S.L." };
		String raoSocial = empresas[rnd.nextInt(empresas.length)];
		ig.setSolicitantRaoSocial(raoSocial);

		String[] cifs = { "S0794867B", "B67657189", "B13829940", "D48465058", "N4957698F", "G19819226", "N1350140H" };
		ig.setSolicitantCif(cifs[rnd.nextInt(cifs.length)]);
		ig.setSolicitantTelefon(900000000 + rnd.nextInt(100000000) + "");

		String correo = nom + "." + llinatge;
		String cadenaNormalize = Normalizer.normalize(correo, Normalizer.Form.NFD);
		correo = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "").toLowerCase();

		ig.setSolicitantEmail(correo + "@common.com");

		ig.setExposa("Expongo mis circunstancias");
		ig.setSolicita("Solicito que se cumplan mis demandas");

		return ig;
	}

	@Override
	public AsientoRegistralWs obtenerAsiento(String numRegF) throws I18NException {
		log.info("Comença obtenerAsiento");

		AsientoRegistralWs as;

		try {
			// TODO XXXXXXXXXXX GESIONAR NULL
			log.info("Cridam API per obtenir asiento");
			String codiDir3 = Configuracio.getRegistreEntidad();
			final boolean conAnexos = true;
			final Long tipoRegistro = 1L; // 1 Entrada - 2 Sortida

			as = getApiRegistre().obtenerAsientoRegistral(codiDir3, numRegF, tipoRegistro, conAnexos);

			log.info("Ja tenim asiento: " + as);

		} catch (WsValidationException e) {
			// TODO XXXXXXXXXXX Mirar que retorna e
			log.error("Error WsValidationException");

			throw new I18NException("genapp.comodi", "error cridada a registre:" + e.getMessage());

		} catch (WsI18NException e) {
			// TODO XXXXXXXXXXX Mirar que retorna e
			log.error("Error WsI18NException ");
			throw new I18NException("genapp.comodi", "error cridada a registre:" + e.getMessage());
		}

		return as;

	}

	@Override
	public AsientoWs obtenerAsientoCiudadano(String numRegF, String nif, String idioma) throws I18NException {
		log.info("Comença obtenerAsiento");

		AsientoWs as;

		// TODO XXXXXXXXXXX GESIONAR NULL
		log.info("Cridam API per obtenir asiento");
		String codiDir3 = Configuracio.getRegistreEntidad();

		as = getApiRegistre().obtenerAsientoCiudadanoCarpeta(codiDir3, nif, numRegF, idioma);

		log.info("Ja tenim asiento: " + as);

		return as;

	}

	@Override
	public RegWebAsientoRegistralWs getApiRegistre() throws I18NException {

		log.info("Comença getApi()");
		String endpoint = Configuracio.getRegistreUrl();
		String usr_app = Configuracio.getRegistreUser(); // username application
		String pwd_app = Configuracio.getRegistrePass(); // password application

		URL wsdl;
		try {
			wsdl = new URL(endpoint + "?wsdl");
		} catch (MalformedURLException e) {

			throw new I18NException("genapp.comodi",
					"error amb la URL al servidor de registre (" + endpoint + "): " + e.getMessage());
		}

		log.info("	-> getApi: tenim parametres: " + endpoint + " - " + usr_app + " - " + pwd_app);

		RegWebAsientoRegistralWsService asientoService = new RegWebAsientoRegistralWsService(wsdl);
		RegWebAsientoRegistralWs asientoApi = asientoService.getRegWebAsientoRegistralWs();

		// Adreça servidor
		Map<String, Object> reqContext = ((BindingProvider) asientoApi).getRequestContext();

		reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
		reqContext.put(BindingProvider.USERNAME_PROPERTY, usr_app);
		reqContext.put(BindingProvider.PASSWORD_PROPERTY, pwd_app);

		log.info("Acaba getApi()");

		return asientoApi;

	}

	@Override
	public FileContentWs getAnexe(Long idAnexo, String idioma) throws I18NException {
		log.info("Comença getAnexe");

		FileContentWs f;

		try {
			// TODO XXXXXXXXXXX GESIONAR NULL
			log.info("Cridam API per obtenir anexes");

			String entidad = Configuracio.getRegistreEntidad();

			f = getApiRegistre().obtenerAnexoCiudadano(entidad, idAnexo, idioma);

			log.info("Ja tenim anexe: " + f);

		} catch (I18NException e) {
			// TODO XXXXXXXXXXX Mirar que retorna e
			log.error("Error WsI18NException ");
			throw new I18NException("genapp.comodi", "Error cridada a obtenerAnexoCiudadano: " + e.getMessage());
		}

		return f;

	}
}
