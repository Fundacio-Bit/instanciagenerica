<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<button>
		<a href="/instanciagenerica/admin/instanciagenericaproves/list/1">Atras</a>
	</button>

	<table id="mytable"
		class="tdformlabel table-sm table table-bordered table-striped marTop10 table-genapp">
		<tbody>
			<script type="text/javascript">
				var json = '{"datos":[{ "name": "ID", "value": "${ar.id}" },{ "name": "Código Entidad", "value": "${ar.entidadCodigo}" },{ "name": "Nombre entidad", "value": "${ar.entidadDenominacion}" },{ "name": "Código Entidad", "value": "${ar.entidadRegistralInicioCodigo}" },{ "name": "Nombre entidad registral Inicio", "value": "${ar.entidadRegistralInicioDenominacion}" },{ "name": "Código entidad registral Inicio", "value": "${ar.entidadRegistralOrigenCodigo}" },{ "name": "entidadRegistralOrigenDenominacion", "value": "${ar.entidadRegistralOrigenDenominacion}" },{ "name": "unidadTramitacionOrigenCódigo ", "value": "${ar.unidadTramitacionOrigenCodigo}" },{ "name": "unidadTramitacionOrigenDenominacion", "value": "${ar.unidadTramitacionOrigenDenominacion}" },{ "name": "entidadRegistralDestinoCódigo ", "value": "${ar.entidadRegistralDestinoCodigo}" },{ "name": "entidadRegistralDestinoDenominacion", "value": "${ar.entidadRegistralDestinoDenominacion}" },{ "name": "unidadTramitacionDestinoCódigo ", "value": "${ar.unidadTramitacionDestinoCodigo}" },{ "name": "unidadTramitacionDestinoDenominacion", "value": "${ar.unidadTramitacionDestinoDenominacion}" },{ "name": "Tipo de Registro ", "value": "${ar.tipoRegistro}" },{ "name": "Fecha Registro ", "value": "${ar.fechaRegistro}" },{ "name": "Número de Registro formteado", "value": "${ar.numeroRegistroFormateado}" },{ "name": "Número de Registro ", "value": "${ar.numeroRegistro}" },{ "name": "Código Libro", "value": "${ar.libroCodigo}" },{ "name": "tipoDocumentacionFisicaCódigo ", "value": "${ar.tipoDocumentacionFisicaCodigo}" },{ "name": "Código Asunto", "value": "${ar.codigoAsunto}" },{ "name": "Código AsuntoDenominacion", "value": "${ar.codigoAsuntoDenominacion}" },{ "name": "Idioma", "value": "${ar.idioma}" },{ "name": "InstanciaGenericaID", "value": "${ar.referenciaExterna}" },{ "name": "Número expediente", "value": "${ar.numeroExpediente}" },{ "name": "Tipo Transporte", "value": "${ar.tipoTransporte}" },{ "name": "Número Transporte", "value": "${ar.numeroTransporte}" },{ "name": "Código Sia", "value": "${ar.codigoSia}" },{ "name": "Código Usuario", "value": "${ar.codigoUsuario}" },{ "name": "aplicacionTelematica", "value": "${ar.aplicacionTelematica}" },{ "name": "Aplicacion", "value": "${ar.aplicacion}" },{ "name": "Version", "value": "${ar.version}" },{ "name": "Observaciones", "value": "${ar.observaciones}" },{ "name": "Expone", "value": "${ar.expone}" },{ "name": "Solicita", "value": "${ar.solicita}" },{ "name": "Presencial", "value": "${presencial}" },{ "name": "Estado", "value": "${ar.estado}" },{ "name": "identificadorIntercambio", "value": "${ar.identificadorIntercambio}" },{ "name": "tipoEnvioDocumentacion", "value": "${ar.tipoEnvioDocumentacion}" },{ "name": "Fecha Recepcion", "value": "${ar.fechaRecepcion}" },{ "name": "Código Error", "value": "${ar.codigoError}" },{ "name": "Descripción Error", "value": "${ar.descripcionError}" },{ "name": "Número Registro Destino", "value": "${ar.numeroRegistroDestino}" },{ "name": "Fecha Registro Destino", "value": "${ar.fechaRegistroDestino}" },{ "name": "Motivo", "value": "${ar.motivo}" }]}';
				json = JSON.parse(json);

				var atributs = json.datos;

				console.log(atributs[1]);
				var html = "<tr><th>Name</th><th>Value</th></tr>";

				for (var i = 0; i < atributs.length; i++) {
					var valor = atributs[i].value;
					html += "<tr><td>" + atributs[i].name + "</td><td>" + valor
							+ "</td></tr>";
					if (valor != "") {
					}

				}
				$("tbody").prepend(html);
			</script>



			<tr>
				<td>Interesados</td>
				<td>
					<table border=1>
						<tr>
							<th>Nombre</th>
							<th>Apellio 1</th>
							<th>Apellio 2</th>
						</tr>

						<c:forEach var="item" items="${ar.interesados}">
							<c:set var="interesado" value="${item.interesado}" />
							<tr>
								<td>${interesado.nombre}</td>
								<td>${interesado.apellido1}</td>
								<td>${interesado.apellido2}</td>
							</tr>
						</c:forEach>

					</table>
				</td>
			</tr>
			<tr>
				<td>Anexos</td>
				<td>
					<table border=1>
						<tr>
							<th>Name</th>
							<th>Size</th>
							<th></th>
						</tr>

						<c:forEach var="anexo" items="${as.anexos}">
							<tr>
								<td>${anexo.name}</td>
								<td>${anexo.size}KB</td>
								<td><a
									href="<c:url value="${contexte}/descarregarFitxer/${ige:encriptar(anexo.fileID)}"/>"><fmt:message
											key="descargar" /></a></td>

							</tr>
						</c:forEach>

					</table>
				</td>
			</tr>
		</tbody>
	</table>

</body>
</html>