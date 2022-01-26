<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
  
<div class="lead" style="margin-bottom:10px">
<label style="font-size: 1.25rem;font-weight: bold;">
 <c:choose>
  <c:when test="${fn:startsWith(instanciaGenericaForm.titleCode,'=')}">
       <c:out value="${fn:substringAfter(instanciaGenericaForm.titleCode, '=')}" escapeXml="false"/>
  </c:when>
  <c:when test="${not empty instanciaGenericaForm.titleCode}">
    <fmt:message key="${instanciaGenericaForm.titleCode}" >
      <fmt:param value="${instanciaGenericaForm.titleParam}" />
    </fmt:message>
  </c:when>
  <c:otherwise>
    <c:if test="${empty instanciaGenericaForm.entityNameCode}">
      <fmt:message var="entityname" key="instanciaGenerica.instanciaGenerica"/>
    </c:if>
    <c:if test="${not empty instanciaGenericaForm.entityNameCode}">
      <fmt:message var="entityname" key="${instanciaGenericaForm.entityNameCode}"/>
    </c:if>
    <c:set var="keytitle" value="${instanciaGenericaForm.nou?'genapp.createtitle':(instanciaGenericaForm.view?'genapp.viewtitle':'genapp.edittitle')}"/>
    <fmt:message key="${keytitle}">
      <fmt:param value="${entityname}"/>
    </fmt:message>
    </c:otherwise>
 </c:choose></label>
  <c:if test="${not empty instanciaGenericaForm.subTitleCode}">
<h6 style="line-height: 10px; margin-top: 0px; margin-bottom: 0px;font-style:italic;">
<c:set var="subtitleTranslated" value="${fn:startsWith(instanciaGenericaForm.subTitleCode,'=')}" />
<c:if test="${subtitleTranslated}">
   <c:out value="${fn:substringAfter(instanciaGenericaForm.subTitleCode, '=')}" escapeXml="false"/>
</c:if>
<c:if test="${not subtitleTranslated}">
  <fmt:message key="${instanciaGenericaForm.subTitleCode}" />
</c:if>
</h6>
  </c:if>
</div>