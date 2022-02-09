
package org.fundaciobit.instanciagenerica.logic;


import javax.ejb.Local;

import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaIJPAManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.instanciagenerica.ejb.InstanciaGenericaService;
import org.fundaciobit.instanciagenerica.model.dao.IInstanciaGenericaManager;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;

/**
 * 
 * @author ptrias
 *
 */
@Local
public interface InstanciaGenericaLogicService extends InstanciaGenericaService {

    public static final String JNDI_NAME = "java:app/instanciagenerica-ejb/InstanciaGenericaLogicEJB!org.fundaciobit.instanciagenerica.logic.InstanciaGenericaLogicService";

    public InstanciaGenerica registrarInstanciaGenerica(InstanciaGenerica ig) throws I18NException;

	public void deleteFull(InstanciaGenerica instanciaGenerica) throws I18NException;
	
	public InstanciaGenericaJPA generarInstanciaGenericaAleatoria(InstanciaGenericaJPA ig);
    
}
