<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="InstanciaGenericaFields" className="org.fundaciobit.instanciagenerica.model.fields.InstanciaGenericaFields"/>
  
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.NUMREGISTRE)}">
        <tr id="instanciaGenerica_numRegistre_rowid">
          <td id="instanciaGenerica_numRegistre_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.NUMREGISTRE])?'instanciaGenerica.numRegistre':__theForm.labels[InstanciaGenericaFields.NUMREGISTRE]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.NUMREGISTRE]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.NUMREGISTRE]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_numRegistre_columnvalueid">
            <form:errors path="instanciaGenerica.numRegistre" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.NUMREGISTRE)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.NUMREGISTRE)? ' uneditable-input' : ''}"  style="" maxlength="50" path="instanciaGenerica.numRegistre"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.UUID)}">
        <tr id="instanciaGenerica_uuid_rowid">
          <td id="instanciaGenerica_uuid_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.UUID])?'instanciaGenerica.uuid':__theForm.labels[InstanciaGenericaFields.UUID]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.UUID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.UUID]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_uuid_columnvalueid">
            <form:errors path="instanciaGenerica.uuid" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.UUID)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.UUID)? ' uneditable-input' : ''}"  style="" maxlength="100" path="instanciaGenerica.uuid"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.SOLICITANTPERSONAFISICA)}">
        <tr id="instanciaGenerica_solicitantPersonaFisica_rowid">
          <td id="instanciaGenerica_solicitantPersonaFisica_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.SOLICITANTPERSONAFISICA])?'instanciaGenerica.solicitantPersonaFisica':__theForm.labels[InstanciaGenericaFields.SOLICITANTPERSONAFISICA]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.SOLICITANTPERSONAFISICA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.SOLICITANTPERSONAFISICA]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_solicitantPersonaFisica_columnvalueid">
          <form:errors path="instanciaGenerica.solicitantPersonaFisica" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTPERSONAFISICA)}" >
          <form:hidden path="instanciaGenerica.solicitantPersonaFisica"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.instanciaGenerica.solicitantPersonaFisica,__theForm.listOfValuesForSolicitantPersonaFisica)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTPERSONAFISICA)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="instanciaGenerica_solicitantPersonaFisica"  onchange="if(typeof onChangeSolicitantPersonaFisica == 'function') {  onChangeSolicitantPersonaFisica(this); };"  cssClass="form-control col-md-9-optional" path="instanciaGenerica.solicitantPersonaFisica">
            <c:forEach items="${__theForm.listOfValuesForSolicitantPersonaFisica}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.SOLICITANTTIPUSADMINID)}">
        <tr id="instanciaGenerica_solicitantTipusAdminID_rowid">
          <td id="instanciaGenerica_solicitantTipusAdminID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.SOLICITANTTIPUSADMINID])?'instanciaGenerica.solicitantTipusAdminID':__theForm.labels[InstanciaGenericaFields.SOLICITANTTIPUSADMINID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.SOLICITANTTIPUSADMINID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.SOLICITANTTIPUSADMINID]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_solicitantTipusAdminID_columnvalueid">
          <form:errors path="instanciaGenerica.solicitantTipusAdminID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTTIPUSADMINID)}" >
          <form:hidden path="instanciaGenerica.solicitantTipusAdminID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.instanciaGenerica.solicitantTipusAdminID,__theForm.listOfValuesForSolicitantTipusAdminID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTTIPUSADMINID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="instanciaGenerica_solicitantTipusAdminID"  onchange="if(typeof onChangeSolicitantTipusAdminID == 'function') {  onChangeSolicitantTipusAdminID(this); };"  cssClass="form-control col-md-9-optional" path="instanciaGenerica.solicitantTipusAdminID">
            <c:forEach items="${__theForm.listOfValuesForSolicitantTipusAdminID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.SOLICITANTADMINID)}">
        <tr id="instanciaGenerica_solicitantAdminID_rowid">
          <td id="instanciaGenerica_solicitantAdminID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.SOLICITANTADMINID])?'instanciaGenerica.solicitantAdminID':__theForm.labels[InstanciaGenericaFields.SOLICITANTADMINID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.SOLICITANTADMINID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.SOLICITANTADMINID]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_solicitantAdminID_columnvalueid">
            <form:errors path="instanciaGenerica.solicitantAdminID" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTADMINID)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTADMINID)? ' uneditable-input' : ''}"  style="" maxlength="50" path="instanciaGenerica.solicitantAdminID"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.SOLICITANTNOM)}">
        <tr id="instanciaGenerica_solicitantNom_rowid">
          <td id="instanciaGenerica_solicitantNom_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.SOLICITANTNOM])?'instanciaGenerica.solicitantNom':__theForm.labels[InstanciaGenericaFields.SOLICITANTNOM]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.SOLICITANTNOM]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.SOLICITANTNOM]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_solicitantNom_columnvalueid">
            <form:errors path="instanciaGenerica.solicitantNom" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTNOM)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTNOM)? ' uneditable-input' : ''}"  style="" maxlength="100" path="instanciaGenerica.solicitantNom"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.SOLICITANTLLINATGE1)}">
        <tr id="instanciaGenerica_solicitantLlinatge1_rowid">
          <td id="instanciaGenerica_solicitantLlinatge1_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.SOLICITANTLLINATGE1])?'instanciaGenerica.solicitantLlinatge1':__theForm.labels[InstanciaGenericaFields.SOLICITANTLLINATGE1]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.SOLICITANTLLINATGE1]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.SOLICITANTLLINATGE1]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_solicitantLlinatge1_columnvalueid">
            <form:errors path="instanciaGenerica.solicitantLlinatge1" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTLLINATGE1)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTLLINATGE1)? ' uneditable-input' : ''}"  style="" maxlength="100" path="instanciaGenerica.solicitantLlinatge1"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.SOLICITANTLLINATGE2)}">
        <tr id="instanciaGenerica_solicitantLlinatge2_rowid">
          <td id="instanciaGenerica_solicitantLlinatge2_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.SOLICITANTLLINATGE2])?'instanciaGenerica.solicitantLlinatge2':__theForm.labels[InstanciaGenericaFields.SOLICITANTLLINATGE2]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.SOLICITANTLLINATGE2]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.SOLICITANTLLINATGE2]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_solicitantLlinatge2_columnvalueid">
            <form:errors path="instanciaGenerica.solicitantLlinatge2" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTLLINATGE2)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTLLINATGE2)? ' uneditable-input' : ''}"  style="" maxlength="100" path="instanciaGenerica.solicitantLlinatge2"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.SOLICITANTCIF)}">
        <tr id="instanciaGenerica_solicitantCif_rowid">
          <td id="instanciaGenerica_solicitantCif_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.SOLICITANTCIF])?'instanciaGenerica.solicitantCif':__theForm.labels[InstanciaGenericaFields.SOLICITANTCIF]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.SOLICITANTCIF]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.SOLICITANTCIF]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_solicitantCif_columnvalueid">
            <form:errors path="instanciaGenerica.solicitantCif" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTCIF)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTCIF)? ' uneditable-input' : ''}"  style="" maxlength="50" path="instanciaGenerica.solicitantCif"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.SOLICITANTRAOSOCIAL)}">
        <tr id="instanciaGenerica_solicitantRaoSocial_rowid">
          <td id="instanciaGenerica_solicitantRaoSocial_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.SOLICITANTRAOSOCIAL])?'instanciaGenerica.solicitantRaoSocial':__theForm.labels[InstanciaGenericaFields.SOLICITANTRAOSOCIAL]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.SOLICITANTRAOSOCIAL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.SOLICITANTRAOSOCIAL]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_solicitantRaoSocial_columnvalueid">
            <form:errors path="instanciaGenerica.solicitantRaoSocial" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTRAOSOCIAL)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTRAOSOCIAL)? ' uneditable-input' : ''}"  style="" maxlength="100" path="instanciaGenerica.solicitantRaoSocial"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.SOLICITANTDIRECCIO)}">
        <tr id="instanciaGenerica_solicitantDireccio_rowid">
          <td id="instanciaGenerica_solicitantDireccio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.SOLICITANTDIRECCIO])?'instanciaGenerica.solicitantDireccio':__theForm.labels[InstanciaGenericaFields.SOLICITANTDIRECCIO]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.SOLICITANTDIRECCIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.SOLICITANTDIRECCIO]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_solicitantDireccio_columnvalueid">
              <form:errors path="instanciaGenerica.solicitantDireccio" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTDIRECCIO)? 'true' : 'false'}" path="instanciaGenerica.solicitantDireccio"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_solicitantDireccio" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_solicitantDireccio" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('instanciaGenerica.solicitantDireccio'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('instanciaGenerica.solicitantDireccio'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('instanciaGenerica.solicitantDireccio'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_solicitantDireccio').on('click', function(){
					var valor = ($('#dropdownMenuContainer_solicitantDireccio').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_solicitantDireccio').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.SOLICITANTEMAIL)}">
        <tr id="instanciaGenerica_solicitantEmail_rowid">
          <td id="instanciaGenerica_solicitantEmail_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.SOLICITANTEMAIL])?'instanciaGenerica.solicitantEmail':__theForm.labels[InstanciaGenericaFields.SOLICITANTEMAIL]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.SOLICITANTEMAIL]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.SOLICITANTEMAIL]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_solicitantEmail_columnvalueid">
            <form:errors path="instanciaGenerica.solicitantEmail" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTEMAIL)? 'true' : 'false'}" cssClass="w-100 form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTEMAIL)? ' uneditable-input' : ''}"  style="" maxlength="100" path="instanciaGenerica.solicitantEmail"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.SOLICITANTTELEFON)}">
        <tr id="instanciaGenerica_solicitantTelefon_rowid">
          <td id="instanciaGenerica_solicitantTelefon_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.SOLICITANTTELEFON])?'instanciaGenerica.solicitantTelefon':__theForm.labels[InstanciaGenericaFields.SOLICITANTTELEFON]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.SOLICITANTTELEFON]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.SOLICITANTTELEFON]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_solicitantTelefon_columnvalueid">
            <form:errors path="instanciaGenerica.solicitantTelefon" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTTELEFON)? 'true' : 'false'}" cssClass="w-75 form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITANTTELEFON)? ' uneditable-input' : ''}"  style="" maxlength="50" path="instanciaGenerica.solicitantTelefon"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.IDIOMAID)}">
        <tr id="instanciaGenerica_idiomaID_rowid">
          <td id="instanciaGenerica_idiomaID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.IDIOMAID])?'instanciaGenerica.idiomaID':__theForm.labels[InstanciaGenericaFields.IDIOMAID]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.IDIOMAID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.IDIOMAID]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_idiomaID_columnvalueid">
          <form:errors path="instanciaGenerica.idiomaID" cssClass="errorField alert alert-danger" />
          <c:if test="${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.IDIOMAID)}" >
          <form:hidden path="instanciaGenerica.idiomaID"/>
          <input type="text" readonly="true" class="form-control col-md-9-optional uneditable-input" value="${gen:findValue(__theForm.instanciaGenerica.idiomaID,__theForm.listOfIdiomaForIdiomaID)}"  />
          </c:if>
          <c:if test="${!gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.IDIOMAID)}" >
          <c:set var="containEmptyValue"  value="false" />
          <form:select id="instanciaGenerica_idiomaID"  onchange="if(typeof onChangeIdiomaID == 'function') {  onChangeIdiomaID(this); };"  cssClass="form-control col-md-9-optional" path="instanciaGenerica.idiomaID">
            <c:forEach items="${__theForm.listOfIdiomaForIdiomaID}" var="tmp">
                <form:option value="${tmp.key}">${tmp.value}</form:option>
                <c:if test="${empty tmp.key}">
                  <c:set var="containEmptyValue"  value="true" />
                </c:if>
            </c:forEach>
          </form:select>
          </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.EXPOSA)}">
        <tr id="instanciaGenerica_exposa_rowid">
          <td id="instanciaGenerica_exposa_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.EXPOSA])?'instanciaGenerica.exposa':__theForm.labels[InstanciaGenericaFields.EXPOSA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.EXPOSA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.EXPOSA]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_exposa_columnvalueid">
              <form:errors path="instanciaGenerica.exposa" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.EXPOSA)? 'true' : 'false'}" path="instanciaGenerica.exposa"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_exposa" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_exposa" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('instanciaGenerica.exposa'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('instanciaGenerica.exposa'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('instanciaGenerica.exposa'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_exposa').on('click', function(){
					var valor = ($('#dropdownMenuContainer_exposa').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_exposa').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.SOLICITA)}">
        <tr id="instanciaGenerica_solicita_rowid">
          <td id="instanciaGenerica_solicita_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.SOLICITA])?'instanciaGenerica.solicita':__theForm.labels[InstanciaGenericaFields.SOLICITA]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.SOLICITA]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.SOLICITA]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_solicita_columnvalueid">
              <form:errors path="instanciaGenerica.solicita" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.SOLICITA)? 'true' : 'false'}" path="instanciaGenerica.solicita"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_solicita" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_solicita" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('instanciaGenerica.solicita'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('instanciaGenerica.solicita'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('instanciaGenerica.solicita'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_solicita').on('click', function(){
					var valor = ($('#dropdownMenuContainer_solicita').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_solicita').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.FITXER1ID)}">
        <tr id="instanciaGenerica_fitxer1ID_rowid">
          <td id="instanciaGenerica_fitxer1ID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.FITXER1ID])?'instanciaGenerica.fitxer1ID':__theForm.labels[InstanciaGenericaFields.FITXER1ID]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.FITXER1ID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.FITXER1ID]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_fitxer1ID_columnvalueid">
              <form:errors path="instanciaGenerica.fitxer1ID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER1ID)}" >
              <a target="_blank" href="<c:url value="${ige:fileUrl(fitxer1ID.fitxer1ID)}"/>">${fitxer1ID.fitxer1ID.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER1ID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER1ID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER1ID)? ' uneditable-input' : ''}"   path="fitxer1ID" type="file" />
                  <label class="custom-file-label" for="fitxer1ID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.instanciaGenerica.fitxer1}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${ige:fileUrl(__theForm.instanciaGenerica.fitxer1)}"/>">${__theForm.instanciaGenerica.fitxer1.nom}</a>
