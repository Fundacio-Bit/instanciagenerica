package org.fundaciobit.instanciagenerica.back.controller;

import org.fundaciobit.instanciagenerica.persistence.FitxerJPA;
import org.fundaciobit.instanciagenerica.model.entity.Fitxer;

import org.fundaciobit.genapp.common.filesystem.IFileManager;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;


/**
 * Gestiona Multiples Fitxers d'un Form
 * 
 * @author anadal
 * 
 */
public class InstanciaGenericaFilesFormManager extends FilesFormManager<Fitxer> {

  public InstanciaGenericaFilesFormManager(IFileManager<Fitxer> fitxerEjb) {
    super(fitxerEjb);
  }

  @Override
  public FitxerJPA createEmptyFile() {    
    return new FitxerJPA();
  }

}
