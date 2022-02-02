
package org.fundaciobit.instanciagenerica.logic;

import javax.ejb.Stateless;
import javax.annotation.security.PermitAll;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.instanciagenerica.model.entity.Fitxer;
import org.fundaciobit.instanciagenerica.ejb.FitxerEJB;

/**
 * 
 * @author ptrias
 *
 */
@Stateless
public class FitxerLogicEJB extends FitxerEJB implements FitxerLogicService {

    @Override
    @PermitAll
    public Fitxer create(Fitxer instance) throws I18NException {
        return super.create(instance);
    }

    @Override
    @PermitAll
    public Fitxer update(Fitxer instance) throws I18NException {
        return super.update(instance);
   }

}
