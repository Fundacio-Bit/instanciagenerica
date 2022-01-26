
package org.fundaciobit.instanciagenerica.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Stateless;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPAManager;

import org.fundaciobit.instanciagenerica.commons.utils.Constants;

@Stateless
public class InstanciaGenericaEJB extends InstanciaGenericaJPAManager implements InstanciaGenericaService {

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS})
    public void delete(InstanciaGenerica instance) {
        super.delete(instance);
    }

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS})
    public InstanciaGenerica create(InstanciaGenerica instance) throws I18NException {
        return super.create(instance);
    }

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS})
    public InstanciaGenerica update(InstanciaGenerica instance) throws I18NException {
         return super.update(instance);
    }

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS})
    public InstanciaGenericaJPA findByPrimaryKey(Long _ID_) {
        return (InstanciaGenericaJPA)super.findByPrimaryKey(_ID_);
    }

}
