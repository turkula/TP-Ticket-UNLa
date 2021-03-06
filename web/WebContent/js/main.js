var arrayButacasCine = []
var cantidadEntradasMaximas;
var cantidadEntradasVendidas;
var idUser;
var precioEntrada;
var user;
var descuento;
var totalFinal=0;
var tipoEvento=3

if(sessionStorage.getItem("userId")==null){
	window.location.replace("login.jsp");
	
}

function calcularTotal(cantidadEntradas){
//	console.log(precioEntrada)
	totalFinal=cantidadEntradas*precioEntrada;
	
	if(descuento!=0){
		totalFinal=(totalFinal*descuento)/100;

	}
	$('#labelPrecioTotal').text(totalFinal);
}

$( document ).ready(function() {
	 idUser=sessionStorage.getItem("userId").trim();
	 
	 //traigo datos usuario
	 $.ajax({
			method:"POST",
			url:"ControladorTraerUsuario",
			data:{idUser:idUser},
			async:true
		}).done(function (data){
			user = JSON.parse(data);
			console.log(user);

			$('#labelUserName').text(user.username);
			
			//normal
			if(user.idTipoCliente==1){
				descuento=0;
			}
			
			//estudiante
			if(user.idTipoCliente==2){
				descuento=20;
			}
			
			//jubilado
			if(user.idTipoCliente==3){
				descuento=50
			}
			
			$('#descuentoTipo').text(user.tipoCliente+" - %"+descuento);

		})
	
	//leno select auditorio
	$.ajax({
		method:"POST",
		url:"ControladorTraerAuditorio",
		data:{tipo:tipoEvento},
		async:true
	}).done(function (data){
	    populateSelect('selectAuditorioCine',JSON.parse(data),false)
	})
	
	
})

//fill selet pelicula
$( "#selectAuditorioCine" ).change(function() {
    $("#tablaAsientos tr").remove(); 
    $('#selectFuncionCine').val('')
    $('#selectSector').val('')

  
    var idComplejo = $('#selectAuditorioCine').val();
    $.ajax({
		method:"POST",
		url:"ControladorTraerEvento",
		data:{
				idAuditorio:idComplejo,
				idTipo:tipoEvento
			},
		async:true
	}).done(function (data){
	    populateSelect('selectEventoCine',JSON.parse(data),false)
	})
	
      });

//lleno evento
  $( "#selectEventoCine" ).change(function() {
	  $('#selectSector').val('')
	      $('#selectFuncionCine').val('')


    $("#tablaAsientos tr").remove();
    
    var idAuditorio = $('#selectAuditorioCine').val();
    var idEvento = $('#selectEventoCine').val();
    
    $.ajax({
		method:"POST",
		url:"ControladorTraerFuncion",
		data:{
				idTipo:tipoEvento,
				idAuditorio:idAuditorio,
				idEvento:idEvento
			},
		async:true
	}).done(function (data){
	    populateSelect('selectFuncionCine',JSON.parse(data),false)
	})
    
  });

//  Select sectores
  $( "#selectFuncionCine" ).change(function() {
    $("#tablaAsientos tr").remove();
    var idAuditorio = $('#selectAuditorioCine').val();
    var idPelicula = $('#selectEventoCine').val();
    var idFuncion = $('#selectFuncionCine').val();
    
    $.ajax({
		method:"POST",
		url:"ControladorTraerSector",
		data:{
				idAuditorio:idAuditorio,
				idFuncion:idFuncion
			},
		async:true
	}).done(function (data){
	    populateSelect('selectSector',JSON.parse(data),false)
	})
    
  });