</small>
                  </span>
                  <span class="input-group-text" id="">
                        <form:checkbox path="fitxer1IDDelete"/>
                        <small><fmt:message key="genapp.form.file.delete"/></small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="fitxer1ID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#fitxer1ID').on('change', function(){
						var ruta = $('#fitxer1ID').val(); 
						var rutaArray = ruta.split('\\');
						$('#fitxer1ID-custom-file-label').css('display','block');
						$('#fitxer1ID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.FITXER2ID)}">
        <tr id="instanciaGenerica_fitxer2ID_rowid">
          <td id="instanciaGenerica_fitxer2ID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.FITXER2ID])?'instanciaGenerica.fitxer2ID':__theForm.labels[InstanciaGenericaFields.FITXER2ID]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.FITXER2ID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.FITXER2ID]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_fitxer2ID_columnvalueid">
              <form:errors path="instanciaGenerica.fitxer2ID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER2ID)}" >
              <a target="_blank" href="<c:url value="${ige:fileUrl(fitxer2ID.fitxer2ID)}"/>">${fitxer2ID.fitxer2ID.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER2ID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER2ID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER2ID)? ' uneditable-input' : ''}"   path="fitxer2ID" type="file" />
                  <label class="custom-file-label" for="fitxer2ID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.instanciaGenerica.fitxer2}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${ige:fileUrl(__theForm.instanciaGenerica.fitxer2)}"/>">${__theForm.instanciaGenerica.fitxer2.nom}</a>
