package org.fundaciobit.instanciagenerica.ejb.test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.Properties;

import javax.mail.Session;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.instanciagenerica.logic.InstanciaGenericaLogicEJB;
import org.fundaciobit.instanciagenerica.logic.utils.EmailUtil;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;

/**
 * 
 * @author ptrias
 *
 */

public class EnviarCorreu {

	public static void main(String[] args) {

		// Generar javax.mail.Session a mà. Metode generic que jo li pasi
		/*
		 * javax.mail.Session clase per generar correus. Buscar como crear un
		 * javax.mail.Session desde 0 Hay que conseguir un sesion sin utilizar ctx
		 */

		// Així es com s'ha de cridar desde EJB
		// Context ctx = new InitialContext();
//		Session session = (javax.mail.Session) ctx.lookup(MAIL_SERVICE);

		// Així es com s'ha de cridar desde TEST

	    try {
	        
	    Properties props = new Properties();
        props.load(new FileInputStream(new File("mail.properties")));

        Session session = Session.getDefaultInstance(props, null);

		boolean debug = true;
		session.setDebug(debug);

		InstanciaGenericaLogicEJB ejb = new InstanciaGenericaLogicEJB();

		InstanciaGenericaJPA ig = new InstanciaGenericaJPA();
		ig = ejb.generarInstanciaGenericaAleatoria(ig);

		ig.setDataCreacio(new Timestamp(System.currentTimeMillis()));
		ig.setDatafinalitzacio(new Timestamp(System.currentTimeMillis()));
		ig.setNumRegistre("GOIB-E-93/2022");
		ig.setUuid("f503843d1ba7403d8bee05941cd088cf");
		ig.setError(
				"Error no contrrolat fent cridada a registre: Document(interesado.documento): El NIE no té format correcte (LLETRA(X,Y,Z) + 7 DÍGITS + LLETRA)");

		String from = props.getProperty("mail.from");
		String[] destinataris = {props.getProperty("mail.to")};

		EmailUtil.enviarCorreuInstancia(session, ig, from, destinataris);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
