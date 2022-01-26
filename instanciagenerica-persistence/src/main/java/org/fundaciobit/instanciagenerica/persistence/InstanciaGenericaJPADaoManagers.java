package org.fundaciobit.instanciagenerica.persistence;

import org.fundaciobit.instanciagenerica.model.*;
import org.fundaciobit.instanciagenerica.model.dao.*;
import javax.persistence.EntityManager;

public final class InstanciaGenericaJPADaoManagers implements IInstanciaGenericaDaoManagers{

   private final FitxerJPAManager ige_fitxer;
   private final IdiomaJPAManager ige_idioma;
   private final InstanciaGenericaJPAManager ige_instanciagenerica;
   private final TraduccioJPAManager ige_traduccio;

  public  InstanciaGenericaJPADaoManagers(EntityManager __em) {
    this.ige_fitxer = new FitxerJPAManager(__em);
    this.ige_idioma = new IdiomaJPAManager(__em);
    this.ige_instanciagenerica = new InstanciaGenericaJPAManager(__em);
    this.ige_traduccio = new TraduccioJPAManager(__em);
  }

    public IFitxerManager getFitxerManager() {
        return this.ige_fitxer;
    };

    public IIdiomaManager getIdiomaManager() {
        return this.ige_idioma;
    };

    public IInstanciaGenericaManager getInstanciaGenericaManager() {
        return this.ige_instanciagenerica;
    };

    public ITraduccioManager getTraduccioManager() {
        return this.ige_traduccio;
    };


}