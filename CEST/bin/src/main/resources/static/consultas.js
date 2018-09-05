function BuscarExt(){
	$.post( "/buscarID",
			{id: $('#id').val()},
			function( extintores ) {
				var tabla = '<table id="Extintores" class="table table-bordered">' +
				'<tr class="bg-primary">' +
				'<td><label>Identificador</label></td>' +
				'<td><label>Tipo</label></td>' +
				'<td><label>Tamaño</label></td>' +
				'<td><label>Fecha ultima recarga</label></td>' +
				'<td><label>Fecha de vencimiento</label></td>' +
				'<td><label>Caducidad (años)</label></td>' +
				'<td><label>Sede</label></td>' +
				'<td><label>Bloque</label></td>' +
				'<td><label>Piso</label></td>' +
				'<td><label>Estado</label></td>' +
				'<td><label>Acciones</label></td>' +
				'</tr>';
				$.each(extintores, 
						function(i,extintor){
							var fila = '<tr>' +
							'<td id="'+extintor.idelemento+'" text="'+extintor.idelemento+'">'+extintor.idelemento+'</td>' +
							'<td text="'+extintor.fichatecnica.tipo+'">'+extintor.fichatecnica.tipo+'</td>' +
							'<td text="'+extintor.tamanio+'">'+extintor.tamanio+'</td>' +
							'<td text="'+extintor.fechaultimarecarga+'">'+extintor.fechaultimarecarga+'</td>' +
							'<td text="'+extintor.fechavencimiento+'">'+extintor.fechavencimiento+'</td>' +
							'<td text="'+extintor.caducidadanios+'">'+extintor.caducidadanios+'</td>' +
							'<td text="'+extintor.elemento.piso.bloque.sede.nombre+'">'+extintor.elemento.piso.bloque.sede.nombre+'</td>' +
							'<td text="'+extintor.elemento.piso.pisoPk.letrabloque+'">'+extintor.elemento.piso.pisoPk.letrabloque+'</td>' +
							'<td text="'+extintor.elemento.piso.pisoPk.numero+'">'+extintor.elemento.piso.pisoPk.numero+'</td>' +
							'<td text="'+extintor.estado+'">'+extintor.estado+'</td>' +
							'<td >' +
							'<button id="'+extintor.elemento.id+'" class="glyphicon glyphicon-pencil btn btn-primary" onclick="enviar(this.id);"></button>' +
							'<button class="glyphicon glyphicon-trash btn btn-danger"></button>' +
							'</td>' +
							'</tr></table>';
							tabla += fila;
						}
				);
				$('#Extintores').html(tabla);
			}
	);
}

function BuscarUbicacion(){
	$.post( "/buscarUbicacion",
			{sede: $('#sede').val(), bloque: $('#bloque').val(), piso: $('#piso').val()},
			function( extintores ) {
				var tabla = '<table id="Extintores" class="table table-bordered">' +
				'<tr class="bg-primary">' +
				'<td><label>Identificador</label></td>' +
				'<td><label>Tipo</label></td>' +
				'<td><label>Tamaño</label></td>' +
				'<td><label>Fecha ultima recarga</label></td>' +
				'<td><label>Fecha de vencimiento</label></td>' +
				'<td><label>Caducidad (años)</label></td>' +
				'<td><label>Sede</label></td>' +
				'<td><label>Bloque</label></td>' +
				'<td><label>Piso</label></td>' +
				'<td><label>Estado</label></td>' +
				'<td><label>Acciones</label></td>' +
				'</tr>';
				$.each(extintores, 
						function(i,extintor){
							var fila = '<tr>' +
							'<td id="'+extintor.idelemento+'" text="'+extintor.idelemento+'">'+extintor.idelemento+'</td>' +
							'<td text="'+extintor.fichatecnica.tipo+'">'+extintor.fichatecnica.tipo+'</td>' +
							'<td text="'+extintor.tamanio+'">'+extintor.tamanio+'</td>' +
							'<td text="'+extintor.fechaultimarecarga+'">'+extintor.fechaultimarecarga+'</td>' +
							'<td text="'+extintor.fechavencimiento+'">'+extintor.fechavencimiento+'</td>' +
							'<td text="'+extintor.caducidadanios+'">'+extintor.caducidadanios+'</td>' +
							'<td text="'+extintor.elemento.piso.bloque.sede.nombre+'">'+extintor.elemento.piso.bloque.sede.nombre+'</td>' +
							'<td text="'+extintor.elemento.piso.pisoPk.letrabloque+'">'+extintor.elemento.piso.pisoPk.letrabloque+'</td>' +
							'<td text="'+extintor.elemento.piso.pisoPk.numero+'">'+extintor.elemento.piso.pisoPk.numero+'</td>' +
							'<td text="'+extintor.estado+'">'+extintor.estado+'</td>' +
							'<td >' +
							'<button id="'+extintor.elemento.id+'" class="glyphicon glyphicon-pencil btn btn-primary" onclick="enviar(this.id);"></button>' +
							'<button class="glyphicon glyphicon-trash btn btn-danger"></button>' +
							'</td>' +
							'</tr></table>';
							tabla += fila;
						}
				);
				$('#Extintores').html(tabla);
			}
	);
}

function LimpiarFiltros(){
	$('#id').val('');
	$('#sede').val('');
	$('#bloque').empty();
	$('#piso').empty();
	BuscarUbicacion();
}