var arrayButacasCine = []

var complejo1 = {
    id:1,
    nombre:"Cine Avellaneda",
    cantidadFilas:8,
    cantidadColumnas:12,
    eventos:[{
                id:1,
                nombre:"Esperando la carroza",
                funciones:[{
                            id:1,
                            nombre:"18/10 - 18:00hs",
                            butacasOcupadas:[]
                        },
                        {
                        id:2,
                        nombre:"18/10 - 20:00hs",
                        butacasOcupadas:[]
                    }]
            },
            {
                id:2,
                nombre:"El secreto de sus Ojos",
                funciones:[{
                            id:1,
                            nombre:"18/10 - 18:00hs",
                            butacasOcupadas:[]
                        },
                        {
                        id:2,
                        nombre:"18/10 - 20:00hs",
                        butacasOcupadas:[]
                    }]
            }]
}

var complejo2 = {
    id:2,
    nombre:"Cine Rosario",
    cantidadFilas:5,
    cantidadColumnas:5,
    eventos:[{
                id:1,
                nombre:"La llamada",
                funciones:[{
                            id:1,
                            nombre:"18/10 - 18:00hs",
                            butacasOcupadas:[]
                        },
                        {
                        id:2,
                        nombre:"18/10 - 20:00hs",
                        butacasOcupadas:[]
                    }]
            },
            {
                id:2,
                nombre:"Okupas",
                funciones:[{
                            id:1,
                            nombre:"18/10 - 18:00hs",
                            butacasOcupadas:[]
                        },
                        {
                        id:2,
                        nombre:"18/10 - 20:00hs",
                        butacasOcupadas:[]
                    }]
            }]
}

arrayComplejos=[complejo1,complejo2]

$( document ).ready(function() {
    populateSelect('selectAuditorioCine',arrayComplejos,false)
})

//fill selet pelicula
$( "#selectAuditorioCine" ).change(function() {
    $("#tablaAsientos tr").remove(); 
    $('#selectFuncionCine').val('')
    var idComplejo = $('#selectAuditorioCine').val();
    populateSelect('selectEventoCine',arrayComplejos[idComplejo-1].eventos,false);
  });

  $( "#selectEventoCine" ).change(function() {
    $("#tablaAsientos tr").remove();
    var idComplejo = $('#selectAuditorioCine').val();
    var idPelicula = $('#selectEventoCine').val();
    populateSelect('selectFuncionCine',arrayComplejos[idComplejo-1].eventos[idPelicula-1].funciones,false);
  });

  $( "#selectFuncionCine" ).change(function() {
    $("#tablaAsientos tr").remove();
    var idComplejo = $('#selectAuditorioCine').val();
    var idPelicula = $('#selectEventoCine').val();
    var idFuncion = $('#selectFuncionCine').val();

    var cantFilas = arrayComplejos[idComplejo-1].cantidadFilas
    var cantColumnas = arrayComplejos[idComplejo-1].cantidadColumnas
    var butacasOcupadas = arrayComplejos[idComplejo-1].eventos[idPelicula-1].funciones[idFuncion-1].butacasOcupadas

    hacerGrilla(cantFilas,cantColumnas,butacasOcupadas);
  });


$('#btnLogin').click(function(){

    var data = {
        user:$('#user').val(),
        pass:$('#password').val()
    }

    // console.log(data);
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

function hacerGrilla(filas,columnas,arrayButacasOcupadas){
    console.log(arrayButacasOcupadas);
    var grilla = '<table>'
    var numeracion = 0;
    for (i = 1; i <= filas; i++) {
        grilla+='<tr>'
        for(y=1;y<=columnas;y++){
            numeracion++

            // PINTO BUTACAS OCUPADAS DE ROJO
            color="";
            arrayButacasOcupadas.forEach(function(element){
                // console.log(element);
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

$('#btnReservar').click(function(){
    if(arrayButacasCine.length<=0){
        alertify.alert("Por favor seleccione una butaca");
    }

    var idComplejo = $('#selectAuditorioCine').val();
    var idPelicula = $('#selectEventoCine').val();
    var idFuncion = $('#selectFuncionCine').val();
    var butacasOcupadas = arrayComplejos[idComplejo-1].eventos[idPelicula-1].funciones[idFuncion-1].butacasOcupadas

    butacasOcupadas=butacasOcupadas.concat(arrayButacasCine);
    console.log(arrayButacasCine);
    console.log(butacasOcupadas);
    $("#tablaAsientos tr").remove();


    var cantFilas = arrayComplejos[idComplejo-1].cantidadFilas
    var cantColumnas = arrayComplejos[idComplejo-1].cantidadColumnas

    hacerGrilla(cantFilas,cantColumnas,butacasOcupadas);

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