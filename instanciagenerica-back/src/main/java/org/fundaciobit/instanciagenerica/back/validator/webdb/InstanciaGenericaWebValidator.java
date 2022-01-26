package org.fundaciobit.instanciagenerica.back.validator.webdb;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.validation.BeanValidatorResult;
import org.fundaciobit.genapp.common.i18n.I18NFieldError;
import java.util.List;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.validation.WebValidationResult;
import org.fundaciobit.instanciagenerica.model.fields.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.fundaciobit.instanciagenerica.persistence.validator.InstanciaGenericaValidator;

import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class InstanciaGenericaWebValidator extends AbstractWebValidator<InstanciaGenericaForm, InstanciaGenerica>
     implements Validator, InstanciaGenericaFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected InstanciaGenericaValidator<InstanciaGenerica> validator = new InstanciaGenericaValidator<InstanciaGenerica>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.instanciagenerica.ejb.IdiomaService.JNDI_NAME)
  protected org.fundaciobit.instanciagenerica.ejb.IdiomaService idiomaEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.instanciagenerica.ejb.InstanciaGenericaService.JNDI_NAME)
  protected org.fundaciobit.instanciagenerica.ejb.InstanciaGenericaService instanciaGenericaEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.instanciagenerica.ejb.TraduccioService.JNDI_NAME)
  protected org.fundaciobit.instanciagenerica.ejb.TraduccioService traduccioEjb;



  public InstanciaGenericaWebValidator() {
    super();    
  }
  
  @Override
  public InstanciaGenerica getBeanOfForm(InstanciaGenericaForm form) {
    return  form.getInstanciaGenerica();
  }

  @Override
  public Class<InstanciaGenericaForm> getClassOfForm() {
    return InstanciaGenericaForm.class;
  }

  @Override
  public void validate(InstanciaGenericaForm __form, InstanciaGenerica __bean, Errors errors) {

java.util.List<Field<?>> _ignoreFields = new java.util.ArrayList<Field<?>>();
_ignoreFields.add(TITOLID);
    WebValidationResult<InstanciaGenericaForm> wvr;
    wvr = new WebValidationResult<InstanciaGenericaForm>(errors, _ignoreFields);

    boolean isNou;
    {
        Object objNou = errors.getFieldValue("nou");
        if (objNou == null) {
            isNou = false;
        } else { 
         Boolean nou = Boolean.parseBoolean((String)objNou);
         isNou =  nou != null && nou.booleanValue();
        }
    }

    validate(__form, __bean , errors, wvr, isNou);
  }


  public void validate(InstanciaGenericaForm __form, InstanciaGenerica __bean, Errors errors,
    WebValidationResult<InstanciaGenericaForm> wvr, boolean isNou) {

  {
      org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA __jpa;
      __jpa = (org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA)__bean;
    {
      // IF CAMP ES NOT NULL verificar que totes les traduccions son not null
      org.fundaciobit.instanciagenerica.persistence.TraduccioJPA tradJPA = __jpa.getTitol();
      if (tradJPA != null) {
        // TODO ERROR
        java.util.Map<String,org.fundaciobit.instanciagenerica.persistence.TraduccioMapJPA> _trad = tradJPA.getTraduccions();
        int countNotNull = 0;
        for (String _idioma : _trad.keySet()) {
          org.fundaciobit.instanciagenerica.persistence.TraduccioMapJPA _map = _trad.get(_idioma);
          if (_map == null || (_map.getValor() == null || _map.getValor().length() == 0 )) {
          } else {
            countNotNull++;
          }
        }

          if (countNotNull  == _trad.size()) {
            // OK Tot esta ple
          } else {
            for (String _idioma : _trad.keySet()) {
              org.fundaciobit.instanciagenerica.persistence.TraduccioMapJPA _map = _trad.get(_idioma);
              if (_map == null || (_map.getValor() == null || _map.getValor().length() == 0 )) {
                errors.rejectValue("instanciaGenerica.titol", "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(TITOLID.fullName)}, null);
                errors.rejectValue("instanciaGenerica.titol.traduccions["+ _idioma +"].valor",
                  "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(TITOLID.fullName)}, null);
              }
            }
          }
      } else {
        errors.rejectValue("instanciaGenerica.titol", "genapp.validation.required", new String[] {org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(TITOLID.fullName)}, null);
      }
    }

  }
    if (isNou) { // Creacio
      // ================ CREATION
      // Fitxers 
    }
    BeanValidatorResult<InstanciaGenerica> __vr = new BeanValidatorResult<InstanciaGenerica>();
    validator.validate(__vr, __bean,
      isNou, idiomaEjb, instanciaGenericaEjb, traduccioEjb);

    if (__vr.hasErrors()) {
        List<I18NFieldError> vrErrors = __vr.getErrors();
    	   for (I18NFieldError i18nFieldError : vrErrors) {
    	       wvr.rejectValue(i18nFieldError.getField(), i18nFieldError.getTranslation().getCode(), i18nFieldError.getTranslation().getArgs());
        }
    }


  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public InstanciaGenericaValidator<InstanciaGenerica> getValidator() {
    return validator;
  }

  public void setValidator(InstanciaGenericaValidator<InstanciaGenerica> validator) {
    this.validator = validator;
  }

}