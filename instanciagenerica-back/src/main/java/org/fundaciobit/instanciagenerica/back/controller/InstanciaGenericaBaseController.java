package org.fundaciobit.instanciagenerica.back.controller;

import org.fundaciobit.genapp.common.IGenAppEntity;
import org.fundaciobit.genapp.common.web.controller.CommonBaseController;

/**
 * POT SOBRESCRIURE AQUESTA CLASSE
 * @author anadal
 *
 */
public abstract class InstanciaGenericaBaseController<I extends IGenAppEntity, PK extends Object> 
  extends CommonBaseController<I, PK> {

}
