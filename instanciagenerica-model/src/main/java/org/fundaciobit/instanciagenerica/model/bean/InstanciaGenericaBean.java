
package org.fundaciobit.instanciagenerica.model.bean;

import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;


public class InstanciaGenericaBean implements InstanciaGenerica {



private static final long serialVersionUID = -814318814L;

	long instanciaGenericaID;// PK
	java.lang.String numRegistre;
	java.lang.String uuid;
	java.sql.Timestamp dataCreacio;
	int solicitantTipusAdminID;
	java.lang.String solicitantAdminID;
	boolean solicitantPersonaFisica;
	java.lang.String solicitantNom;
	java.lang.String solicitantLlinatge1;
	java.lang.String solicitantLlinatge2;
	java.lang.String solicitantCif;
	java.lang.String solicitantRaoSocial;
	java.lang.String solicitantDireccio;
	java.lang.String solicitantEmail;
	java.lang.String solicitantTelefon;
	java.lang.String idiomaID;
	java.lang.String exposa;
	java.lang.String solicita;
	java.lang.Long fitxer1ID;
	java.lang.Long fitxer2ID;
	java.lang.Long fitxer3ID;
	java.lang.Long fitxer4ID;
	java.lang.Long fitxer5ID;
	java.lang.Long fitxer6ID;
	java.lang.Long fitxer7ID;
	java.lang.Long fitxer8ID;
	java.lang.Long fitxer9ID;
	int estat;
	java.lang.String error;
	java.lang.String exception;
	java.sql.Timestamp datafinalitzacio;


  /** Constructor Buit */
  public InstanciaGenericaBean() {
  }

