
package org.fundaciobit.instanciagenerica.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fundaciobit.instanciagenerica.model.entity.*;
import org.fundaciobit.instanciagenerica.model.fields.*;
import org.fundaciobit.instanciagenerica.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class InstanciaGenericaJPAManager
         extends AbstractJPAManager<InstanciaGenerica, Long>
         implements InstanciaGenericaIJPAManager, IInstanciaGenericaManager, InstanciaGenericaFields {




    private static final long serialVersionUID = -627106492L;

    public static final TableName<InstanciaGenerica> _TABLENAME =  new TableName<InstanciaGenerica>("InstanciaGenericaJPA");


    @PersistenceContext
    protected EntityManager __em;

    public InstanciaGenericaJPAManager() {
    }

    protected InstanciaGenericaJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return InstanciaGenericaJPA. class;
    }



    public TableName<InstanciaGenerica> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public InstanciaGenerica[] listToArray(List<InstanciaGenerica> list)  {
        if(list == null) { return null; };
        return list.toArray(new InstanciaGenerica[list.size()]);
    };

    public InstanciaGenerica create( java.lang.String _numRegistre_, java.lang.String _uuid_, boolean _solicitantPersonaFisica_, int _solicitantTipusAdminID_, java.lang.String _solicitantAdminID_, java.lang.String _solicitantNom_, java.lang.String _solicitantLlinatge1_, java.lang.String _solicitantLlinatge2_, java.lang.String _solicitantCif_, java.lang.String _solicitantRaoSocial_, java.lang.String _solicitantDireccio_, java.lang.String _solicitantEmail_, java.lang.String _solicitantTelefon_, java.lang.String _idiomaID_, java.lang.String _exposa_, java.lang.String _solicita_, java.lang.Long _fitxer1ID_, java.lang.Long _fitxer2ID_, java.lang.Long _fitxer3ID_, java.lang.Long _fitxer4ID_, java.lang.Long _fitxer5ID_, java.lang.Long _fitxer6ID_, java.lang.Long _fitxer7ID_, java.lang.Long _fitxer8ID_, java.lang.Long _fitxer9ID_, java.sql.Timestamp _dataCreacio_, java.sql.Timestamp _datafinalitzacio_, int _estat_, java.lang.String _error_, java.lang.String _exception_) throws I18NException {
        InstanciaGenericaJPA __bean =  new InstanciaGenericaJPA(_numRegistre_,_uuid_,_solicitantPersonaFisica_,_solicitantTipusAdminID_,_solicitantAdminID_,_solicitantNom_,_solicitantLlinatge1_,_solicitantLlinatge2_,_solicitantCif_,_solicitantRaoSocial_,_solicitantDireccio_,_solicitantEmail_,_solicitantTelefon_,_idiomaID_,_exposa_,_solicita_,_fitxer1ID_,_fitxer2ID_,_fitxer3ID_,_fitxer4ID_,_fitxer5ID_,_fitxer6ID_,_fitxer7ID_,_fitxer8ID_,_fitxer9ID_,_dataCreacio_,_datafinalitzacio_,_estat_,_error_,_exception_);
        return create(__bean);
    }



 public void delete(java.lang.Long _instanciaGenericaID_) {
   delete(findByPrimaryKey(_instanciaGenericaID_));
 }




    public InstanciaGenerica findByPrimaryKey(java.lang.Long _instanciaGenericaID_) {
        return __em.find(InstanciaGenericaJPA.class, _instanciaGenericaID_);  
    }
    @Override
    protected InstanciaGenerica getJPAInstance(InstanciaGenerica __bean) {
        return convertToJPA(__bean);
    }


    public static InstanciaGenericaJPA convertToJPA(InstanciaGenerica __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof InstanciaGenericaJPA) {
        return (InstanciaGenericaJPA)__bean;
      }
      
      return InstanciaGenericaJPA.toJPA(__bean);
    }


}