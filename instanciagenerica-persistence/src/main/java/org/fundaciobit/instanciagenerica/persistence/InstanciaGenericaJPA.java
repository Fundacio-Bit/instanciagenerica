
package org.fundaciobit.instanciagenerica.persistence;
import org.fundaciobit.instanciagenerica.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.Index;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import org.hibernate.annotations.Type;
import javax.persistence.Id;


@Entity
@Table(name = "ige_instanciagenerica" )
@SequenceGenerator(name="INSTANCIAGENERICA_SEQ", sequenceName="ige_instanciagenerica_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class InstanciaGenericaJPA implements InstanciaGenerica {



private static final long serialVersionUID = 389380649L;

  /** Clau primaria */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="INSTANCIAGENERICA_SEQ")
    @Index(name="ige_instanciagenerica_pk_i")
    @Column(name="instanciagenericaid",nullable = false,length = 19)
    long instanciaGenericaID;

  /** Numero de registre de la instancia, corporatiu */
    @Column(name="numregistre",length = 50)
    java.lang.String numRegistre;

  /** Identificador de la instancia amb hash */
    @Column(name="uuid",length = 100)
    java.lang.String uuid;

  /** Per saber si es persona física o jurídica
 */
    @Column(name="solicitantpersonafisica",nullable = false,length = 1)
    boolean solicitantPersonaFisica;

  /** Tipus de document (DNI, NIE, Passaport, etc) */
    @Column(name="solicitanttipusadminid",nullable = false,length = 10)
    int solicitantTipusAdminID;

  /** Nombre del docmuent (pot tenir lletres) */
    @Column(name="solicitantadminid",nullable = false,length = 50)
    java.lang.String solicitantAdminID;

    @Column(name="solicitantnom",length = 100)
    java.lang.String solicitantNom;

    @Column(name="solicitantllinatge1",length = 100)
    java.lang.String solicitantLlinatge1;

    @Column(name="solicitantllinatge2",length = 100)
    java.lang.String solicitantLlinatge2;

  /** Numero CIF de la rao social si es persona juridica */
    @Column(name="solicitantcif",length = 50)
    java.lang.String solicitantCif;

    @Column(name="solicitantraosocial",length = 100)
    java.lang.String solicitantRaoSocial;

    @Column(name="solicitantdireccio",nullable = false,length = 255)
    java.lang.String solicitantDireccio;

    @Column(name="solicitantemail",nullable = false,length = 100)
    java.lang.String solicitantEmail;

    @Column(name="solicitanttelefon",nullable = false,length = 50)
    java.lang.String solicitantTelefon;

  /** Idioma en que del que esta exposat */
    @Index(name="ige_instgen_idiomaid_fk_i")
    @Column(name="idiomaid",nullable = false,length = 20)
    java.lang.String idiomaID;

    @Column(name="exposa",nullable = false,length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String exposa;

    @Column(name="solicita",nullable = false,length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String solicita;

    @Index(name="ige_instgen_fitxer1id_fk_i")
    @Column(name="fitxer1id",length = 19)
    java.lang.Long fitxer1ID;

    @Index(name="ige_instgen_fitxer2id_fk_i")
    @Column(name="fitxer2id",length = 19)
    java.lang.Long fitxer2ID;

    @Index(name="ige_instgen_fitxer3id_fk_i")
    @Column(name="fitxer3id",length = 19)
    java.lang.Long fitxer3ID;

    @Index(name="ige_instgen_fitxer4id_fk_i")
    @Column(name="fitxer4id",length = 19)
    java.lang.Long fitxer4ID;

    @Index(name="ige_instgen_fitxer5id_fk_i")
    @Column(name="fitxer5id",length = 19)
    java.lang.Long fitxer5ID;

    @Index(name="ige_instgen_fitxer6id_fk_i")
    @Column(name="fitxer6id",length = 19)
    java.lang.Long fitxer6ID;

    @Index(name="ige_instgen_fitxer7id_fk_i")
    @Column(name="fitxer7id",length = 19)
    java.lang.Long fitxer7ID;

    @Index(name="ige_instgen_fitxer8id_fk_i")
    @Column(name="fitxer8id",length = 19)
    java.lang.Long fitxer8ID;

    @Index(name="ige_instgen_fitxer9id_fk_i")
    @Column(name="fitxer9id",length = 19)
    java.lang.Long fitxer9ID;

    @Column(name="datafinalitzacio",length = 29,precision = 6)
    java.sql.Timestamp datafinalitzacio;

    @Column(name="datacreacio",nullable = false,length = 29,precision = 6)
    java.sql.Timestamp dataCreacio;

    @Column(name="estat",length = 10)
    int estat;

    @Column(name="error",length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String error;

    @Column(name="exception",length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String exception;



  /** Constructor Buit */
  public InstanciaGenericaJPA() {
  }

  /** Constructor amb tots els camps  */
  public InstanciaGenericaJPA(long instanciaGenericaID , java.lang.String numRegistre , java.lang.String uuid , boolean solicitantPersonaFisica , int solicitantTipusAdminID , java.lang.String solicitantAdminID , java.lang.String solicitantNom , java.lang.String solicitantLlinatge1 , java.lang.String solicitantLlinatge2 , java.lang.String solicitantCif , java.lang.String solicitantRaoSocial , java.lang.String solicitantDireccio , java.lang.String solicitantEmail , java.lang.String solicitantTelefon , java.lang.String idiomaID , java.lang.String exposa , java.lang.String solicita , java.lang.Long fitxer1ID , java.lang.Long fitxer2ID , java.lang.Long fitxer3ID , java.lang.Long fitxer4ID , java.lang.Long fitxer5ID , java.lang.Long fitxer6ID , java.lang.Long fitxer7ID , java.lang.Long fitxer8ID , java.lang.Long fitxer9ID , java.sql.Timestamp datafinalitzacio , java.sql.Timestamp dataCreacio , int estat , java.lang.String error , java.lang.String exception) {
    this.instanciaGenericaID=instanciaGenericaID;
    this.numRegistre=numRegistre;
    this.uuid=uuid;
    this.solicitantPersonaFisica=solicitantPersonaFisica;
    this.solicitantTipusAdminID=solicitantTipusAdminID;
    this.solicitantAdminID=solicitantAdminID;
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
    this.datafinalitzacio=datafinalitzacio;
    this.dataCreacio=dataCreacio;
    this.estat=estat;
    this.error=error;
    this.exception=exception;
}
  /** Constructor sense valors autoincrementals */
  public InstanciaGenericaJPA(java.lang.String numRegistre , java.lang.String uuid , boolean solicitantPersonaFisica , int solicitantTipusAdminID , java.lang.String solicitantAdminID , java.lang.String solicitantNom , java.lang.String solicitantLlinatge1 , java.lang.String solicitantLlinatge2 , java.lang.String solicitantCif , java.lang.String solicitantRaoSocial , java.lang.String solicitantDireccio , java.lang.String solicitantEmail , java.lang.String solicitantTelefon , java.lang.String idiomaID , java.lang.String exposa , java.lang.String solicita , java.lang.Long fitxer1ID , java.lang.Long fitxer2ID , java.lang.Long fitxer3ID , java.lang.Long fitxer4ID , java.lang.Long fitxer5ID , java.lang.Long fitxer6ID , java.lang.Long fitxer7ID , java.lang.Long fitxer8ID , java.lang.Long fitxer9ID , java.sql.Timestamp datafinalitzacio , java.sql.Timestamp dataCreacio , int estat , java.lang.String error , java.lang.String exception) {
    this.numRegistre=numRegistre;
    this.uuid=uuid;
    this.solicitantPersonaFisica=solicitantPersonaFisica;
    this.solicitantTipusAdminID=solicitantTipusAdminID;
    this.solicitantAdminID=solicitantAdminID;
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
    this.datafinalitzacio=datafinalitzacio;
    this.dataCreacio=dataCreacio;
    this.estat=estat;
    this.error=error;
    this.exception=exception;
}
  /** Constructor dels valors Not Null */
  public InstanciaGenericaJPA(long instanciaGenericaID , boolean solicitantPersonaFisica , int solicitantTipusAdminID , java.lang.String solicitantAdminID , java.lang.String solicitantDireccio , java.lang.String solicitantEmail , java.lang.String solicitantTelefon , java.lang.String idiomaID , java.lang.String exposa , java.lang.String solicita , java.sql.Timestamp dataCreacio) {
    this.instanciaGenericaID=instanciaGenericaID;
    this.solicitantPersonaFisica=solicitantPersonaFisica;
    this.solicitantTipusAdminID=solicitantTipusAdminID;
    this.solicitantAdminID=solicitantAdminID;
    this.solicitantDireccio=solicitantDireccio;
    this.solicitantEmail=solicitantEmail;
    this.solicitantTelefon=solicitantTelefon;
    this.idiomaID=idiomaID;
    this.exposa=exposa;
    this.solicita=solicita;
    this.dataCreacio=dataCreacio;
}
  public InstanciaGenericaJPA(InstanciaGenerica __bean) {
    this.setInstanciaGenericaID(__bean.getInstanciaGenericaID());
    this.setNumRegistre(__bean.getNumRegistre());
    this.setUuid(__bean.getUuid());
    this.setSolicitantPersonaFisica(__bean.isSolicitantPersonaFisica());
    this.setSolicitantTipusAdminID(__bean.getSolicitantTipusAdminID());
    this.setSolicitantAdminID(__bean.getSolicitantAdminID());
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
    this.setDatafinalitzacio(__bean.getDatafinalitzacio());
    this.setDataCreacio(__bean.getDataCreacio());
    this.setEstat(__bean.getEstat());
    this.setError(__bean.getError());
    this.setException(__bean.getException());
    // Fitxer
    this.setFitxer1(FitxerJPA.toJPA(__bean.getFitxer1()));
    // Fitxer
    this.setFitxer2(FitxerJPA.toJPA(__bean.getFitxer2()));
    // Fitxer
    this.setFitxer3(FitxerJPA.toJPA(__bean.getFitxer3()));
    // Fitxer
    this.setFitxer4(FitxerJPA.toJPA(__bean.getFitxer4()));
    // Fitxer
    this.setFitxer5(FitxerJPA.toJPA(__bean.getFitxer5()));
    // Fitxer
    this.setFitxer6(FitxerJPA.toJPA(__bean.getFitxer6()));
    // Fitxer
    this.setFitxer7(FitxerJPA.toJPA(__bean.getFitxer7()));
    // Fitxer
    this.setFitxer8(FitxerJPA.toJPA(__bean.getFitxer8()));
    // Fitxer
    this.setFitxer9(FitxerJPA.toJPA(__bean.getFitxer9()));
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

	public boolean isSolicitantPersonaFisica() {
		return(solicitantPersonaFisica);
	};
	public void setSolicitantPersonaFisica(boolean _solicitantPersonaFisica_) {
		this.solicitantPersonaFisica = _solicitantPersonaFisica_;
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

	public java.sql.Timestamp getDatafinalitzacio() {
		return(datafinalitzacio);
	};
	public void setDatafinalitzacio(java.sql.Timestamp _datafinalitzacio_) {
		this.datafinalitzacio = _datafinalitzacio_;
	};

	public java.sql.Timestamp getDataCreacio() {
		return(dataCreacio);
	};
	public void setDataCreacio(java.sql.Timestamp _dataCreacio_) {
		this.dataCreacio = _dataCreacio_;
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



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof InstanciaGenerica) {
      InstanciaGenerica __instance = (InstanciaGenerica)__obj;
      __result = true;
      __result = __result && (this.getInstanciaGenericaID() == __instance.getInstanciaGenericaID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// IMP Field:idiomaid | Table: ige_idioma | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @ForeignKey(name="ige_instgen_idioma_idioma_fk")
    @JoinColumn(name = "idiomaid", referencedColumnName ="idiomaID", nullable = false, insertable=false, updatable=false)
    private IdiomaJPA idioma;

    public IdiomaJPA getIdioma() {
    return this.idioma;
  }

    public  void setIdioma(IdiomaJPA idioma) {
    this.idioma = idioma;
  }

// IMP Field:fitxerid | Table: ige_fitxer | Type: 1  

    @ManyToOne(fetch = FetchType.EAGER)
    @ForeignKey(name="ige_instgen_fitxer_fitxer1_fk")
    @JoinColumn(name = "fitxer1id", referencedColumnName ="fitxerID", nullable = true, insertable=false, updatable=false)
    private FitxerJPA fitxer1;

    public FitxerJPA getFitxer1() {
    return this.fitxer1;
  }

    public  void setFitxer1(FitxerJPA fitxer1) {
    this.fitxer1 = fitxer1;
  }

// IMP Field:fitxerid | Table: ige_fitxer | Type: 1  

    @ManyToOne(fetch = FetchType.EAGER)
    @ForeignKey(name="ige_instgen_fitxer_fitxer2_fk")
    @JoinColumn(name = "fitxer2id", referencedColumnName ="fitxerID", nullable = true, insertable=false, updatable=false)
    private FitxerJPA fitxer2;

    public FitxerJPA getFitxer2() {
    return this.fitxer2;
  }

    public  void setFitxer2(FitxerJPA fitxer2) {
    this.fitxer2 = fitxer2;
  }

// IMP Field:fitxerid | Table: ige_fitxer | Type: 1  

    @ManyToOne(fetch = FetchType.EAGER)
    @ForeignKey(name="ige_instgen_fitxer_fitxer3_fk")
    @JoinColumn(name = "fitxer3id", referencedColumnName ="fitxerID", nullable = true, insertable=false, updatable=false)
    private FitxerJPA fitxer3;

    public FitxerJPA getFitxer3() {
    return this.fitxer3;
  }

    public  void setFitxer3(FitxerJPA fitxer3) {
    this.fitxer3 = fitxer3;
  }

// IMP Field:fitxerid | Table: ige_fitxer | Type: 1  

    @ManyToOne(fetch = FetchType.EAGER)
    @ForeignKey(name="ige_instgen_fitxer_fitxer4_fk")
    @JoinColumn(name = "fitxer4id", referencedColumnName ="fitxerID", nullable = true, insertable=false, updatable=false)
    private FitxerJPA fitxer4;

    public FitxerJPA getFitxer4() {
    return this.fitxer4;
  }

    public  void setFitxer4(FitxerJPA fitxer4) {
    this.fitxer4 = fitxer4;
  }

// IMP Field:fitxerid | Table: ige_fitxer | Type: 1  

    @ManyToOne(fetch = FetchType.EAGER)
    @ForeignKey(name="ige_instgen_fitxer_fitxer5_fk")
    @JoinColumn(name = "fitxer5id", referencedColumnName ="fitxerID", nullable = true, insertable=false, updatable=false)
    private FitxerJPA fitxer5;

    public FitxerJPA getFitxer5() {
    return this.fitxer5;
  }

    public  void setFitxer5(FitxerJPA fitxer5) {
    this.fitxer5 = fitxer5;
  }

// IMP Field:fitxerid | Table: ige_fitxer | Type: 1  

    @ManyToOne(fetch = FetchType.EAGER)
    @ForeignKey(name="ige_instgen_fitxer_fitxer6_fk")
    @JoinColumn(name = "fitxer6id", referencedColumnName ="fitxerID", nullable = true, insertable=false, updatable=false)
    private FitxerJPA fitxer6;

    public FitxerJPA getFitxer6() {
    return this.fitxer6;
  }

    public  void setFitxer6(FitxerJPA fitxer6) {
    this.fitxer6 = fitxer6;
  }

// IMP Field:fitxerid | Table: ige_fitxer | Type: 1  

    @ManyToOne(fetch = FetchType.EAGER)
    @ForeignKey(name="ige_instgen_fitxer_fitxer7_fk")
    @JoinColumn(name = "fitxer7id", referencedColumnName ="fitxerID", nullable = true, insertable=false, updatable=false)
    private FitxerJPA fitxer7;

    public FitxerJPA getFitxer7() {
    return this.fitxer7;
  }

    public  void setFitxer7(FitxerJPA fitxer7) {
    this.fitxer7 = fitxer7;
  }

// IMP Field:fitxerid | Table: ige_fitxer | Type: 1  

    @ManyToOne(fetch = FetchType.EAGER)
    @ForeignKey(name="ige_instgen_fitxer_fitxer8_fk")
    @JoinColumn(name = "fitxer8id", referencedColumnName ="fitxerID", nullable = true, insertable=false, updatable=false)
    private FitxerJPA fitxer8;

    public FitxerJPA getFitxer8() {
    return this.fitxer8;
  }

    public  void setFitxer8(FitxerJPA fitxer8) {
    this.fitxer8 = fitxer8;
  }

// IMP Field:fitxerid | Table: ige_fitxer | Type: 1  

    @ManyToOne(fetch = FetchType.EAGER)
    @ForeignKey(name="ige_instgen_fitxer_fitxer9_fk")
    @JoinColumn(name = "fitxer9id", referencedColumnName ="fitxerID", nullable = true, insertable=false, updatable=false)
    private FitxerJPA fitxer9;

    public FitxerJPA getFitxer9() {
    return this.fitxer9;
  }

    public  void setFitxer9(FitxerJPA fitxer9) {
    this.fitxer9 = fitxer9;
  }


 // ---------------  STATIC METHODS ------------------
  public static InstanciaGenericaJPA toJPA(InstanciaGenerica __bean) {
    if (__bean == null) { return null;}
    InstanciaGenericaJPA __tmp = new InstanciaGenericaJPA();
    __tmp.setInstanciaGenericaID(__bean.getInstanciaGenericaID());
    __tmp.setNumRegistre(__bean.getNumRegistre());
    __tmp.setUuid(__bean.getUuid());
    __tmp.setSolicitantPersonaFisica(__bean.isSolicitantPersonaFisica());
    __tmp.setSolicitantTipusAdminID(__bean.getSolicitantTipusAdminID());
    __tmp.setSolicitantAdminID(__bean.getSolicitantAdminID());
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
    __tmp.setDatafinalitzacio(__bean.getDatafinalitzacio());
    __tmp.setDataCreacio(__bean.getDataCreacio());
    __tmp.setEstat(__bean.getEstat());
    __tmp.setError(__bean.getError());
    __tmp.setException(__bean.getException());
    // Fitxer
    __tmp.setFitxer1(FitxerJPA.toJPA(__bean.getFitxer1()));
    // Fitxer
    __tmp.setFitxer2(FitxerJPA.toJPA(__bean.getFitxer2()));
    // Fitxer
    __tmp.setFitxer3(FitxerJPA.toJPA(__bean.getFitxer3()));
    // Fitxer
    __tmp.setFitxer4(FitxerJPA.toJPA(__bean.getFitxer4()));
    // Fitxer
    __tmp.setFitxer5(FitxerJPA.toJPA(__bean.getFitxer5()));
    // Fitxer
    __tmp.setFitxer6(FitxerJPA.toJPA(__bean.getFitxer6()));
    // Fitxer
    __tmp.setFitxer7(FitxerJPA.toJPA(__bean.getFitxer7()));
    // Fitxer
    __tmp.setFitxer8(FitxerJPA.toJPA(__bean.getFitxer8()));
    // Fitxer
    __tmp.setFitxer9(FitxerJPA.toJPA(__bean.getFitxer9()));
		return __tmp;
	}


  public static InstanciaGenericaJPA copyJPA(InstanciaGenericaJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<InstanciaGenericaJPA> copyJPA(java.util.Set<InstanciaGenericaJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<InstanciaGenericaJPA> __tmpSet = (java.util.Set<InstanciaGenericaJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<InstanciaGenericaJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (InstanciaGenericaJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static InstanciaGenericaJPA copyJPA(InstanciaGenericaJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    InstanciaGenericaJPA __tmp = (InstanciaGenericaJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"IdiomaJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.idioma) || org.hibernate.Hibernate.isInitialized(__jpa.getIdioma()) ) ) {
      __tmp.setIdioma(IdiomaJPA.copyJPA(__jpa.getIdioma(), __alreadyCopied,"InstanciaGenericaJPA"));
    }

    return __tmp;
  }




}
