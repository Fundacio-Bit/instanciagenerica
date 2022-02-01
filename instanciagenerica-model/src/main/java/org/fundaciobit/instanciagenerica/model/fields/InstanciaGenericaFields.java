
package org.fundaciobit.instanciagenerica.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface InstanciaGenericaFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "ige_instanciagenerica";


  public static final String _TABLE_MODEL = "instanciaGenerica";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField INSTANCIAGENERICAID = new LongField(_TABLE_MODEL, "instanciaGenericaID", "instanciagenericaid");  // PK
	 public static final StringField NUMREGISTRE = new StringField(_TABLE_MODEL, "numRegistre", "numregistre");
	 public static final StringField UUID = new StringField(_TABLE_MODEL, "uuid", "uuid");
	 public static final TimestampField DATACREACIO = new TimestampField(_TABLE_MODEL, "dataCreacio", "datacreacio");
	 public static final IntegerField SOLICITANTTIPUSADMINID = new IntegerField(_TABLE_MODEL, "solicitantTipusAdminID", "solicitanttipusadminid");
	 public static final StringField SOLICITANTADMINID = new StringField(_TABLE_MODEL, "solicitantAdminID", "solicitantadminid");
	 public static final BooleanField SOLICITANTPERSONAFISICA = new BooleanField(_TABLE_MODEL, "solicitantPersonaFisica", "solicitantpersonafisica");
	 public static final StringField SOLICITANTNOM = new StringField(_TABLE_MODEL, "solicitantNom", "solicitantnom");
	 public static final StringField SOLICITANTLLINATGE1 = new StringField(_TABLE_MODEL, "solicitantLlinatge1", "solicitantllinatge1");
	 public static final StringField SOLICITANTLLINATGE2 = new StringField(_TABLE_MODEL, "solicitantLlinatge2", "solicitantllinatge2");
	 public static final StringField SOLICITANTRAOSOCIAL = new StringField(_TABLE_MODEL, "solicitantRaoSocial", "solicitantraosocial");
	 public static final StringField SOLICITANTDIRECCIO = new StringField(_TABLE_MODEL, "solicitantDireccio", "solicitantdireccio");
	 public static final StringField SOLICITANTEMAIL = new StringField(_TABLE_MODEL, "solicitantEmail", "solicitantemail");
	 public static final StringField SOLICITANTTELEFON = new StringField(_TABLE_MODEL, "solicitantTelefon", "solicitanttelefon");
	 public static final LongField TITOLID = new LongField(_TABLE_MODEL, "titolID", "titolid");
	 public static final StringField IDIOMAID = new StringField(_TABLE_MODEL, "idiomaID", "idiomaid");
	 public static final StringField EXPOSA = new StringField(_TABLE_MODEL, "exposa", "exposa");
	 public static final StringField SOLICITA = new StringField(_TABLE_MODEL, "solicita", "solicita");
	 public static final LongField FITXER1ID = new LongField(_TABLE_MODEL, "fitxer1ID", "fitxer1id");
	 public static final LongField FITXER2ID = new LongField(_TABLE_MODEL, "fitxer2ID", "fitxer2id");
	 public static final LongField FITXER3ID = new LongField(_TABLE_MODEL, "fitxer3ID", "fitxer3id");
	 public static final LongField FITXER4ID = new LongField(_TABLE_MODEL, "fitxer4ID", "fitxer4id");
	 public static final LongField FITXER5ID = new LongField(_TABLE_MODEL, "fitxer5ID", "fitxer5id");
	 public static final LongField FITXER6ID = new LongField(_TABLE_MODEL, "fitxer6ID", "fitxer6id");
	 public static final LongField FITXER7ID = new LongField(_TABLE_MODEL, "fitxer7ID", "fitxer7id");
	 public static final LongField FITXER8ID = new LongField(_TABLE_MODEL, "fitxer8ID", "fitxer8id");
	 public static final LongField FITXER9ID = new LongField(_TABLE_MODEL, "fitxer9ID", "fitxer9id");
	 public static final IntegerField ESTAT = new IntegerField(_TABLE_MODEL, "estat", "estat");
	 public static final StringField ERROR = new StringField(_TABLE_MODEL, "error", "error");
	 public static final StringField EXCEPTION = new StringField(_TABLE_MODEL, "exception", "exception");
	 public static final TimestampField DATAFINALITZACIO = new TimestampField(_TABLE_MODEL, "datafinalitzacio", "datafinalitzacio");


  public static final Field<?>[] ALL_INSTANCIAGENERICA_FIELDS = {
    INSTANCIAGENERICAID,
    NUMREGISTRE,
    UUID,
    DATACREACIO,
    SOLICITANTTIPUSADMINID,
    SOLICITANTADMINID,
    SOLICITANTPERSONAFISICA,
    SOLICITANTNOM,
    SOLICITANTLLINATGE1,
    SOLICITANTLLINATGE2,
    SOLICITANTRAOSOCIAL,
    SOLICITANTDIRECCIO,
    SOLICITANTEMAIL,
    SOLICITANTTELEFON,
    TITOLID,
    IDIOMAID,
    EXPOSA,
    SOLICITA,
    FITXER1ID,
    FITXER2ID,
    FITXER3ID,
    FITXER4ID,
    FITXER5ID,
    FITXER6ID,
    FITXER7ID,
    FITXER8ID,
    FITXER9ID,
    ESTAT,
    ERROR,
    EXCEPTION,
    DATAFINALITZACIO
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
INSTANCIAGENERICAID
  };
}
