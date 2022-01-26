
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
import org.fundaciobit.instanciagenerica.ejb.TraduccioService;
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

  @EJB(mappedName = TraduccioService.JNDI_NAME)
  private TraduccioService traduccioEjb;
  public InstanciaGenericaRefList(InstanciaGenericaRefList __clone) {
    super(__clone);
    this.instanciaGenericaEjb = __clone.instanciaGenericaEjb;
    this.traduccioEjb = __clone.traduccioEjb;
  }
  public InstanciaGenericaRefList() {
    setSelects(new Select<?>[] { NUMREGISTRE.select });
    addCampTraduible(TITOLID.select);
  }
  public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where, OrderBy ... orderBy) throws I18NException {
    Select<Long> _transSelect = checkTranslationFields();
    Select<StringKeyValue> select =  new org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue(keyField.select, getSeparator(), getSelects());
    List<StringKeyValue> list = instanciaGenericaEjb.executeQuery(select, where, (orderBy==null || orderBy.length == 0) ? getOrderBy() : orderBy);
    if (_transSelect == null) {
      return list;
    }
    // key => TransID | value => instanciaGenericaEjb_PK
    java.util.Map<String,String> keysMap = org.fundaciobit.genapp.common.utils.Utils.listToMapInverse(list);
    org.fundaciobit.genapp.common.query.Where _w1 = org.fundaciobit.instanciagenerica.model.fields.TraduccioFields.TRADUCCIOID.in(instanciaGenericaEjb.executeQuery(_transSelect, where));
    List<org.fundaciobit.instanciagenerica.model.entity.Traduccio> traduccions = traduccioEjb.select(_w1);
    List<StringKeyValue> _list = new java.util.ArrayList<StringKeyValue>(traduccions.size());
    final String _lang = org.fundaciobit.genapp.common.web.i18n.I18NUtils.getLocale().getLanguage();
    for (org.fundaciobit.instanciagenerica.model.entity.Traduccio traduccio : traduccions) {
      org.fundaciobit.instanciagenerica.persistence.TraduccioJPA traduccioJPA = (org.fundaciobit.instanciagenerica.persistence.TraduccioJPA) traduccio;
      String key = keysMap.get(String.valueOf(traduccioJPA.getTraduccioID()));
      org.fundaciobit.instanciagenerica.persistence.TraduccioMapJPA _tm = traduccioJPA.getTraduccio(_lang);
      String value;
      if (_tm == null) {
          value = "NO_TRADUCCIO_PER_CODI_" + traduccio.getTraduccioID() + "_[" + _lang + "]";
      } else {
          value= _tm.getValor();
      }
      StringKeyValue skv = new StringKeyValue(key, value);
      _list.add(skv);
    }
    if (!_list.isEmpty()) {
      java.util.Collections.sort(_list, new org.fundaciobit.genapp.common.KeyValue.KeyValueComparator<String>());
    }
    return _list;

  }
}