//  LLENO GRILLA
  $( "#selectSector" ).change(function() {
	    $("#tablaAsientos tr").remove();
	    $("#divPopular").addClass("d-none")
	    $("#cantidadEntradas tr").val(0);
	    var idSector = $('#selectSector').val();
	    var idFuncion = $('#selectFuncionCine').val();
	    
	    //valor entrada
	    $.ajax({
			method:"POST",
			url:"ControladorTraerTarifa",
			data:{
				idSector:idSector,
				idFuncion:idFuncion
			},
			async:true
		}).done(function (data){
			precioEntrada=data;
			$('#valorEntrada').text(precioEntrada);
		})
	    
	    
	    //grilla
	    $.ajax({
			method:"POST",
			url:"ControladorHacerGrilla",
			data:{
					idSector:idSector,
					idFuncion:idFuncion
				},
			async:true
			}).done(function (data){
		    data=JSON.parse(data);
//		    console.log(data)
		    if(data[2]==1){
//		    	FLAG PARA SABER QUE TIPO DE OPERACION SE ESTA HACIENDO
		    	$('#flagTipoReserva').val(1);
		    	hacerGrilla(data[0],data[1]);	
		    }
		    
		    if(data[2]==0){
		    	if(data[0]>data[1]){
//			    	FLAG PARA SABER QUE TIPO DE OPERACION SE ESTA HACIENDO
		    		$('#flagTipoReserva').val(0);
		    		$('#divPopular').removeClass('d-none');	
		    		
		    		cantidadEntradasMaximas=parseInt(data[0])
		    		cantidadEntradasVendidas=parseInt(data[1])
		    		
		    		$('#labelVendida').text(cantidadEntradasVendidas)
		    		$('#labelMaxima').text(cantidadEntradasMaximas)
		    	
		    	}
		    	
		    }
		})
	  });
  
  
  


// SUMAR ENTRADA
$('#masEntrada').click(function(){
   var cantidadEntrada = $('#cantidadEntradas').val()
    cantidadEntrada++;
    $('#cantidadEntradas').val(cantidadEntrada);
})

// RESTAR ENTRADA
$('#menosEntrada').click(function(){
   var cantidadEntrada = $('#cantidadEntradas').val()
   if(cantidadEntrada>0){
    cantidadEntrada--;
    $('#cantidadEntradas').val(cantidadEntrada);
   }
})

var butacasArray=[]
function hacerGrilla(arrayButacas,arrayButacasOcupadas){   
    var grilla = '<table>'
    var numeracion = 0;
    var arrayButacasOcupadas=arrayButacasOcupadas;
    var butacasArray=arrayButacas;
    var fila=arrayButacas[0].fila
    grilla+='<tr>';
    
       
    for(var i=0;i<butacasArray.length;i++){
    	if(fila!=butacasArray[i].fila){
    		grilla+='</tr>';
    		grilla+='<tr>';
    	}
    	color="";
    	
    	for(var y=0;y<arrayButacasOcupadas.length;y++){
    		if(butacasArray[i].id==arrayButacasOcupadas[y].id){
    			color="rojo";
    		}
    	}
    	
    	grilla+='<td><div id="butaca'+butacasArray[i].id+'" style="height:25px; width:40px" class="circle text-center '+color+'" onclick=reservarButaca('+butacasArray[i].fila+','+butacasArray[i].columna+','+butacasArray[i].id+')>'+butacasArray[i].id+'</div></td>';	
    	fila=arrayButacas[i].fila
    }
    grilla+='</tr>';
    grilla+='</table>'
<
    $('#tablaAsientos').append(grilla);
}


function reservarButaca(fila,columna,id){
    //verifico si ya esta reservada
    if(!$( "#butaca"+id ).is( ".rojo" )){

        // verifico si ya fue seleccionda
      if($( "#butaca"+id ).is( ".verde" )){
        $('#butaca'+id).removeClass('verde');

        // saco la butaca del array
        arrayButacasCine.forEach(function(butaca,index) {
            if(butaca.id==id){
                arrayButacasCine.splice(index, 1);
            }
          })

      }else{
          $('#butaca'+id).addClass('verde');

          //creo objeto butaca
          butaca={
              fila:fila,
              columna:columna,
              id:id
          }

          //lo meto en el array de cine
          arrayButacasCine.push(butaca);
      }  
    }
    calcularTotal(arrayButacasCine.length)
}

