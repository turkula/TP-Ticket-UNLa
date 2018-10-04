var arrayButacasCine = []
var arrayButacasOcupadas = [1,55,10,4]


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
hacerGrilla(9,15,arrayButacasOcupadas)
 })


function hacerGrilla(filas,columnas,arrayButacasOcupadas){
    var grilla = '<table>'
    var numeracion = 0;
    for (i = 1; i <= filas; i++) {
        grilla+='<tr>'
        for(y=1;y<=columnas;y++){
            numeracion++

            // PINTO BUTACAS OCUPADAS DE ROJO
            color="";
            arrayButacasOcupadas.forEach(function(element){
                console.log(element);
                if(numeracion==element){
                    color="rojo";
                }
            })

            grilla+='<td><div id="butaca'+numeracion+'" class="circle text-center '+color+'" onclick=reservarButaca('+i+','+y+','+numeracion+')>'+numeracion+'</div></td>';
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
}