</small>
                  </span>
                  <span class="input-group-text" id="">
                        <form:checkbox path="fitxer2IDDelete"/>
                        <small><fmt:message key="genapp.form.file.delete"/></small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="fitxer2ID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#fitxer2ID').on('change', function(){
						var ruta = $('#fitxer2ID').val(); 
						var rutaArray = ruta.split('\\');
						$('#fitxer2ID-custom-file-label').css('display','block');
						$('#fitxer2ID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.FITXER3ID)}">
        <tr id="instanciaGenerica_fitxer3ID_rowid">
          <td id="instanciaGenerica_fitxer3ID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.FITXER3ID])?'instanciaGenerica.fitxer3ID':__theForm.labels[InstanciaGenericaFields.FITXER3ID]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.FITXER3ID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.FITXER3ID]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_fitxer3ID_columnvalueid">
              <form:errors path="instanciaGenerica.fitxer3ID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER3ID)}" >
              <a target="_blank" href="<c:url value="${ige:fileUrl(fitxer3ID.fitxer3ID)}"/>">${fitxer3ID.fitxer3ID.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER3ID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER3ID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER3ID)? ' uneditable-input' : ''}"   path="fitxer3ID" type="file" />
                  <label class="custom-file-label" for="fitxer3ID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.instanciaGenerica.fitxer3}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${ige:fileUrl(__theForm.instanciaGenerica.fitxer3)}"/>">${__theForm.instanciaGenerica.fitxer3.nom}</a>
