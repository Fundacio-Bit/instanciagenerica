
package org.fundaciobit.instanciagenerica.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaIJPAManager;
import org.fundaciobit.instanciagenerica.model.dao.IInstanciaGenericaManager;

@Local
public interface InstanciaGenericaService extends InstanciaGenericaIJPAManager,IInstanciaGenericaManager {

    public static final String JNDI_NAME = "java:app/instanciagenerica-ejb/InstanciaGenericaEJB!org.fundaciobit.instanciagenerica.ejb.InstanciaGenericaService";

    public InstanciaGenericaJPA findByPrimaryKey(Long _ID_);
}
