package org.fundaciobit.instanciagenerica.logic;


/*
import org.fundaciobit.instanciagenerica.ejb.AnnexEJB;
import org.fundaciobit.instanciagenerica.ejb.FitxerService;
import org.fundaciobit.instanciagenerica.persistence.AnnexJPA;
import org.fundaciobit.instanciagenerica.model.entity.AnnexFirmat;
import org.fundaciobit.instanciagenerica.model.fields.AnnexFields;
import org.fundaciobit.instanciagenerica.model.fields.AnnexFirmatFields;

import org.fundaciobit.genapp.common.i18n.I18NException;

*/

import javax.ejb.Stateless;

/**
 * 
 * @author anadal
 *
 */
@Stateless(name = "SampleLogicaEJB")
public class SampleLogicaEJB implements SampleLogicaService {


}
 
 /**
@Stateless(name = "AnnexLogicaEJB")
public class AnnexLogicaEJB extends AnnexEJB implements AnnexLogicaService,
    AnnexFields {


  @EJB(mappedName = FitxerService.JNDI_NAME)
  private FitxerService fitxerEjb;

  @EJB(mappedName = org.fundaciobit.instanciagenerica.ejb.AnnexFirmatService.JNDI_NAME)
  protected org.fundaciobit.instanciagenerica.ejb.AnnexFirmatServiceannexFirmatEjb;
  
  
  @Override
  public AnnexJPA createFull(AnnexJPA annex) throws I18NException {
    // TODO Validar !!!
    
    return (AnnexJPA)create(annex);
  }
  


  @Override
  public Set<Long> deleteFull(AnnexJPA annex) throws I18NException {
    
    Set<Long> files = new HashSet<Long>();
    
    if (annex == null) {
      return files;
    }
    
    // Annex
    delete(annex);
    
    return files;
  }

}
*/
