function filtrar(){
	var sede = document.getElementById('sedeSelected').value;
	alert('Será redirecionado');
	location.href='/consulta?tipo=general&sede='+sede+'&bloque&piso';
}

function BuscarId(id){
	$.post( "/buscarID",
			{id: id},
			function( extintor ) {
				$('#Extintores').val(extintor);
			}
	);
}

function ObtenerBloques(){
	$.post( "/obtenerBloques",
			{sede: $('#sede').val()},
			function( data ) {
				$('#bloque').html('<option value ="">Seleccione</option>');
				$('#piso').html('<option value="">Seleccione</option>');
				$.each(data, 
						function(i,val){
							$('#bloque').append('<option value="'+val+'">'+val+'</option>');
						}
				);
			}
	);
}


function ObtenerPisos(){
	$.post( "/obtenerPisos",
			{sede: $('#sede').val(), bloque: $('#bloque').val()},
			function( data ) {
				$('#piso').html('<option value="">Seleccione</option>');
				$.each(data, 
						function(i,val){
							$('#piso').append('<option value="'+val+'">'+val+'</option>');
						}
				);
			}
	);
}

function CalcularVencimiento(caducidad){
	var array = $('#fechaultimarecarga').val().split('-');
	var fechavencimiento = (parseInt(array[0])+parseInt(caducidad))+'-'+array[1]+'-'+array[2]
	$('#fechavencimiento').val(fechavencimiento);
	$('#fechavencimiento').text(fechavencimiento);
}

function ObtenerEmpresa(){
	$.post( "/obtenerEmpresa",
			{numerocontrato: $('#numerocontrato').val()},
			function( data ) {
				if (data == ""){
					var confirmacion = confirm('El contrato No. '+$('#numerocontrato').val()+' no existe.\nDesea registrarlo?');
					if(confirmacion == true){
						location.href='/registrarContrato';
					}else{
						alert('No registrar');
					}
				}else{
					console.log('Empresa: '+data);
				}
				$('#empresa').val(data);
				$('#empresa').text(data);
			}
	);
}

function ValidarCedula(){
	$.post( "/buscarEncargado",
			{cedula: $('#cedulaencargado').val()},
			function( data ) {
				if ( data == "" ){
					var confirmacion = confirm('la cedula no esta en el sistema \nDesea registrarla?');
					if ( confirmacion == true ){
						location.href = '/registrarEncargado';
					}
				}
			}
	);
}