</small>
                  </span>
                  <span class="input-group-text" id="">
                        <form:checkbox path="fitxer3IDDelete"/>
                        <small><fmt:message key="genapp.form.file.delete"/></small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="fitxer3ID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#fitxer3ID').on('change', function(){
						var ruta = $('#fitxer3ID').val(); 
						var rutaArray = ruta.split('\\');
						$('#fitxer3ID-custom-file-label').css('display','block');
						$('#fitxer3ID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.FITXER4ID)}">
        <tr id="instanciaGenerica_fitxer4ID_rowid">
          <td id="instanciaGenerica_fitxer4ID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.FITXER4ID])?'instanciaGenerica.fitxer4ID':__theForm.labels[InstanciaGenericaFields.FITXER4ID]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.FITXER4ID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.FITXER4ID]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_fitxer4ID_columnvalueid">
              <form:errors path="instanciaGenerica.fitxer4ID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER4ID)}" >
              <a target="_blank" href="<c:url value="${ige:fileUrl(fitxer4ID.fitxer4ID)}"/>">${fitxer4ID.fitxer4ID.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER4ID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER4ID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER4ID)? ' uneditable-input' : ''}"   path="fitxer4ID" type="file" />
                  <label class="custom-file-label" for="fitxer4ID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.instanciaGenerica.fitxer4}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${ige:fileUrl(__theForm.instanciaGenerica.fitxer4)}"/>">${__theForm.instanciaGenerica.fitxer4.nom}</a>
