
package org.fundaciobit.instanciagenerica.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.instanciagenerica.back.form.InstanciaGenericaBaseFilterForm;

import org.fundaciobit.instanciagenerica.model.fields.InstanciaGenericaFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class InstanciaGenericaFilterForm extends InstanciaGenericaBaseFilterForm implements InstanciaGenericaFields {

  private java.lang.Long instanciaGenericaIDDesde;

  public java.lang.Long getInstanciaGenericaIDDesde() {
    return this.instanciaGenericaIDDesde;
  }

  public void setInstanciaGenericaIDDesde(java.lang.Long instanciaGenericaIDDesde) {
    this.instanciaGenericaIDDesde = instanciaGenericaIDDesde;
  }


  private java.lang.Long instanciaGenericaIDFins;

  public java.lang.Long getInstanciaGenericaIDFins() {
    return this.instanciaGenericaIDFins;
  }

  public void setInstanciaGenericaIDFins(java.lang.Long instanciaGenericaIDFins) {
    this.instanciaGenericaIDFins = instanciaGenericaIDFins;
  }


  private java.lang.String numRegistre;

  public java.lang.String getNumRegistre() {
    return this.numRegistre;
  }

  public void setNumRegistre(java.lang.String numRegistre) {
    this.numRegistre = numRegistre;
  }


  private java.lang.String uuid;

  public java.lang.String getUuid() {
    return this.uuid;
  }

  public void setUuid(java.lang.String uuid) {
    this.uuid = uuid;
  }


  private java.lang.Integer solicitantTipusAdminIDDesde;

  public java.lang.Integer getSolicitantTipusAdminIDDesde() {
    return this.solicitantTipusAdminIDDesde;
  }

  public void setSolicitantTipusAdminIDDesde(java.lang.Integer solicitantTipusAdminIDDesde) {
    this.solicitantTipusAdminIDDesde = solicitantTipusAdminIDDesde;
  }


  private java.lang.Integer solicitantTipusAdminIDFins;

  public java.lang.Integer getSolicitantTipusAdminIDFins() {
    return this.solicitantTipusAdminIDFins;
  }

  public void setSolicitantTipusAdminIDFins(java.lang.Integer solicitantTipusAdminIDFins) {
    this.solicitantTipusAdminIDFins = solicitantTipusAdminIDFins;
  }


  private java.lang.String solicitantAdminID;

  public java.lang.String getSolicitantAdminID() {
    return this.solicitantAdminID;
  }

  public void setSolicitantAdminID(java.lang.String solicitantAdminID) {
    this.solicitantAdminID = solicitantAdminID;
  }


  private java.lang.String solicitantNom;

  public java.lang.String getSolicitantNom() {
    return this.solicitantNom;
  }

  public void setSolicitantNom(java.lang.String solicitantNom) {
    this.solicitantNom = solicitantNom;
  }


  private java.lang.String solicitantLlinatge1;

  public java.lang.String getSolicitantLlinatge1() {
    return this.solicitantLlinatge1;
  }

  public void setSolicitantLlinatge1(java.lang.String solicitantLlinatge1) {
    this.solicitantLlinatge1 = solicitantLlinatge1;
  }


  private java.lang.String solicitantLlinatge2;

  public java.lang.String getSolicitantLlinatge2() {
    return this.solicitantLlinatge2;
  }

  public void setSolicitantLlinatge2(java.lang.String solicitantLlinatge2) {
    this.solicitantLlinatge2 = solicitantLlinatge2;
  }


  private java.lang.String solicitantCif;

  public java.lang.String getSolicitantCif() {
    return this.solicitantCif;
  }

  public void setSolicitantCif(java.lang.String solicitantCif) {
    this.solicitantCif = solicitantCif;
  }


  private java.lang.String solicitantRaoSocial;

  public java.lang.String getSolicitantRaoSocial() {
    return this.solicitantRaoSocial;
  }

  public void setSolicitantRaoSocial(java.lang.String solicitantRaoSocial) {
    this.solicitantRaoSocial = solicitantRaoSocial;
  }


  private java.lang.String solicitantDireccio;

  public java.lang.String getSolicitantDireccio() {
    return this.solicitantDireccio;
  }

  public void setSolicitantDireccio(java.lang.String solicitantDireccio) {
    this.solicitantDireccio = solicitantDireccio;
  }


  private java.lang.String solicitantEmail;

  public java.lang.String getSolicitantEmail() {
    return this.solicitantEmail;
  }

  public void setSolicitantEmail(java.lang.String solicitantEmail) {
    this.solicitantEmail = solicitantEmail;
  }


  private java.lang.String solicitantTelefon;

  public java.lang.String getSolicitantTelefon() {
    return this.solicitantTelefon;
  }

  public void setSolicitantTelefon(java.lang.String solicitantTelefon) {
    this.solicitantTelefon = solicitantTelefon;
  }


  private java.lang.String idiomaID;

  public java.lang.String getIdiomaID() {
    return this.idiomaID;
  }

  public void setIdiomaID(java.lang.String idiomaID) {
    this.idiomaID = idiomaID;
  }


  private java.lang.String exposa;

  public java.lang.String getExposa() {
    return this.exposa;
  }

  public void setExposa(java.lang.String exposa) {
    this.exposa = exposa;
  }


  private java.lang.String solicita;

  public java.lang.String getSolicita() {
    return this.solicita;
  }

  public void setSolicita(java.lang.String solicita) {
    this.solicita = solicita;
  }


  private java.sql.Timestamp dataCreacioDesde;

  public java.sql.Timestamp getDataCreacioDesde() {
    return this.dataCreacioDesde;
  }

  public void setDataCreacioDesde(java.sql.Timestamp dataCreacioDesde) {
    this.dataCreacioDesde = dataCreacioDesde;
  }


  private java.sql.Timestamp dataCreacioFins;

  public java.sql.Timestamp getDataCreacioFins() {
    return this.dataCreacioFins;
  }

  public void setDataCreacioFins(java.sql.Timestamp dataCreacioFins) {
    this.dataCreacioFins = dataCreacioFins;
  }


  private java.sql.Timestamp datafinalitzacioDesde;

  public java.sql.Timestamp getDatafinalitzacioDesde() {
    return this.datafinalitzacioDesde;
  }

  public void setDatafinalitzacioDesde(java.sql.Timestamp datafinalitzacioDesde) {
    this.datafinalitzacioDesde = datafinalitzacioDesde;
  }


  private java.sql.Timestamp datafinalitzacioFins;

  public java.sql.Timestamp getDatafinalitzacioFins() {
    return this.datafinalitzacioFins;
  }

  public void setDatafinalitzacioFins(java.sql.Timestamp datafinalitzacioFins) {
    this.datafinalitzacioFins = datafinalitzacioFins;
  }


  private java.lang.Integer estatDesde;

  public java.lang.Integer getEstatDesde() {
    return this.estatDesde;
  }

  public void setEstatDesde(java.lang.Integer estatDesde) {
    this.estatDesde = estatDesde;
  }


  private java.lang.Integer estatFins;

  public java.lang.Integer getEstatFins() {
    return this.estatFins;
  }

  public void setEstatFins(java.lang.Integer estatFins) {
    this.estatFins = estatFins;
  }


  private java.lang.String error;

  public java.lang.String getError() {
    return this.error;
  }

  public void setError(java.lang.String error) {
    this.error = error;
  }


  private java.lang.String exception;

  public java.lang.String getException() {
    return this.exception;
  }

  public void setException(java.lang.String exception) {
    this.exception = exception;
  }


  public InstanciaGenericaFilterForm() {
  }
  
  public InstanciaGenericaFilterForm(InstanciaGenericaFilterForm __toClone) {
    super(__toClone);
    this.instanciaGenericaIDDesde = __toClone.instanciaGenericaIDDesde;
    this.instanciaGenericaIDFins = __toClone.instanciaGenericaIDFins;
    this.numRegistre = __toClone.numRegistre;
    this.uuid = __toClone.uuid;
    this.solicitantTipusAdminIDDesde = __toClone.solicitantTipusAdminIDDesde;
    this.solicitantTipusAdminIDFins = __toClone.solicitantTipusAdminIDFins;
    this.solicitantAdminID = __toClone.solicitantAdminID;
    this.solicitantNom = __toClone.solicitantNom;
    this.solicitantLlinatge1 = __toClone.solicitantLlinatge1;
    this.solicitantLlinatge2 = __toClone.solicitantLlinatge2;
    this.solicitantCif = __toClone.solicitantCif;
    this.solicitantRaoSocial = __toClone.solicitantRaoSocial;
    this.solicitantDireccio = __toClone.solicitantDireccio;
    this.solicitantEmail = __toClone.solicitantEmail;
    this.solicitantTelefon = __toClone.solicitantTelefon;
    this.idiomaID = __toClone.idiomaID;
    this.exposa = __toClone.exposa;
    this.solicita = __toClone.solicita;
    this.dataCreacioDesde = __toClone.dataCreacioDesde;
    this.dataCreacioFins = __toClone.dataCreacioFins;
    this.datafinalitzacioDesde = __toClone.datafinalitzacioDesde;
    this.datafinalitzacioFins = __toClone.datafinalitzacioFins;
    this.estatDesde = __toClone.estatDesde;
    this.estatFins = __toClone.estatFins;
    this.error = __toClone.error;
    this.exception = __toClone.exception;
    this.mapOfValuesForSolicitantPersonaFisica = __toClone.mapOfValuesForSolicitantPersonaFisica;
    this.mapOfValuesForSolicitantTipusAdminID = __toClone.mapOfValuesForSolicitantTipusAdminID;
    this.mapOfIdiomaForIdiomaID = __toClone.mapOfIdiomaForIdiomaID;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { NUMREGISTRE ,SOLICITANTADMINID ,SOLICITANTLLINATGE1 ,SOLICITANTLLINATGE2 ,SOLICITANTRAOSOCIAL ,SOLICITANTEMAIL ,DATACREACIO ,ESTAT }));
  }

  @Override
  public List<Field<?>> getDefaultGroupByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { SOLICITANTPERSONAFISICA ,SOLICITANTTIPUSADMINID ,IDIOMAID ,DATACREACIO }));
  }


  protected OrderBy[] defaultOrderBy = new OrderBy[] {new OrderBy(INSTANCIAGENERICAID )};


  public OrderBy[] getDefaultOrderBy() {
    return this.defaultOrderBy;
  }

  public void setDefaultOrderBy(OrderBy[] defOrderBy) {
    this.defaultOrderBy = defOrderBy;
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

   // -----------------------
   // Maps de referencies.
   // -----------------------
  private Map<String, String> mapOfValuesForSolicitantPersonaFisica;

  public Map<String, String> getMapOfValuesForSolicitantPersonaFisica() {
    return this.mapOfValuesForSolicitantPersonaFisica;
  }

  public void setMapOfValuesForSolicitantPersonaFisica(Map<String, String> mapOfValuesForSolicitantPersonaFisica) {
    this.mapOfValuesForSolicitantPersonaFisica = mapOfValuesForSolicitantPersonaFisica;
  }



  private Map<String, String> mapOfValuesForSolicitantTipusAdminID;

  public Map<String, String> getMapOfValuesForSolicitantTipusAdminID() {
    return this.mapOfValuesForSolicitantTipusAdminID;
  }

  public void setMapOfValuesForSolicitantTipusAdminID(Map<String, String> mapOfValuesForSolicitantTipusAdminID) {
    this.mapOfValuesForSolicitantTipusAdminID = mapOfValuesForSolicitantTipusAdminID;
  }



  private Map<String, String> mapOfIdiomaForIdiomaID;

  public Map<String, String> getMapOfIdiomaForIdiomaID() {
    return this.mapOfIdiomaForIdiomaID;
  }

  public void setMapOfIdiomaForIdiomaID(Map<String, String> mapOfIdiomaForIdiomaID) {
    this.mapOfIdiomaForIdiomaID = mapOfIdiomaForIdiomaID;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
