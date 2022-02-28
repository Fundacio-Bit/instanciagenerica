<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/jsp/moduls/includes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Lato'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<button id="back-buton" class="boton btn-3 btn-sep icon">
		<fmt:message key="atras" />
	</button>

	<style>
/* General button style */
.boton {
	border: none;
	font-family: 'Lato';
	font-size: inherit;
	color: inherit;
	background: none;
	cursor: pointer;
	/* 	padding: 25px 80px;
 */
	display: inline-block;
	margin-top: 1rem;
	text-transform: uppercase;
	letter-spacing: 1px;
	font-weight: 700;
	outline: none;
	position: relative;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
}

.boton:after {
	content: '';
	position: absolute;
	z-index: -1;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
}

/* Pseudo elements for icons */
.boton:before {
	font-family: 'FontAwesome';
	speak: none;
	font-style: normal;
	font-weight: normal;
	font-variant: normal;
	text-transform: none;
	line-height: 1;
	position: relative;
	-webkit-font-smoothing: antialiased;
}

/* Icon separator */
.btn-sep {
	/* 	padding: 25px 60px 25px 120px;
 */
	padding: 0.5rem 1rem 0.5rem 2.5rem;
}

.btn-sep:before {
	background: rgba(0, 0, 0, 0.15);
}

/* Button 3 */
.btn-3 {
	background: #3498db;
	color: #fff;
}

.btn-3:hover {
	background: #2980b9;
}

.btn-3:before {
	height: 100%;
	left: 0;
	line-height: 2;
	font-size: 130%;
	width: 2rem;
	margin: 0;
	position: absolute;
	top: 50%;
	-ms-transform: translateY(-50%);
	transform: translateY(-50%);
}

