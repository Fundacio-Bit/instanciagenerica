package org.fundaciobit.instanciagenerica.persistence.validator;

import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;
import org.fundaciobit.genapp.common.validation.BeanValidatorResult;
import java.util.List;
import org.fundaciobit.genapp.common.i18n.I18NFieldError;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.validation.AbstractBeanValidator;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class InstanciaGenericaBeanValidator 
      extends AbstractBeanValidator<InstanciaGenericaJPA> {


  // EJB's
  protected final org.fundaciobit.instanciagenerica.model.dao.IIdiomaManager __idiomaManager;

  protected final org.fundaciobit.instanciagenerica.model.dao.IInstanciaGenericaManager __instanciaGenericaManager;

  protected final org.fundaciobit.instanciagenerica.model.dao.ITraduccioManager __traduccioManager;


  public final InstanciaGenericaValidator<InstanciaGenericaJPA> _validator;


  public InstanciaGenericaBeanValidator(org.fundaciobit.instanciagenerica.model.dao.IIdiomaManager __idiomaManager,
     org.fundaciobit.instanciagenerica.model.dao.IInstanciaGenericaManager __instanciaGenericaManager,
     org.fundaciobit.instanciagenerica.model.dao.ITraduccioManager __traduccioManager) { 
    this.__idiomaManager = __idiomaManager;
    this.__instanciaGenericaManager = __instanciaGenericaManager;
    this.__traduccioManager = __traduccioManager;
    _validator = new InstanciaGenericaValidator<InstanciaGenericaJPA>();
  }

  public InstanciaGenericaBeanValidator(InstanciaGenericaValidator<InstanciaGenericaJPA> _validator,
     org.fundaciobit.instanciagenerica.model.dao.IIdiomaManager __idiomaManager,
     org.fundaciobit.instanciagenerica.model.dao.IInstanciaGenericaManager __instanciaGenericaManager,
     org.fundaciobit.instanciagenerica.model.dao.ITraduccioManager __traduccioManager) {
    this.__idiomaManager = __idiomaManager;
    this.__instanciaGenericaManager = __instanciaGenericaManager;
    this.__traduccioManager = __traduccioManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(InstanciaGenericaJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<InstanciaGenericaJPA> _bvr_ = new BeanValidatorResult<InstanciaGenericaJPA>();
    _validator.validate(_bvr_, target, isNou, __idiomaManager, __instanciaGenericaManager, __traduccioManager);
    return _bvr_.getErrors();
  }
}
