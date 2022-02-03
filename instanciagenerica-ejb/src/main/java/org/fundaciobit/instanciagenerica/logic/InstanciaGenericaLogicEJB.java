
package org.fundaciobit.instanciagenerica.logic;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.TransactionSynchronizationRegistry;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;


import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;
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

	@Resource(mappedName = "jboss.naming.context.java.jboss.java:TransactionSynchronizationRegistry")
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
		InfoRegistre ir = cridarAPIRegistre(ig);

		if (ir.getEstat() == InfoRegistre.ESTAT_ERROR) {
			ig.setEstat(Constants.ESTAT_ERROR);
			ig.setError(ir.getError());
			ig.setException(ir.getExccepcio());
		} else {
			ig.setEstat(Constants.ESTAT_FINALITZAT);
			ig.setNumRegistre(ir.getNumRegistre());
		}
		ig.setDatafinalitzacio(new Timestamp(System.currentTimeMillis()));

		this.update(ig);
		return ig;
	}

	public InfoRegistre cridarAPIRegistre(InstanciaGenerica ig) {
		// Pot pasar 3 coses: Ok, Error, Exception

		try {
			// Simulam cridada a registre amb error

			Random rand = new Random();
			int int_random = rand.nextInt(1000);

			if (int_random < 500) {
				return new InfoRegistre("Error numeric, " + int_random + " ha de ser major que 500", null);
			} else {
				return new InfoRegistre("" + int_random);
			}

			// Simulam cridada a registre ok

		} catch (Exception e) {

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sStackTrace = sw.toString(); // stack trace as a string

			return new InfoRegistre(e.getMessage(), sStackTrace);

		}

	}

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

		Long[] fitxers = { instanciaGenerica.getFitxer1(), instanciaGenerica.getFitxer2(),
				instanciaGenerica.getFitxer3(), instanciaGenerica.getFitxer4(), instanciaGenerica.getFitxer5(),
				instanciaGenerica.getFitxer6(), instanciaGenerica.getFitxer7(), instanciaGenerica.getFitxer8(),
				instanciaGenerica.getFitxer9() };

		Set<Long> fitxersEsborrar = new HashSet<Long>();

		// Borram fitxers a BD
		for (Long f : fitxers) {
			if (f != null) {

				fitxerEjb.delete(f);
				fitxersEsborrar.add(f);
			}
		}

		// Borram fitxers fisic
		FileSystemManager.eliminarArxius(fitxersEsborrar);
//		log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX " +transactionSynchronizationRegistry );
//		transactionSynchronizationRegistry.registerInterposedSynchronization(new CleanFilesSynchronization(fitxersEsborrar));

		log.info("Final deleteFull");
		// log.error("Passa per netejaFitxers => FINAL");

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

			if (!FileSystemManager.eliminarArxius(filesToDelete)) {
				log.error("No s'ha pogut esborrar alguns dels següents fitxers: "
						+ Arrays.toString(filesToDelete.toArray()));
			}

			log.info("Final CleanFilesSynchronization::afterCompletion()");
		}
	}

}