</small>
                  </span>
                  <span class="input-group-text" id="">
                        <form:checkbox path="fitxer4IDDelete"/>
                        <small><fmt:message key="genapp.form.file.delete"/></small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="fitxer4ID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#fitxer4ID').on('change', function(){
						var ruta = $('#fitxer4ID').val(); 
						var rutaArray = ruta.split('\\');
						$('#fitxer4ID-custom-file-label').css('display','block');
						$('#fitxer4ID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.FITXER5ID)}">
        <tr id="instanciaGenerica_fitxer5ID_rowid">
          <td id="instanciaGenerica_fitxer5ID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.FITXER5ID])?'instanciaGenerica.fitxer5ID':__theForm.labels[InstanciaGenericaFields.FITXER5ID]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.FITXER5ID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.FITXER5ID]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_fitxer5ID_columnvalueid">
              <form:errors path="instanciaGenerica.fitxer5ID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER5ID)}" >
              <a target="_blank" href="<c:url value="${ige:fileUrl(fitxer5ID.fitxer5ID)}"/>">${fitxer5ID.fitxer5ID.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER5ID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER5ID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER5ID)? ' uneditable-input' : ''}"   path="fitxer5ID" type="file" />
                  <label class="custom-file-label" for="fitxer5ID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.instanciaGenerica.fitxer5}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${ige:fileUrl(__theForm.instanciaGenerica.fitxer5)}"/>">${__theForm.instanciaGenerica.fitxer5.nom}</a>
</small>
                  </span>
                  <span class="input-group-text" id="">
                        <form:checkbox path="fitxer5IDDelete"/>
                        <small><fmt:message key="genapp.form.file.delete"/></small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="fitxer5ID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#fitxer5ID').on('change', function(){
						var ruta = $('#fitxer5ID').val(); 
						var rutaArray = ruta.split('\\');
						$('#fitxer5ID-custom-file-label').css('display','block');
						$('#fitxer5ID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.FITXER6ID)}">
        <tr id="instanciaGenerica_fitxer6ID_rowid">
          <td id="instanciaGenerica_fitxer6ID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.FITXER6ID])?'instanciaGenerica.fitxer6ID':__theForm.labels[InstanciaGenericaFields.FITXER6ID]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.FITXER6ID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.FITXER6ID]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_fitxer6ID_columnvalueid">
              <form:errors path="instanciaGenerica.fitxer6ID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER6ID)}" >
              <a target="_blank" href="<c:url value="${ige:fileUrl(fitxer6ID.fitxer6ID)}"/>">${fitxer6ID.fitxer6ID.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER6ID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER6ID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER6ID)? ' uneditable-input' : ''}"   path="fitxer6ID" type="file" />
                  <label class="custom-file-label" for="fitxer6ID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.instanciaGenerica.fitxer6}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${ige:fileUrl(__theForm.instanciaGenerica.fitxer6)}"/>">${__theForm.instanciaGenerica.fitxer6.nom}</a>
