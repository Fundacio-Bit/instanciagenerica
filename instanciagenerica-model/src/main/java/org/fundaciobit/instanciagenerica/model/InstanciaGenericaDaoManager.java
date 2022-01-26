package org.fundaciobit.instanciagenerica.model;

public class InstanciaGenericaDaoManager {
  
  private static IInstanciaGenericaDaoManagers instance = null;
  
  public static void setDaoManagers(IInstanciaGenericaDaoManagers managers) {
    instance = managers;
  }
  
  public static IInstanciaGenericaDaoManagers getDaoManagers() throws Exception {
    if(instance == null) {
      throw new Exception("Ha de inicialitzar el sistema de Managers cridant "
          + " al mètode InstanciaGenericaDaoManager.setDaoManagers(...)");
    }
    return instance;
  }
  
}
