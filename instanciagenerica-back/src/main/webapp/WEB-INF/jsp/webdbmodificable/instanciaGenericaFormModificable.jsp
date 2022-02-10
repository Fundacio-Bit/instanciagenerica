<c:if test="${mostrarScript}">
	<script type="text/javascript">
		function onChangeSolicitantPersonaFisica(elem) {
			var personaFisica = elem.value == "true"
			configFisicaJuridica(personaFisica);
		}

		//Per defecte, serà persona fisica
		configFisicaJuridica(true);

		function configFisicaJuridica(personaFisica) {
			var aCambiar = [ "solicitantAdminID", "solicitantNom", "solicitantLlinatge1",
					"solicitantLlinatge2" ];

			$.each(aCambiar, function(key, value) {

				var id = "#instanciaGenerica_" + value + "_columnlabelid"
				var html = $(id).html();
				var cadenaNueva;

				if (personaFisica) {
					cadenaNueva = '<fmt:message key="solicitant"/>';
				} else {
					cadenaNueva = '<fmt:message key="representant"/>';
				}

				html = html.substring(0, (html.indexOf("(")) + 1) + cadenaNueva
						+ html.substring(html.indexOf(")"), html.length);

				$(id).html(html);
			});

			var aEsconder = [ "solicitantRaoSocial", "solicitantCif" ];
			$.each(aEsconder, function(key, value) {
				var id = "#instanciaGenerica_" + value + "_rowid";
				if (personaFisica)
					$(id).hide();
				else
					$(id).show();
			});
		}

		var fitxrersArray = Array(10).fill("");
		var contador = 0;
		var idx_files = 3;
		for (var i = 1; i <= 9; i++) {
			$("#fitxer" + i + "ID").on("change", {
				pepito : i
			}, mifunc);
			if (i > idx_files) {
				$("#instanciaGenerica_fitxer" + i + "ID_rowid").hide();
			}
		}

		function mifunc(event) {
			var i = event.data.pepito;
			var ruta = $("#fitxer" + i + "ID").val();

			var action;

			if (ruta.localeCompare("") == 0) {
				console.log("eliminar");
				contador--;
				console.log("	cont:" + contador + " - idx:" + idx_files);

				if (contador == idx_files - 3) {
					$("#instanciaGenerica_fitxer" + idx_files + "ID_rowid")
							.hide();
					idx_files--;
				}
				console.log("	cont:" + contador + " - idx:" + idx_files);

			} else if (fitxrersArray[i].localeCompare("") == 0) {
				console.log("afegir");
				contador++;
				console.log("	cont:" + contador + " - idx:" + idx_files);

				if (contador == idx_files - 1) {
					idx_files++;
					$("#instanciaGenerica_fitxer" + idx_files + "ID_rowid")
							.show();
				}
				console.log("	cont:" + contador + " - idx:" + idx_files);

				// 	} else if (!fitxrersArray[i].equals(ruta)) {
				//		action = "modificar";
			}

			fitxrersArray[i] = ruta;

			console.log("Fichero " + i + ": " + ruta);
			console.log(fitxrersArray);

		}

		function reemplazarCadena(cadenaVieja, cadenaNueva, cadenaCompleta) {
			// Reemplaza cadenaVieja por cadenaNueva en cadenaCompleta

			for (var i = 0; i < cadenaCompleta.length; i++) {
				if (cadenaCompleta.substring(i, i + cadenaVieja.length) == cadenaVieja) {
					cadenaCompleta = cadenaCompleta.substring(0, i)
							+ cadenaNueva
							+ cadenaCompleta.substring(i + cadenaVieja.length,
									cadenaCompleta.length);
				}
			}
			return cadenaCompleta;
		}
	</script>
</c:if>



