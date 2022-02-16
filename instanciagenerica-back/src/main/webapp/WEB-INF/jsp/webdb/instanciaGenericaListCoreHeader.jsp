<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="InstanciaGenericaFields" className="org.fundaciobit.instanciagenerica.model.fields.InstanciaGenericaFields"/>
  


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key < 0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${ige:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.INSTANCIAGENERICAID)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.INSTANCIAGENERICAID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.NUMREGISTRE)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.NUMREGISTRE)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.UUID)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.UUID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTPERSONAFISICA)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.SOLICITANTPERSONAFISICA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTTIPUSADMINID)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.SOLICITANTTIPUSADMINID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTADMINID)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.SOLICITANTADMINID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTNOM)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.SOLICITANTNOM)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTLLINATGE1)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.SOLICITANTLLINATGE1)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTLLINATGE2)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.SOLICITANTLLINATGE2)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTCIF)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.SOLICITANTCIF)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTRAOSOCIAL)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.SOLICITANTRAOSOCIAL)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTDIRECCIO)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.SOLICITANTDIRECCIO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTEMAIL)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.SOLICITANTEMAIL)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTTELEFON)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.SOLICITANTTELEFON)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.IDIOMAID)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.IDIOMAID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.EXPOSA)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.EXPOSA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITA)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.SOLICITA)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER1ID)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.FITXER1ID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER2ID)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.FITXER2ID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER3ID)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.FITXER3ID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER4ID)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.FITXER4ID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER5ID)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.FITXER5ID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER6ID)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.FITXER6ID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER7ID)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.FITXER7ID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER8ID)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.FITXER8ID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER9ID)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.FITXER9ID)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.DATACREACIO)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.DATACREACIO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.DATAFINALITZACIO)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.DATAFINALITZACIO)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.ESTAT)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.ESTAT)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.ERROR)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.ERROR)}</th>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.EXCEPTION)}">
        <th>${ige:getSortIcons(__theFilterForm,InstanciaGenericaFields.EXCEPTION)}</th>
        </c:if>


        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}">
        <c:if test="${ __entry.key >=0 && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
        <th>
        ${ige:getSortIconsAdditionalField(__theFilterForm,__entry.value)}
        </th>
        </c:if>
        </c:forEach>

