
package org.fundaciobit.instanciagenerica.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.instanciagenerica.persistence.IdiomaJPA;
import org.fundaciobit.instanciagenerica.persistence.IdiomaIJPAManager;
import org.fundaciobit.instanciagenerica.model.dao.IIdiomaManager;

@Local
public interface IdiomaService extends IdiomaIJPAManager,IIdiomaManager {

    public static final String JNDI_NAME = "java:app/instanciagenerica-ejb/IdiomaEJB!org.fundaciobit.instanciagenerica.ejb.IdiomaService";

    public IdiomaJPA findByPrimaryKey(String _ID_);
}
