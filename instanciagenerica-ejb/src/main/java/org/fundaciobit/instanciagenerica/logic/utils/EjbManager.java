package org.fundaciobit.instanciagenerica.logic.utils;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.i18n.I18NArgumentString;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.instanciagenerica.logic.FitxerLogicService;
import org.fundaciobit.instanciagenerica.logic.InstanciaGenericaLogicService;
import org.fundaciobit.instanciagenerica.logic.SampleLogicaService;

import javax.naming.InitialContext;

public class EjbManager {

	protected static final Logger log = Logger.getLogger(EjbManager.class);

	protected static FitxerLogicService fitxerLogicService;

	protected static InstanciaGenericaLogicService instanciaGenericaLogicService;

	protected static SampleLogicaService sampleLogicaService;

	private static void throwNewI18NException(Throwable e, String name) throws I18NException {
		throw new I18NException(e, "error.unknown",
				new I18NArgumentString("No puc instanciar " + name + ": " + e.getMessage()));
	}

	public static FitxerLogicService getFitxerLogicEJB() throws I18NException {
		if (fitxerLogicService == null) {
			try {
				fitxerLogicService = (FitxerLogicService) new InitialContext().lookup(FitxerLogicService.JNDI_NAME);
			} catch (Throwable e) {
				throwNewI18NException(e, FitxerLogicService.JNDI_NAME);
			}
		}
		return fitxerLogicService;
	}
	

	public static InstanciaGenericaLogicService getInstanciaGenericaLogicEJB() throws I18NException {
		if (instanciaGenericaLogicService == null) {
			try {
				instanciaGenericaLogicService = (InstanciaGenericaLogicService) new InitialContext()
						.lookup(InstanciaGenericaLogicService.JNDI_NAME);
			} catch (Throwable e) {
				throwNewI18NException(e, InstanciaGenericaLogicService.JNDI_NAME);
			}
		}
		return instanciaGenericaLogicService;
	}

	public static SampleLogicaService getSampleLogicaEJB() throws I18NException {
		if (sampleLogicaService == null) {
			try {
				sampleLogicaService = (SampleLogicaService) new InitialContext().lookup(SampleLogicaService.JNDI_NAME);
			} catch (Throwable e) {
				throwNewI18NException(e, SampleLogicaService.JNDI_NAME);
			}
		}
		return sampleLogicaService;
	}

}
