package org.fundaciobit.instanciagenerica.logic;

import javax.ejb.Local;
/*
import org.fundaciobit.instanciagenerica.ejb.AnnexService;
import org.fundaciobit.instanciagenerica.persistence.AnnexJPA;

import org.fundaciobit.genapp.common.i18n.I18NException;
*/
/**
 * 
 * @author anadal
 *
 */
@Local
public interface SampleLogicaService /* extends AnnexService */ {
	
	public static final String JNDI_NAME = "java:app/instanciagenerica-ejb/SampleLogicaEJB!org.fundaciobit.instanciagenerica.logic.SampleLogicaService";

/*
  public Set<Long> deleteFull(AnnexJPA annex) throws I18NException;
  
  public AnnexJPA createFull(AnnexJPA annex) throws I18NException;
  */
}

