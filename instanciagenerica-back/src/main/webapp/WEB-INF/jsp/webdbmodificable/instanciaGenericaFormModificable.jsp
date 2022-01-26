
<h1>Hola caracola 2</h1>

<c:if test="${mostrarScript}">
	<script type="text/javascript">
		function onChangeSolicitantPersonaFisica(elem) {

			console.log(elem.value);

			var tipusPersona = elem.value;

			if (tipusPersona == "true") { //persona fisica
				$("#instanciaGenerica_solicitantNom_rowid").show();
				$("#instanciaGenerica_solicitantLlinatge1_rowid").show();
				$("#instanciaGenerica_solicitantLlinatge2_rowid").show();

				$("#instanciaGenerica_solicitantRaoSocial_rowid").hide();

			} else {

				$("#instanciaGenerica_solicitantNom_rowid").hide();
				$("#instanciaGenerica_solicitantLlinatge1_rowid").hide();
				$("#instanciaGenerica_solicitantLlinatge2_rowid").hide();

				$("#instanciaGenerica_solicitantRaoSocial_rowid").show();
				// "table-row";
			}
		}
		onChangeSolicitantPersonaFisica($("#instanciaGenerica_solicitantTipusAdminID"));

		function onChangeSolicitantTipusAdminID(elem) {
			console.log(elem.value);
			console.log(elem.options);
			console.log(elem.selectedIndex);
		}
	</script>
</c:if>



