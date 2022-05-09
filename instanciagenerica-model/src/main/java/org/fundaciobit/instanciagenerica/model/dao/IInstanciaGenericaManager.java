package org.fundaciobit.instanciagenerica.model.dao;

import org.fundaciobit.instanciagenerica.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IInstanciaGenericaManager extends org.fundaciobit.genapp.common.query.ITableManager<InstanciaGenerica, Long> {


	public InstanciaGenerica create( java.lang.String _numRegistre_, java.lang.String _uuid_, boolean _solicitantPersonaFisica_, int _solicitantTipusAdminID_, java.lang.String _solicitantAdminID_, java.lang.String _solicitantNom_, java.lang.String _solicitantLlinatge1_, java.lang.String _solicitantLlinatge2_, java.lang.String _solicitantCif_, java.lang.String _solicitantRaoSocial_, java.lang.String _solicitantDireccio_, java.lang.String _solicitantEmail_, java.lang.String _solicitantTelefon_, java.lang.String _idiomaID_, java.lang.String _exposa_, java.lang.String _solicita_, java.lang.Long _fitxer1ID_, java.lang.Long _fitxer2ID_, java.lang.Long _fitxer3ID_, java.lang.Long _fitxer4ID_, java.lang.Long _fitxer5ID_, java.lang.Long _fitxer6ID_, java.lang.Long _fitxer7ID_, java.lang.Long _fitxer8ID_, java.lang.Long _fitxer9ID_, java.sql.Timestamp _dataCreacio_, java.sql.Timestamp _datafinalitzacio_, int _estat_, java.lang.String _error_, java.lang.String _exception_) throws I18NException;

	public InstanciaGenerica findByPrimaryKey(java.lang.Long _instanciaGenericaID_);

	public void delete(java.lang.Long _instanciaGenericaID_);

}
