<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="InstanciaGenericaFields" className="org.fundaciobit.instanciagenerica.model.fields.InstanciaGenericaFields"/>

  <%-- HIDDEN PARAMS: FILTER BY --%> 
  <form:hidden path="visibleFilterBy"/>

  <%-- FILTRAR PER - INICI --%>
  
  <c:set var="displayFilterDiv" value="${__theFilterForm.visibleFilterBy?'':'display:none;'}" />  
  
  <div id="FilterDiv" class="wellgroupfilter formbox" style="${displayFilterDiv} margin-bottom:3px; margin-left: 1px; padding:3px;">

      <div class="page-header">
        <fmt:message key="genapp.form.filterby"/>
        
        <div class="float-right">

           <a class="float-right" style="margin-left:10px" href="#"> <i title="<fmt:message key="genapp.form.hidefilter"/>" onclick="document.getElementById('FilterDiv').style.display='none'; document.getElementById('FilterButton').style.display='inline';" class="far fa-window-close"></i></a>
           <input style="margin-left: 3px" class="btn btn-sm btn-warning float-right" type="button" onclick="clear_form_elements(this.form)" value="<fmt:message key="genapp.form.clean"/>"/>
           <input style="margin-left: 3px" class="btn btn-sm btn-warning float-right" type="reset" value="<fmt:message key="genapp.form.reset"/>"/>
           <input style="margin-left: 3px" class="btn btn-sm btn-primary float-right" type="submit" value="<fmt:message key="genapp.form.search"/>"/>

        </div>
      </div>
      <div class="form-inline">
      
      <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
      <c:if test="${ __entry.key < 0 && not empty __entry.value.searchBy }">
      <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
        <span class="add-on"><fmt:message key="${__entry.value.codeName}" />:</span>
        <fmt:message key="genapp.form.searchby" var="cercaperAF" >
          <fmt:param>
            <fmt:message key="${__entry.value.codeName}" />
          </fmt:param>
        </fmt:message>
        <c:choose>
          <c:when test="${gen:isFieldSearchInRange(__entry.value.searchBy)}">
            <span class="add-on"><fmt:message key="genapp.from" /></span>
            <input id="${__entry.value.searchBy.fullName}" name="${__entry.value.searchBy.fullName}" class="input-small input-medium" type="text" value="${__entry.value.searchByValue}"/>
            <span class="add-on"><fmt:message key="genapp.to" /></span>
            <input id="${__entry.value.searchBy.fullName}Fins" name="${__entry.value.searchBy.fullName}Fins" class="input-small input-medium search-query" type="text" value="${__entry.value.searchByValueFins}"/>
          </c:when>
          <c:otherwise>
            <input id="${__entry.value.searchBy.fullName}" name="${__entry.value.searchBy.fullName}" class="search-query input-medium" placeholder="${cercaperAF}" type="text" value="${__entry.value.searchByValue}"/>
          </c:otherwise>
        </c:choose>
      </div>
      </c:if>
      </c:forEach>


        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.INSTANCIAGENERICAID)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="instanciaGenerica.instanciaGenericaID" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="instanciaGenericaIDDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="instanciaGenericaIDFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.NUMREGISTRE)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="instanciaGenerica.numRegistre" var="numRegistre" />
              <fmt:message key="genapp.form.searchby" var="cercapernumRegistre" >                
                 <fmt:param value="${numRegistre}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${numRegistre}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapernumRegistre}" path="numRegistre" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.UUID)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="instanciaGenerica.uuid" var="uuid" />
              <fmt:message key="genapp.form.searchby" var="cercaperuuid" >                
                 <fmt:param value="${uuid}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${uuid}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperuuid}" path="uuid" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.DATACREACIO)}">
            <%-- FILTRE DATE --%>
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="instanciaGenerica.dataCreacio" />:</span>
              <span class="add-on"><fmt:message key="genapp.from" /></span>
              <div id="dataCreacioDesde" class="input-append">
                <form:input cssClass="input-large" path="dataCreacioDesde" />
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#dataCreacioDesde').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
              <span class="add-on"><fmt:message key="genapp.to" /></span>              
              <div id="dataCreacioFins" class="input-append">
                <form:input cssClass="input-large" path="dataCreacioFins" />
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#dataCreacioFins').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
            </div>

    
        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.SOLICITANTTIPUSADMINID)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="instanciaGenerica.solicitantTipusAdminID" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="solicitantTipusAdminIDDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="solicitantTipusAdminIDFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.SOLICITANTADMINID)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="instanciaGenerica.solicitantAdminID" var="solicitantAdminID" />
              <fmt:message key="genapp.form.searchby" var="cercapersolicitantAdminID" >                
                 <fmt:param value="${solicitantAdminID}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${solicitantAdminID}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapersolicitantAdminID}" path="solicitantAdminID" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.SOLICITANTPERSONAFISICA)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="instanciaGenerica.solicitantPersonaFisica" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="solicitantPersonaFisicaDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="solicitantPersonaFisicaFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.SOLICITANTNOM)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="instanciaGenerica.solicitantNom" var="solicitantNom" />
              <fmt:message key="genapp.form.searchby" var="cercapersolicitantNom" >                
                 <fmt:param value="${solicitantNom}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${solicitantNom}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapersolicitantNom}" path="solicitantNom" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.SOLICITANTLLINATGE1)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="instanciaGenerica.solicitantLlinatge1" var="solicitantLlinatge1" />
              <fmt:message key="genapp.form.searchby" var="cercapersolicitantLlinatge1" >                
                 <fmt:param value="${solicitantLlinatge1}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${solicitantLlinatge1}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapersolicitantLlinatge1}" path="solicitantLlinatge1" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.SOLICITANTLLINATGE2)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="instanciaGenerica.solicitantLlinatge2" var="solicitantLlinatge2" />
              <fmt:message key="genapp.form.searchby" var="cercapersolicitantLlinatge2" >                
                 <fmt:param value="${solicitantLlinatge2}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${solicitantLlinatge2}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapersolicitantLlinatge2}" path="solicitantLlinatge2" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.SOLICITANTCIF)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="instanciaGenerica.solicitantCif" var="solicitantCif" />
              <fmt:message key="genapp.form.searchby" var="cercapersolicitantCif" >                
                 <fmt:param value="${solicitantCif}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${solicitantCif}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapersolicitantCif}" path="solicitantCif" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.SOLICITANTRAOSOCIAL)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="instanciaGenerica.solicitantRaoSocial" var="solicitantRaoSocial" />
              <fmt:message key="genapp.form.searchby" var="cercapersolicitantRaoSocial" >                
                 <fmt:param value="${solicitantRaoSocial}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${solicitantRaoSocial}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapersolicitantRaoSocial}" path="solicitantRaoSocial" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.SOLICITANTDIRECCIO)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="instanciaGenerica.solicitantDireccio" var="solicitantDireccio" />
              <fmt:message key="genapp.form.searchby" var="cercapersolicitantDireccio" >                
                 <fmt:param value="${solicitantDireccio}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${solicitantDireccio}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapersolicitantDireccio}" path="solicitantDireccio" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.SOLICITANTEMAIL)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="instanciaGenerica.solicitantEmail" var="solicitantEmail" />
              <fmt:message key="genapp.form.searchby" var="cercapersolicitantEmail" >                
                 <fmt:param value="${solicitantEmail}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${solicitantEmail}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapersolicitantEmail}" path="solicitantEmail" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.SOLICITANTTELEFON)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="instanciaGenerica.solicitantTelefon" var="solicitantTelefon" />
              <fmt:message key="genapp.form.searchby" var="cercapersolicitantTelefon" >                
                 <fmt:param value="${solicitantTelefon}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${solicitantTelefon}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapersolicitantTelefon}" path="solicitantTelefon" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.IDIOMAID)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="instanciaGenerica.idiomaID" var="idiomaID" />
              <fmt:message key="genapp.form.searchby" var="cercaperidiomaID" >                
                 <fmt:param value="${idiomaID}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${idiomaID}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperidiomaID}" path="idiomaID" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.EXPOSA)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="instanciaGenerica.exposa" var="exposa" />
              <fmt:message key="genapp.form.searchby" var="cercaperexposa" >                
                 <fmt:param value="${exposa}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${exposa}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperexposa}" path="exposa" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.SOLICITA)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="instanciaGenerica.solicita" var="solicita" />
              <fmt:message key="genapp.form.searchby" var="cercapersolicita" >                
                 <fmt:param value="${solicita}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${solicita}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapersolicita}" path="solicita" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.ESTAT)}">
            <%-- FILTRE NUMERO --%>      
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="instanciaGenerica.estat" />:</span>

              <span class="add-on"><fmt:message key="genapp.from" /></span>
              
              <form:input cssClass="input-append input-small" path="estatDesde" />


              <span class="add-on"><fmt:message key="genapp.to" /></span>

              <form:input cssClass="input-append input-small search-query" path="estatFins" />

            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.ERROR)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="instanciaGenerica.error" var="error" />
              <fmt:message key="genapp.form.searchby" var="cercapererror" >                
                 <fmt:param value="${error}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${error}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercapererror}" path="error" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.EXCEPTION)}">
            <%-- FILTRE STRING --%>
            <div class="input-prepend" style="padding-right: 4px;padding-bottom: 4px;">
              <fmt:message key="instanciaGenerica.exception" var="exception" />
              <fmt:message key="genapp.form.searchby" var="cercaperexception" >                
                 <fmt:param value="${exception}"/>
              </fmt:message>
              <span class="add-on"><c:out value="${exception}" />:</span>
              <form:input cssClass="search-query input-medium" placeholder="${cercaperexception}" path="exception" />
            </div>


        </c:if>
        <c:if test="${gen:contains(__theFilterForm.filterByFields ,InstanciaGenericaFields.DATAFINALITZACIO)}">
            <%-- FILTRE DATE --%>
            <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
              <span class="add-on"><fmt:message key="instanciaGenerica.datafinalitzacio" />:</span>
              <span class="add-on"><fmt:message key="genapp.from" /></span>
              <div id="datafinalitzacioDesde" class="input-append">
                <form:input cssClass="input-large" path="datafinalitzacioDesde" />
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#datafinalitzacioDesde').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
              <span class="add-on"><fmt:message key="genapp.to" /></span>              
              <div id="datafinalitzacioFins" class="input-append">
                <form:input cssClass="input-large" path="datafinalitzacioFins" />
                <span class="add-on">
                  <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                  </i>
                </span>
              </div>
              <script type="text/javascript">                
                $(function() {
                  $('#datafinalitzacioFins').datetimepicker({
                    language: '${lang}',
                    pick12HourFormat: <c:out value="${fn:contains(gen:getDateTimePattern(), 'a')?'true' : 'false'}"/>,
                    format:  '${gen:getJSDateTimePattern()}',
                    pickTime: true,
                    weekStart: ${gen:getFirstDayOfTheWeek()}
                  });
                });
              </script>
            </div>

    
        </c:if>

      <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
      <c:if test="${ __entry.key >= 0 && not empty __entry.value.searchBy }">
      <div class="input-group" style="padding-right: 4px;padding-bottom: 4px;">
        <span class="add-on"><fmt:message key="${__entry.value.codeName}" />:</span>
        <fmt:message key="genapp.form.searchby" var="cercaperAF" >
          <fmt:param>
            <fmt:message key="${__entry.value.codeName}" />
          </fmt:param>
        </fmt:message>
        <c:choose>
          <c:when test="${gen:isFieldSearchInRange(__entry.value.searchBy)}">
            <span class="add-on"><fmt:message key="genapp.from" /></span>
            <input id="${__entry.value.searchBy.fullName}" name="${__entry.value.searchBy.fullName}" class="input-small input-medium" type="text" value="${__entry.value.searchByValue}"/>
            <span class="add-on"><fmt:message key="genapp.to" /></span>
            <input id="${__entry.value.searchBy.fullName}Fins" name="${__entry.value.searchBy.fullName}Fins" class="input-small input-medium search-query" type="text" value="${__entry.value.searchByValueFins}"/>
          </c:when>
          <c:otherwise>
            <input id="${__entry.value.searchBy.fullName}" name="${__entry.value.searchBy.fullName}" class="search-query input-medium" placeholder="${cercaperAF}" type="text" value="${__entry.value.searchByValue}"/>
          </c:otherwise>
        </c:choose>
      </div>
      </c:if>
      </c:forEach>
      </div>
    </div>



    <%-- FILTRAR PER - FINAL --%>
  
