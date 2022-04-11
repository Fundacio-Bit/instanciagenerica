
package org.fundaciobit.instanciagenerica.logic;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.instanciagenerica.ejb.InstanciaGenericaService;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;

import es.caib.regweb3.ws.api.v3.AsientoRegistralWs;
import es.caib.regweb3.ws.api.v3.AsientoWs;
import es.caib.regweb3.ws.api.v3.FileContentWs;
import es.caib.regweb3.ws.api.v3.JustificanteWs;
import es.caib.regweb3.ws.api.v3.RegWebAsientoRegistralWs;

/**
 * 
 * @author ptrias
 *
 */
@Local
public interface InstanciaGenericaLogicService extends InstanciaGenericaService {

	public static final String JNDI_NAME = "java:app/instanciagenerica-ejb/InstanciaGenericaLogicEJB!org.fundaciobit.instanciagenerica.logic.InstanciaGenericaLogicService";

	public void deleteFull(InstanciaGenerica instanciaGenerica) throws I18NException;

	public InstanciaGenericaJPA generarInstanciaGenericaAleatoria(InstanciaGenericaJPA ig);

	public AsientoRegistralWs obtenerAsiento(String numRegF) throws I18NException;

	public AsientoWs obtenerAsientoCiudadano(String numRegF, String nif, String idioma) throws I18NException;

	public RegWebAsientoRegistralWs getApiRegistre() throws I18NException;

	public FileContentWs getAnexe(Long idAnexo, String idioma) throws I18NException;

	public JustificanteWs getJustificant(String numRegF) throws I18NException;
	
	
}
