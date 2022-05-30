package org.fundaciobit.instanciagenerica.ejb.test;

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

	public static final String PORTAFIB_PROPERTY_BASE = "es.caib.portafib.";
	public static final String MAIL_SERVICE = "java:/org.fundaciobit.instanciagenerica.mail";

	// TRUE ROLES
	public static final String PFI_ADMIN = "PFI_ADMIN";
	public static final String PFI_USER = "PFI_USER";

	// VIRTUAL SECURITY ROLES
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_USER = "ROLE_USER";

	// EJB HIGH LEVEL ROLES
	public static final String ROLE_EJB_FULL_ACCESS = PFI_ADMIN;
	public static final String ROLE_EJB_BASIC_ACCESS = PFI_USER;

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
		Properties props = new Properties();
		props.put("mail.store.protocol", "pop3");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.user", "nobody");
		props.put("mail.pop3.host", "mail.fundaciobit.org");
		props.put("mail.smtp.host", "mail.fundaciobit.org");
		props.put("mail.smtp.port", "25");
		props.put("mail.from", "otae@fundaciobit.org");
		props.put("mail.debug", "false");

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

//		String[] destinataris = { "ptrias@fundaciobit.org", "anadal@fundaciobit.org", "atrobat@fundaciobit.org" };
		String[] destinataris = {"ptrias@fundaciobit.org"};
		String from = "ptrias@fundaciobit.org";

		try {
			EmailUtil.enviarCorreuInstancia(session, ig, from, destinataris);
		} catch (I18NException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
