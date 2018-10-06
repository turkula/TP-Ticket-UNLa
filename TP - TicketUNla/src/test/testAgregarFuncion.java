package test;

import java.time.LocalTime;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import funciones.Funciones;
import negocio.AuditorioABM;
import negocio.FuncionABM;
import datos.Tarifa;
import datos.Descuento;
import datos.Evento;
import negocio.*;
import datos.*;
public class testAgregarFuncion {

	public static void main(String[] args) throws Exception {
/*
		String descripcion= "Fito Paez";
		GregorianCalendar fecha= Funciones.traerFecha(2018,20,10);
		Set<Tarifa> tarifas =new HashSet<Tarifa>(); 
		Set<Descuento> descuentos = new HashSet<Descuento>();
		Evento evento= new Evento();
		FuncionABM abm= new FuncionABM();

		int ultimoIdFuncion = abm.agregar( descripcion,fecha,evento,tarifas,descuentos);
		System.out.println(ultimoIdFuncion);
*/
		AuditorioABM auABM = new AuditorioABM();
		TipoAuditorioABM taABM = new TipoAuditorioABM();
		TipoAuditorio tipoau = taABM.traerTipoAuditorio(2);
		TipoEventoABM teABM = new TipoEventoABM();
		
		Set<Butaca> butacas =new HashSet<Butaca>();
		Butaca butaca =new Butaca(1,1);
		butacas.add(butaca);
		Numerada sector =new Numerada("Numerada1",butacas);
		
		Set<Sector> sectores = new HashSet<Sector>();
		sectores.add(sector);
		
		TipoEvento tipoeven = teABM.traerTipoEvento(2);
		Tarifa tarifa =new Tarifa(350,sector);
		Set<Tarifa> tarifas =new HashSet<Tarifa>();
		tarifas.add(tarifa);

		Codigo descuento =new Codigo(50,false,sector,"aa01");
		Set<Descuento> descuentos = new HashSet<Descuento>();
		descuentos.add(descuento);
		Evento evento2 =new Evento();
		Set<Evento> eventos2 =new HashSet<Evento>();
		eventos2.add(evento2);
		Funcion funcion = new Funcion(Funciones.traerFecha(2018, 10,11),evento2,tarifas,descuentos);
		Set<Funcion> funciones = new HashSet<Funcion>();
		funciones.add(funcion);
		TipoAuditorio tipoaud = taABM.traerTipoAuditorio(2);
		Auditorio auditorio =new Auditorio("Maipo",tipoaud,eventos2,sectores);
		Evento evento = new Evento("Gordo fovba",tipoeven,funciones,auditorio);
	
		
		auABM.agregar("Maipo",tipoaud,eventos2,sectores);
		}
	

}
