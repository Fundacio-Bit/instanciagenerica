<c:if test="${mostrarScript}">
	<script type="text/javascript">
		var isFisica = $("#instanciaGenerica_solicitantPersonaFisica").val();
		console.log(isFisica ? '1-Fisica' : '1-Juridica');

		$("#instanciaGenerica_solicitantRaoSocial_rowid").hide();

		function onChangeSolicitantPersonaFisica(elem) {

			var isPersonaFisica = elem.value;

			if (isPersonaFisica == "true") { //persona fisica
				console.log(" -> Persona fisica");

				$("#instanciaGenerica_solicitantNom_columnlabelid").html(
						"<label>Nom solicitant</label>");
				$("#instanciaGenerica_solicitantLlinatge1_columnlabelid").html(
						"<label>Llinatge solicitant</label>");
				$("#instanciaGenerica_solicitantLlinatge2_columnlabelid").html(
						"<label>Segon llinatge solicitant</label>");

				$("#instanciaGenerica_solicitantRaoSocial_rowid").hide();

			} else {
				console.log(" -> Persona juridica");

				$("#instanciaGenerica_solicitantNom_columnlabelid").html(
						"<label>Nom representant</label>");
				$("#instanciaGenerica_solicitantLlinatge1_columnlabelid").html(
						"<label>Llinatge representant</label>");
				$("#instanciaGenerica_solicitantLlinatge2_columnlabelid").html(
						"<label>Segon llinatge representant</label>");

				$("#instanciaGenerica_solicitantRaoSocial_rowid").show();
				// "table-row";
			}
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
		/* 		instanciaGenerica_fitxer6ID_rowid
		 fitxer6ID
		 */
	</script>
</c:if>



