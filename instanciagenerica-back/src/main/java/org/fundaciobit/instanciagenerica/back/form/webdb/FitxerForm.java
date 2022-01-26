package org.fundaciobit.instanciagenerica.back.form.webdb;

import org.fundaciobit.instanciagenerica.back.form.InstanciaGenericaBaseForm;
import org.fundaciobit.instanciagenerica.persistence.FitxerJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class FitxerForm extends InstanciaGenericaBaseForm {
  
  private FitxerJPA fitxer;
  
  public FitxerForm() {
  }
  
  public FitxerForm(FitxerForm __toClone) {
    super(__toClone);
      this.fitxer = __toClone.fitxer;
  }
  
  public FitxerForm(FitxerJPA fitxer, boolean nou) {
    super(nou);
    this.fitxer = fitxer;
  }
  
  public FitxerJPA getFitxer() {
    return fitxer;
  }
  public void setFitxer(FitxerJPA fitxer) {
    this.fitxer = fitxer;
  }
  
  
  
} // Final de Classe 
