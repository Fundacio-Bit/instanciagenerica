package org.fundaciobit.instanciagenerica.logic.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.instanciagenerica.commons.utils.Constants;
import org.fundaciobit.instanciagenerica.logic.InstanciaGenericaLogicEJB.InfoRegistre;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;
import org.fundaciobit.pluginsib.utils.templateengine.TemplateEngine;

/**
 * 
 * @author anadal
 * 
 */
public class EmailUtil {

	/**
	 * Envia un email a un {@link List} de emails
	 * 
	 * @param subject    Asunto del Mensaje
	 * @param message    Contenido a enviar
	 * @param from       Indica la procedencia del mensaje
	 * @param type       Indica el con que de que tipo es el destinatario, Copia,
	 *                   Copia Oculta, etc
	 * @param isHtml     Decide si el contenido del mensaje a de ser visualizado en
	 *                   html o no
	 * @param recipients Conjunto de emails para los que va dirigido el mensaje
	 * @throws Exception
	 */
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

	public static void enviarCorreuInstancia(Session session, InstanciaGenerica ig, String from,
			String[] destinataris) throws I18NException {
		// TODO Auto-generated method stub

		String nomDestinatari = ig.getSolicitantNom() + " " + ig.getSolicitantLlinatge1() + " "
				+ ig.getSolicitantLlinatge2();

		String plantillaSubject;
		String plantillaMessage;

		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss 'del' EEEEE dd 'de' MMMM 'de' YYYY", new Locale("ca"));

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("id", ig.getInstanciaGenericaID());
		map.put("nomDestinatari", nomDestinatari);
		map.put("dataHora", dateFormat.format(ig.getDatafinalitzacio()));
		map.put("numReg", ig.getNumRegistre());
		map.put("uuid", ig.getUuid());

		plantillaSubject = "La seva instancia generica (ID=${id}) s'ha registrat correctament";

		plantillaMessage = "<h4>Benvolgut/benvolguda ${nomDestinatari} </h4>" + "<div>"
				+ "    <p>La seva instancia genèrica s'ha registrat correctament.</p>" + "    <p>A les ${dataHora}"
				+ "        s'ha registrat al registre de la Fundació BIT la seva instancia amb el següent numero de registre:</p>"
				+ "    <div style='margin-left: 3rem;'> <i>  ${numReg}  </i>" + "    </div>"
				+ "    <p>Si vol veure informació de la seva instancia pot anar a la següent URL:"
				+ "        <a href='http://localhost:8080/instanciagenerica/public/instanciagenerica/v/${uuid}'> Veure instancia generica</a>"
				+ "    </p>" + "<p>Atentament Fundacio BIT.</p>" + "</div>"
				+ "<img src='https://www.caib.es/sites/manualdidentitatcorporativa/ca/fundacia_balear_dinnovacia_i_tecnologia_fbit/archivopub.do?ctrl=MCRST9545ZI292448&id=292448'"
				+ "width='200px'>";

		boolean isHtml = true;

		try {
			String message = TemplateEngine.processExpressionLanguage(plantillaMessage, map);
			String subject = TemplateEngine.processExpressionLanguage(plantillaSubject, map);

			postMail(subject, message, isHtml, from, destinataris, session);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new I18NException("genapp.comodi", "error redactant correu:" + e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new I18NException("genapp.comodi", "error enviant correu:" + e.getMessage());
		}
	}
}
