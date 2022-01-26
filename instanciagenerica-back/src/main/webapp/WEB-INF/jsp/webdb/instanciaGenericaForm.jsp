
<%-- ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! --%>
<%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
 
  <%@include file="instanciaGenericaFormTitle.jsp" %>


<form:form modelAttribute="instanciaGenericaForm" method="${(empty method)?'post':method}"
  enctype="multipart/form-data">
  
  <c:set var="contexte" value="${instanciaGenericaForm.contexte}"/>
  <form:hidden path="nou" />
  
  <%@include file="instanciaGenericaFormCorePre.jsp" %>
  <%@include file="instanciaGenericaFormCore.jsp" %>

  <%@include file="instanciaGenericaFormCorePost.jsp" %>

  <%@include file="instanciaGenericaFormButtons.jsp" %>

  <c:if test="${instanciaGenericaForm.attachedAdditionalJspCode}">
     <%@include file="../webdbmodificable/instanciaGenericaFormModificable.jsp" %>
  </c:if>

</form:form>


