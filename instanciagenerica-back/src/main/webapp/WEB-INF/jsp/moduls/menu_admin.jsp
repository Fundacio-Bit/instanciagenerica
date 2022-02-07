<%@ page contentType="text/html;charset=UTF-8" language="java"%><%@ include
	file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>
	<h5>
		<fmt:message key="menuadmin" />
	</h5>
	<ul class="tree" style="margin: 3px; padding: 0px;">

			<%-- Example with security: virtual roles  --%>
			<%--
   <sec:authorize access="hasAnyRole('ROLE_SOLI', 'ROLE_DEST', 'ROLE_COLA', 'ROLE_DELE')">
      <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
      <li style="list-style-type: disc; list-style-position: inside;">
       <a href="<c:url value="/common/rebreAvis/list/1"/>" >
       <span style="${(fn:contains(url, 'optionxxxxx/') && fn:contains(url, '/list'))? "font-weight: bold;" : ""}" >
       Option XXXXX</span></a></li>
   </sec:authorize>
		</c:if>
--%>

		<hr style="margin-top: 6px; margin-bottom: 6px;" />
		<li style="list-style-type: disc; list-style-position: inside;">
			<a href="<c:url value="/admin/instanciagenerica/list"/>"> <span
				style="${(fn:contains(url, 'admin/instanciagenerica/list'))? "font-weight:bold;" : ""}">
					Llistar instancies</span>
		</a>
		</li>

		<hr style="margin-top: 6px; margin-bottom: 6px;" />
		<li style="list-style-type: disc; list-style-position: inside;">
			<a href="<c:url value="/admin/instanciagenericaproves/list"/>"> <span
				style="${(fn:contains(url, 'admin/instanciagenericaproves/list'))? "font-weight:bold;" : ""}">
					Proves Llistar instancies</span>
		</a>
		</li>

		<hr style="margin-top: 6px; margin-bottom: 6px;" />
		<li style="list-style-type: disc; list-style-position: inside;">
			<a href="<c:url value="/admin/instanciagenericaerrors/list"/>"> <span
				style="${(fn:contains(url, 'admin/instanciagenericaerrors/list'))? "font-weight:bold;" : ""}">
					Instancies amb errors</span>
		</a>
		</li>

	</ul>
</div>

