package org.fundaciobit.instanciagenerica.ejb.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.fundaciobit.instanciagenerica.logic.InstanciaGenericaLogicEJB;
import org.fundaciobit.instanciagenerica.logic.InstanciaGenericaLogicEJB.InfoRegistre;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;

/**
 * 
 * @author ptrias
 *
 */

public class CridadaRegistre {

	public static void main(String[] args) {
		pruebasRegistro();
	}

	public static void pruebasRegistro() {

		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File("connection.properties")));

			String endpoint = prop.getProperty("url");
			String usr_app = prop.getProperty("user"); // username application
			String pwd_app = prop.getProperty("pass"); // password application
			String codiDir3 = prop.getProperty("entidad");

			String oficinaDestiCodi = prop.getProperty("oficinadesti.codi");
			String oficinaDestiDenominacio = prop.getProperty("oficinadesti.denominacio");

			String unitatTramitacioDestiCodi = prop.getProperty("unitattramitacio.codi");
			String unitatTramitacioDestiDenominacio = prop.getProperty("unitattramitacio.denominacio");

			System.out.println(endpoint + "\n" + usr_app + "\n" + pwd_app + "\n" + codiDir3 + "\n" + oficinaDestiCodi
					+ "\n" + oficinaDestiDenominacio);

			boolean justificant = false;
			boolean distribuir = false;

			InstanciaGenericaLogicEJB ejb = new InstanciaGenericaLogicEJB();

			InstanciaGenericaJPA ig = new InstanciaGenericaJPA();
			ig = ejb.generarInstanciaGenericaAleatoria(ig);

			InfoRegistre ir = ejb.cridadaRegistre(codiDir3, justificant, distribuir, oficinaDestiCodi,
					unitatTramitacioDestiCodi, ig);

			if (ir.getEstat() == InfoRegistre.ESTAT_ERROR) {
				System.out.println("Error cridant Api: " + ir.getError());
				System.out.println(ir.getExccepcio());

			} else {
				System.out.println("	-> Ha anat OK. Numero de registre: " + ir.getNumRegistre());
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
//		asientoApi.obtenerAsientoRegistral("A04003003","INNO-E-352/2019", "INNO", 1, 0));
	}

}
