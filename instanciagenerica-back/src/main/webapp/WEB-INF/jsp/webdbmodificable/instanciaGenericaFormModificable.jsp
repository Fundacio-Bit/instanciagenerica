<input id="id_urlnavegador" type="hidden" name="urlnavegador" />




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

	var isFisicaForm = $("#instanciaGenerica_solicitantPersonaFisica").val();
	var isFisicaView = document
			.getElementById("instanciaGenerica.solicitantPersonaFisica");

	if (isFisicaForm != null) {
		configFisicaJuridica(isFisicaForm == "true");
	}

	if (isFisicaView != null) {

		var seccio1 = [ "solicitantTipusAdminID", "solicitantAdminID",
				"solicitantPersonaFisica", "solicitantNom",
				"solicitantLlinatge1", "solicitantLlinatge2" ];

		if (isFisicaView.value != "true") {
			seccio1.push("solicitantRaoSocial");
			seccio1.push("solicitantCif");
		}

		var seccio2 = [ "numRegistre", "datafinalitzacio" ];

		var seccio3 = [ "dataCreacio", "exposa", "solicita" ];

		var seccio4 = [ "solicitantDireccio", "solicitantEmail",
				"solicitantTelefon" ];

		var seccio5 = [];
		for (var i = 1; i <= 9; i++) {
			seccio5.push("fitxer" + i + "ID");
		}
		
		splitTable("Contacte solicitant", seccio4, "infoSolicitantAdicional");
		splitTable("Annexes", seccio5, "fitxers");
		splitTable("Resum", seccio3, "infoInstancia");
		splitTable("Solicitant", seccio1, "infoSolicitant");
		splitTable("Registre", seccio2, "infoRegistre");

		configFisicaJuridica(isFisicaView.value == "true");

	}

	function splitTable(title, trs, id) {

		var table = document.getElementsByTagName("table")[0];
		var newtable = table.cloneNode(false);
		var tbody = document.createElement("tbody");

		for (var i = 0; i < trs.length; i++) {

			trs[i] = document.getElementById("instanciaGenerica_" + trs[i]
					+ "_rowid");
			if (trs[i]) {
				tbody.appendChild(trs[i]);
			}
		}

		newtable.setAttribute("id", "seccio_" + id);
		newtable.appendChild(tbody);

		var p = document.createElement("h3");
		p.appendChild(document.createTextNode(title));
		if (table.nextSibling) {
			table.parentNode.insertBefore(p, table.nextSibling);
		} else {
			table.parentNode.appendChild(p);
		}

		if (p.nextSibling) {
			table.parentNode.insertBefore(newtable, p.nextSibling);
		} else {
			table.parentNode.appendChild(newtable);
		}

	}

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

	$("#id_urlnavegador").val(getAbsolutePath());

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

	//cogerURLdelNavegador y poner en input hidden
</script>


