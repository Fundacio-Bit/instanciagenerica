
package org.fundaciobit.instanciagenerica.logic;

import javax.ejb.Stateless;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;

import javax.annotation.security.PermitAll;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;
import org.fundaciobit.instanciagenerica.model.fields.InstanciaGenericaFields;
import org.fundaciobit.instanciagenerica.commons.utils.Constants;
import org.fundaciobit.instanciagenerica.ejb.InstanciaGenericaEJB;
import org.fundaciobit.instanciagenerica.hibernate.HibernateFileUtil;

/**
 * 
 * @author ptrias
 *
 */
@Stateless
public class InstanciaGenericaLogicEJB extends InstanciaGenericaEJB implements InstanciaGenericaLogicService {

	@Override
	@PermitAll
	public InstanciaGenerica create(InstanciaGenerica instance) throws I18NException {
		
		String uuid = java.util.UUID.randomUUID().toString();
		instance.setUuid(uuid);
				
				
		InstanciaGenerica ig = super.create(instance);

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
		//Pot pasar 3 coses: Ok, Error, Exception
		
		try {
			// Simulam cridada a registre amb error
			//return new InfoRegistre("Error inventat", null);


			// Simulam cridada a registre ok
			return new InfoRegistre("555888222");

		} catch (Exception e) {

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sStackTrace = sw.toString(); // stack trace as a string
			
			return new InfoRegistre(e.getMessage(), sStackTrace);

		}

	}

	public static class InfoRegistre {

		/** Valors possibles de estat */

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

}
