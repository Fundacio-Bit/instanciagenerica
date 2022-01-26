
package org.fundaciobit.instanciagenerica.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class FitxerQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public FitxerQueryPath() {
  }

  protected FitxerQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField FITXERID() {
    return new LongField(getQueryPath(), FitxerFields.FITXERID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), FitxerFields.NOM);
  }

  public StringField MIME() {
    return new StringField(getQueryPath(), FitxerFields.MIME);
  }

  public LongField TAMANY() {
    return new LongField(getQueryPath(), FitxerFields.TAMANY);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), FitxerFields.DESCRIPCIO);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (FitxerFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public InstanciaGenericaQueryPath INSTANCIAGENERICA_FITXER1IDS() {
    return new InstanciaGenericaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return FitxerQueryPath.this.getQueryPath() + "instanciaGenerica_fitxer1ids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public InstanciaGenericaQueryPath INSTANCIAGENERICA_FITXER2IDS() {
    return new InstanciaGenericaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return FitxerQueryPath.this.getQueryPath() + "instanciaGenerica_fitxer2ids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public InstanciaGenericaQueryPath INSTANCIAGENERICA_FITXER3IDS() {
    return new InstanciaGenericaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return FitxerQueryPath.this.getQueryPath() + "instanciaGenerica_fitxer3ids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public InstanciaGenericaQueryPath INSTANCIAGENERICA_FITXER4IDS() {
    return new InstanciaGenericaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return FitxerQueryPath.this.getQueryPath() + "instanciaGenerica_fitxer4ids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public InstanciaGenericaQueryPath INSTANCIAGENERICA_FITXER5IDS() {
    return new InstanciaGenericaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return FitxerQueryPath.this.getQueryPath() + "instanciaGenerica_fitxer5ids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public InstanciaGenericaQueryPath INSTANCIAGENERICA_FITXER6IDS() {
    return new InstanciaGenericaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return FitxerQueryPath.this.getQueryPath() + "instanciaGenerica_fitxer6ids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public InstanciaGenericaQueryPath INSTANCIAGENERICA_FITXER7IDS() {
    return new InstanciaGenericaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return FitxerQueryPath.this.getQueryPath() + "instanciaGenerica_fitxer7ids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public InstanciaGenericaQueryPath INSTANCIAGENERICA_FITXER8IDS() {
    return new InstanciaGenericaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return FitxerQueryPath.this.getQueryPath() + "instanciaGenerica_fitxer8ids" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public InstanciaGenericaQueryPath INSTANCIAGENERICA_FITXER9IDS() {
    return new InstanciaGenericaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return FitxerQueryPath.this.getQueryPath() + "instanciaGenerica_fitxer9ids" + ".";
      }
    });
  }
*/

}