  /** Constructor amb tots els camps  */
  public InstanciaGenericaBean(long instanciaGenericaID , java.lang.String numRegistre , java.lang.String uuid , java.sql.Timestamp dataCreacio , int solicitantTipusAdminID , java.lang.String solicitantAdminID , boolean solicitantPersonaFisica , java.lang.String solicitantNom , java.lang.String solicitantLlinatge1 , java.lang.String solicitantLlinatge2 , java.lang.String solicitantCif , java.lang.String solicitantRaoSocial , java.lang.String solicitantDireccio , java.lang.String solicitantEmail , java.lang.String solicitantTelefon , java.lang.String idiomaID , java.lang.String exposa , java.lang.String solicita , java.lang.Long fitxer1ID , java.lang.Long fitxer2ID , java.lang.Long fitxer3ID , java.lang.Long fitxer4ID , java.lang.Long fitxer5ID , java.lang.Long fitxer6ID , java.lang.Long fitxer7ID , java.lang.Long fitxer8ID , java.lang.Long fitxer9ID , int estat , java.lang.String error , java.lang.String exception , java.sql.Timestamp datafinalitzacio) {
    this.instanciaGenericaID=instanciaGenericaID;
    this.numRegistre=numRegistre;
    this.uuid=uuid;
    this.dataCreacio=dataCreacio;
    this.solicitantTipusAdminID=solicitantTipusAdminID;
    this.solicitantAdminID=solicitantAdminID;
    this.solicitantPersonaFisica=solicitantPersonaFisica;
    this.solicitantNom=solicitantNom;
    this.solicitantLlinatge1=solicitantLlinatge1;
    this.solicitantLlinatge2=solicitantLlinatge2;
    this.solicitantCif=solicitantCif;
    this.solicitantRaoSocial=solicitantRaoSocial;
    this.solicitantDireccio=solicitantDireccio;
    this.solicitantEmail=solicitantEmail;
    this.solicitantTelefon=solicitantTelefon;
    this.idiomaID=idiomaID;
    this.exposa=exposa;
    this.solicita=solicita;
    this.fitxer1ID=fitxer1ID;
    this.fitxer2ID=fitxer2ID;
    this.fitxer3ID=fitxer3ID;
    this.fitxer4ID=fitxer4ID;
    this.fitxer5ID=fitxer5ID;
    this.fitxer6ID=fitxer6ID;
    this.fitxer7ID=fitxer7ID;
    this.fitxer8ID=fitxer8ID;
    this.fitxer9ID=fitxer9ID;
    this.estat=estat;
    this.error=error;
    this.exception=exception;
    this.datafinalitzacio=datafinalitzacio;
}
  /** Constructor sense valors autoincrementals */
  public InstanciaGenericaBean(java.lang.String numRegistre , java.lang.String uuid , java.sql.Timestamp dataCreacio , int solicitantTipusAdminID , java.lang.String solicitantAdminID , boolean solicitantPersonaFisica , java.lang.String solicitantNom , java.lang.String solicitantLlinatge1 , java.lang.String solicitantLlinatge2 , java.lang.String solicitantCif , java.lang.String solicitantRaoSocial , java.lang.String solicitantDireccio , java.lang.String solicitantEmail , java.lang.String solicitantTelefon , java.lang.String idiomaID , java.lang.String exposa , java.lang.String solicita , java.lang.Long fitxer1ID , java.lang.Long fitxer2ID , java.lang.Long fitxer3ID , java.lang.Long fitxer4ID , java.lang.Long fitxer5ID , java.lang.Long fitxer6ID , java.lang.Long fitxer7ID , java.lang.Long fitxer8ID , java.lang.Long fitxer9ID , int estat , java.lang.String error , java.lang.String exception , java.sql.Timestamp datafinalitzacio) {
    this.numRegistre=numRegistre;
    this.uuid=uuid;
    this.dataCreacio=dataCreacio;
    this.solicitantTipusAdminID=solicitantTipusAdminID;
    this.solicitantAdminID=solicitantAdminID;
    this.solicitantPersonaFisica=solicitantPersonaFisica;
    this.solicitantNom=solicitantNom;
    this.solicitantLlinatge1=solicitantLlinatge1;
    this.solicitantLlinatge2=solicitantLlinatge2;
    this.solicitantCif=solicitantCif;
    this.solicitantRaoSocial=solicitantRaoSocial;
    this.solicitantDireccio=solicitantDireccio;
    this.solicitantEmail=solicitantEmail;
    this.solicitantTelefon=solicitantTelefon;
    this.idiomaID=idiomaID;
    this.exposa=exposa;
    this.solicita=solicita;
    this.fitxer1ID=fitxer1ID;
    this.fitxer2ID=fitxer2ID;
    this.fitxer3ID=fitxer3ID;
    this.fitxer4ID=fitxer4ID;
    this.fitxer5ID=fitxer5ID;
    this.fitxer6ID=fitxer6ID;
    this.fitxer7ID=fitxer7ID;
    this.fitxer8ID=fitxer8ID;
    this.fitxer9ID=fitxer9ID;
    this.estat=estat;
    this.error=error;
    this.exception=exception;
    this.datafinalitzacio=datafinalitzacio;
}
  /** Constructor dels valors Not Null */
  public InstanciaGenericaBean(long instanciaGenericaID , java.sql.Timestamp dataCreacio , int solicitantTipusAdminID , java.lang.String solicitantAdminID , boolean solicitantPersonaFisica , java.lang.String solicitantDireccio , java.lang.String solicitantEmail , java.lang.String solicitantTelefon , java.lang.String idiomaID , java.lang.String exposa , java.lang.String solicita) {
    this.instanciaGenericaID=instanciaGenericaID;
    this.dataCreacio=dataCreacio;
    this.solicitantTipusAdminID=solicitantTipusAdminID;
    this.solicitantAdminID=solicitantAdminID;
    this.solicitantPersonaFisica=solicitantPersonaFisica;
    this.solicitantDireccio=solicitantDireccio;
    this.solicitantEmail=solicitantEmail;
    this.solicitantTelefon=solicitantTelefon;
    this.idiomaID=idiomaID;
    this.exposa=exposa;
    this.solicita=solicita;
}
  public InstanciaGenericaBean(InstanciaGenerica __bean) {
    this.setInstanciaGenericaID(__bean.getInstanciaGenericaID());
    this.setNumRegistre(__bean.getNumRegistre());
    this.setUuid(__bean.getUuid());
    this.setDataCreacio(__bean.getDataCreacio());
    this.setSolicitantTipusAdminID(__bean.getSolicitantTipusAdminID());
    this.setSolicitantAdminID(__bean.getSolicitantAdminID());
    this.setSolicitantPersonaFisica(__bean.isSolicitantPersonaFisica());
    this.setSolicitantNom(__bean.getSolicitantNom());
    this.setSolicitantLlinatge1(__bean.getSolicitantLlinatge1());
    this.setSolicitantLlinatge2(__bean.getSolicitantLlinatge2());
    this.setSolicitantCif(__bean.getSolicitantCif());
    this.setSolicitantRaoSocial(__bean.getSolicitantRaoSocial());
    this.setSolicitantDireccio(__bean.getSolicitantDireccio());
    this.setSolicitantEmail(__bean.getSolicitantEmail());
    this.setSolicitantTelefon(__bean.getSolicitantTelefon());
    this.setIdiomaID(__bean.getIdiomaID());
    this.setExposa(__bean.getExposa());
    this.setSolicita(__bean.getSolicita());
    this.setFitxer1ID(__bean.getFitxer1ID());
    this.setFitxer2ID(__bean.getFitxer2ID());
    this.setFitxer3ID(__bean.getFitxer3ID());
    this.setFitxer4ID(__bean.getFitxer4ID());
    this.setFitxer5ID(__bean.getFitxer5ID());
    this.setFitxer6ID(__bean.getFitxer6ID());
    this.setFitxer7ID(__bean.getFitxer7ID());
    this.setFitxer8ID(__bean.getFitxer8ID());
    this.setFitxer9ID(__bean.getFitxer9ID());
    this.setEstat(__bean.getEstat());
    this.setError(__bean.getError());
    this.setException(__bean.getException());
    this.setDatafinalitzacio(__bean.getDatafinalitzacio());
    // Fitxer
    this.setFitxer1(FitxerBean.toBean(__bean.getFitxer1()));
    // Fitxer
    this.setFitxer2(FitxerBean.toBean(__bean.getFitxer2()));
    // Fitxer
    this.setFitxer3(FitxerBean.toBean(__bean.getFitxer3()));
    // Fitxer
    this.setFitxer4(FitxerBean.toBean(__bean.getFitxer4()));
    // Fitxer
    this.setFitxer5(FitxerBean.toBean(__bean.getFitxer5()));
    // Fitxer
    this.setFitxer6(FitxerBean.toBean(__bean.getFitxer6()));
    // Fitxer
    this.setFitxer7(FitxerBean.toBean(__bean.getFitxer7()));
    // Fitxer
    this.setFitxer8(FitxerBean.toBean(__bean.getFitxer8()));
    // Fitxer
    this.setFitxer9(FitxerBean.toBean(__bean.getFitxer9()));
	}

