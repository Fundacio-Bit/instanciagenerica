
package org.fundaciobit.instanciagenerica.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class InstanciaGenericaQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public InstanciaGenericaQueryPath() {
  }

  protected InstanciaGenericaQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField INSTANCIAGENERICAID() {
    return new LongField(getQueryPath(), InstanciaGenericaFields.INSTANCIAGENERICAID);
  }

  public StringField NUMREGISTRE() {
    return new StringField(getQueryPath(), InstanciaGenericaFields.NUMREGISTRE);
  }

  public StringField UUID() {
    return new StringField(getQueryPath(), InstanciaGenericaFields.UUID);
  }

  public TimestampField DATACREACIO() {
    return new TimestampField(getQueryPath(), InstanciaGenericaFields.DATACREACIO);
  }

  public IntegerField SOLICITANTTIPUSADMINID() {
    return new IntegerField(getQueryPath(), InstanciaGenericaFields.SOLICITANTTIPUSADMINID);
  }

  public StringField SOLICITANTADMINID() {
    return new StringField(getQueryPath(), InstanciaGenericaFields.SOLICITANTADMINID);
  }

  public BooleanField SOLICITANTPERSONAFISICA() {
    return new BooleanField(getQueryPath(), InstanciaGenericaFields.SOLICITANTPERSONAFISICA);
  }

  public StringField SOLICITANTNOM() {
    return new StringField(getQueryPath(), InstanciaGenericaFields.SOLICITANTNOM);
  }

  public StringField SOLICITANTLLINATGE1() {
    return new StringField(getQueryPath(), InstanciaGenericaFields.SOLICITANTLLINATGE1);
  }

  public StringField SOLICITANTLLINATGE2() {
    return new StringField(getQueryPath(), InstanciaGenericaFields.SOLICITANTLLINATGE2);
  }

  public StringField SOLICITANTRAOSOCIAL() {
    return new StringField(getQueryPath(), InstanciaGenericaFields.SOLICITANTRAOSOCIAL);
  }

  public StringField SOLICITANTDIRECCIO() {
    return new StringField(getQueryPath(), InstanciaGenericaFields.SOLICITANTDIRECCIO);
  }

  public StringField SOLICITANTEMAIL() {
    return new StringField(getQueryPath(), InstanciaGenericaFields.SOLICITANTEMAIL);
  }

  public StringField SOLICITANTTELEFON() {
    return new StringField(getQueryPath(), InstanciaGenericaFields.SOLICITANTTELEFON);
  }

  public StringField IDIOMAID() {
    return new StringField(getQueryPath(), InstanciaGenericaFields.IDIOMAID);
  }

  public StringField EXPOSA() {
    return new StringField(getQueryPath(), InstanciaGenericaFields.EXPOSA);
  }

  public StringField SOLICITA() {
    return new StringField(getQueryPath(), InstanciaGenericaFields.SOLICITA);
  }

  public LongField FITXER1ID() {
    return new LongField(getQueryPath(), InstanciaGenericaFields.FITXER1ID);
  }

  public LongField FITXER2ID() {
    return new LongField(getQueryPath(), InstanciaGenericaFields.FITXER2ID);
  }

  public LongField FITXER3ID() {
    return new LongField(getQueryPath(), InstanciaGenericaFields.FITXER3ID);
  }

  public LongField FITXER4ID() {
    return new LongField(getQueryPath(), InstanciaGenericaFields.FITXER4ID);
  }

  public LongField FITXER5ID() {
    return new LongField(getQueryPath(), InstanciaGenericaFields.FITXER5ID);
  }

  public LongField FITXER6ID() {
    return new LongField(getQueryPath(), InstanciaGenericaFields.FITXER6ID);
  }

  public LongField FITXER7ID() {
    return new LongField(getQueryPath(), InstanciaGenericaFields.FITXER7ID);
  }

  public LongField FITXER8ID() {
    return new LongField(getQueryPath(), InstanciaGenericaFields.FITXER8ID);
  }

  public LongField FITXER9ID() {
    return new LongField(getQueryPath(), InstanciaGenericaFields.FITXER9ID);
  }

  public IntegerField ESTAT() {
    return new IntegerField(getQueryPath(), InstanciaGenericaFields.ESTAT);
  }

  public StringField ERROR() {
    return new StringField(getQueryPath(), InstanciaGenericaFields.ERROR);
  }

  public StringField EXCEPTION() {
    return new StringField(getQueryPath(), InstanciaGenericaFields.EXCEPTION);
  }

  public TimestampField DATAFINALITZACIO() {
    return new TimestampField(getQueryPath(), InstanciaGenericaFields.DATAFINALITZACIO);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (InstanciaGenericaFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public IdiomaQueryPath IDIOMA() {
    return new IdiomaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return InstanciaGenericaQueryPath.this.getQueryPath() + "idioma" + ".";
      }
    });
  }

  public FitxerQueryPath FITXER1() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return InstanciaGenericaQueryPath.this.getQueryPath() + "fitxer1" + ".";
      }
    });
  }

  public FitxerQueryPath FITXER2() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return InstanciaGenericaQueryPath.this.getQueryPath() + "fitxer2" + ".";
      }
    });
  }

  public FitxerQueryPath FITXER3() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return InstanciaGenericaQueryPath.this.getQueryPath() + "fitxer3" + ".";
      }
    });
  }

  public FitxerQueryPath FITXER4() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return InstanciaGenericaQueryPath.this.getQueryPath() + "fitxer4" + ".";
      }
    });
  }

  public FitxerQueryPath FITXER5() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return InstanciaGenericaQueryPath.this.getQueryPath() + "fitxer5" + ".";
      }
    });
  }

  public FitxerQueryPath FITXER6() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return InstanciaGenericaQueryPath.this.getQueryPath() + "fitxer6" + ".";
      }
    });
  }

  public FitxerQueryPath FITXER7() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return InstanciaGenericaQueryPath.this.getQueryPath() + "fitxer7" + ".";
      }
    });
  }

  public FitxerQueryPath FITXER8() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return InstanciaGenericaQueryPath.this.getQueryPath() + "fitxer8" + ".";
      }
    });
  }

  public FitxerQueryPath FITXER9() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return InstanciaGenericaQueryPath.this.getQueryPath() + "fitxer9" + ".";
      }
    });
  }

}
