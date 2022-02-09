
package org.fundaciobit.instanciagenerica.logic;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Status;
import javax.transaction.TransactionSynchronizationRegistry;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;

import javax.xml.ws.BindingProvider;

import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;

import es.caib.regweb3.ws.api.v3.AnexoWs;
import es.caib.regweb3.ws.api.v3.AsientoRegistralWs;
import es.caib.regweb3.ws.api.v3.DatosInteresadoWs;
import es.caib.regweb3.ws.api.v3.InteresadoWs;
import es.caib.regweb3.ws.api.v3.RegWebAsientoRegistralWs;
import es.caib.regweb3.ws.api.v3.RegWebAsientoRegistralWsService;

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

		String endpoint = Configuracio.getRegistreUrl();
		String usr_app = Configuracio.getRegistreUser(); // username application
		String pwd_app = Configuracio.getRegistrePass(); // password application
		String codiDir3 = Configuracio.getRegistreEntidad();

		String oficinaDestiCodi = Configuracio.getRegistreOficinaDestiCodi();
		String oficinaDestiDenominacio = Configuracio.getRegistreOficinaDestiCodi();

		String unitatTramitacioDestiCodi = Configuracio.getRegistreUnitatTramitacioDestiCodi();
		String unitatTramitacioDestiDenominacio = Configuracio.getRegistreUnitatTramitacioDestiDenominacio();

		boolean justificant = false;
		boolean distribuir = false;

		InfoRegistre ir = cridadaRegistre(endpoint, usr_app, pwd_app, codiDir3, justificant, distribuir,
				oficinaDestiCodi, oficinaDestiDenominacio, unitatTramitacioDestiCodi, unitatTramitacioDestiDenominacio,
				ig);

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

	public InfoRegistre cridadaRegistre(String endpoint, String usr_app, String pwd_app, String codiDir3,
			boolean justificant, boolean distribuir, String oficinaDestiCodi, String oficinaDestiDenominacio,
			String unitatTramitacioDestiCodi, String unitatTramitacioDestiDenominacio, InstanciaGenerica ig) {

		try {
			URL wsdl = new URL(endpoint + "?wsdl");

			RegWebAsientoRegistralWsService asientoService = new RegWebAsientoRegistralWsService(wsdl);
			RegWebAsientoRegistralWs asientoApi = asientoService.getRegWebAsientoRegistralWs();

			// Adreça servidor
			Map<String, Object> reqContext = ((BindingProvider) asientoApi).getRequestContext();

			reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
			reqContext.put(BindingProvider.USERNAME_PROPERTY, usr_app);
			reqContext.put(BindingProvider.PASSWORD_PROPERTY, pwd_app);

			// Codi dir3 de l'entitat de registre.fundaciobit.org
			Long idSesion = asientoApi.obtenerSesionRegistro(codiDir3);

			// TODO Posar tots els camps.
			AsientoRegistralWs asientoRegistral = new AsientoRegistralWs();
			asientoRegistral.setAplicacion("instanciagenerica");
			asientoRegistral.setAplicacionTelematica(null);
			asientoRegistral.setCodigoAsunto(null);
			asientoRegistral.setCodigoAsuntoDenominacion(null);

			asientoRegistral.setCodigoEntidadRegistralProcesado(null);
			asientoRegistral.setCodigoSia(null);// Codi del tràmit administratiu corresponent a l’assentament registral.
												// https://administracionelectronica.gob.es/ctt/sia
			asientoRegistral.setCodigoUsuario(usr_app);

//			asientoRegistral.setDecodificacionEntidadRegistralProcesado(codiDir3);
			asientoRegistral.setEntidadCodigo(codiDir3);
			asientoRegistral.setEntidadDenominacion("fundaciobit");

			asientoRegistral.setEntidadRegistralDestinoCodigo(oficinaDestiCodi);
			asientoRegistral.setEntidadRegistralDestinoDenominacion(oficinaDestiDenominacio);

			asientoRegistral.setEntidadRegistralInicioCodigo(oficinaDestiCodi);
			asientoRegistral.setEntidadRegistralInicioDenominacion(oficinaDestiDenominacio);

			asientoRegistral.setEntidadRegistralOrigenCodigo(oficinaDestiCodi);
			asientoRegistral.setEntidadRegistralOrigenDenominacion(oficinaDestiDenominacio);

			asientoRegistral.setExpone(ig.getExposa());

			Long idioma = ig.getIdiomaID().equals("ca") ? 1L : 2L;
			asientoRegistral.setIdioma(idioma);// Vol un long, el nostre idioma es un String

			asientoRegistral.setLibroCodigo(null); // Codi del llibre a on es vol fer l’assentament.
			asientoRegistral.setNumeroExpediente(null);// Número de l'expedient a que fa referència l'assentament.
			asientoRegistral.setNumeroTransporte(null);// Número del transport d'entrada.
			asientoRegistral.setObservaciones(null);

			asientoRegistral.setPresencial(false);

			asientoRegistral.setReferenciaExterna(ig.getInstanciaGenericaID() + "");// Referència externa del tràmit
																					// (matrícula de
			// cotxe, rebut,...)
			asientoRegistral.setResumen("Registre d'una instancia genèrica a al registre de la fundació bit");
			asientoRegistral.setSolicita(ig.getSolicita());

			asientoRegistral.setTipoEnvioDocumentacion(null);// Indica si la documentació adjunta al registre s’envia
																// embebida dins el propi missatge SICRES o a traves del
																// «Sistema de Referencia Única de Documentación».

			asientoRegistral.setTipoDocumentacionFisicaCodigo(3L);// 3: Documentació adjunta digitalitzada
			asientoRegistral.setTipoRegistro(1L);// 1: Registre d'entrada
			asientoRegistral.setTipoTransporte(null); // Forma d'arribada de l’assentament de tipus «Entrada»

			asientoRegistral.setUnidadTramitacionDestinoCodigo(unitatTramitacioDestiCodi);
			asientoRegistral.setUnidadTramitacionDestinoDenominacion(unitatTramitacioDestiDenominacio);

			asientoRegistral.setUnidadTramitacionOrigenCodigo(null);
			asientoRegistral.setUnidadTramitacionOrigenDenominacion(null);

			// TODO XXXXXXXXXXXXXX if isPersonaFisica, tratarlo de una manera, else, de
			// otra.
			DatosInteresadoWs d = new DatosInteresadoWs();
			d.setApellido1(ig.getSolicitantLlinatge1());
			d.setApellido2(ig.getSolicitantLlinatge2());

			d.setCanal(null);
			d.setCodigoDire(null);
			d.setCp(null);

			d.setDireccion(ig.getSolicitantDireccio());
			d.setDireccionElectronica(ig.getSolicitantEmail());
			d.setDocumento(ig.getSolicitantAdminID());
			d.setEmail(ig.getSolicitantEmail());

			d.setLocalidad(null);
			d.setNombre(ig.getSolicitantNom());

			d.setObservaciones(null);
			d.setPais(null);
			d.setProvincia(null);

			d.setRazonSocial(ig.getSolicitantRaoSocial());
			d.setTelefono(ig.getSolicitantTelefon());

			String tipusAdminId;
			switch (ig.getSolicitantTipusAdminID()) {
			case 1:
				tipusAdminId = "N";// NIF
				break;
			case 2:
				tipusAdminId = "E";// NIE
				break;
			case 3:
				tipusAdminId = "P";// Passaport
				break;
			case 4:
				tipusAdminId = "X";// Altres
				break;
			case 5:
				tipusAdminId = "C";// CIF
				break;
			default:
				tipusAdminId = "O";// Codi d'origen
				break;
			}

			d.setTipoDocumentoIdentificacion(tipusAdminId);

			Long tipus = ig.isSolicitantPersonaFisica() ? 2L : 3L;
			d.setTipoInteresado(2L);

			InteresadoWs i = new InteresadoWs();
			i.setInteresado(d);

			asientoRegistral.getInteresados().add(i);

//			AnexoWs anex = new AnexoWs();
//			anex.set
//			
//			asientoRegistral.getAnexos().add(anex);

			asientoRegistral.setVersion(null); // ersió de la aplicació que fa l’assentament. Camp intern que es omplit
												// per REGWEB3.

			AsientoRegistralWs asiento = asientoApi.crearAsientoRegistral(idSesion, codiDir3, asientoRegistral, null,
					justificant, distribuir);

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

		} catch (Exception e) {

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sStackTrace = sw.toString(); // stack trace as a string

			return new InfoRegistre("Error no contrrolat fent cridada a registre: " + e.getMessage(), sStackTrace);
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
		String[] nombres = { "Paco", "Alex", "Toni", "Joan", "Marilen", "Oscar", "Pau", "Mateu", "Xavi", "Leo",
				"Giovanni", "Aragorn", "Naruto", "Sasuke", "Rafa" };
		String[] apellidos = { "Garcia", "Perez", "Gaita", "Macia", "Gonzalez", "Ronaldo", "Nadal", "Trobat",
				"Hernandez", "Messi", "Lo Celso", "Guiterrez del Alamo", "Sureda", "Martin", "Pernia", "Uzumaki",
				"Uchiha" };

		Random rnd = new Random();

		ig.setSolicitantTipusAdminID(rnd.nextInt(1)); // DNI

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
		ig.setSolicitantRaoSocial("INDRA");
		ig.setSolicitantTelefon(900000000 + rnd.nextInt(100000000) + "");
		ig.setSolicitantEmail(nom.toLowerCase() + "." + llinatge.toLowerCase() + "@common.com");

		ig.setExposa("Expongo mis circunstancias");
		ig.setSolicita("Solicito que se cumplan mis demandas");

		return ig;
	}

}
