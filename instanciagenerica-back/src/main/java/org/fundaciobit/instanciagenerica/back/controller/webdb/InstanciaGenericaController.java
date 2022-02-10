package org.fundaciobit.instanciagenerica.back.controller.webdb;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.utils.Utils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.GroupByItem;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.web.validation.ValidationWebUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.fundaciobit.instanciagenerica.back.form.webdb.*;
import org.fundaciobit.instanciagenerica.back.form.webdb.InstanciaGenericaForm;

import org.fundaciobit.instanciagenerica.back.validator.webdb.InstanciaGenericaWebValidator;

import org.fundaciobit.instanciagenerica.model.entity.Fitxer;
import org.fundaciobit.instanciagenerica.persistence.FitxerJPA;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;
import org.fundaciobit.instanciagenerica.persistence.InstanciaGenericaJPA;
import org.fundaciobit.instanciagenerica.model.entity.InstanciaGenerica;
import org.fundaciobit.instanciagenerica.model.fields.*;

/**
 * Controller per gestionar un InstanciaGenerica
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/instanciaGenerica")
@SessionAttributes(types = { InstanciaGenericaForm.class, InstanciaGenericaFilterForm.class })
public class InstanciaGenericaController
    extends org.fundaciobit.instanciagenerica.back.controller.InstanciaGenericaFilesBaseController<InstanciaGenerica, java.lang.Long, InstanciaGenericaForm> implements InstanciaGenericaFields {

  @EJB(mappedName = org.fundaciobit.instanciagenerica.ejb.InstanciaGenericaService.JNDI_NAME)
  protected org.fundaciobit.instanciagenerica.ejb.InstanciaGenericaService instanciaGenericaEjb;

  @Autowired
  private InstanciaGenericaWebValidator instanciaGenericaWebValidator;

  @Autowired
  protected InstanciaGenericaRefList instanciaGenericaRefList;

  // References 
  @Autowired
  protected IdiomaRefList idiomaRefList;

  /**
   * Llistat de totes InstanciaGenerica
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    InstanciaGenericaFilterForm ff;
    ff = (InstanciaGenericaFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar InstanciaGenerica de forma paginada
   */
  @RequestMapping(value = "/list/{pagina}", method = RequestMethod.GET)
  public ModelAndView llistatPaginat(HttpServletRequest request,
    HttpServletResponse response, @PathVariable Integer pagina)
      throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileList());
    llistat(mav, request, getInstanciaGenericaFilterForm(pagina, mav, request));
    return mav;
  }

  public InstanciaGenericaFilterForm getInstanciaGenericaFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    InstanciaGenericaFilterForm instanciaGenericaFilterForm;
    instanciaGenericaFilterForm = (InstanciaGenericaFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(instanciaGenericaFilterForm == null) {
      instanciaGenericaFilterForm = new InstanciaGenericaFilterForm();
      instanciaGenericaFilterForm.setContexte(getContextWeb());
      instanciaGenericaFilterForm.setEntityNameCode(getEntityNameCode());
      instanciaGenericaFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      instanciaGenericaFilterForm.setNou(true);
    } else {
      instanciaGenericaFilterForm.setNou(false);
    }
    instanciaGenericaFilterForm.setPage(pagina == null ? 1 : pagina);
    return instanciaGenericaFilterForm;
  }

  /**
   * Segona i següent peticions per llistar InstanciaGenerica de forma paginada
   * 
   * @param request
   * @param pagina
   * @param filterForm
   * @return
   * @throws I18NException
   */
  @RequestMapping(value = "/list/{pagina}", method = RequestMethod.POST)
  public ModelAndView llistatPaginat(HttpServletRequest request,
      HttpServletResponse response,@PathVariable Integer pagina,
      @ModelAttribute InstanciaGenericaFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getInstanciaGenericaFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de InstanciaGenerica de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<InstanciaGenerica> llistat(ModelAndView mav, HttpServletRequest request,
     InstanciaGenericaFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<InstanciaGenerica> instanciaGenerica = processarLlistat(instanciaGenericaEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("instanciaGenericaItems", instanciaGenerica);

    mav.addObject("instanciaGenericaFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, instanciaGenerica, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, instanciaGenerica);

    return instanciaGenerica;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(InstanciaGenericaFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<InstanciaGenerica> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;


      fillValuesToGroupByItemsBoolean("personafisica", groupByItemsMap, SOLICITANTPERSONAFISICA);

    // Field solicitantTipusAdminID
    {
      _listSKV = getReferenceListForSolicitantTipusAdminID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfValuesForSolicitantTipusAdminID(_tmp);
      if (filterForm.getGroupByFields().contains(SOLICITANTTIPUSADMINID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, SOLICITANTTIPUSADMINID, false);
      };
    }

    // Field idiomaID
    {
      _listSKV = getReferenceListForIdiomaID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfIdiomaForIdiomaID(_tmp);
      if (filterForm.getGroupByFields().contains(IDIOMAID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, IDIOMAID, false);
      };
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    InstanciaGenericaFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<InstanciaGenerica> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_INSTANCIAGENERICA_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(SOLICITANTTIPUSADMINID, filterForm.getMapOfValuesForSolicitantTipusAdminID());
    __mapping.put(IDIOMAID, filterForm.getMapOfIdiomaForIdiomaID());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou InstanciaGenerica
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearInstanciaGenericaGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    InstanciaGenericaForm instanciaGenericaForm = getInstanciaGenericaForm(null, false, request, mav);
    mav.addObject("instanciaGenericaForm" ,instanciaGenericaForm);
    fillReferencesForForm(instanciaGenericaForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public InstanciaGenericaForm getInstanciaGenericaForm(InstanciaGenericaJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    InstanciaGenericaForm instanciaGenericaForm;
    if(_jpa == null) {
      instanciaGenericaForm = new InstanciaGenericaForm(new InstanciaGenericaJPA(), true);
    } else {
      instanciaGenericaForm = new InstanciaGenericaForm(_jpa, false);
      instanciaGenericaForm.setView(__isView);
    }
    instanciaGenericaForm.setContexte(getContextWeb());
    instanciaGenericaForm.setEntityNameCode(getEntityNameCode());
    instanciaGenericaForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return instanciaGenericaForm;
  }

  public void fillReferencesForForm(InstanciaGenericaForm instanciaGenericaForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (instanciaGenericaForm.getListOfValuesForSolicitantPersonaFisica() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForSolicitantPersonaFisica(request, mav, instanciaGenericaForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      instanciaGenericaForm.setListOfValuesForSolicitantPersonaFisica(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (instanciaGenericaForm.getListOfValuesForSolicitantTipusAdminID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForSolicitantTipusAdminID(request, mav, instanciaGenericaForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      instanciaGenericaForm.setListOfValuesForSolicitantTipusAdminID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (instanciaGenericaForm.getListOfIdiomaForIdiomaID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForIdiomaID(request, mav, instanciaGenericaForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      instanciaGenericaForm.setListOfIdiomaForIdiomaID(_listSKV);
    }
    
  }

  /**
   * Guardar un nou InstanciaGenerica
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearInstanciaGenericaPost(@ModelAttribute InstanciaGenericaForm instanciaGenericaForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    InstanciaGenericaJPA instanciaGenerica = instanciaGenericaForm.getInstanciaGenerica();

    FilesFormManager<Fitxer> afm = getFilesFormManager(); // FILE

    try {
      this.setFilesFormToEntity(afm, instanciaGenerica, instanciaGenericaForm); // FILE
      preValidate(request, instanciaGenericaForm, result);
      getWebValidator().validate(instanciaGenericaForm, result);
      postValidate(request,instanciaGenericaForm, result);

      if (result.hasErrors()) {
        afm.processErrorFilesWithoutThrowException(); // FILE
        result.reject("error.form");
        return getTileForm();
      } else {
        instanciaGenerica = create(request, instanciaGenerica);
        afm.postPersistFiles(); // FILE
        createMessageSuccess(request, "success.creation", instanciaGenerica.getInstanciaGenericaID());
        instanciaGenericaForm.setInstanciaGenerica(instanciaGenerica);
        return getRedirectWhenCreated(request, instanciaGenericaForm);
      }
    } catch (Throwable __e) {
      afm.processErrorFilesWithoutThrowException(); // FILE
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.creation", null, __e);
      log.error(msg, __e);
      return getTileForm();
    }
  }

  @RequestMapping(value = "/view/{instanciaGenericaID}", method = RequestMethod.GET)
  public ModelAndView veureInstanciaGenericaGet(@PathVariable("instanciaGenericaID") java.lang.Long instanciaGenericaID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewInstanciaGenericaGet(instanciaGenericaID,
        request, response, true);
  }


  protected ModelAndView editAndViewInstanciaGenericaGet(@PathVariable("instanciaGenericaID") java.lang.Long instanciaGenericaID,
      HttpServletRequest request,
      HttpServletResponse response, boolean __isView) throws I18NException {
    if((!__isView) && !isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    } else {
      if(__isView && !isActiveFormView()) {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return null;
      }
    }
    InstanciaGenericaJPA instanciaGenerica = findByPrimaryKey(request, instanciaGenericaID);

    if (instanciaGenerica == null) {
      createMessageWarning(request, "error.notfound", instanciaGenericaID);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, instanciaGenericaID), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      InstanciaGenericaForm instanciaGenericaForm = getInstanciaGenericaForm(instanciaGenerica, __isView, request, mav);
      instanciaGenericaForm.setView(__isView);
      if(__isView) {
        instanciaGenericaForm.setAllFieldsReadOnly(ALL_INSTANCIAGENERICA_FIELDS);
        instanciaGenericaForm.setSaveButtonVisible(false);
        instanciaGenericaForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(instanciaGenericaForm, request, mav);
      mav.addObject("instanciaGenericaForm", instanciaGenericaForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un InstanciaGenerica existent
   */
  @RequestMapping(value = "/{instanciaGenericaID}/edit", method = RequestMethod.GET)
  public ModelAndView editarInstanciaGenericaGet(@PathVariable("instanciaGenericaID") java.lang.Long instanciaGenericaID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewInstanciaGenericaGet(instanciaGenericaID,
        request, response, false);
  }



  /**
   * Editar un InstanciaGenerica existent
   */
  @RequestMapping(value = "/{instanciaGenericaID}/edit", method = RequestMethod.POST)
  public String editarInstanciaGenericaPost(@ModelAttribute InstanciaGenericaForm instanciaGenericaForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    InstanciaGenericaJPA instanciaGenerica = instanciaGenericaForm.getInstanciaGenerica();

    FilesFormManager<Fitxer> afm = getFilesFormManager(); // FILE
    try {
      this.setFilesFormToEntity(afm, instanciaGenerica, instanciaGenericaForm); // FILE
      preValidate(request, instanciaGenericaForm, result);
      getWebValidator().validate(instanciaGenericaForm, result);
      postValidate(request, instanciaGenericaForm, result);

      if (result.hasErrors()) {
        afm.processErrorFilesWithoutThrowException(); // FILE
        result.reject("error.form");
        return getTileForm();
      } else {
        instanciaGenerica = update(request, instanciaGenerica);
        afm.postPersistFiles(); // FILE
        createMessageSuccess(request, "success.modification", instanciaGenerica.getInstanciaGenericaID());
        status.setComplete();
        return getRedirectWhenModified(request, instanciaGenericaForm, null);
      }
    } catch (Throwable __e) {
      afm.processErrorFilesWithoutThrowException(); // FILE
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          instanciaGenerica.getInstanciaGenericaID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, instanciaGenericaForm, __e);
    }

  }


  /**
   * Eliminar un InstanciaGenerica existent
   */
  @RequestMapping(value = "/{instanciaGenericaID}/delete")
  public String eliminarInstanciaGenerica(@PathVariable("instanciaGenericaID") java.lang.Long instanciaGenericaID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      InstanciaGenerica instanciaGenerica = instanciaGenericaEjb.findByPrimaryKey(instanciaGenericaID);
      if (instanciaGenerica == null) {
        String __msg =createMessageError(request, "error.notfound", instanciaGenericaID);
        return getRedirectWhenDelete(request, instanciaGenericaID, new Exception(__msg));
      } else {
        delete(request, instanciaGenerica);
        createMessageSuccess(request, "success.deleted", instanciaGenericaID);
        return getRedirectWhenDelete(request, instanciaGenericaID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", instanciaGenericaID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, instanciaGenericaID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute InstanciaGenericaFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarInstanciaGenerica(stringToPK(seleccionats[i]), request, response);
    }
  }
  if (redirect == null) {
    redirect = getRedirectWhenDelete(request, null,null);
  }

  return redirect;
}



public java.lang.Long stringToPK(String value) {
  return java.lang.Long.parseLong(value, 10);
}

  @Override
  public String[] getArgumentsMissatge(Object __instanciaGenericaID, Throwable e) {
    java.lang.Long instanciaGenericaID = (java.lang.Long)__instanciaGenericaID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (instanciaGenericaID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(instanciaGenericaID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "instanciaGenerica.instanciaGenerica";
  }

  public String getEntityNameCodePlural() {
    return "instanciaGenerica.instanciaGenerica.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("instanciaGenerica.instanciaGenericaID");
  }

  @InitBinder("instanciaGenericaFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("instanciaGenericaForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "instanciaGenerica.instanciaGenericaID");
  }

  public InstanciaGenericaWebValidator getWebValidator() {
    return instanciaGenericaWebValidator;
  }


  public void setWebValidator(InstanciaGenericaWebValidator __val) {
    if (__val != null) {
      this.instanciaGenericaWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de InstanciaGenerica
   */
  @RequestMapping(value = "/{instanciaGenericaID}/cancel")
  public String cancelInstanciaGenerica(@PathVariable("instanciaGenericaID") java.lang.Long instanciaGenericaID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, instanciaGenericaID);
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

  // FILE
  @Override
  public void setFilesFormToEntity(FilesFormManager<Fitxer> afm, InstanciaGenerica instanciaGenerica,
      InstanciaGenericaForm form) throws I18NException {

    FitxerJPA f;
    f = (FitxerJPA)afm.preProcessFile(form.getFitxer1ID(), form.isFitxer1IDDelete(),
        form.isNou()? null : instanciaGenerica.getFitxer1());
    ((InstanciaGenericaJPA)instanciaGenerica).setFitxer1(f);
    if (f != null) { 
      instanciaGenerica.setFitxer1ID(f.getFitxerID());
    } else {
      instanciaGenerica.setFitxer1ID(null);
    }


    f = (FitxerJPA)afm.preProcessFile(form.getFitxer2ID(), form.isFitxer2IDDelete(),
        form.isNou()? null : instanciaGenerica.getFitxer2());
    ((InstanciaGenericaJPA)instanciaGenerica).setFitxer2(f);
    if (f != null) { 
      instanciaGenerica.setFitxer2ID(f.getFitxerID());
    } else {
      instanciaGenerica.setFitxer2ID(null);
    }


    f = (FitxerJPA)afm.preProcessFile(form.getFitxer3ID(), form.isFitxer3IDDelete(),
        form.isNou()? null : instanciaGenerica.getFitxer3());
    ((InstanciaGenericaJPA)instanciaGenerica).setFitxer3(f);
    if (f != null) { 
      instanciaGenerica.setFitxer3ID(f.getFitxerID());
    } else {
      instanciaGenerica.setFitxer3ID(null);
    }


    f = (FitxerJPA)afm.preProcessFile(form.getFitxer4ID(), form.isFitxer4IDDelete(),
        form.isNou()? null : instanciaGenerica.getFitxer4());
    ((InstanciaGenericaJPA)instanciaGenerica).setFitxer4(f);
    if (f != null) { 
      instanciaGenerica.setFitxer4ID(f.getFitxerID());
    } else {
      instanciaGenerica.setFitxer4ID(null);
    }


    f = (FitxerJPA)afm.preProcessFile(form.getFitxer5ID(), form.isFitxer5IDDelete(),
        form.isNou()? null : instanciaGenerica.getFitxer5());
    ((InstanciaGenericaJPA)instanciaGenerica).setFitxer5(f);
    if (f != null) { 
      instanciaGenerica.setFitxer5ID(f.getFitxerID());
    } else {
      instanciaGenerica.setFitxer5ID(null);
    }


    f = (FitxerJPA)afm.preProcessFile(form.getFitxer6ID(), form.isFitxer6IDDelete(),
        form.isNou()? null : instanciaGenerica.getFitxer6());
    ((InstanciaGenericaJPA)instanciaGenerica).setFitxer6(f);
    if (f != null) { 
      instanciaGenerica.setFitxer6ID(f.getFitxerID());
    } else {
      instanciaGenerica.setFitxer6ID(null);
    }


    f = (FitxerJPA)afm.preProcessFile(form.getFitxer7ID(), form.isFitxer7IDDelete(),
        form.isNou()? null : instanciaGenerica.getFitxer7());
    ((InstanciaGenericaJPA)instanciaGenerica).setFitxer7(f);
    if (f != null) { 
      instanciaGenerica.setFitxer7ID(f.getFitxerID());
    } else {
      instanciaGenerica.setFitxer7ID(null);
    }


    f = (FitxerJPA)afm.preProcessFile(form.getFitxer8ID(), form.isFitxer8IDDelete(),
        form.isNou()? null : instanciaGenerica.getFitxer8());
    ((InstanciaGenericaJPA)instanciaGenerica).setFitxer8(f);
    if (f != null) { 
      instanciaGenerica.setFitxer8ID(f.getFitxerID());
    } else {
      instanciaGenerica.setFitxer8ID(null);
    }


    f = (FitxerJPA)afm.preProcessFile(form.getFitxer9ID(), form.isFitxer9IDDelete(),
        form.isNou()? null : instanciaGenerica.getFitxer9());
    ((InstanciaGenericaJPA)instanciaGenerica).setFitxer9(f);
    if (f != null) { 
      instanciaGenerica.setFitxer9ID(f.getFitxerID());
    } else {
      instanciaGenerica.setFitxer9ID(null);
    }


  }

  // FILE
  @Override
  public void deleteFiles(InstanciaGenerica instanciaGenerica) {
    deleteFile(instanciaGenerica.getFitxer1ID());
    deleteFile(instanciaGenerica.getFitxer2ID());
    deleteFile(instanciaGenerica.getFitxer3ID());
    deleteFile(instanciaGenerica.getFitxer4ID());
    deleteFile(instanciaGenerica.getFitxer5ID());
    deleteFile(instanciaGenerica.getFitxer6ID());
    deleteFile(instanciaGenerica.getFitxer7ID());
    deleteFile(instanciaGenerica.getFitxer8ID());
    deleteFile(instanciaGenerica.getFitxer9ID());
  }
  // Mètodes a sobreescriure 

  public boolean isActiveList() {
    return true;
  }


  public boolean isActiveFormNew() {
    return true;
  }


  public boolean isActiveFormEdit() {
    return true;
  }


  public boolean isActiveDelete() {
    return true;
  }


  public boolean isActiveFormView() {
    return isActiveFormEdit();
  }


  public List<StringKeyValue> getReferenceListForSolicitantPersonaFisica(HttpServletRequest request,
       ModelAndView mav, InstanciaGenericaForm instanciaGenericaForm, Where where)  throws I18NException {
    if (instanciaGenericaForm.isHiddenField(SOLICITANTPERSONAFISICA)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    return getReferenceListForSolicitantPersonaFisica(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForSolicitantPersonaFisica(HttpServletRequest request,
       ModelAndView mav, InstanciaGenericaFilterForm instanciaGenericaFilterForm,
       List<InstanciaGenerica> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (instanciaGenericaFilterForm.isHiddenField(SOLICITANTPERSONAFISICA)
      && !instanciaGenericaFilterForm.isGroupByField(SOLICITANTPERSONAFISICA)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    return getReferenceListForSolicitantPersonaFisica(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForSolicitantPersonaFisica(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("personafisica" , "personafisica"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForSolicitantTipusAdminID(HttpServletRequest request,
       ModelAndView mav, InstanciaGenericaForm instanciaGenericaForm, Where where)  throws I18NException {
    if (instanciaGenericaForm.isHiddenField(SOLICITANTTIPUSADMINID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    return getReferenceListForSolicitantTipusAdminID(request, mav, where);
  }


  public List<StringKeyValue> getReferenceListForSolicitantTipusAdminID(HttpServletRequest request,
       ModelAndView mav, InstanciaGenericaFilterForm instanciaGenericaFilterForm,
       List<InstanciaGenerica> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (instanciaGenericaFilterForm.isHiddenField(SOLICITANTTIPUSADMINID)
      && !instanciaGenericaFilterForm.isGroupByField(SOLICITANTTIPUSADMINID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    return getReferenceListForSolicitantTipusAdminID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForSolicitantTipusAdminID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
    __tmp.add(new StringKeyValue("1" , "1"));
    __tmp.add(new StringKeyValue("2" , "2"));
    __tmp.add(new StringKeyValue("3" , "3"));
    __tmp.add(new StringKeyValue("4" , "4"));
    return __tmp;
  }


  public List<StringKeyValue> getReferenceListForIdiomaID(HttpServletRequest request,
       ModelAndView mav, InstanciaGenericaForm instanciaGenericaForm, Where where)  throws I18NException {
    if (instanciaGenericaForm.isHiddenField(IDIOMAID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (instanciaGenericaForm.isReadOnlyField(IDIOMAID)) {
      _where = IdiomaFields.IDIOMAID.equal(instanciaGenericaForm.getInstanciaGenerica().getIdiomaID());
    }
    return getReferenceListForIdiomaID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForIdiomaID(HttpServletRequest request,
       ModelAndView mav, InstanciaGenericaFilterForm instanciaGenericaFilterForm,
       List<InstanciaGenerica> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (instanciaGenericaFilterForm.isHiddenField(IDIOMAID)
      && !instanciaGenericaFilterForm.isGroupByField(IDIOMAID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(IDIOMAID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.String> _pkList = new java.util.HashSet<java.lang.String>();
      for (InstanciaGenerica _item : list) {
        _pkList.add(_item.getIdiomaID());
        }
        _w = IdiomaFields.IDIOMAID.in(_pkList);
      }
    return getReferenceListForIdiomaID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForIdiomaID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return idiomaRefList.getReferenceList(IdiomaFields.IDIOMAID, where );
  }


  public void preValidate(HttpServletRequest request,InstanciaGenericaForm instanciaGenericaForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,InstanciaGenericaForm instanciaGenericaForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, InstanciaGenericaFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, InstanciaGenericaFilterForm filterForm,  List<InstanciaGenerica> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, InstanciaGenericaForm instanciaGenericaForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, InstanciaGenericaForm instanciaGenericaForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long instanciaGenericaID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long instanciaGenericaID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "instanciaGenericaFormWebDB";
  }

  public String getTileList() {
    return "instanciaGenericaListWebDB";
  }

  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public String getSessionAttributeFilterForm() {
    return "InstanciaGenericaWebDB_FilterForm";
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public InstanciaGenericaJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long instanciaGenericaID) throws I18NException {
    return (InstanciaGenericaJPA) instanciaGenericaEjb.findByPrimaryKey(instanciaGenericaID);
  }


  public InstanciaGenericaJPA create(HttpServletRequest request, InstanciaGenericaJPA instanciaGenerica)
    throws Exception,I18NException, I18NValidationException {
    return (InstanciaGenericaJPA) instanciaGenericaEjb.create(instanciaGenerica);
  }


  public InstanciaGenericaJPA update(HttpServletRequest request, InstanciaGenericaJPA instanciaGenerica)
    throws Exception,I18NException, I18NValidationException {
    return (InstanciaGenericaJPA) instanciaGenericaEjb.update(instanciaGenerica);
  }


  public void delete(HttpServletRequest request, InstanciaGenerica instanciaGenerica) throws Exception,I18NException {
    instanciaGenericaEjb.delete(instanciaGenerica);
  }

} // Final de Classe

