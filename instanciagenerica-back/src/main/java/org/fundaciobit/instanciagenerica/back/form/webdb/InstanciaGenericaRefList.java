
package org.fundaciobit.instanciagenerica.back.form.webdb;

import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Select;
import org.fundaciobit.genapp.common.query.Where;

import org.fundaciobit.instanciagenerica.ejb.InstanciaGenericaService;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.instanciagenerica.model.fields.InstanciaGenericaFields;
import org.fundaciobit.genapp.common.web.controller.RefListBase;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class InstanciaGenericaRefList extends RefListBase
    implements InstanciaGenericaFields {

  @EJB(mappedName = InstanciaGenericaService.JNDI_NAME)
  private InstanciaGenericaService instanciaGenericaEjb;

  public InstanciaGenericaRefList(InstanciaGenericaRefList __clone) {
    super(__clone);
    this.instanciaGenericaEjb = __clone.instanciaGenericaEjb;
  }
  public InstanciaGenericaRefList() {
    setSelects(new Select<?>[] { NUMREGISTRE.select });
  }
  public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where, OrderBy ... orderBy) throws I18NException {
    Select<StringKeyValue> select =  new org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue(keyField.select, getSeparator(), getSelects());
    List<StringKeyValue> list = instanciaGenericaEjb.executeQuery(select, where, (orderBy==null || orderBy.length == 0) ? getOrderBy() : orderBy);
    return list;
  }
}