</small>
                  </span>
                  <span class="input-group-text" id="">
                        <form:checkbox path="fitxer6IDDelete"/>
                        <small><fmt:message key="genapp.form.file.delete"/></small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="fitxer6ID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#fitxer6ID').on('change', function(){
						var ruta = $('#fitxer6ID').val(); 
						var rutaArray = ruta.split('\\');
						$('#fitxer6ID-custom-file-label').css('display','block');
						$('#fitxer6ID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.FITXER7ID)}">
        <tr id="instanciaGenerica_fitxer7ID_rowid">
          <td id="instanciaGenerica_fitxer7ID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.FITXER7ID])?'instanciaGenerica.fitxer7ID':__theForm.labels[InstanciaGenericaFields.FITXER7ID]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.FITXER7ID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.FITXER7ID]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_fitxer7ID_columnvalueid">
              <form:errors path="instanciaGenerica.fitxer7ID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER7ID)}" >
              <a target="_blank" href="<c:url value="${ige:fileUrl(fitxer7ID.fitxer7ID)}"/>">${fitxer7ID.fitxer7ID.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER7ID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER7ID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER7ID)? ' uneditable-input' : ''}"   path="fitxer7ID" type="file" />
                  <label class="custom-file-label" for="fitxer7ID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.instanciaGenerica.fitxer7}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${ige:fileUrl(__theForm.instanciaGenerica.fitxer7)}"/>">${__theForm.instanciaGenerica.fitxer7.nom}</a>
</small>
                  </span>
                  <span class="input-group-text" id="">
                        <form:checkbox path="fitxer7IDDelete"/>
                        <small><fmt:message key="genapp.form.file.delete"/></small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="fitxer7ID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#fitxer7ID').on('change', function(){
						var ruta = $('#fitxer7ID').val(); 
						var rutaArray = ruta.split('\\');
						$('#fitxer7ID-custom-file-label').css('display','block');
						$('#fitxer7ID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.FITXER8ID)}">
        <tr id="instanciaGenerica_fitxer8ID_rowid">
          <td id="instanciaGenerica_fitxer8ID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.FITXER8ID])?'instanciaGenerica.fitxer8ID':__theForm.labels[InstanciaGenericaFields.FITXER8ID]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.FITXER8ID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.FITXER8ID]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_fitxer8ID_columnvalueid">
              <form:errors path="instanciaGenerica.fitxer8ID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER8ID)}" >
              <a target="_blank" href="<c:url value="${ige:fileUrl(fitxer8ID.fitxer8ID)}"/>">${fitxer8ID.fitxer8ID.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER8ID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER8ID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER8ID)? ' uneditable-input' : ''}"   path="fitxer8ID" type="file" />
                  <label class="custom-file-label" for="fitxer8ID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.instanciaGenerica.fitxer8}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${ige:fileUrl(__theForm.instanciaGenerica.fitxer8)}"/>">${__theForm.instanciaGenerica.fitxer8.nom}</a>
