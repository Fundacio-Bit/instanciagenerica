
<h1>Hola caracola 2</h1>

<c:if test="${mostrarScript}">
	<script type="text/javascript">
		var isFisica = $("#instanciaGenerica_solicitantPersonaFisica").val();
		console.log(isFisica ? '1-Fisica' : '1-Juridica');

		$("#instanciaGenerica_solicitantRaoSocial_rowid").hide();

		function onChangeSolicitantPersonaFisica(elem) {

			var isPersonaFisica = elem.value;
			console.log(elem.value ? 'Fisica' : 'Juridica');

			console.log(elem.value);
			console.log(elem.value == "true");
			console.log(isPersonaFisica);
			console.log(isPersonaFisica == "Fisica");

			if (isPersonaFisica == "true") { //persona fisica
				console.log(" -> Persona fisica");
				$("#instanciaGenerica_solicitantNom_rowid").show();
				$("#instanciaGenerica_solicitantLlinatge1_rowid").show();
				$("#instanciaGenerica_solicitantLlinatge2_rowid").show();

				$("#instanciaGenerica_solicitantRaoSocial_rowid").hide();

			} else {
				console.log(" -> Persona juridica");
				$("#instanciaGenerica_solicitantNom_rowid").hide();
				$("#instanciaGenerica_solicitantLlinatge1_rowid").hide();
				$("#instanciaGenerica_solicitantLlinatge2_rowid").hide();

				$("#instanciaGenerica_solicitantRaoSocial_rowid").show();
				// "table-row";
			}
		}

//		onChangeSolicitantPersonaFisica($("#instanciaGenerica_solicitantPersonaFisica"));

		function onChangeSolicitantTipusAdminID(elem) {
			console.log(elem.value);
			console.log(elem.options);
			console.log(elem.selectedIndex);
		}
	</script>
</c:if>



