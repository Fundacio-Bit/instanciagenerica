
package org.fundaciobit.instanciagenerica.logic;


import javax.ejb.Local;

import org.fundaciobit.instanciagenerica.ejb.FitxerService;

/**
 * 
 * @author ptrias
 *
 */
@Local
public interface FitxerLogicService extends FitxerService {

    public static final String JNDI_NAME = "java:app/instanciagenerica-ejb/FitxerLogicEJB!org.fundaciobit.instanciagenerica.logic.FitxerLogicService";

}