</small>
                  </span>
                  <span class="input-group-text" id="">
                        <form:checkbox path="fitxer8IDDelete"/>
                        <small><fmt:message key="genapp.form.file.delete"/></small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="fitxer8ID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#fitxer8ID').on('change', function(){
						var ruta = $('#fitxer8ID').val(); 
						var rutaArray = ruta.split('\\');
						$('#fitxer8ID-custom-file-label').css('display','block');
						$('#fitxer8ID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.FITXER9ID)}">
        <tr id="instanciaGenerica_fitxer9ID_rowid">
          <td id="instanciaGenerica_fitxer9ID_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.FITXER9ID])?'instanciaGenerica.fitxer9ID':__theForm.labels[InstanciaGenericaFields.FITXER9ID]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.FITXER9ID]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.FITXER9ID]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_fitxer9ID_columnvalueid">
              <form:errors path="instanciaGenerica.fitxer9ID" cssClass="errorField alert alert-danger" />
            <c:if test="${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER9ID)}" >
              <a target="_blank" href="<c:url value="${ige:fileUrl(fitxer9ID.fitxer9ID)}"/>">${fitxer9ID.fitxer9ID.nom}</a>
            </c:if>
            <c:if test="${!gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER9ID)}" >
              <div class="input-group col-md-9-optional" style="padding: 0px">
                <div class="custom-file">
                  <form:input  readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER9ID)? 'true' : 'false'}" cssClass="custom-file-input form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.FITXER9ID)? ' uneditable-input' : ''}"   path="fitxer9ID" type="file" />
                  <label class="custom-file-label" for="fitxer9ID">
                  </label>
                </div>
                <c:choose>
                <c:when test="${not empty __theForm.instanciaGenerica.fitxer9}">
                <div class="input-group-append">
                  <span class="input-group-text" id="">
                  <small>              <a target="_blank" href="<c:url value="${ige:fileUrl(__theForm.instanciaGenerica.fitxer9)}"/>">${__theForm.instanciaGenerica.fitxer9.nom}</a>
