<%@ page contentType="text/html;charset=UTF-8" language="java"
%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>
  <h5>Menú LLISTATS</h5>
  <ul class="tree" style="margin: 3px; padding: 0px;">


<%--     <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/option1"/>">
        <span style="${(fn:contains(url, 'option1'))? "font-weight: bold;" : ""}">ADMIN: Option 1</span>
      </a>
    </li>
 --%>
   <%-- Example with security: virtual roles  --%>
   <%--
   <sec:authorize access="hasAnyRole('ROLE_SOLI', 'ROLE_DEST', 'ROLE_COLA', 'ROLE_DELE')">
      <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
      <li style="list-style-type: disc; list-style-position: inside;">
       <a href="<c:url value="/admin/rebreAvis/list/1"/>" >
       <span style="${(fn:contains(url, 'optionxxxxx/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
       Option XXXXX</span></a></li>
   </sec:authorize>
    --%>

    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/instanciagenerica/list"/>">
        <span style="${(fn:contains(url, 'instanciagenerica/list'))? "font-weight: bold;" : ""}">Llistar instancies</span>
      </a>
    </li>

    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/instanciagenericaproves/list"/>">
        <span style="${(fn:contains(url, 'instanciagenericaproves/list'))? "font-weight: bold;" : ""}">Proves Llistar instancies</span>
      </a>
    </li>

    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
    <li style="list-style-type: disc; list-style-position: inside;">
      <a href="<c:url value="/admin/instanciagenericaerrors/list"/>">
        <span style="${(fn:contains(url, 'instanciagenericaerrors/list'))? "font-weight: bold;" : ""}">Instancies no registrades</span>
      </a>
    </li>
   
  </ul>
</div>

