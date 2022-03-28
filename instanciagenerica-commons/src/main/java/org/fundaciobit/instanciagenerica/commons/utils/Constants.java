package org.fundaciobit.instanciagenerica.commons.utils;

/**
 *
 * @author anadal
 *
 */
public interface Constants {

	public static final String INSTANCIAGENERICA_PROPERTY_BASE = "org.fundaciobit.instanciagenerica.";

	public static final String MAIL_SERVICE = "java:/org.fundaciobit.instanciagenerica.mail";

	// TRUE ROLES
	public static final String IGE_ADMIN = "IGE_ADMIN";
	public static final String IGE_USER = "IGE_USER";

	// VIRTUAL SECURITY ROLES
	public static final String ROLE_ADMIN = "ADMINISTRADOR";
	public static final String ROLE_USER = "ROLE_USER";

	// EJB HIGH LEVEL ROLES
	public static final String ROLE_EJB_FULL_ACCESS = IGE_ADMIN;
	public static final String ROLE_EJB_BASIC_ACCESS = IGE_USER;

	// CONSTANTS DE ESTAT DE INSTANCIAGENERICA
	public static final int ESTAT_OK = 0;
	public static final int ESTAT_NO_ENVIAT = 1;
	public static final int ESTAT_NO_RESUM = 2;
	public static final int ESTAT_NO_ENVIAT_NO_RESUM = 3;

}
