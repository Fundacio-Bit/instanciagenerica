
<script type="text/javascript">
	function onChangeSolicitantPersonaFisica(elem) {
		var personaFisica = (elem.value == "true");
		configFisicaJuridica(personaFisica);
	}

	function configFisicaJuridica(personaFisica) {
		var aCambiar = [ "solicitantAdminID", "solicitantNom",
				"solicitantLlinatge1", "solicitantLlinatge2" ];

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

	function veureFitxerId(event) {
		var i = event.data.id;
		var ruta = $("#fitxer" + i + "ID").val();

		var action;

		if (ruta.localeCompare("") == 0) {
			console.log("eliminar");
			contador--;
			if (contador == idx_files - 3) {
				$("#instanciaGenerica_fitxer" + idx_files + "ID_rowid").hide();
				idx_files--;
			}
		} else if (fitxrersArray[i].localeCompare("") == 0) {
			console.log("afegir");
			contador++;
			if (contador == idx_files - 1) {
				idx_files++;
				$("#instanciaGenerica_fitxer" + idx_files + "ID_rowid").show();
			}
			// 	} else if (!fitxrersArray[i].equals(ruta)) {
			//		action = "modificar";
		}

		fitxrersArray[i] = ruta;

		console.log("Fichero " + i + ": " + ruta);
		console.log(fitxrersArray);

	}

	//Per defecte, serà persona fisica
	configFisicaJuridica(true);

	var fitxrersArray = Array(10).fill("");
	var contador = 0;
	var idx_files = 3;
	for (var i = 1; i <= 9; i++) {
		$("#fitxer" + i + "ID").on("change", {
			id : i
		}, veureFitxerId);
		if (i > idx_files) {
			$("#instanciaGenerica_fitxer" + i + "ID_rowid").hide();
		}
	}
</script>


