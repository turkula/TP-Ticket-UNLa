$('#btnLogin').click(function(){

    var data = {
        user:$('#user').val(),
        pass:$('#password').val()
    }

    console.log(data);
} )

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

$('#prueba').click(function(){
hacerGrilla(5,15)
 })

function hacerGrilla(filas,columnas){
    var grilla = '<table>'
    var numeracion = 0;
    for (i = 1; i <= filas; i++) {
        grilla+='<tr>'
        for(y=1;y<=columnas;y++){
            numeracion++
            grilla+='<td><div id="butaca'+numeracion+'" class="circle text-center" onclick=reservarButaca('+i+','+y+','+numeracion+')>'+numeracion+'</div></td>';
        }
        grilla+='</tr>'
    }
    grilla+='</table>'

    $('#tablaAsientos').append(grilla);
}


function reservarButaca(fila,columna,id){4
    //verifico si ya esta reservada
    if(!$( "#butaca"+id ).is( ".rojo" )){
        // verifico si ya fue seleccionda
      if($( "#butaca"+id ).is( ".verde" )){
        $('#butaca'+id).removeClass('verde');
      }else{
          $('#butaca'+id).addClass('verde');
      }  
    }
}