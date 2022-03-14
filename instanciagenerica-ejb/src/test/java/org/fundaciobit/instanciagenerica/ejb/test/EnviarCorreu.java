package org.fundaciobit.instanciagenerica.ejb.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import java.util.Date;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
		props.put("mail.smtp.host", "mail.fundaciobit.org");
		
		//Posar: totes 

		Session session = Session.getDefaultInstance(props, null);

		boolean debug = true;
		session.setDebug(debug);

		pruebasCorreo(session);

	}

	public static void pruebasCorreo(Session session) {
		// TODO Auto-generated method stub

		String subject = "Asumpte de prova";
		String message = "Aquest es un missatge de prova per comprobar el funcionament del correu";
		boolean isHtml = false;
		String from = "ptrias@fundaciobit.org";
		String[] recipients = { "ptrias@fundaciobit.org" };

		try {
			postMail(subject, message, isHtml, from, recipients, session);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void postMail(String subject, String message, boolean isHtml, String from, String[] recipients,
			Session session) throws Exception {

		// Creamos el mensaje
		MimeMessage msg = new MimeMessage(session);

		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);

		// Indicamos los destinatarios
		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);
		}

		final RecipientType type = RecipientType.TO;

		msg.setRecipients(type, addressTo);

		// Configuramos el asunto
		msg.setSubject(subject, "UTF-8");
		msg.setSentDate(new Date());

		// Configuramos el contenido
		if (isHtml) {
			msg.setHeader("Content-Type", "text/html;charset=utf-8");
			// URL urlToAdd = new URL(url); msg.setDataHandler(new DataHandler(urlToAdd));
			msg.setContent(message, "text/html;charset=utf-8");
		} else {
			msg.setContent(message, "text/plain" /* ; charset=UTF-8" */);
		}

		// Mandamos el mail
		Transport.send(msg);

	}

}