	public long getInstanciaGenericaID() {
		return(instanciaGenericaID);
	};
	public void setInstanciaGenericaID(long _instanciaGenericaID_) {
		this.instanciaGenericaID = _instanciaGenericaID_;
	};

	public java.lang.String getNumRegistre() {
		return(numRegistre);
	};
	public void setNumRegistre(java.lang.String _numRegistre_) {
		this.numRegistre = _numRegistre_;
	};

	public java.lang.String getUuid() {
		return(uuid);
	};
	public void setUuid(java.lang.String _uuid_) {
		this.uuid = _uuid_;
	};

	public java.sql.Timestamp getDataCreacio() {
		return(dataCreacio);
	};
	public void setDataCreacio(java.sql.Timestamp _dataCreacio_) {
		this.dataCreacio = _dataCreacio_;
	};

	public int getSolicitantTipusAdminID() {
		return(solicitantTipusAdminID);
	};
	public void setSolicitantTipusAdminID(int _solicitantTipusAdminID_) {
		this.solicitantTipusAdminID = _solicitantTipusAdminID_;
	};

	public java.lang.String getSolicitantAdminID() {
		return(solicitantAdminID);
	};
	public void setSolicitantAdminID(java.lang.String _solicitantAdminID_) {
		this.solicitantAdminID = _solicitantAdminID_;
	};

