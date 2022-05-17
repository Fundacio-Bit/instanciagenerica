
package org.fundaciobit.instanciagenerica.persistence;
import org.fundaciobit.instanciagenerica.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.Id;


@Entity(name = "FitxerJPA")
@Table(name = "ige_fitxer" , indexes = { 
        @Index(name="ige_fitxer_pk_i", columnList = "fitxerid")})
@SequenceGenerator(name="FITXER_SEQ", sequenceName="ige_fitxer_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class FitxerJPA implements Fitxer {



private static final long serialVersionUID = -252813913L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FITXER_SEQ")
    @Column(name="fitxerid",nullable = false,length = 19)
    long fitxerID;

    @Column(name="nom",nullable = false,length = 255)
    java.lang.String nom;

    @Column(name="mime",nullable = false,length = 255)
    java.lang.String mime;

    @Column(name="tamany",nullable = false,length = 19)
    long tamany;

    @Column(name="descripcio",length = 1000)
    java.lang.String descripcio;



  /** Constructor Buit */
  public FitxerJPA() {
  }

  /** Constructor amb tots els camps  */
  public FitxerJPA(long fitxerID , java.lang.String nom , java.lang.String mime , long tamany , java.lang.String descripcio) {
    this.fitxerID=fitxerID;
    this.nom=nom;
    this.mime=mime;
    this.tamany=tamany;
    this.descripcio=descripcio;
}
  /** Constructor sense valors autoincrementals */
  public FitxerJPA(java.lang.String nom , java.lang.String mime , long tamany , java.lang.String descripcio) {
    this.nom=nom;
    this.mime=mime;
    this.tamany=tamany;
    this.descripcio=descripcio;
}
  public FitxerJPA(Fitxer __bean) {
    this.setFitxerID(__bean.getFitxerID());
    this.setNom(__bean.getNom());
    this.setMime(__bean.getMime());
    this.setTamany(__bean.getTamany());
    this.setDescripcio(__bean.getDescripcio());
    // DataHandler
    this.setData(__bean.getData());
    // EncryptedFileID
    this.setEncryptedFileID(__bean.getEncryptedFileID());
	}

	public long getFitxerID() {
		return(fitxerID);
	};
	public void setFitxerID(long _fitxerID_) {
		this.fitxerID = _fitxerID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getMime() {
		return(mime);
	};
	public void setMime(java.lang.String _mime_) {
		this.mime = _mime_;
	};

	public long getTamany() {
		return(tamany);
	};
	public void setTamany(long _tamany_) {
		this.tamany = _tamany_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Fitxer) {
      Fitxer __instance = (Fitxer)__obj;
      __result = true;
      __result = __result && (this.getFitxerID() == __instance.getFitxerID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:fitxer1id | Table: ige_instanciagenerica | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fitxer1ID")
    private Set<InstanciaGenericaJPA> instanciaGenerica_fitxer1ids = new HashSet<InstanciaGenericaJPA>(0);
    public  Set<InstanciaGenericaJPA> getInstanciaGenerica_fitxer1ids() {
    return this.instanciaGenerica_fitxer1ids;
  }

    public void setInstanciaGenerica_fitxer1ids(Set<InstanciaGenericaJPA> instanciaGenerica_fitxer1ids) {
      this.instanciaGenerica_fitxer1ids = instanciaGenerica_fitxer1ids;
    }


// EXP  Field:fitxer2id | Table: ige_instanciagenerica | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fitxer2ID")
    private Set<InstanciaGenericaJPA> instanciaGenerica_fitxer2ids = new HashSet<InstanciaGenericaJPA>(0);
    public  Set<InstanciaGenericaJPA> getInstanciaGenerica_fitxer2ids() {
    return this.instanciaGenerica_fitxer2ids;
  }

    public void setInstanciaGenerica_fitxer2ids(Set<InstanciaGenericaJPA> instanciaGenerica_fitxer2ids) {
      this.instanciaGenerica_fitxer2ids = instanciaGenerica_fitxer2ids;
    }


// EXP  Field:fitxer3id | Table: ige_instanciagenerica | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fitxer3ID")
    private Set<InstanciaGenericaJPA> instanciaGenerica_fitxer3ids = new HashSet<InstanciaGenericaJPA>(0);
    public  Set<InstanciaGenericaJPA> getInstanciaGenerica_fitxer3ids() {
    return this.instanciaGenerica_fitxer3ids;
  }

    public void setInstanciaGenerica_fitxer3ids(Set<InstanciaGenericaJPA> instanciaGenerica_fitxer3ids) {
      this.instanciaGenerica_fitxer3ids = instanciaGenerica_fitxer3ids;
    }


// EXP  Field:fitxer4id | Table: ige_instanciagenerica | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fitxer4ID")
    private Set<InstanciaGenericaJPA> instanciaGenerica_fitxer4ids = new HashSet<InstanciaGenericaJPA>(0);
    public  Set<InstanciaGenericaJPA> getInstanciaGenerica_fitxer4ids() {
    return this.instanciaGenerica_fitxer4ids;
  }

    public void setInstanciaGenerica_fitxer4ids(Set<InstanciaGenericaJPA> instanciaGenerica_fitxer4ids) {
      this.instanciaGenerica_fitxer4ids = instanciaGenerica_fitxer4ids;
    }


// EXP  Field:fitxer5id | Table: ige_instanciagenerica | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fitxer5ID")
    private Set<InstanciaGenericaJPA> instanciaGenerica_fitxer5ids = new HashSet<InstanciaGenericaJPA>(0);
    public  Set<InstanciaGenericaJPA> getInstanciaGenerica_fitxer5ids() {
    return this.instanciaGenerica_fitxer5ids;
  }

    public void setInstanciaGenerica_fitxer5ids(Set<InstanciaGenericaJPA> instanciaGenerica_fitxer5ids) {
      this.instanciaGenerica_fitxer5ids = instanciaGenerica_fitxer5ids;
    }


// EXP  Field:fitxer6id | Table: ige_instanciagenerica | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fitxer6ID")
    private Set<InstanciaGenericaJPA> instanciaGenerica_fitxer6ids = new HashSet<InstanciaGenericaJPA>(0);
    public  Set<InstanciaGenericaJPA> getInstanciaGenerica_fitxer6ids() {
    return this.instanciaGenerica_fitxer6ids;
  }

    public void setInstanciaGenerica_fitxer6ids(Set<InstanciaGenericaJPA> instanciaGenerica_fitxer6ids) {
      this.instanciaGenerica_fitxer6ids = instanciaGenerica_fitxer6ids;
    }


// EXP  Field:fitxer7id | Table: ige_instanciagenerica | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fitxer7ID")
    private Set<InstanciaGenericaJPA> instanciaGenerica_fitxer7ids = new HashSet<InstanciaGenericaJPA>(0);
    public  Set<InstanciaGenericaJPA> getInstanciaGenerica_fitxer7ids() {
    return this.instanciaGenerica_fitxer7ids;
  }

    public void setInstanciaGenerica_fitxer7ids(Set<InstanciaGenericaJPA> instanciaGenerica_fitxer7ids) {
      this.instanciaGenerica_fitxer7ids = instanciaGenerica_fitxer7ids;
    }


// EXP  Field:fitxer8id | Table: ige_instanciagenerica | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fitxer8ID")
    private Set<InstanciaGenericaJPA> instanciaGenerica_fitxer8ids = new HashSet<InstanciaGenericaJPA>(0);
    public  Set<InstanciaGenericaJPA> getInstanciaGenerica_fitxer8ids() {
    return this.instanciaGenerica_fitxer8ids;
  }

    public void setInstanciaGenerica_fitxer8ids(Set<InstanciaGenericaJPA> instanciaGenerica_fitxer8ids) {
      this.instanciaGenerica_fitxer8ids = instanciaGenerica_fitxer8ids;
    }


// EXP  Field:fitxer9id | Table: ige_instanciagenerica | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fitxer9ID")
    private Set<InstanciaGenericaJPA> instanciaGenerica_fitxer9ids = new HashSet<InstanciaGenericaJPA>(0);
    public  Set<InstanciaGenericaJPA> getInstanciaGenerica_fitxer9ids() {
    return this.instanciaGenerica_fitxer9ids;
  }

    public void setInstanciaGenerica_fitxer9ids(Set<InstanciaGenericaJPA> instanciaGenerica_fitxer9ids) {
      this.instanciaGenerica_fitxer9ids = instanciaGenerica_fitxer9ids;
    }



  @javax.persistence.Transient
  javax.activation.DataHandler data;

  public javax.activation.DataHandler getData() {
    return data;
  }

  public void setData(javax.activation.DataHandler data) {
    this.data = data;
  }

  @javax.persistence.Transient
  String encryptedFileID;

  public String getEncryptedFileID() {
    return encryptedFileID;
  }

  public void setEncryptedFileID(String encryptedFileID) {
    this.encryptedFileID = encryptedFileID;
  }


  final static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

  public static void enableEncryptedFileIDGeneration() {
    threadLocal.set("");
  }

  public static void disableEncryptedFileIDGeneration() {
    threadLocal.remove();
  }

  @javax.persistence.PostPersist
  @javax.persistence.PostLoad
  void postLoad() {
    if (threadLocal.get() != null) {
      this.encryptedFileID = org.fundaciobit.instanciagenerica.hibernate.HibernateFileUtil.encryptFileID(fitxerID);
    }
  }


 // ---------------  STATIC METHODS ------------------
  public static FitxerJPA toJPA(Fitxer __bean) {
    if (__bean == null) { return null;}
    FitxerJPA __tmp = new FitxerJPA();
    __tmp.setFitxerID(__bean.getFitxerID());
    __tmp.setNom(__bean.getNom());
    __tmp.setMime(__bean.getMime());
    __tmp.setTamany(__bean.getTamany());
    __tmp.setDescripcio(__bean.getDescripcio());
    // DataHandler
    __tmp.setData(__bean.getData());
    // EncryptedFileID
    __tmp.setEncryptedFileID(__bean.getEncryptedFileID());
		return __tmp;
	}


  public static FitxerJPA copyJPA(FitxerJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<FitxerJPA> copyJPA(java.util.Set<FitxerJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<FitxerJPA> __tmpSet = (java.util.Set<FitxerJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<FitxerJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (FitxerJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static FitxerJPA copyJPA(FitxerJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    FitxerJPA __tmp = (FitxerJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"InstanciaGenericaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.instanciaGenerica_fitxer6ids) || org.hibernate.Hibernate.isInitialized(__jpa.getInstanciaGenerica_fitxer6ids())) ) {
      __tmp.setInstanciaGenerica_fitxer6ids(InstanciaGenericaJPA.copyJPA(__jpa.getInstanciaGenerica_fitxer6ids(), __alreadyCopied,"FitxerJPA"));
    }
    if(!"InstanciaGenericaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.instanciaGenerica_fitxer7ids) || org.hibernate.Hibernate.isInitialized(__jpa.getInstanciaGenerica_fitxer7ids())) ) {
      __tmp.setInstanciaGenerica_fitxer7ids(InstanciaGenericaJPA.copyJPA(__jpa.getInstanciaGenerica_fitxer7ids(), __alreadyCopied,"FitxerJPA"));
    }
    if(!"InstanciaGenericaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.instanciaGenerica_fitxer9ids) || org.hibernate.Hibernate.isInitialized(__jpa.getInstanciaGenerica_fitxer9ids())) ) {
      __tmp.setInstanciaGenerica_fitxer9ids(InstanciaGenericaJPA.copyJPA(__jpa.getInstanciaGenerica_fitxer9ids(), __alreadyCopied,"FitxerJPA"));
    }
    if(!"InstanciaGenericaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.instanciaGenerica_fitxer8ids) || org.hibernate.Hibernate.isInitialized(__jpa.getInstanciaGenerica_fitxer8ids())) ) {
      __tmp.setInstanciaGenerica_fitxer8ids(InstanciaGenericaJPA.copyJPA(__jpa.getInstanciaGenerica_fitxer8ids(), __alreadyCopied,"FitxerJPA"));
    }
    if(!"InstanciaGenericaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.instanciaGenerica_fitxer2ids) || org.hibernate.Hibernate.isInitialized(__jpa.getInstanciaGenerica_fitxer2ids())) ) {
      __tmp.setInstanciaGenerica_fitxer2ids(InstanciaGenericaJPA.copyJPA(__jpa.getInstanciaGenerica_fitxer2ids(), __alreadyCopied,"FitxerJPA"));
    }
    if(!"InstanciaGenericaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.instanciaGenerica_fitxer5ids) || org.hibernate.Hibernate.isInitialized(__jpa.getInstanciaGenerica_fitxer5ids())) ) {
      __tmp.setInstanciaGenerica_fitxer5ids(InstanciaGenericaJPA.copyJPA(__jpa.getInstanciaGenerica_fitxer5ids(), __alreadyCopied,"FitxerJPA"));
    }
    if(!"InstanciaGenericaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.instanciaGenerica_fitxer3ids) || org.hibernate.Hibernate.isInitialized(__jpa.getInstanciaGenerica_fitxer3ids())) ) {
      __tmp.setInstanciaGenerica_fitxer3ids(InstanciaGenericaJPA.copyJPA(__jpa.getInstanciaGenerica_fitxer3ids(), __alreadyCopied,"FitxerJPA"));
    }
    if(!"InstanciaGenericaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.instanciaGenerica_fitxer4ids) || org.hibernate.Hibernate.isInitialized(__jpa.getInstanciaGenerica_fitxer4ids())) ) {
      __tmp.setInstanciaGenerica_fitxer4ids(InstanciaGenericaJPA.copyJPA(__jpa.getInstanciaGenerica_fitxer4ids(), __alreadyCopied,"FitxerJPA"));
    }
    if(!"InstanciaGenericaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.instanciaGenerica_fitxer1ids) || org.hibernate.Hibernate.isInitialized(__jpa.getInstanciaGenerica_fitxer1ids())) ) {
      __tmp.setInstanciaGenerica_fitxer1ids(InstanciaGenericaJPA.copyJPA(__jpa.getInstanciaGenerica_fitxer1ids(), __alreadyCopied,"FitxerJPA"));
    }
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
