package org.fundaciobit.instanciagenerica.persistence.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.instanciagenerica.model.fields.InstanciaGenericaFields;
import org.fundaciobit.instanciagenerica.model.fields.IdiomaFields;
import org.fundaciobit.instanciagenerica.model.fields.TraduccioFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class InstanciaGenericaValidator<I extends InstanciaGenerica>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements InstanciaGenericaFields {

    protected final Logger log = Logger.getLogger(getClass());


  public InstanciaGenericaValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,org.fundaciobit.instanciagenerica.model.dao.IIdiomaManager __idiomaManager
    ,org.fundaciobit.instanciagenerica.model.dao.IInstanciaGenericaManager __instanciaGenericaManager
    ,org.fundaciobit.instanciagenerica.model.dao.ITraduccioManager __traduccioManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,NUMREGISTRE, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NUMREGISTRE)));

    __vr.rejectIfEmptyOrWhitespace(__target__,DATACREACIO, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DATACREACIO)));

    __vr.rejectIfEmptyOrWhitespace(__target__,SOLICITANTTIPUSADMINID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITANTTIPUSADMINID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,SOLICITANTADMINID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITANTADMINID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,SOLICITANTPERSONAFISICA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITANTPERSONAFISICA)));

    __vr.rejectIfEmptyOrWhitespace(__target__,SOLICITANTDIRECCIO, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITANTDIRECCIO)));

    __vr.rejectIfEmptyOrWhitespace(__target__,SOLICITANTEMAIL, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITANTEMAIL)));

    __vr.rejectIfEmptyOrWhitespace(__target__,SOLICITANTTELEFON, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITANTTELEFON)));

    __vr.rejectIfEmptyOrWhitespace(__target__,TITOLID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TITOLID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,IDIOMAID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(IDIOMAID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,EXPOSA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(EXPOSA)));

    __vr.rejectIfEmptyOrWhitespace(__target__,SOLICITA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITA)));

    // Check size
    if (__vr.getFieldErrorCount(NUMREGISTRE) == 0) {
      java.lang.String __numregistre = __target__.getNumRegistre();
      if (__numregistre!= null && __numregistre.length() > 50) {
        __vr.rejectValue(NUMREGISTRE, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NUMREGISTRE)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(50)));
      }
    }

    if (__vr.getFieldErrorCount(UUID) == 0) {
      java.lang.String __uuid = __target__.getUuid();
      if (__uuid!= null && __uuid.length() > 100) {
        __vr.rejectValue(UUID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(UUID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(SOLICITANTADMINID) == 0) {
      java.lang.String __solicitantadminid = __target__.getSolicitantAdminID();
      if (__solicitantadminid!= null && __solicitantadminid.length() > 50) {
        __vr.rejectValue(SOLICITANTADMINID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITANTADMINID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(50)));
      }
    }

    if (__vr.getFieldErrorCount(SOLICITANTADMINID) == 0) {
      String val = __target__.getSolicitantAdminID();
      if (val != null && val.trim().length() != 0) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("([XYZ][0-9]{7}[A-Z])|([0-9]{8}[A-Z])");
        if (!p.matcher(val).matches()) {
          __vr.rejectValue(SOLICITANTADMINID, "genapp.validation.malformed",
             new org.fundaciobit.genapp.common.i18n.I18NArgumentString(val), new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITANTADMINID)));
        }
      }
    }

    if (__vr.getFieldErrorCount(SOLICITANTNOM) == 0) {
      java.lang.String __solicitantnom = __target__.getSolicitantNom();
      if (__solicitantnom!= null && __solicitantnom.length() > 100) {
        __vr.rejectValue(SOLICITANTNOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITANTNOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(SOLICITANTLLINATGE1) == 0) {
      java.lang.String __solicitantllinatge1 = __target__.getSolicitantLlinatge1();
      if (__solicitantllinatge1!= null && __solicitantllinatge1.length() > 100) {
        __vr.rejectValue(SOLICITANTLLINATGE1, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITANTLLINATGE1)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(SOLICITANTLLINATGE2) == 0) {
      java.lang.String __solicitantllinatge2 = __target__.getSolicitantLlinatge2();
      if (__solicitantllinatge2!= null && __solicitantllinatge2.length() > 100) {
        __vr.rejectValue(SOLICITANTLLINATGE2, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITANTLLINATGE2)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(SOLICITANTRAOSOCIAL) == 0) {
      java.lang.String __solicitantraosocial = __target__.getSolicitantRaoSocial();
      if (__solicitantraosocial!= null && __solicitantraosocial.length() > 100) {
        __vr.rejectValue(SOLICITANTRAOSOCIAL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITANTRAOSOCIAL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(SOLICITANTDIRECCIO) == 0) {
      java.lang.String __solicitantdireccio = __target__.getSolicitantDireccio();
      if (__solicitantdireccio!= null && __solicitantdireccio.length() > 255) {
        __vr.rejectValue(SOLICITANTDIRECCIO, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITANTDIRECCIO)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(255)));
      }
    }

    if (__vr.getFieldErrorCount(SOLICITANTEMAIL) == 0) {
      java.lang.String __solicitantemail = __target__.getSolicitantEmail();
      if (__solicitantemail!= null && __solicitantemail.length() > 100) {
        __vr.rejectValue(SOLICITANTEMAIL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITANTEMAIL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(SOLICITANTEMAIL) == 0) {
      String val = __target__.getSolicitantEmail();
      if (val != null && val.trim().length() != 0) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
        if (!p.matcher(val).matches()) {
          __vr.rejectValue(SOLICITANTEMAIL, "genapp.validation.malformed",
             new org.fundaciobit.genapp.common.i18n.I18NArgumentString(val), new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITANTEMAIL)));
        }
      }
    }

    if (__vr.getFieldErrorCount(SOLICITANTTELEFON) == 0) {
      java.lang.String __solicitanttelefon = __target__.getSolicitantTelefon();
      if (__solicitanttelefon!= null && __solicitanttelefon.length() > 50) {
        __vr.rejectValue(SOLICITANTTELEFON, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITANTTELEFON)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(50)));
      }
    }

    if (__vr.getFieldErrorCount(IDIOMAID) == 0) {
      java.lang.String __idiomaid = __target__.getIdiomaID();
      if (__idiomaid!= null && __idiomaid.length() > 20) {
        __vr.rejectValue(IDIOMAID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(IDIOMAID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(20)));
      }
    }

    if (__vr.getFieldErrorCount(EXPOSA) == 0) {
      java.lang.String __exposa = __target__.getExposa();
      if (__exposa!= null && __exposa.length() > 2147483647) {
        __vr.rejectValue(EXPOSA, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(EXPOSA)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }

    if (__vr.getFieldErrorCount(SOLICITA) == 0) {
      java.lang.String __solicita = __target__.getSolicita();
      if (__solicita!= null && __solicita.length() > 2147483647) {
        __vr.rejectValue(SOLICITA, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(SOLICITA)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }

    if (__vr.getFieldErrorCount(ERROR) == 0) {
      java.lang.String __error = __target__.getError();
      if (__error!= null && __error.length() > 2147483647) {
        __vr.rejectValue(ERROR, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ERROR)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }

    if (__vr.getFieldErrorCount(EXCEPTION) == 0) {
      java.lang.String __exception = __target__.getException();
      if (__exception!= null && __exception.length() > 2147483647) {
        __vr.rejectValue(EXCEPTION, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(EXCEPTION)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }

    if (__isNou__) { // Creació
      // ================ CREATION
      // Fitxers 
      // ====== Check Unique MULTIPLES - NOU =======

      // Check Unique - no PK
      // Check Unique - PK no AutoIncrement amb UNA SOLA PK 
    } else {
      // ================ UPDATE

      // ====== Check Unique MULTIPLES - EDIT  =======

      // Check Unique - no PK
    }

    // Fields with References to Other tables 
    if (__vr.getFieldErrorCount(TITOLID) == 0) {
      java.lang.Long __titolid = __target__.getTitolID();
      Long __count_ = null;
      try { __count_ = __traduccioManager.count(TraduccioFields.TRADUCCIOID.equal(__titolid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(TITOLID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("traduccio.traduccio"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("traduccio.traduccioID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__titolid)));
      }
    }

    if (__vr.getFieldErrorCount(IDIOMAID) == 0) {
      java.lang.String __idiomaid = __target__.getIdiomaID();
      Long __count_ = null;
      try { __count_ = __idiomaManager.count(IdiomaFields.IDIOMAID.equal(__idiomaid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(IDIOMAID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("idioma.idioma"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("idioma.idiomaID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__idiomaid)));
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}