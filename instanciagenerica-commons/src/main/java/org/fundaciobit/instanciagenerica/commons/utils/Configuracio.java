package org.fundaciobit.instanciagenerica.commons.utils;

import org.fundaciobit.instanciagenerica.commons.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author anadal
 * 
 */
public class Configuracio implements Constants {

	private static final Logger LOG = LoggerFactory.getLogger(Configuracio.class);

	private static final Properties fileProperties = new Properties();

	private static final Properties fileAndSystemProperties = new Properties();

	/*
	 * Agafa els fitxers de propietats definits a l'standalone
	 *
	 * Seguim els estandars de la CAIB
	 */
	public static Properties getFilesProperties() {

		if (fileProperties.isEmpty()) {
			// matches the property name as defined in the system-properties element in
			// WildFly
			try {
				String property = Constants.INSTANCIAGENERICA_PROPERTY_BASE + "properties";
				loadPropertyFile(property);

				String propertySystem = Constants.INSTANCIAGENERICA_PROPERTY_BASE + "system.properties";
				loadPropertyFile(propertySystem);

			} catch (FileNotFoundException e) {
				LOG.error("El Fitxer de propietats no está definit", e);

			} catch (NullPointerException e) {
				LOG.error("Propietat sense valor", e);

			} catch (IOException e) {
				LOG.error("No es pot carregar algun dels fitxers de propietats ... ", e);
			}
		}

		return fileProperties;

	}

	public static void loadPropertyFile(String property) throws FileNotFoundException, IOException {
		String propertyFile = System.getProperty(property);

		if (propertyFile.equals("")) {
			throw new NullPointerException("No esta definida la propietat: " + property);
		}

		File File = new File(propertyFile);
		if (!File.exists()) {
			throw new FileNotFoundException(File.getAbsolutePath());
		}
		fileProperties.load(new FileInputStream(File));
	}

	public static Properties getSystemAndFileProperties() {

		if (fileAndSystemProperties.isEmpty()) {
			fileAndSystemProperties.putAll(getFilesProperties());
			fileAndSystemProperties.putAll(System.getProperties());
		}
		return fileAndSystemProperties;
	}

	public static String getProperty(String key) {

		return getFilesProperties().getProperty(key);

	}

	public static String getProperty(String key, String def) {

		return getFilesProperties().getProperty(key, def);

	}

	public static boolean isDesenvolupament() {

		return Boolean.parseBoolean(getProperty(INSTANCIAGENERICA_PROPERTY_BASE + "development"));
	}

	public static boolean isCAIB() {
		return Boolean.parseBoolean(getProperty(INSTANCIAGENERICA_PROPERTY_BASE + "iscaib"));
	}

	public static String getAppUrl() {
		return getProperty(INSTANCIAGENERICA_PROPERTY_BASE + "url");
	}

	public static String getAppEmail() {
		return getProperty(INSTANCIAGENERICA_PROPERTY_BASE + "email.from");
	}

	public static String getAppName() {
		return getProperty(INSTANCIAGENERICA_PROPERTY_BASE + "name", "InstanciaGenerica");
	}

	public static String getDefaultLanguage() {
		return getProperty(INSTANCIAGENERICA_PROPERTY_BASE + "defaultlanguage", "ca");
	}

	public static byte[] getEncryptKey() {
		return getProperty(INSTANCIAGENERICA_PROPERTY_BASE + "encryptkey", "0123456789123456").getBytes();
	}

	public static Long getMaxUploadSizeInBytes() {
		return Long.getLong(INSTANCIAGENERICA_PROPERTY_BASE + "maxuploadsizeinbytes");
	}

	public static Long getMaxFitxerAdaptatSizeInBytes() {
		return Long.getLong(INSTANCIAGENERICA_PROPERTY_BASE + "maxfitxeradaptatsizeinbytes");
	}

	public static File getFilesDirectory() {
		String path = getProperty(INSTANCIAGENERICA_PROPERTY_BASE + "filesdirectory");
		return new File(path);
	}

	public static String getFileSystemManager() {
		return getProperty(INSTANCIAGENERICA_PROPERTY_BASE + "filesystemmanagerclass");
	}


	public static String getRegistreUrl() {
		return getProperty(INSTANCIAGENERICA_PROPERTY_BASE + "registre.url");
	}

	public static String getRegistreUser() {
		return getProperty(INSTANCIAGENERICA_PROPERTY_BASE + "registre.user");
	}

	public static String getRegistrePass() {
		return getProperty(INSTANCIAGENERICA_PROPERTY_BASE + "registre.pass");
	}

	public static String getRegistreEntidad() {
		return getProperty(INSTANCIAGENERICA_PROPERTY_BASE + "registre.entidad");
	}

	public static String getRegistreOficinaDestiCodi() {
		return getProperty(INSTANCIAGENERICA_PROPERTY_BASE + "registre.oficinadesti.codi");
	}

	public static String getRegistreUnitatTramitacioDestiCodi() {
		return getProperty(INSTANCIAGENERICA_PROPERTY_BASE + "registre.unitattramitacio.codi");
	}

	public static File getPlantillaFitxerResum() {
		String path = getProperty(INSTANCIAGENERICA_PROPERTY_BASE + "plantilla_fitxer_resum");
		return new File(path);
	}	
}
