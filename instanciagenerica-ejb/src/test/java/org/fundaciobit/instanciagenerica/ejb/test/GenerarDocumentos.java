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
import org.fundaciobit.instanciagenerica.logic.utils.GeneradorDocuments;
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

			GeneradorDocuments.generarDocumento(ig, plantillaPdf, dstPDF);
		} catch (I18NException e) {
			// TODO Auto-generated catch block
			System.out.println("Pete");
		}
	}

	
//	System.out.println(e.getMessage());
//	throw new I18NException("error.unknown", "Error omplint formulari d´autorització:" + e.getMessage());

}
