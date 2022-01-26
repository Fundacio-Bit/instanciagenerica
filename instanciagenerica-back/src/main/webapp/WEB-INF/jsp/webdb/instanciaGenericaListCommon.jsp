<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>

  <c:set var="contexte" value="${instanciaGenericaFilterForm.contexte}"/>
  <c:set var="formName" value="instanciaGenerica" />
  <c:set var="__theFilterForm" value="${instanciaGenericaFilterForm}" />
  <c:if test="${empty instanciaGenericaFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="instanciaGenerica.instanciaGenerica"/>
  </c:if>
  <c:if test="${not empty instanciaGenericaFilterForm.entityNameCode}">
    <fmt:message var="entityname" key="${instanciaGenericaFilterForm.entityNameCode}"/>
  </c:if>
  <c:if test="${empty instanciaGenericaFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="instanciaGenerica.instanciaGenerica"/>
  </c:if>
  <c:if test="${not empty instanciaGenericaFilterForm.entityNameCodePlural}">
    <fmt:message var="entitynameplural" key="${instanciaGenericaFilterForm.entityNameCodePlural}"/>
  </c:if>
  <%-- HIDDEN PARAMS: ORDER BY --%> 
  <form:hidden id="orderBy" path="orderBy"/> 
  <form:hidden id="orderAsc" path="orderAsc"/>

  <form:hidden path="nou" value="false"/>

<script type="text/javascript">
  function executeOrderBy(orderBy, orderType) {
    document.getElementById('orderBy').value = orderBy;
    document.getElementById('orderAsc').value = orderType;
    document.instanciaGenerica.submit();  
  }
</script>