$('#btnReservar').click(function(){
	
	var flag = $('#flagTipoReserva').val();
    var idSector = $('#selectSector').val();
    var idFuncion = $('#selectFuncionCine').val();
    var cantidadEntradas = parseInt($('#cantidadEntradas').val());
    var response=[]; 
    var controlador='';

    
    if(flag==1){
    	 var array=[];
    	 if(arrayButacasCine.length<=0 ){

    	        alertify.alert("Por favor seleccione una butaca");
    	        return;
    	    }
    	 
    	 arrayButacasCine.forEach(function(butaca) {
    			array.push(butaca.id);
    			});
    			
    	response=JSON.stringify(array)
    	
    	controlador="ControladorReservaNumerada"
    }
   
    
    if(flag==0){
    	if(isNaN(cantidadEntradas)){
    		alertify.alert("Por favor ingrese un numero valido");
    		return;
    	}
    	if(cantidadEntradas<=0 ){
    		alertify.alert("Por favor ingrese una cantidad de entradas");
        	return;
    	}
    	if(cantidadEntradas+cantidadEntradasVendidas>cantidadEntradasMaximas){
    		alertify.alert("La cantidad ingresada supera el maximo de capacidad del auditorio");
    		return;
    	}
    	
    	controlador="ControladorReservaPopular"
    	response=cantidadEntradas;
   
    
    }
    console.log(totalFinal);

        $.ajax({
    		method:"POST",
    		url:controlador,
    		data:{
    				idSector:idSector,
    				idFuncion:idFuncion,
    				idUsuario:idUser,
    				precioTotal:totalFinal,
    				array:response
    			},
    		async:true
    		}).done(function (data){
//    			console.log(data);
//    			if(data=="OK"){
    				alertify.alert("Su reserva se realizo con exito");
//    			}
    		})
        
        
        $("#tablaAsientos tr").remove();
  	  	$('#selectAuditorioCine').val('')
  	  	$('#selectEventoCine').val('')
		$('#selectFuncionCine').val('')
		$('#selectSector').val('')
		$('#cantidadEntradas').val(0)
		$('#divPopular').addClass('d-none');

        arrayButacasCine=[];
    
});



function populateSelect(idSelect, values, ordered = true) {

    var select = $('#' + idSelect);

    select.find('option:not(:first)').remove();

    if (ordered) {
        values = _.sortBy(values, [function (o) {
            return o.nombre;
        }])
    }

    $.each(values, function (key, value) {

        select.append($('<option>', {
            text: value.nombre,
            value: value.id
        }));
    })
}

//abrin modal registrarse
$('#linkModalRegistrarse').click(function(){
    $('#modalRegistro').modal('show'); 
});


//calcular totoal
$("#masEntrada").click(function() {
	calcularTotal($("#cantidadEntradas").val())
});

$("#menosEntrada").click(function() {
	calcularTotal($("#cantidadEntradas").val())
});


//change value del tab
$("#tabCine").click(function() {
	clearPage();
	tipoEvento=3
	//leno select auditorio
	$.ajax({
		method:"POST",
		url:"ControladorTraerAuditorio",
		data:{tipo:tipoEvento},
		async:true
	}).done(function (data){
	    populateSelect('selectAuditorioCine',JSON.parse(data),false)
	})
});

$("#tabTeatro").click(function() {
	clearPage();
	tipoEvento=2
	//leno select auditorio
	$.ajax({
		method:"POST",
		url:"ControladorTraerAuditorio",
		data:{tipo:tipoEvento},
		async:true
	}).done(function (data){
	    populateSelect('selectAuditorioCine',JSON.parse(data),false)
	})
});

$("#tabConcierto").click(function() {
	clearPage();
	tipoEvento=1
	//leno select auditorio
	$.ajax({
		method:"POST",
		url:"ControladorTraerAuditorio",
		data:{tipo:1},
		async:true
	}).done(function (data){
	    populateSelect('selectAuditorioCine',JSON.parse(data),false)
	})
});

function clearPage(){
	
	 $("#tablaAsientos tr").remove();
    $("#divPopular").addClass("d-none")
    $("#cantidadEntradas tr").val(0);
    $('#selectFuncionCine').val('')
    $('#selectSector').val('')
    $('#selectEventoCine').val('')
    totalFinal=0
    arrayButacasCine=[];
	$('#labelPrecioTotal').text(0);
	$('#valorEntrada').text(0);

}

$("#labelUserName").click(function() {
	alertify.confirm('¿Desea cerrar la session?',function(){ 
		sessionStorage.setItem("userId",0);
		window.location.replace("login.jsp");
	});
})