</small>
                  </span>
                  <span class="input-group-text" id="">
                        <form:checkbox path="fitxer9IDDelete"/>
                        <small><fmt:message key="genapp.form.file.delete"/></small>
                  </span>
                </div>
                </c:when>
                <c:otherwise>
                <div class="input-group-append input-group-append-file">
                  <span class="input-group-text" id="fitxer9ID-custom-file-label" style="display:none">
                  <small></small>
                  </span>
                </div>
                <script type="text/javascript">
					$('#fitxer9ID').on('change', function(){
						var ruta = $('#fitxer9ID').val(); 
						var rutaArray = ruta.split('\\');
						$('#fitxer9ID-custom-file-label').css('display','block');
						$('#fitxer9ID-custom-file-label small').html(rutaArray[rutaArray.length - 1]);
					});
				</script>                </c:otherwise>
                </c:choose>
              </div>
            </c:if>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.DATAFINALITZACIO)}">
        <tr id="instanciaGenerica_datafinalitzacio_rowid">
          <td id="instanciaGenerica_datafinalitzacio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.DATAFINALITZACIO])?'instanciaGenerica.datafinalitzacio':__theForm.labels[InstanciaGenericaFields.DATAFINALITZACIO]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.DATAFINALITZACIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.DATAFINALITZACIO]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_datafinalitzacio_columnvalueid">
    <form:errors path="instanciaGenerica.datafinalitzacio" cssClass="errorField alert alert-danger" />
            <div class="form-group">
                <div class="input-group date" id="instanciaGenerica_datafinalitzacio" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.DATAFINALITZACIO)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#instanciaGenerica_datafinalitzacio" path="instanciaGenerica.datafinalitzacio" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.DATAFINALITZACIO)}" >
                    <div class="input-group-append"  data-target="#instanciaGenerica_datafinalitzacio"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#instanciaGenerica_datafinalitzacio').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.DATACREACIO)}">
        <tr id="instanciaGenerica_dataCreacio_rowid">
          <td id="instanciaGenerica_dataCreacio_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.DATACREACIO])?'instanciaGenerica.dataCreacio':__theForm.labels[InstanciaGenericaFields.DATACREACIO]}" /> &nbsp;(*)
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.DATACREACIO]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.DATACREACIO]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_dataCreacio_columnvalueid">
    <form:errors path="instanciaGenerica.dataCreacio" cssClass="errorField alert alert-danger" />
            <div class="form-group">
                <div class="input-group date" id="instanciaGenerica_dataCreacio" data-target-input="nearest">
                      <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.DATACREACIO)? 'true' : 'false'}" cssClass="form-control datetimepicker-input"  data-target="#instanciaGenerica_dataCreacio" path="instanciaGenerica.dataCreacio" />
                    <c:if test="${!gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.DATACREACIO)}" >
                    <div class="input-group-append"  data-target="#instanciaGenerica_dataCreacio"  data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                    </c:if>
                </div>
            </div>
        <script type="text/javascript">
            $(function () {
                $('#instanciaGenerica_dataCreacio').datetimepicker({
                    format: '${gen:getJSDateTimePattern()}',
                    locale: '${lang}',
                    icons: {
                       time: 'far fa-clock'
                    }
                });
            });
        </script>           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.ESTAT)}">
        <tr id="instanciaGenerica_estat_rowid">
          <td id="instanciaGenerica_estat_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.ESTAT])?'instanciaGenerica.estat':__theForm.labels[InstanciaGenericaFields.ESTAT]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.ESTAT]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.ESTAT]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_estat_columnvalueid">
            <form:errors path="instanciaGenerica.estat" cssClass="errorField alert alert-danger" />
            <form:input readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.ESTAT)? 'true' : 'false'}" cssClass="w-25 form-control  ${gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.ESTAT)? ' uneditable-input' : ''}"  style=""  path="instanciaGenerica.estat"   />

           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.ERROR)}">
        <tr id="instanciaGenerica_error_rowid">
          <td id="instanciaGenerica_error_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.ERROR])?'instanciaGenerica.error':__theForm.labels[InstanciaGenericaFields.ERROR]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.ERROR]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.ERROR]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_error_columnvalueid">
              <form:errors path="instanciaGenerica.error" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.ERROR)? 'true' : 'false'}" path="instanciaGenerica.error"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_error" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_error" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('instanciaGenerica.error'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('instanciaGenerica.error'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('instanciaGenerica.error'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_error').on('click', function(){
					var valor = ($('#dropdownMenuContainer_error').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_error').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
        <c:if test="${!gen:contains(__theForm.hiddenFields,InstanciaGenericaFields.EXCEPTION)}">
        <tr id="instanciaGenerica_exception_rowid">
          <td id="instanciaGenerica_exception_columnlabelid">
            <label>
              <fmt:message key="${(empty __theForm.labels[InstanciaGenericaFields.EXCEPTION])?'instanciaGenerica.exception':__theForm.labels[InstanciaGenericaFields.EXCEPTION]}" />
             </label>
              <c:if test="${not empty __theForm.help[InstanciaGenericaFields.EXCEPTION]}">
              <i class="fas fa-info-circle" title="${__theForm.help[InstanciaGenericaFields.EXCEPTION]}" ></i>
              </c:if>
            </td>
          <td id="instanciaGenerica_exception_columnvalueid">
              <form:errors path="instanciaGenerica.exception" cssClass="errorField alert alert-danger" />
  <table style="width:100%">
  <tr>
  <td>
       <form:textarea rows="3" wrap="soft" style="overflow:auto;display: inline;resize:both;" cssClass="form-control col-md-9-optional" readonly="${ gen:contains(__theForm.readOnlyFields ,InstanciaGenericaFields.EXCEPTION)? 'true' : 'false'}" path="instanciaGenerica.exception"  />
   </td>
   <td style="width:40px">
      <div id="dropdownMenuButton_exception" style="vertical-align:top;display:inline;position:relative;">
        <button  class="btn btn-secondary btn-sm dropdown-toggle" type="button" style="margin-left:0px;"><span class="caret"></span></button>
        <div id="dropdownMenuContainer_exception" class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('instanciaGenerica.exception'); ta.wrap='off';" >No Wrap</a>
          <a class="dropdown-item"  href="#" onclick="javascript:var ta=document.getElementById('instanciaGenerica.exception'); ta.wrap='soft';">Soft Wrap</a>
          <a class="dropdown-item" href="#" onclick="javascript:var ta=document.getElementById('instanciaGenerica.exception'); ta.wrap='hard';">Hard Wrap</a>
        </div>
      </div>
      <script type="text/javascript">
			$('#dropdownMenuButton_exception').on('click', function(){
					var valor = ($('#dropdownMenuContainer_exception').css('display') != 'none') ? 'none' : 'block';
                 $('#dropdownMenuContainer_exception').css('display', valor);
                 return false;
				});
      </script>   </td>
   </tr>
   </table>
           </td>
        </tr>
        </c:if>
        
