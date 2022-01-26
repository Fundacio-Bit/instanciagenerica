package org.fundaciobit.instanciagenerica.model;

import org.fundaciobit.instanciagenerica.model.dao.*;

public interface IInstanciaGenericaDaoManagers {
	public IFitxerManager getFitxerManager();
	public IIdiomaManager getIdiomaManager();
	public IInstanciaGenericaManager getInstanciaGenericaManager();
	public ITraduccioManager getTraduccioManager();

}