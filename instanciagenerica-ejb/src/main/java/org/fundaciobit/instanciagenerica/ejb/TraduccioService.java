
package org.fundaciobit.instanciagenerica.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.instanciagenerica.persistence.TraduccioJPA;
import org.fundaciobit.instanciagenerica.persistence.TraduccioIJPAManager;
import org.fundaciobit.instanciagenerica.model.dao.ITraduccioManager;

@Local
public interface TraduccioService extends TraduccioIJPAManager,ITraduccioManager {

    public static final String JNDI_NAME = "java:app/instanciagenerica-ejb/TraduccioEJB!org.fundaciobit.instanciagenerica.ejb.TraduccioService";

    public TraduccioJPA findByPrimaryKey(Long _ID_);
}
