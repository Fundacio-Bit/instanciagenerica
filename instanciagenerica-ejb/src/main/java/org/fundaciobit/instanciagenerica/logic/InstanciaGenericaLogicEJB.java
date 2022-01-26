
package org.fundaciobit.instanciagenerica.logic;

import javax.ejb.Stateless;
import javax.annotation.security.PermitAll;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;

import org.fundaciobit.instanciagenerica.ejb.InstanciaGenericaEJB;

/**
 * 
 * @author ptrias
 *
 */
@Stateless
public class InstanciaGenericaLogicEJB extends InstanciaGenericaEJB implements InstanciaGenericaLogicService {

    @Override
    @PermitAll
    public InstanciaGenerica create(InstanciaGenerica instance) throws I18NException {
        return super.create(instance);
    }
}