	public boolean isSolicitantPersonaFisica() {
		return(solicitantPersonaFisica);
	};
	public void setSolicitantPersonaFisica(boolean _solicitantPersonaFisica_) {
		this.solicitantPersonaFisica = _solicitantPersonaFisica_;
	};

	public java.lang.String getSolicitantNom() {
		return(solicitantNom);
	};
	public void setSolicitantNom(java.lang.String _solicitantNom_) {
		this.solicitantNom = _solicitantNom_;
	};

	public java.lang.String getSolicitantLlinatge1() {
		return(solicitantLlinatge1);
	};
	public void setSolicitantLlinatge1(java.lang.String _solicitantLlinatge1_) {
		this.solicitantLlinatge1 = _solicitantLlinatge1_;
	};

	public java.lang.String getSolicitantLlinatge2() {
		return(solicitantLlinatge2);
	};
	public void setSolicitantLlinatge2(java.lang.String _solicitantLlinatge2_) {
		this.solicitantLlinatge2 = _solicitantLlinatge2_;
	};

	public java.lang.String getSolicitantCif() {
		return(solicitantCif);
	};
	public void setSolicitantCif(java.lang.String _solicitantCif_) {
		this.solicitantCif = _solicitantCif_;
	};

	public java.lang.String getSolicitantRaoSocial() {
		return(solicitantRaoSocial);
	};
	public void setSolicitantRaoSocial(java.lang.String _solicitantRaoSocial_) {
		this.solicitantRaoSocial = _solicitantRaoSocial_;
	};

	public java.lang.String getSolicitantDireccio() {
		return(solicitantDireccio);
	};
	public void setSolicitantDireccio(java.lang.String _solicitantDireccio_) {
		this.solicitantDireccio = _solicitantDireccio_;
	};

	public java.lang.String getSolicitantEmail() {
		return(solicitantEmail);
	};
	public void setSolicitantEmail(java.lang.String _solicitantEmail_) {
		this.solicitantEmail = _solicitantEmail_;
	};

	public java.lang.String getSolicitantTelefon() {
		return(solicitantTelefon);
	};
	public void setSolicitantTelefon(java.lang.String _solicitantTelefon_) {
		this.solicitantTelefon = _solicitantTelefon_;
	};

	public java.lang.String getIdiomaID() {
		return(idiomaID);
	};
	public void setIdiomaID(java.lang.String _idiomaID_) {
		this.idiomaID = _idiomaID_;
	};

	public java.lang.String getExposa() {
		return(exposa);
	};
	public void setExposa(java.lang.String _exposa_) {
		this.exposa = _exposa_;
	};

	public java.lang.String getSolicita() {
		return(solicita);
	};
	public void setSolicita(java.lang.String _solicita_) {
		this.solicita = _solicita_;
	};

	public java.lang.Long getFitxer1ID() {
		return(fitxer1ID);
	};
	public void setFitxer1ID(java.lang.Long _fitxer1ID_) {
		this.fitxer1ID = _fitxer1ID_;
	};

	public java.lang.Long getFitxer2ID() {
		return(fitxer2ID);
	};
	public void setFitxer2ID(java.lang.Long _fitxer2ID_) {
		this.fitxer2ID = _fitxer2ID_;
	};

