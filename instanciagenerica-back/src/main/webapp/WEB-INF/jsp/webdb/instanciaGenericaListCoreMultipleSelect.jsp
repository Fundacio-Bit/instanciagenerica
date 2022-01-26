      <%--  CHECK DE SELECCIO MULTIPLE  --%>
      <c:if test="${__theFilterForm.visibleMultipleSelection}">
      <td>
       <form:checkbox path="selectedItems" value="${instanciaGenerica.instanciaGenericaID}"/>
       &nbsp;
      </td>
      </c:if>

