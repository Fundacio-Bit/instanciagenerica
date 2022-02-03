package org.fundaciobit.instanciagenerica.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.fundaciobit.instanciagenerica.back.form.InstanciaGenericaBaseForm;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class InstanciaGenericaForm extends InstanciaGenericaBaseForm {
  
  private InstanciaGenericaJPA instanciaGenerica;
  
  
  private CommonsMultipartFile fitxer1ID;
  private boolean fitxer1IDDelete;
  
  
  private CommonsMultipartFile fitxer2ID;
  private boolean fitxer2IDDelete;
  
  
  private CommonsMultipartFile fitxer3ID;
  private boolean fitxer3IDDelete;
  
  
  private CommonsMultipartFile fitxer4ID;
  private boolean fitxer4IDDelete;
  
  
  private CommonsMultipartFile fitxer5ID;
  private boolean fitxer5IDDelete;
  
  
  private CommonsMultipartFile fitxer6ID;
  private boolean fitxer6IDDelete;
  
  
  private CommonsMultipartFile fitxer7ID;
  private boolean fitxer7IDDelete;
  
  
  private CommonsMultipartFile fitxer8ID;
  private boolean fitxer8IDDelete;
  
  
  private CommonsMultipartFile fitxer9ID;
  private boolean fitxer9IDDelete;
  
  public InstanciaGenericaForm() {
  }
  
  public InstanciaGenericaForm(InstanciaGenericaForm __toClone) {
    super(__toClone);
      this.instanciaGenerica = __toClone.instanciaGenerica;
    this.listOfValuesForSolicitantTipusAdminID = __toClone.listOfValuesForSolicitantTipusAdminID;
    this.listOfValuesForSolicitantPersonaFisica = __toClone.listOfValuesForSolicitantPersonaFisica;
    this.listOfIdiomaForIdiomaID = __toClone.listOfIdiomaForIdiomaID;
  }
  
  public InstanciaGenericaForm(InstanciaGenericaJPA instanciaGenerica, boolean nou) {
    super(nou);
    this.instanciaGenerica = instanciaGenerica;
  }
  
  public InstanciaGenericaJPA getInstanciaGenerica() {
    return instanciaGenerica;
  }
  public void setInstanciaGenerica(InstanciaGenericaJPA instanciaGenerica) {
    this.instanciaGenerica = instanciaGenerica;
  }
  
  
  public CommonsMultipartFile getFitxer1ID() {
    return fitxer1ID;
  }
  
   public void setFitxer1ID(CommonsMultipartFile fitxer1ID) {
    this.fitxer1ID = fitxer1ID;
  }
  public boolean isFitxer1IDDelete() {
    return fitxer1IDDelete;
  }
  
  public void setFitxer1IDDelete(boolean fitxer1IDDelete) {
    this.fitxer1IDDelete = fitxer1IDDelete;
   }
  public CommonsMultipartFile getFitxer2ID() {
    return fitxer2ID;
  }
  
   public void setFitxer2ID(CommonsMultipartFile fitxer2ID) {
    this.fitxer2ID = fitxer2ID;
  }
  public boolean isFitxer2IDDelete() {
    return fitxer2IDDelete;
  }
  
  public void setFitxer2IDDelete(boolean fitxer2IDDelete) {
    this.fitxer2IDDelete = fitxer2IDDelete;
   }
  public CommonsMultipartFile getFitxer3ID() {
    return fitxer3ID;
  }
  
   public void setFitxer3ID(CommonsMultipartFile fitxer3ID) {
    this.fitxer3ID = fitxer3ID;
  }
  public boolean isFitxer3IDDelete() {
    return fitxer3IDDelete;
  }
  
  public void setFitxer3IDDelete(boolean fitxer3IDDelete) {
    this.fitxer3IDDelete = fitxer3IDDelete;
   }
  public CommonsMultipartFile getFitxer4ID() {
    return fitxer4ID;
  }
  
   public void setFitxer4ID(CommonsMultipartFile fitxer4ID) {
    this.fitxer4ID = fitxer4ID;
  }
  public boolean isFitxer4IDDelete() {
    return fitxer4IDDelete;
  }
  
  public void setFitxer4IDDelete(boolean fitxer4IDDelete) {
    this.fitxer4IDDelete = fitxer4IDDelete;
   }
  public CommonsMultipartFile getFitxer5ID() {
    return fitxer5ID;
  }
  
   public void setFitxer5ID(CommonsMultipartFile fitxer5ID) {
    this.fitxer5ID = fitxer5ID;
  }
  public boolean isFitxer5IDDelete() {
    return fitxer5IDDelete;
  }
  
  public void setFitxer5IDDelete(boolean fitxer5IDDelete) {
    this.fitxer5IDDelete = fitxer5IDDelete;
   }
  public CommonsMultipartFile getFitxer6ID() {
    return fitxer6ID;
  }
  
   public void setFitxer6ID(CommonsMultipartFile fitxer6ID) {
    this.fitxer6ID = fitxer6ID;
  }
  public boolean isFitxer6IDDelete() {
    return fitxer6IDDelete;
  }
  
  public void setFitxer6IDDelete(boolean fitxer6IDDelete) {
    this.fitxer6IDDelete = fitxer6IDDelete;
   }
  public CommonsMultipartFile getFitxer7ID() {
    return fitxer7ID;
  }
  
   public void setFitxer7ID(CommonsMultipartFile fitxer7ID) {
    this.fitxer7ID = fitxer7ID;
  }
  public boolean isFitxer7IDDelete() {
    return fitxer7IDDelete;
  }
  
  public void setFitxer7IDDelete(boolean fitxer7IDDelete) {
    this.fitxer7IDDelete = fitxer7IDDelete;
   }
  public CommonsMultipartFile getFitxer8ID() {
    return fitxer8ID;
  }
  
   public void setFitxer8ID(CommonsMultipartFile fitxer8ID) {
    this.fitxer8ID = fitxer8ID;
  }
  public boolean isFitxer8IDDelete() {
    return fitxer8IDDelete;
  }
  
  public void setFitxer8IDDelete(boolean fitxer8IDDelete) {
    this.fitxer8IDDelete = fitxer8IDDelete;
   }
  public CommonsMultipartFile getFitxer9ID() {
    return fitxer9ID;
  }
  
   public void setFitxer9ID(CommonsMultipartFile fitxer9ID) {
    this.fitxer9ID = fitxer9ID;
  }
  public boolean isFitxer9IDDelete() {
    return fitxer9IDDelete;
  }
  
  public void setFitxer9IDDelete(boolean fitxer9IDDelete) {
    this.fitxer9IDDelete = fitxer9IDDelete;
   }
  private List<StringKeyValue> listOfValuesForSolicitantTipusAdminID;

  public List<StringKeyValue> getListOfValuesForSolicitantTipusAdminID() {
    return this.listOfValuesForSolicitantTipusAdminID;
  }

  public void setListOfValuesForSolicitantTipusAdminID(List<StringKeyValue> listOfValuesForSolicitantTipusAdminID) {
    this.listOfValuesForSolicitantTipusAdminID = listOfValuesForSolicitantTipusAdminID;
  }



  private List<StringKeyValue> listOfValuesForSolicitantPersonaFisica;

  public List<StringKeyValue> getListOfValuesForSolicitantPersonaFisica() {
    return this.listOfValuesForSolicitantPersonaFisica;
  }

  public void setListOfValuesForSolicitantPersonaFisica(List<StringKeyValue> listOfValuesForSolicitantPersonaFisica) {
    this.listOfValuesForSolicitantPersonaFisica = listOfValuesForSolicitantPersonaFisica;
  }



  private List<StringKeyValue> listOfIdiomaForIdiomaID;

  public List<StringKeyValue> getListOfIdiomaForIdiomaID() {
    return this.listOfIdiomaForIdiomaID;
  }

  public void setListOfIdiomaForIdiomaID(List<StringKeyValue> listOfIdiomaForIdiomaID) {
    this.listOfIdiomaForIdiomaID = listOfIdiomaForIdiomaID;
  }



  
} // Final de Classe 
