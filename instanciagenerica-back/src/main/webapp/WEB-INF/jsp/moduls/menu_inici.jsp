<%@ page contentType="text/html;charset=UTF-8" language="java"%><%@ include
	file="/WEB-INF/jsp/moduls/includes.jsp"%>
<c:set var="url" value="${urlActual}" />
<div>
	<h5>
		<fmt:message key="menuinici" />
	</h5>
	<ul class="tree" style="margin: 3px; padding: 0px;">



<%-- 		<c:if test="${empty loginInfo}">
			<li style="list-style-type: disc; list-style-position: inside;">
				<a href="<c:url value="/index.jsp"/>"> <span
					style="${(fn:contains(url, 'principal'))? "font-weight:bold;" : ""}">
						PUBLIC: Start page</span>
			</a>
			</li>
		</c:if>

		<c:if test="${not empty loginInfo}">
			<li style="list-style-type: disc; list-style-position: inside;">
				<a href="<c:url value="/index.jsp"/>"> <span
					style="${(fn:contains(url, 'principal'))? "font-weight:bold;" : ""}">
						COMMON: Start page</span>
			</a>
			</li>
 --%>
			<%-- 	    <hr  style="margin-top: 6px;  margin-bottom: 6px;" />
	    <li style="list-style-type: disc; list-style-position: inside;">
	      <a href="<c:url value="/common/option1"/>">
	        <span style="${(fn:contains(url, 'option1'))? "font-weight: bold;" : ""}">COMMON: Option 1</span>
	      </a>
	    </li>
 --%>

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
			<a href="<c:url value="/public/instanciagenerica/new"/>"> <span
				style="${(fn:contains(url, 'instanciagenerica/new'))? "font-weight:bold;" : ""}">
					Afegir instancia</span>
		</a>
		</li>

	</ul>
</div>