	public java.lang.Long getFitxer3ID() {
		return(fitxer3ID);
	};
	public void setFitxer3ID(java.lang.Long _fitxer3ID_) {
		this.fitxer3ID = _fitxer3ID_;
	};

	public java.lang.Long getFitxer4ID() {
		return(fitxer4ID);
	};
	public void setFitxer4ID(java.lang.Long _fitxer4ID_) {
		this.fitxer4ID = _fitxer4ID_;
	};

	public java.lang.Long getFitxer5ID() {
		return(fitxer5ID);
	};
	public void setFitxer5ID(java.lang.Long _fitxer5ID_) {
		this.fitxer5ID = _fitxer5ID_;
	};

	public java.lang.Long getFitxer6ID() {
		return(fitxer6ID);
	};
	public void setFitxer6ID(java.lang.Long _fitxer6ID_) {
		this.fitxer6ID = _fitxer6ID_;
	};

	public java.lang.Long getFitxer7ID() {
		return(fitxer7ID);
	};
	public void setFitxer7ID(java.lang.Long _fitxer7ID_) {
		this.fitxer7ID = _fitxer7ID_;
	};

	public java.lang.Long getFitxer8ID() {
		return(fitxer8ID);
	};
	public void setFitxer8ID(java.lang.Long _fitxer8ID_) {
		this.fitxer8ID = _fitxer8ID_;
	};

	public java.lang.Long getFitxer9ID() {
		return(fitxer9ID);
	};
	public void setFitxer9ID(java.lang.Long _fitxer9ID_) {
		this.fitxer9ID = _fitxer9ID_;
	};

	public int getEstat() {
		return(estat);
	};
	public void setEstat(int _estat_) {
		this.estat = _estat_;
	};

	public java.lang.String getError() {
		return(error);
	};
	public void setError(java.lang.String _error_) {
		this.error = _error_;
	};

	public java.lang.String getException() {
		return(exception);
	};
	public void setException(java.lang.String _exception_) {
		this.exception = _exception_;
	};

	public java.sql.Timestamp getDatafinalitzacio() {
		return(datafinalitzacio);
	};
	public void setDatafinalitzacio(java.sql.Timestamp _datafinalitzacio_) {
		this.datafinalitzacio = _datafinalitzacio_;
	};



  // ======================================

