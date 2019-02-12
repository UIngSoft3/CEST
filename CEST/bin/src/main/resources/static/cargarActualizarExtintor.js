function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
    results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}
	
function Leer(){
	$.post( "/obtenerExtintor",
			{id: getParameterByName('id')},
			function( extintor ) {
				$('#id').val(extintor.elemento.id);
				$('#cedulaencargado').val(extintor.elemento.encargado.cedula);
				$('#numerocontrato').val(extintor.elemento.contrato.numero);
				$('#tamanio').val(extintor.tamanio);
				$('#fichatecnica').val(extintor.fichatecnica.tipo);
				$('#empresa').val(extintor.elemento.contrato.empresa.nombre);
				$('#fechaultimarecarga').val(extintor.fechaultimarecarga);
				$('#caducidad').val(extintor.caducidadanios);
				$('#fechavencimiento').val(extintor.fechavencimiento);
				$('#estado').val(extintor.estado);
				$('#sede').val(extintor.elemento.piso.bloque.sede.nombre);
				$('#bloque').html('<option>'+extintor.elemento.piso.pisoPk.letrabloque+'</option>');
				$('#piso').html('<option>'+extintor.elemento.piso.pisoPk.numero+'</option>');
			}
	);
}
window.onload = Leer;