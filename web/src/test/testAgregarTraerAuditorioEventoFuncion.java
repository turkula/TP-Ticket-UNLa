package test;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.FuncionDao;
import funciones.Funciones;
import negocio.AuditorioABM;
import negocio.ButacaABM;
import negocio.EventoABM;
import negocio.FuncionABM;
import negocio.SectorABM;
import negocio.TicketABM;
import datos.Tarifa;
import datos.Auditorio;
import datos.Butaca;
import datos.Descuento;
import datos.Evento;
import datos.Funcion;
import datos.Sector;
import datos.TipoAuditorio;

public class testAgregarTraerAuditorioEventoFuncion {

	public static void main(String[] args) throws Exception {

		/*
		String descripcion= "Fito Paez";
		GregorianCalendar fecha= Funciones.traerFecha(2018,20,10);
		Set<Tarifa> tarifas =new HashSet<Tarifa>(); 
		Set<Descuento> descuentos = new HashSet<Descuento>();
		Evento evento= new Evento();
		*/
		FuncionABM funabm= new FuncionABM();
		EventoABM evenabm = new EventoABM();
		AuditorioABM audabm = new AuditorioABM();
		SectorABM secabm = new SectorABM();
		ButacaABM butabm =new ButacaABM();
		TicketABM tiabm =new TicketABM();
		
/*
		int ultimoIdFuncion = funabm.agregar( descripcion,fecha,evento,tarifas,descuentos);
		System.out.println(ultimoIdFuncion);
*/
/*

 
  //    TRAER Y AGREGAR FUNCION
		
		Funcion funcion = funabm.traerFuncion(2);
		System.out.println(funcion);
		funcion.setFechaHora(Funciones.traerFecha(2018, 10, 24));
		FuncionDao fDao = new FuncionDao();
		fDao.agregar(funcion);
*/
		// TRAER Y AGREGAR EVENTO
		
//		Evento evento = evenabm.traerEventoCompleto(1);
//		System.out.println(evento);
//		evenabm.agregar("Indio Solari", evento.getTipoEvento(), evento.getFunciones(), evento.getAuditorio());
	

		List<Evento> eventos = evenabm.traerEventoPorAuditorioYTipoEvento(3, 4);
		System.out.println(eventos);		
			
		
		//TRAER Y AGREGAR AUDITORIO
	
//		Auditorio auditorio = audabm.traerAuditorio(1);
//		auditorio= audabm.traerAuditorioCompleto(1);
//		System.out.println(auditorio);
 
//		List<Auditorio> auditoriosXtipo = audabm.traerAuditoriosPorTipo(2);
//		for(Object lista: auditoriosXtipo){
//			System.out.println(lista);
//		}
//		Object auditorioOut=audabm.traerAuditorio(1);
//		System.out.println(auditorioOut.toString());

//		auditoriosXtipo = audabm.traerAuditoriosPorTipoDeEvento(2);
//		for(Object lista: auditoriosXtipo){
//			System.out.println(lista);
//		}
		/*
		Auditorio auditorio2= (Auditorio) auditoriosXtipo.get(0);

		Set<Evento> eventos= (Set<Evento>) auditorio2.getEventos();
		
 		for(Evento lista: eventos){
			System.out.println(lista);
		}
	
		System.out.println(eventos);
		*/

		//TRAER SECTORES Y BUTACAS POR AUDITORIO
		
//		List<Sector> sectores = secabm.traerSectoresPorAuditorio(1);
//		for(Sector s: sectores) {
//			System.out.println(s);
//		}
//		
//		List<Butaca> butacas = butabm.traeButacas(sectores.get(1));
//		for(Butaca b: butacas) {
//			System.out.println(b);
//		}
//		
//		butacas = tiabm.traerButacasXfuncionYSector(1, 2);
//		for(Butaca b: butacas) {
//			System.out.println(b);
//		}
		
	}

}
