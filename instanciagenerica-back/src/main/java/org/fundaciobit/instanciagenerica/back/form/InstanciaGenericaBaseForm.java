package org.fundaciobit.instanciagenerica.back.form;

import org.fundaciobit.genapp.common.web.form.BaseForm;

/**
 * 
 * @author anadal
 *
 */
public abstract class InstanciaGenericaBaseForm extends BaseForm {

  public InstanciaGenericaBaseForm() {
  }
  
  public InstanciaGenericaBaseForm(boolean nou) {
    super(nou);
  }
  
  public InstanciaGenericaBaseForm(InstanciaGenericaBaseForm __toClone) {
    super(__toClone);
  }
  
}
