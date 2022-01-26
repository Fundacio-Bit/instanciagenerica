
package org.fundaciobit.instanciagenerica.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.instanciagenerica.persistence.FitxerJPA;
import org.fundaciobit.instanciagenerica.persistence.FitxerIJPAManager;
import org.fundaciobit.instanciagenerica.model.dao.IFitxerManager;

@Local
public interface FitxerService extends FitxerIJPAManager,IFitxerManager {

    public static final String JNDI_NAME = "java:app/instanciagenerica-ejb/FitxerEJB!org.fundaciobit.instanciagenerica.ejb.FitxerService";

    public FitxerJPA findByPrimaryKey(Long _ID_);
}
