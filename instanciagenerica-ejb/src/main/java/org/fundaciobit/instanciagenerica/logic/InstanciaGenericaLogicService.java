
package org.fundaciobit.instanciagenerica.logic;


import javax.ejb.Local;

import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaIJPAManager;
import org.fundaciobit.instanciagenerica.ejb.InstanciaGenericaService;
import org.fundaciobit.instanciagenerica.model.dao.IInstanciaGenericaManager;

/**
 * 
 * @author ptrias
 *
 */
@Local
public interface InstanciaGenericaLogicService extends InstanciaGenericaService {

    public static final String JNDI_NAME = "java:app/instanciagenerica-ejb/InstanciaGenericaLogicEJB!org.fundaciobit.instanciagenerica.logic.InstanciaGenericaLogicService";

}
