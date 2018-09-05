function BuscarElmt(){
	$.post( "/buscarElementoTipo",
			{tipo: $('#tipo').val()},
			function( elementos ) {
				var tabla = '<table id="Elementos" class="table table-bordered">' +
				'<tr class="bg-primary">' +
				'<td><label>Tipo de elemento</label></td>' +
				'<td><label>Id</label></td>' +
				'<td><label>Ubicación</label></td>' +
				'<td><label>Tipo</label></td>' +
				'<td><label>Fecha de vencimiento</label></td>' +
				'</tr>';
				$.each(elementos, 
						function(i,elemento){
							var fila = '<tr>' +
							'<td text="'+elemento.tipoelemento+'">'+elemento.tipoelemento+'</td>' +
							'<td text="'+elemento.id+'">'+elemento.id+'</td>' +
							'<td text="'+elemento.ubicacion+'">'+elemento.ubicacion+'</td>' +
							'<td text="'+elemento.tipo+'">'+elemento.tipo+'</td>' +
							'<td text="'+elemento.fechavencimiento+'">'+elemento.fechavencimiento+'</td>' +
							'</tr></table>';
							tabla += fila;
						}
				);
				$('#Elementos').html(tabla);
			}
	);
}

function BuscarUbicacionGen(){
	$.post( "/buscarUbicacionElmt",
			{sede: $('#sede').val(), bloque: $('#bloque').val(), piso: $('#piso').val()},
			function( elementos ) {
				var tabla = '<table id="Elementos" class="table table-bordered">' +
				'<tr class="bg-primary">' +
				'<td><label>Tipo de elemento</label></td>' +
				'<td><label>Id</label></td>' +
				'<td><label>Ubicación</label></td>' +
				'<td><label>Tipo</label></td>' +
				'<td><label>Fecha de vencimiento</label></td>' +
				'</tr>';
				$.each(elementos, 
						function(i,elemento){
							var fila = '<tr>' +
							'<td text="'+elemento.tipoelemento+'">'+elemento.tipoelemento+'</td>' +
							'<td text="'+elemento.id+'">'+elemento.id+'</td>' +
							'<td text="'+elemento.ubicacion+'">'+elemento.ubicacion+'</td>' +
							'<td text="'+elemento.tipo+'">'+elemento.tipo+'</td>' +
							'<td text="'+elemento.fechavencimiento+'">'+elemento.fechavencimiento+'</td>' +
							'</tr></table>';
							tabla += fila;
						}
				);
				$('#Elementos').html(tabla);
			}
	);
}

function LimpiarFiltrosGen(){
	$('#id').val('');
	$('#sede').val('');
	$('#bloque').empty();
	$('#piso').empty();
	BuscarUbicacionGen();
}