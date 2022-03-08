<input id="id_urlnavegador" type="hidden" name="urlnavegador" />

<script type="text/javascript">
	function onChangeSolicitantPersonaFisica(elem) {
		var personaFisica = (elem.value == "true");
		//		configFisicaJuridica(personaFisica);
		setPersonaFisica(personaFisica);
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

		if (personaFisica)
			$("#seccio_entitat").hide();
		else
			$("#seccio_entitat").show();

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

	//cogerURLdelNavegador y poner en input hidden
	function getAbsolutePath() {
		var loc = window.location;
		var pathName = loc.pathname.substring(0,
				loc.pathname.lastIndexOf('/') + 1);

		var ret = loc.href
				.substring(
						0,
						loc.href.length
								- ((loc.pathname + loc.search + loc.hash).length - pathName.length));

		return ret
	}

	function setPersonaFisica(personaFisica) {

		var h4 = document.getElementById("seccio_solicitant").children[0];
		var cadenaNueva;
		if (personaFisica) {
			cadenaNueva = '<fmt:message key="solicitant"/>';
			$("#seccio_entitat").hide();
		} else {
			cadenaNueva = '<fmt:message key="representant"/>';
			$("#seccio_entitat").show();
		}

		h4.innerHTML = cadenaNueva;
	}
	//Per defecte, serà persona fisica

	var personaFisica = false;
	var isFisicaForm = $("#instanciaGenerica_solicitantPersonaFisica").val();
	var isFisicaView = document
			.getElementById("instanciaGenerica.solicitantPersonaFisica");

	if (isFisicaForm != null) {
		personaFisica = isFisicaForm == "true";
	}

	if (isFisicaView != null) {
		personaFisica = isFisicaView.value == "true"
	}

	$("#id_urlnavegador").val(getAbsolutePath());

	//	configFisicaJuridica(personaFisica);
	setPersonaFisica(personaFisica);

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

		console.log($("#fitxer" + i + "ID").val())
		if ($("#fitxer" + i + "ID").val() != "") {
			$("#instanciaGenerica_fitxer" + i + "ID_rowid").show();
		}
	}
</script>


