<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<un:useConstants var="InstanciaGenericaFields" className="org.fundaciobit.instanciagenerica.model.fields.InstanciaGenericaFields"/>



        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key < 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[instanciaGenerica.instanciaGenericaID]}" />
             </c:if>
             <c:if test="${not empty __entry.value.valueField }">
               <c:set var="__tmp" value="${pageScope}" />
               <c:set var="__trosos" value="${fn:split(__entry.value.valueField.fullName,'.')}" />
               <c:forEach var="__tros" items="${__trosos}">
                  <c:set var="__tmp" value="${__tmp[__tros]}" />
               </c:forEach>
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__tmp}" />
             </c:if>
          </td>
          </c:if>
          </c:forEach>


        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.INSTANCIAGENERICAID)}">
          <td>
          ${instanciaGenerica.instanciaGenericaID}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.NUMREGISTRE)}">
          <td>
          ${instanciaGenerica.numRegistre}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.UUID)}">
          <td>
          ${instanciaGenerica.uuid}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.DATACREACIO)}">
          <td> <fmt:formatDate pattern="${gen:getDateTimePattern()}" value="${instanciaGenerica.dataCreacio}" /></td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTTIPUSADMINID)}">
          <td>
          <c:set var="tmp">${instanciaGenerica.solicitantTipusAdminID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForSolicitantTipusAdminID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTADMINID)}">
          <td>
          ${instanciaGenerica.solicitantAdminID}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTPERSONAFISICA)}">
          <td>
          <c:set var="tmp">${instanciaGenerica.solicitantPersonaFisica}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfValuesForSolicitantPersonaFisica[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTNOM)}">
          <td>
          ${instanciaGenerica.solicitantNom}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTLLINATGE1)}">
          <td>
          ${instanciaGenerica.solicitantLlinatge1}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTLLINATGE2)}">
          <td>
          ${instanciaGenerica.solicitantLlinatge2}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTRAOSOCIAL)}">
          <td>
          ${instanciaGenerica.solicitantRaoSocial}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTDIRECCIO)}">
          <td>
          ${instanciaGenerica.solicitantDireccio}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTEMAIL)}">
          <td>
          ${instanciaGenerica.solicitantEmail}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITANTTELEFON)}">
          <td>
          ${instanciaGenerica.solicitantTelefon}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.TITOLID)}">
          <td>
          <c:set var="tmp">${instanciaGenerica.titolID}</c:set>
          <c:if test="${not empty tmp}">
          ${instanciaGenerica.titol.traduccions[lang].valor}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.IDIOMAID)}">
          <td>
          <c:set var="tmp">${instanciaGenerica.idiomaID}</c:set>
          <c:if test="${not empty tmp}">
          ${__theFilterForm.mapOfIdiomaForIdiomaID[tmp]}
          </c:if>
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.EXPOSA)}">
          <td>
          ${instanciaGenerica.exposa}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.SOLICITA)}">
          <td>
          ${instanciaGenerica.solicita}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER1ID)}">
          <td>
            <c:if test="${not empty instanciaGenerica.fitxer1}">
              <a target="_blank" href="<c:url value="${ige:fileUrl(instanciaGenerica.fitxer1)}"/>">${instanciaGenerica.fitxer1.nom}</a>
            </c:if>
           </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER2ID)}">
          <td>
            <c:if test="${not empty instanciaGenerica.fitxer2}">
              <a target="_blank" href="<c:url value="${ige:fileUrl(instanciaGenerica.fitxer2)}"/>">${instanciaGenerica.fitxer2.nom}</a>
            </c:if>
           </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER3ID)}">
          <td>
            <c:if test="${not empty instanciaGenerica.fitxer3}">
              <a target="_blank" href="<c:url value="${ige:fileUrl(instanciaGenerica.fitxer3)}"/>">${instanciaGenerica.fitxer3.nom}</a>
            </c:if>
           </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER4ID)}">
          <td>
            <c:if test="${not empty instanciaGenerica.fitxer4}">
              <a target="_blank" href="<c:url value="${ige:fileUrl(instanciaGenerica.fitxer4)}"/>">${instanciaGenerica.fitxer4.nom}</a>
            </c:if>
           </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER5ID)}">
          <td>
            <c:if test="${not empty instanciaGenerica.fitxer5}">
              <a target="_blank" href="<c:url value="${ige:fileUrl(instanciaGenerica.fitxer5)}"/>">${instanciaGenerica.fitxer5.nom}</a>
            </c:if>
           </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER6ID)}">
          <td>
            <c:if test="${not empty instanciaGenerica.fitxer6}">
              <a target="_blank" href="<c:url value="${ige:fileUrl(instanciaGenerica.fitxer6)}"/>">${instanciaGenerica.fitxer6.nom}</a>
            </c:if>
           </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER7ID)}">
          <td>
            <c:if test="${not empty instanciaGenerica.fitxer7}">
              <a target="_blank" href="<c:url value="${ige:fileUrl(instanciaGenerica.fitxer7)}"/>">${instanciaGenerica.fitxer7.nom}</a>
            </c:if>
           </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER8ID)}">
          <td>
            <c:if test="${not empty instanciaGenerica.fitxer8}">
              <a target="_blank" href="<c:url value="${ige:fileUrl(instanciaGenerica.fitxer8)}"/>">${instanciaGenerica.fitxer8.nom}</a>
            </c:if>
           </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.FITXER9ID)}">
          <td>
            <c:if test="${not empty instanciaGenerica.fitxer9}">
              <a target="_blank" href="<c:url value="${ige:fileUrl(instanciaGenerica.fitxer9)}"/>">${instanciaGenerica.fitxer9.nom}</a>
            </c:if>
           </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.ESTAT)}">
          <td>
          ${instanciaGenerica.estat}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.ERROR)}">
          <td>
          ${instanciaGenerica.error}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.EXCEPTION)}">
          <td>
          ${instanciaGenerica.exception}
          </td>
        </c:if>
        <c:if test="${!gen:contains(__theFilterForm.hiddenFields,InstanciaGenericaFields.DATAFINALITZACIO)}">
          <td> <fmt:formatDate pattern="${gen:getDateTimePattern()}" value="${instanciaGenerica.datafinalitzacio}" /></td>
        </c:if>


        <!--  /** Additional Fields */  -->
        <c:forEach var="__entry" items="${__theFilterForm.additionalFields}" >
        <c:if test="${ __entry.key >= 0  && ((empty __entry.value.searchBy)? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.searchBy)) && ((empty __entry.value.groupBy )? true : !gen:contains(__theFilterForm.hiddenFields, __entry.value.groupBy ))}">
          <td>
             <c:if test="${not empty __entry.value.valueMap }">
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__entry.value.valueMap[instanciaGenerica.instanciaGenericaID]}" />
             </c:if>
             <c:if test="${not empty __entry.value.valueField }">
               <c:set var="__tmp" value="${pageScope}" />
               <c:set var="__trosos" value="${fn:split(__entry.value.valueField.fullName,'.')}" />
               <c:forEach var="__tros" items="${__trosos}">
                  <c:set var="__tmp" value="${__tmp[__tros]}" />
               </c:forEach>
               <c:out escapeXml="${__entry.value.escapeXml}" value="${__tmp}" />
             </c:if>
          </td>
          </c:if>
          </c:forEach>