  public static InstanciaGenericaBean toBean(InstanciaGenerica __bean) {
    if (__bean == null) { return null;}
    InstanciaGenericaBean __tmp = new InstanciaGenericaBean();
    __tmp.setInstanciaGenericaID(__bean.getInstanciaGenericaID());
    __tmp.setNumRegistre(__bean.getNumRegistre());
    __tmp.setUuid(__bean.getUuid());
    __tmp.setDataCreacio(__bean.getDataCreacio());
    __tmp.setSolicitantTipusAdminID(__bean.getSolicitantTipusAdminID());
    __tmp.setSolicitantAdminID(__bean.getSolicitantAdminID());
    __tmp.setSolicitantPersonaFisica(__bean.isSolicitantPersonaFisica());
    __tmp.setSolicitantNom(__bean.getSolicitantNom());
    __tmp.setSolicitantLlinatge1(__bean.getSolicitantLlinatge1());
    __tmp.setSolicitantLlinatge2(__bean.getSolicitantLlinatge2());
    __tmp.setSolicitantCif(__bean.getSolicitantCif());
    __tmp.setSolicitantRaoSocial(__bean.getSolicitantRaoSocial());
    __tmp.setSolicitantDireccio(__bean.getSolicitantDireccio());
    __tmp.setSolicitantEmail(__bean.getSolicitantEmail());
    __tmp.setSolicitantTelefon(__bean.getSolicitantTelefon());
    __tmp.setIdiomaID(__bean.getIdiomaID());
    __tmp.setExposa(__bean.getExposa());
    __tmp.setSolicita(__bean.getSolicita());
    __tmp.setFitxer1ID(__bean.getFitxer1ID());
    __tmp.setFitxer2ID(__bean.getFitxer2ID());
    __tmp.setFitxer3ID(__bean.getFitxer3ID());
    __tmp.setFitxer4ID(__bean.getFitxer4ID());
    __tmp.setFitxer5ID(__bean.getFitxer5ID());
    __tmp.setFitxer6ID(__bean.getFitxer6ID());
    __tmp.setFitxer7ID(__bean.getFitxer7ID());
    __tmp.setFitxer8ID(__bean.getFitxer8ID());
    __tmp.setFitxer9ID(__bean.getFitxer9ID());
    __tmp.setEstat(__bean.getEstat());
    __tmp.setError(__bean.getError());
    __tmp.setException(__bean.getException());
    __tmp.setDatafinalitzacio(__bean.getDatafinalitzacio());
    // Fitxer
    __tmp.setFitxer1(FitxerBean.toBean(__bean.getFitxer1()));
    // Fitxer
    __tmp.setFitxer2(FitxerBean.toBean(__bean.getFitxer2()));
    // Fitxer
    __tmp.setFitxer3(FitxerBean.toBean(__bean.getFitxer3()));
    // Fitxer
    __tmp.setFitxer4(FitxerBean.toBean(__bean.getFitxer4()));
    // Fitxer
    __tmp.setFitxer5(FitxerBean.toBean(__bean.getFitxer5()));
    // Fitxer
    __tmp.setFitxer6(FitxerBean.toBean(__bean.getFitxer6()));
    // Fitxer
    __tmp.setFitxer7(FitxerBean.toBean(__bean.getFitxer7()));
    // Fitxer
    __tmp.setFitxer8(FitxerBean.toBean(__bean.getFitxer8()));
    // Fitxer
    __tmp.setFitxer9(FitxerBean.toBean(__bean.getFitxer9()));
		return __tmp;
	}

  protected FitxerBean fitxer1;
  public FitxerBean getFitxer1() {
    return fitxer1;
  }
  public void setFitxer1(FitxerBean __field) {
    this. fitxer1 = __field;
  }
  protected FitxerBean fitxer2;
  public FitxerBean getFitxer2() {
    return fitxer2;
  }
  public void setFitxer2(FitxerBean __field) {
    this. fitxer2 = __field;
  }
  protected FitxerBean fitxer3;
  public FitxerBean getFitxer3() {
    return fitxer3;
  }
  public void setFitxer3(FitxerBean __field) {
    this. fitxer3 = __field;
  }
  protected FitxerBean fitxer4;
  public FitxerBean getFitxer4() {
    return fitxer4;
  }
  public void setFitxer4(FitxerBean __field) {
    this. fitxer4 = __field;
  }
  protected FitxerBean fitxer5;
  public FitxerBean getFitxer5() {
    return fitxer5;
  }
  public void setFitxer5(FitxerBean __field) {
    this. fitxer5 = __field;
  }
  protected FitxerBean fitxer6;
  public FitxerBean getFitxer6() {
    return fitxer6;
  }
  public void setFitxer6(FitxerBean __field) {
    this. fitxer6 = __field;
  }
  protected FitxerBean fitxer7;
  public FitxerBean getFitxer7() {
    return fitxer7;
  }
  public void setFitxer7(FitxerBean __field) {
    this. fitxer7 = __field;
  }
  protected FitxerBean fitxer8;
  public FitxerBean getFitxer8() {
    return fitxer8;
  }
  public void setFitxer8(FitxerBean __field) {
    this. fitxer8 = __field;
  }
  protected FitxerBean fitxer9;
  public FitxerBean getFitxer9() {
    return fitxer9;
  }
  public void setFitxer9(FitxerBean __field) {
    this. fitxer9 = __field;
  }


}
