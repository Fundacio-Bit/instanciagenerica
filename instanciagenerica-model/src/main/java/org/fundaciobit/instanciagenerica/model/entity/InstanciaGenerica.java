package org.fundaciobit.instanciagenerica.model.entity;

public interface InstanciaGenerica extends org.fundaciobit.genapp.common.IGenAppEntity {

	public java.lang.Long getInstanciaGenericaID();
	public void setInstanciaGenericaID(java.lang.Long _instanciaGenericaID_);

	public java.lang.String getNumRegistre();
	public void setNumRegistre(java.lang.String _numRegistre_);

	public java.lang.String getUuid();
	public void setUuid(java.lang.String _uuid_);

	public boolean isSolicitantPersonaFisica();
	public void setSolicitantPersonaFisica(boolean _solicitantPersonaFisica_);

	public int getSolicitantTipusAdminID();
	public void setSolicitantTipusAdminID(int _solicitantTipusAdminID_);

	public java.lang.String getSolicitantAdminID();
	public void setSolicitantAdminID(java.lang.String _solicitantAdminID_);

	public java.lang.String getSolicitantNom();
	public void setSolicitantNom(java.lang.String _solicitantNom_);

	public java.lang.String getSolicitantLlinatge1();
	public void setSolicitantLlinatge1(java.lang.String _solicitantLlinatge1_);

	public java.lang.String getSolicitantLlinatge2();
	public void setSolicitantLlinatge2(java.lang.String _solicitantLlinatge2_);

	public java.lang.String getSolicitantCif();
	public void setSolicitantCif(java.lang.String _solicitantCif_);

	public java.lang.String getSolicitantRaoSocial();
	public void setSolicitantRaoSocial(java.lang.String _solicitantRaoSocial_);

	public java.lang.String getSolicitantDireccio();
	public void setSolicitantDireccio(java.lang.String _solicitantDireccio_);

	public java.lang.String getSolicitantEmail();
	public void setSolicitantEmail(java.lang.String _solicitantEmail_);

	public java.lang.String getSolicitantTelefon();
	public void setSolicitantTelefon(java.lang.String _solicitantTelefon_);

	public java.lang.String getIdiomaID();
	public void setIdiomaID(java.lang.String _idiomaID_);

	public java.lang.String getExposa();
	public void setExposa(java.lang.String _exposa_);

	public java.lang.String getSolicita();
	public void setSolicita(java.lang.String _solicita_);

	public java.lang.Long getFitxer1ID();
	public void setFitxer1ID(java.lang.Long _fitxer1ID_);

	public java.lang.Long getFitxer2ID();
	public void setFitxer2ID(java.lang.Long _fitxer2ID_);

	public java.lang.Long getFitxer3ID();
	public void setFitxer3ID(java.lang.Long _fitxer3ID_);

	public java.lang.Long getFitxer4ID();
	public void setFitxer4ID(java.lang.Long _fitxer4ID_);

	public java.lang.Long getFitxer5ID();
	public void setFitxer5ID(java.lang.Long _fitxer5ID_);

	public java.lang.Long getFitxer6ID();
	public void setFitxer6ID(java.lang.Long _fitxer6ID_);

	public java.lang.Long getFitxer7ID();
	public void setFitxer7ID(java.lang.Long _fitxer7ID_);

	public java.lang.Long getFitxer8ID();
	public void setFitxer8ID(java.lang.Long _fitxer8ID_);

	public java.lang.Long getFitxer9ID();
	public void setFitxer9ID(java.lang.Long _fitxer9ID_);

	public java.sql.Timestamp getDataCreacio();
	public void setDataCreacio(java.sql.Timestamp _dataCreacio_);

	public java.sql.Timestamp getDatafinalitzacio();
	public void setDatafinalitzacio(java.sql.Timestamp _datafinalitzacio_);

	public int getEstat();
	public void setEstat(int _estat_);

	public java.lang.String getError();
	public void setError(java.lang.String _error_);

	public java.lang.String getException();
	public void setException(java.lang.String _exception_);

  // Fitxer
  public <F extends Fitxer> F getFitxer1();
  // Fitxer
  public <F extends Fitxer> F getFitxer2();
  // Fitxer
  public <F extends Fitxer> F getFitxer3();
  // Fitxer
  public <F extends Fitxer> F getFitxer4();
  // Fitxer
  public <F extends Fitxer> F getFitxer5();
  // Fitxer
  public <F extends Fitxer> F getFitxer6();
  // Fitxer
  public <F extends Fitxer> F getFitxer7();
  // Fitxer
  public <F extends Fitxer> F getFitxer8();
  // Fitxer
  public <F extends Fitxer> F getFitxer9();


  // ======================================

}
