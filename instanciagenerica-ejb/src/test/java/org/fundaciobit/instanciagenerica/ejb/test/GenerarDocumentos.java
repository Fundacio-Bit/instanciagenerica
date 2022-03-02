package org.fundaciobit.instanciagenerica.ejb.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.instanciagenerica.logic.InstanciaGenericaLogicEJB;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.AcroFields.Item;

public class GenerarDocumentos {
	public static void main(String[] args) {

		try {

			// TODO Check Plantilla
			// TODO Guardar plantilles a scripts/config i modificar posteriorment el manual
			// d'instal.lacio

			InstanciaGenericaLogicEJB ejb = new InstanciaGenericaLogicEJB();

			InstanciaGenericaJPA ig = new InstanciaGenericaJPA();
			ig = ejb.generarInstanciaGenericaAleatoria(ig);

			ig.setDataCreacio(new Timestamp(System.currentTimeMillis()));
			ig.setDatafinalitzacio(new Timestamp(System.currentTimeMillis()));
			ig.setNumRegistre("GOIB-E-93/2022");
			ig.setUuid("f503843d1ba7403d8bee05941cd088cf");
			
//			 File plantillaPdf = FileSystemManager.getFile(plantilla.getFitxerID());
			File plantillaPdf = new File("formulariDelegacio.pdf");

//			File dstPDF = ig.getFitxer9();
			File dstPDF = new File("formularis/f" + System.currentTimeMillis() + ".pdf");

			pruebasDocumento(ig, plantillaPdf, dstPDF);
		} catch (I18NException e) {
			// TODO Auto-generated catch block
			System.out.println("Pete");
		}
	}

	public static void pruebasDocumento(InstanciaGenerica ig, File plantillaPdf, File fileDst) throws I18NException {

		System.out.println("Start");
		try {
			PdfReader reader = new PdfReader(new FileInputStream(plantillaPdf));
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(fileDst), '\0', false);
			AcroFields fields = stamper.getAcroFields();

			System.out.println("Empezamos a poner parametros");
			String nomDest = ig.getSolicitantNom();
			boolean isPersonaFisica = ig.isSolicitantPersonaFisica();

			System.out.println("personaFisica: " + isPersonaFisica);

			String[] tipusAdminId = { "DNI", "NIE", "Passport", "Otros" };

			fields.setField("SOLICITANT.NOM", nomDest);
			fields.setField("SOLICITANT.LLINATGES", ig.getSolicitantLlinatge1() + " " + ig.getSolicitantLlinatge2());
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
			fields.setField("REGISTRE.NUMERO", ig.getNumRegistre());

			fields.setField("EXPOSA", ig.getExposa());
			fields.setField("SOLICITA", ig.getSolicita());

			fields.setField("URL",
					"http://localhost:8080/instanciagenerica/public/instanciagenerica/v/" + ig.getUuid());

			dateFormat = new SimpleDateFormat("EEEEE dd 'de' MMMM 'de' YYYY", new Locale ("ca"));
			fields.setField("DATA", dateFormat.format(new Timestamp(System.currentTimeMillis())));

			stamper.setFormFlattening(true);
			stamper.close();
			System.out.println("Fin");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("error de FileNotFoundException");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error de IOException");

		} catch (DocumentException e) {
			System.out.println("error de DocumentException");
			e.printStackTrace();
		}
	}
//	System.out.println(e.getMessage());
//	throw new I18NException("error.unknown", "Error omplint formulari d´autorització:" + e.getMessage());

}