.icon:before {
	content: "\f100";
}
</style>
	<table id="mytable"
		class="tdformlabel table-sm table table-bordered table-striped marTop10 table-genapp">
		<tbody>
		</tbody>
	</table>

	<script type="text/javascript">

		document.getElementById("back-buton").onclick = function() {
//			window.location.pathname = "${pathname}";
			window.location.pathname="<%=request.getContextPath()%>
		${contexte}/v/${uuid}";
		};

		var secciones = [ {
			title : "Seccion 0",
			elems : [],
			id : "0"
		}, {
			title : "Oficinas y unidades",
			elems : [],
			id : "1"
		}, {
			title : "Datos de registro",
			elems : [],
			id : "2"
		}, {
			title : "Datos de la instancia",
			elems : [],
			id : "3"
		}, {
			title : "Otros datos",
			elems : [],
			id : "4"
		}, {
			title : "Otros datos 2",
			elems : [],
			id : "5"
		} ];

		/* 		var secciones = [
		 {name:"Seccion 0", elems:[]},
		 {name:"Seccion 1", elems:[]},
		 {name:"Seccion 2", elems:[]},
		 {name:"Seccion 3", elems:[]},
		 {name:"Seccion 4", elems:[]},
		 {name:"Seccion 5", elems:[]}
		 ];
		 */

		var json = '{"datos":[{ "title": "ID", "name": "id", "value": "${ar.id}" , "sec": 0},{ "title": "Entidad", "name": "entidadCodigo", "value": "${ar.entidadDenominacion} - ${ar.entidadCodigo}" , "sec": 1},{ "title": "Entidad registral (Oficina) Inicio", "name": "entidadRegistralInicioCodigo", "value": "${ar.entidadRegistralInicioDenominacion} - ${ar.entidadRegistralInicioCodigo}" , "sec": 1},{ "title": "Entidad registral (Oficina) Origen", "name": "entidadRegistralOrigenCodigo", "value": "${ar.entidadRegistralOrigenDenominacion} - ${ar.entidadRegistralOrigenCodigo}" , "sec": 1},{ "title": "Entidad Registral (Oficina) Destino", "name": "entidadRegistralDestinoCodigo", "value": "${ar.entidadRegistralDestinoDenominacion} - ${ar.entidadRegistralDestinoCodigo}" , "sec": 1},{ "title": "Unidad Tramitacion Origen", "name": "unidadTramitacionOrigenCodigo", "value": "${ar.unidadTramitacionOrigenDenominacion} - ${ar.unidadTramitacionOrigenCodigo}" , "sec": 1},{ "title": "Unidad Tramitacion Destino", "name": "unidadTramitacionDestinoCodigo", "value": "${ar.unidadTramitacionDestinoDenominacion} - ${ar.unidadTramitacionDestinoCodigo}" , "sec": 1},{ "title": "Tipo de Registro ", "name": "tipoRegistro", "value": "${ar.tipoRegistro}" , "sec": 2},{ "title": "Fecha Registro ", "name": "fechaRegistro", "value": "${ar.fechaRegistro}" , "sec": 2},{ "title": "Número de Registro formteado", "name": "numeroRegistroFormateado", "value": "${ar.numeroRegistroFormateado}" , "sec": 2},{ "title": "Número de Registro ", "name": "numeroRegistro", "value": "${ar.numeroRegistro}" , "sec": 2},{ "title": "Código Libro", "name": "libroCodigo", "value": "${ar.libroCodigo}" , "sec": 2},{ "title": "Resumen", "name": "resumen", "value": "${ar.resumen}" , "sec": 2},{ "title": "Tipo Documentacion Fisica", "name": "tipoDocumentacionFisicaCodigo", "value": "${ar.tipoDocumentacionFisicaCodigo}" , "sec": 2},{ "title": "Código Asunto", "name": "codigoAsunto", "value": "${ar.codigoAsunto}" , "sec": 3},{ "title": "Código Asunto Denominacion", "name": "codigoAsuntoDenominacion", "value": "${ar.codigoAsuntoDenominacion}" , "sec": 3},{ "title": "Idioma", "name": "idioma", "value": "${ar.idioma}" , "sec": 3},{ "title": "InstanciaGenericaID", "name": "referenciaExterna", "value": "${ar.referenciaExterna}" , "sec": 3},{ "title": "Número expediente", "name": "numeroExpediente", "value": "${ar.numeroExpediente}" , "sec": 3},{ "title": "Tipo Transporte", "name": "tipoTransporte", "value": "${ar.tipoTransporte}" , "sec": 3},{ "title": "Número Transporte", "name": "numeroTransporte", "value": "${ar.numeroTransporte}" , "sec": 3},{ "title": "Código Sia", "name": "codigoSia", "value": "${ar.codigoSia}" , "sec": 4},{ "title": "Código Usuario", "name": "codigoUsuario", "value": "${ar.codigoUsuario}" , "sec": 4},{ "title": "Aplicación Telematica", "name": "aplicacionTelematica", "value": "${ar.aplicacionTelematica}" , "sec": 4},{ "title": "Aplicacion", "name": "aplicacion", "value": "${ar.aplicacion}" , "sec": 4},{ "title": "Version", "name": "version", "value": "${ar.version}" , "sec": 4},{ "title": "Observaciones", "name": "observaciones", "value": "${ar.observaciones}" , "sec": 4},{ "title": "Expone", "name": "expone", "value": "${ar.expone}" , "sec": 3},{ "title": "Solicita", "name": "solicita", "value": "${ar.solicita}" , "sec": 3},{ "title": "Presencial", "name": "presencial", "value": "${presencial}" , "sec": 3},{ "title": "Estado", "name": "estado", "value": "${ar.estado}" , "sec": 4},{ "title": "Identificador Intercambio", "name": "identificadorIntercambio", "value": "${ar.identificadorIntercambio}" , "sec": 5},{ "title": "Tipo Envio Documentacion", "name": "tipoEnvioDocumentacion", "value": "${ar.tipoEnvioDocumentacion}" , "sec": 5},{ "title": "Fecha Recepcion", "name": "fechaRecepcion", "value": "${ar.fechaRecepcion}" , "sec": 5},{ "title": "Código Error", "name": "codigoError", "value": "${ar.codigoError}" , "sec": 5},{ "title": "Descripción Error", "name": "descripcionError", "value": "${ar.descripcionError}" , "sec": 5},{ "title": "Número Registro Destino", "name": "numeroRegistroDestino", "value": "${ar.numeroRegistroDestino}" , "sec": 5},{ "title": "Fecha Registro Destino", "name": "fechaRegistroDestino", "value": "${ar.fechaRegistroDestino}" , "sec": 5},{ "title": "Motivo", "name": "motivo", "value": "${ar.motivo}" , "sec": 5}]}';
		json = JSON.parse(json);
		var atributs = json.datos;

		//Construir la tabla principal
		var html = "";
		for (var i = 0; i < atributs.length; i++) {
			var id = atributs[i].name;
			var valor = atributs[i].value;

			var mostrarTodo = true;
			if (valor == "") {
				valor = "-";
			}
			html += "<tr id='id_" + id + "'>";
			html += "<td class='item' id='"+ id + "_label'>"
					+ atributs[i].title + "</td>";
			html += "<td class='item' id='"+ id + "_value'>" + valor + "</td>";
			html += "</tr>";

			//Incluir cada campo en su seccion
			secciones[atributs[i].sec].elems.push(id);
		}

		$("#mytable").prepend(html);
		$(".item").css("width", "20rem");

		splitTable(secciones, "h4", "id_XXXXX");

		function splitTable(secciones, tag, rowformat) {

			console.log(secciones);
			for (var j = 0; j < secciones.length; j++) {

				var seccion = secciones[j];
				console.log(seccion);
				var rows = seccion.elems;

				var div = document.createElement("div");
				var tbody = document.createElement("tbody");

				var table = document.getElementsByTagName("table")[0];
				var newtable = table.cloneNode(false);

				var idx = 0;
				for (var i = 0; i < rows.length; i++) {
					var rowid = rowformat.replace("XXXXX", rows[i]);
					rows[i] = document.getElementById(rowid);

					if (rows[i]) {
						tbody.appendChild(rows[i]);
						idx++;
					}
				}

				if (idx > 0) {
					div.setAttribute("id", "seccio_" + seccion.id);

					newtable.appendChild(tbody);

					var p = document.createElement(tag);
					p.innerHTML = seccion.title;

					div.appendChild(p);
					div.appendChild(newtable);

					table.parentNode.appendChild(div);
				}
			}
		}

		function contextualiza(idcampo, datos) {
			var campo = $("#" + idcampo + "_value").html();
			for (var i = 0; i < datos.length; i++) {
				if (campo == i + 1) {
					$("#" + idcampo + "_value").html(datos[i]);
					console.log(datos[i] + "(" + campo + ")");
					break;
				}
			}
		}

		function adaptaCampos() {
			contextualiza("tipoRegistro", [ "Entrada", "Sortida" ]);

			contextualiza(
					"tipoDocumentacionFisicaCodigo",
					[
							"Documentació adjunta en suport PAPER (o altres suports)",
							"Documentació adjunta digitalitzada i complementàriament en paper",
							"Documentació adjunta digitalitzada" ]);

			contextualiza("idioma", [ "Català", "Castellà", "Galleg",
					"Euskera", "Anglès", "Altres" ]);

			contextualiza("estado", [ "Vàlid", "Reserva", "Pendent de Visar",
					"Ofici extern", "Ofici intern", "Ofici acceptat",
					"Distribuït", "Anul·lat", "Rectificat", "Rebutjat",
					"Reenviat", "Distribuint", "Ofici SIR" ]);

			contextualiza("tipoTransporte", [ "Servei de missatgers",
					"Correu postal", "Correu postal certificat", "Burofax",
					"En ma", "Fax", "Altres" ]);

			contextualiza("tipoInteresadoEntidad", [ "ADMINISTRACIÓ",
					"PERSONA FÍSICA", "PERSONA JURÍDICA" ]);
			contextualiza("tipoInteresadoRepresentante", [ "ADMINISTRACIÓ",
					"PERSONA FÍSICA", "PERSONA JURÍDICA" ]);

			var tiposAdminID = [ {
				"key" : "N",
				"value" : "DNI"
			}, {
				"key" : "C",
				"value" : "CIF"
			}, {
				"key" : "P",
				"value" : "Passaport"
			}, {
				"key" : "E",
				"value" : "NIE"
			}, {
				"key" : "X",
				"value" : "Altres de persona física"
			}, {
				"key" : "O",
				"value" : "Codi d'origen"
			} ]

			var interesadosTipoAdminID = document
					.getElementsByClassName("tipo-admiID");
			console.log(interesadosTipoAdminID);
			for (var i = 0; i < interesadosTipoAdminID.length; i++) {
				var code = interesadosTipoAdminID[i].innerHTML;
				for (var j = 0; j < tiposAdminID.length; j++) {
					if (code == tiposAdminID[j].key) {
						interesadosTipoAdminID[i].innerHTML = tiposAdminID[j].value
								+ ":";
						break;
					}
				}
			}

		}
	</script>

	<h3>Interesados</h3>

	<c:if test="${countPF > 0 }">

		<h5>Persona fisica</h5>
		<table id="t_interesadospersonafisica"
			class="table-sm table table-bordered table-striped marTop10 table-genapp">
			<tr>
				<th><fmt:message key="registre.adminid" /></th>
				<th><fmt:message key="registre.nom" /></th>
				<th><fmt:message key="registre.llinatges" /></th>
				<th><fmt:message key="registre.email" /></th>
			</tr>
			<c:forEach var="item" items="${ar.interesados}">
				<c:if test="${empty item.representante}">
					<c:set var="persona" value="${item.interesado}" />
					<tr>
						<td><b class="tipo-admiID">${persona.tipoDocumentoIdentificacion}</b>
							${persona.documento}</td>
						<td>${persona.nombre}</td>
						<td>${persona.apellido1}<span></span> ${persona.apellido2}
						</td>
						<td>${persona.email}</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</c:if>

	<c:if test="${countPJ > 0 }">

		<h5>Persona Jurididca</h5>
		<table id="t_interesadospersonajuridica"
			class="table-sm table table-bordered table-striped marTop10 table-genapp">
			<tr>
				<th>CIF<//th>
				<th><fmt:message key="registre.raosocial" /></th>
				<th><fmt:message key="registre.adminid.representant" /></th>
				<th><fmt:message key="registre.nom" /></th>
				<th><fmt:message key="registre.llinatges" /></th>
			</tr>
			<c:forEach var="item" items="${ar.interesados}">
				<c:set var="interesado" value="${item.interesado}" />
				<c:set var="representante" value="${item.representante}" />
				<c:if test="${not empty representante}">
					<tr>
						<td>${interesado.documento}</td>
						<td>${interesado.razonSocial}</td>

						<td><b class="tipo-admiID">${representante.tipoDocumentoIdentificacion}</b>
							${representante.documento}</td>
						<td>${representante.nombre}</td>
						<td>${representante.apellido1}<span></span>
							${representante.apellido2}
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</c:if>

	<%-- 	<c:if test="${personaFisica}">
		<h5>
			<fmt:message key="solicitant" />
		</h5>
	</c:if>
 --%>



	<h4>Anexos</h4>
	<c:if test="${as.anexos.size() eq 0}">
		<p>No hay anexos para esta instancia</p>
	</c:if>
	<c:if test="${as.anexos.size() > 0}">
		<table id="t_anexos"
			class="tdformlabel table-sm table table-bordered table-striped marTop10 table-genapp">
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
						href="
					<c:url value="${contexte}/descarregarFitxer/${ige:encriptar(anexo.fileID)}"/>">
							<fmt:message key="descargar" />
					</a></td>

				</tr>
			</c:forEach>
		</table>
	</c:if>


	<h4>
		<a
			href="<c:url value="${contexte}/descarregarJustificant/${instanciaGenericaID}"/>">
			<fmt:message key="justificant" />
		</a>
	</h4>
	<script type="text/javascript">
		adaptaCampos();
	</script>
</body>
</html>