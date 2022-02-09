<%@page import="org.springframework.security.core.Authentication"%><%@page
	import="org.springframework.context.i18n.LocaleContextHolder"%><%@page
	import="org.springframework.security.core.context.SecurityContext"%><%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%><%@ page
	language="java"%><%@ include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<div class="clear"></div>
<div class="spacer"></div>

<div>
	<br />
	<center>
		<img src="<c:url value="/img/app-logo.png"/>" width="60px"
			height="60px" alt="InstanciaGenerica" title="InstanciaGenerica" /> <br />
		<br /> This page is generated automatically. Please edit. <br /> <br />
		<table border="0">
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td valign="top"><a
					href="http://blog.fundaciobit.org/category/admindigital/"
					target="_blank"> <img
						src="<c:url value="/img/fundaciobit.png"/>" alt="Fundaci� Bit"
						title="Fundaci� Bit" />
				</a></td>
			</tr>
		</table>
		<br />
	</center>

</div>

<br />
<%-- --%>
<br />

<c:if test="${ige:isDesenvolupament()}">
	Only in Development Mode
	<br>

	Username: ${loginInfo.username}<br />
	&#36;{ige:hasRole(ROLE_ADMIN)}= ${ige:hasRole('ROLE_ADMIN')}<br />
	&#36;{ige:hasRole(ROLE_USER) }= ${ige:hasRole('ROLE_USER') }<br />
	Locale = <%=LocaleContextHolder.getLocale()%>
	<br>

	lang = ${lang} <br />



</c:if>
