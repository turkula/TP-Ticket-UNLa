<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Ticket Unla</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="public/bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="css/main.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="public/alertify/alertify.css" />
<!--         <link rel="stylesheet" type="text/css" media="screen" href="../public/font-awesome/css/font-awesome.min.css" />     -->
        <link rel="stylesheet"  type="text/css" media="screen" href="public/font-awesome/css/all.css" >
    
    <link rel="icon" href="image/logo-UNLa.jpg">

</head>

<header>
    <div class="row form-group">
        <div class="col-2">
            <img src="image/logo-UNLa.jpg" alt="logoUNLa" height="100" width="100">
        </div>
        <div>
            <h1 class="text-center">Tickets UNLa</h1>
        </div>
    </div>
</header>

<body>
<div class="float-right">
	<a href="#"><i class="fas fa-user fa-1x"></i>
	<label id="labelUserName"></label></a><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
</div>
    <div class="container-fluid">
        <!-- TABS -->
        <div class="form-group">
            <ul class="nav nav-pills nav-fill" id="pills-tab" role="tablist">
                <li class="nav-item">
                <a class="nav-link active" data-toggle="pill" href="" id="tabCine" role="tab" aria-controls="tabCine" aria-selected="true">Cine</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" data-toggle="pill" href="" role="tab" id="tabTeatro" aria-controls="tabTeatro" aria-selected="false">Teatro</a>
                </li>
                <li class="nav-item">
                <a class="nav-link"  data-toggle="pill" href="" role="tab" id="tabConcierto" aria-controls="tabConcierto" aria-selected="false">Concieto</a>
                </li>
          </ul>
        </div>
        <div class="row ">
                  <div class="col-2"></div>
        <div class="card card-body ">
          <div class="tab-content" id="pills-tabContent">
                    <!-- CINE -->
                    <div class="tab-pane fade show active" id="tabCine" role="tabpanel" >
                        <form>
                            <div class="row">
                                <div class="form-group col-4">
                                        <label for="selectAuditorioCine">Seleccione un complejo</label>
                                        <select class="form-control" id="selectAuditorioCine">
                                        <option value="" >Seleccione</option>
                                        </select>
                                </div>
                                <div class="form-group col-4">
                                        <label for="selectEventoCine">Seleccione un evento</label>
                                        <select class="form-control" id="selectEventoCine">
                                        <option value="" >Seleccione</option>
                                        </select>
                                </div>   
                                <div class="form-group col-4">
                                        <label for="selectFuncionCine">Seleccione una funcion</label>
                                        <select class="form-control" id="selectFuncionCine">
                                        <option value="" >Seleccione</option>
                                        </select>
                                </div>
                            </div>
                            <div class="row">
                            <input id="flagTipoReserva" hidden/>
                                <div class="col-5">
                                    <div class="row ">
                                        
                                    </div>  
                                    <div class="row ">
                                    	<div class="form-group" >
                                            <div class="col ">
                                                    <label for="selectSector">Seleccione un sector:</label>
                                                    <select class="form-control" id="selectSector">
                                        		<option value="" >Seleccione</option>
                                        	</select>
                                            </div>
                                        </div>
<!--                                         <div > -->
<!--                                             <div class="col-5"> -->
<!--                                                     <label for="selectAuditorioCine">Ingrese Codigo de descuento(Opcional):</label> -->
<!--                                             </div> -->
<!--                                             <div class="input-group col-5 form-group"> -->
<!--                                                 <input type="text" class="form-control" placeholder="Codigo" name="codigoDescuento" id="codigoDescuento"> -->
<!--                                             </div> -->
<!--                                         </div> -->
                                    </div>
                                </div>
                                <div class="col-6 card card-body form-group">
                                    <h4 class="text-center">Seleccione las ubicaciones</h4>
                                    <table id="tablaAsientos" class="form-group">
                                    </table>
<!--                                     BOTON ENTRADAS POPULARES -->
                                    <div class="d-none" id="divPopular">
                                            <div class="col-5">
                                                    <label for="selectAuditorioCine">Cantidad de entradas:</label>
                                            </div>
                                            <div class="input-group col-5 form-group">
                                                <div class="input-group-prepend">
                                                    <button class="btn btn-outline-secondary" type="button" id="menosEntrada">-</button>
                                                </div>
                                                <input  id="cantidadEntradas" class="form-control text-center" value="0">
                                                <div class="input-group-append">
                                                        <button class="btn btn-outline-secondary" type="button" id="masEntrada">+</button>
                                                </div>
                                            </div>
                                            <label >Cantidad vendida:</label><label name ="labelVendida" id="labelVendida"></label>
                                            <label >Cantidad maxima del sector:</label><label name ="labelMaxima" id="labelMaxima"></label>
                                        </div> 
                                </div>
                            </div>
                            <label>Valor de entrada por persona: $</label><label id="valorEntrada"></label>
                            <div class="row">
                            	<label class="">Descuento: </label><label id="descuentoTipo"></label>
                            	<div class="col-6"></div>
	                            <div >
	                            	<label>TOTAL:$</label><label  id="labelPrecioTotal"></label>
	                            </div>
                            </div>
                        </form>
                        <button id="btnReservar" class="col-12 btn btn-primary form-group">Reservar</button>         
                    </div>
                                
                    <!-- TEATRO -->
                    <div class="tab-pane fade" id="tabTeatro" role="tabpanel" >
						<h1>AS1</h1>
                    </div>
                    
                    <!-- CONCIERTO -->
                    <div class="tab-pane fade" id="tabConcierto" role="tabpanel" >
						<h1>AS2</h1>
                    </div>
          </div>
          </div>
          <div class="col-2"></div>
           </div>
        
      </div>
</body>
<script src="public/jquery33/jquery.js"></script>
<script src="public/bootstrap/js/bootstrap.js"></script>
<script src="public/popper/popper.js"></script>
<script src="public/alertify/alertify.js"></script>
<script src="js/login.js"></script>
<script src="js/main.js"></script>
</html>