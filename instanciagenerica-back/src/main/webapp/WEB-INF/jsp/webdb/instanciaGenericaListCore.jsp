  <c:if test="${empty instanciaGenericaItems}">
     <%@include file="instanciaGenericaListEmpty.jsp" %>

  </c:if>
  
  <c:if test="${not empty instanciaGenericaItems}">

  <div class="row" style="margin-left: 0px;">
  <table class="table table-sm table-bordered table-striped table-genapp" style="width:auto;"> 
    <thead>
      <tr>

          <%@include file="instanciaGenericaListCoreHeaderMultipleSelect.jsp" %>

          <%@include file="instanciaGenericaListCoreHeader.jsp" %>

          <%-- ADD HERE NEW COLUMNS HEADER  --%>

          <%@include file="instanciaGenericaListButtonsHeader.jsp" %>

      </tr>
    </thead>
    <tbody>

      <c:forEach var="instanciaGenerica" items="${instanciaGenericaItems}">

        <tr id="instanciaGenerica_rowid_${instanciaGenerica.instanciaGenericaID}">
          <%@include file="instanciaGenericaListCoreMultipleSelect.jsp" %>

          <%@include file="instanciaGenericaListCoreContent.jsp" %>

          <%--  ADD HERE NEW COLUMNS CONTENT --%>


          <%@include file="instanciaGenericaListButtons.jsp" %>


        </tr>

      </c:forEach>

    </tbody>
  </table>
  </div>
  </c:if>
  
