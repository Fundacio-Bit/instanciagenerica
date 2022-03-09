package org.fundaciobit.instanciagenerica.logic.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.instanciagenerica.model.entity.Fitxer;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * 
 * @author ptrias
 *
 */

public class GeneradorDocuments {

	public static final Logger log = Logger.getLogger(GeneradorDocuments.class);
	
	public static void generarDocumento(InstanciaGenerica ig, File plantillaPdf, File fileDst) throws I18NException {

		log.info("Start");
		try {
			PdfReader reader = new PdfReader(new FileInputStream(plantillaPdf));
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(fileDst), '\0', false);
			AcroFields fields = stamper.getAcroFields();

			log.info("Empezamos a poner parametros");
			String nomDest = ig.getSolicitantNom();
			boolean isPersonaFisica = ig.isSolicitantPersonaFisica();

			log.info("personaFisica: " + isPersonaFisica);

			String[] tipusAdminId = { "DNI", "NIE", "Passport", "Otros" };

			fields.setField("SOLICITANT.NOM",
					nomDest + " " + ig.getSolicitantLlinatge1() + " " + ig.getSolicitantLlinatge2());
//			fields.setField("SOLICITANT.LLINATGES", );
			fields.setField("SOLICITANT.NIF",
					"(" + tipusAdminId[ig.getSolicitantTipusAdminID()] + "): " + ig.getSolicitantAdminID());

			fields.setField("SOLICITANT.MAIL", ig.getSolicitantEmail());
			fields.setField("SOLICITANT.TELEFON", ig.getSolicitantTelefon());
			fields.setField("SOLICITANT.DIRECCIO", ig.getSolicitantDireccio());

			if (!isPersonaFisica) {
				fields.setField("ENTITAT.RAOSOCIAL", ig.getSolicitantRaoSocial());
				fields.setField("ENTITAT.CIF", "(CIF): " + ig.getSolicitantCif());
			} else {
				fields.setField("ENTITAT.RAOSOCIAL", "-");
				fields.setField("ENTITAT.CIF", "-");
			}

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY - HH:mm:ss");
//			DateFormat dateFormat = new SimpleDateFormat("", new Locale ("ca"));
			fields.setField("REGISTRE.DATA", dateFormat.format(ig.getDatafinalitzacio()));

//			fields.setField("REGISTRE.DATA", ig.getDatafinalitzacio().toGMTString());
			fields.setField("REGISTRE.NUMERO", ig.getNumRegistre());

			fields.setField("EXPOSA", ig.getExposa());
			fields.setField("SOLICITA", ig.getSolicita());

			Fitxer[] fitxers = { ig.getFitxer1(), ig.getFitxer2(), ig.getFitxer3(), ig.getFitxer4(), ig.getFitxer5(),
					ig.getFitxer6(), ig.getFitxer7(), ig.getFitxer8(), ig.getFitxer9() };

			String cadena = "";
			int idx = 0;
			for (Fitxer fitxer : fitxers) {
				if (fitxer != null) {
					idx++;
					cadena += idx + ". " + fitxer.getNom() + "\n";
				}
			}
			if (idx == 0) {
				cadena = "No hi ha anexes";
			}
			fields.setField("ANEXES", cadena);

			fields.setField("URL",
					"http://localhost:8080/instanciagenerica/public/instanciagenerica/v/" + ig.getUuid());

			dateFormat = new SimpleDateFormat("EEEEE dd 'de' MMMM 'de' YYYY", new Locale("ca"));
			fields.setField("DATA", dateFormat.format(new Timestamp(System.currentTimeMillis())));

			stamper.setFormFlattening(true);
			stamper.close();
			log.info("Fin");

		} catch (FileNotFoundException e) {
			log.error("Error de FileNotFoundException");
			throw new I18NException("genapp.comodi", "Error cridada a generarDocumento: " + e.getMessage());
		} catch (IOException e) {
			log.error("Error de IOException");
			throw new I18NException("genapp.comodi", "Error cridada a generarDocumento: " + e.getMessage());
		} catch (DocumentException e) {
			log.error("Error de DocumentException");
			throw new I18NException("genapp.comodi", "Error cridada a generarDocumento: " + e.getMessage());
		}
	}

}
