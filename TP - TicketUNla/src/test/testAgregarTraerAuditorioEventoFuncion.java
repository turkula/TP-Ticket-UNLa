package test;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.FuncionDao;
import funciones.Funciones;
import negocio.AuditorioABM;
import negocio.EventoABM;
import negocio.FuncionABM;
import datos.Tarifa;
import datos.Auditorio;
import datos.Descuento;
import datos.Evento;
import datos.Funcion;
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
/*		
		Evento evento = evenabm.traerEventoCompleto(1);
		System.out.println(evento);
		evenabm.agregar("Indio Solari", evento.getTipoEvento(), evento.getFunciones(), evento.getAuditorio());
*/	
		//TRAER Y AGREGAR AUDITORIO
	
		Auditorio auditorio = audabm.traerAuditorio(1);
		auditorio= audabm.traerAuditorioCompleto(1);
		System.out.println(auditorio);
 
		List<Object> auditoriosXtipo = audabm.traerAuditoriosPorTipo(2);
		for(Object lista: auditoriosXtipo){
			System.out.println(lista);
		}
	
		auditoriosXtipo = audabm.traerAuditoriosPorTipoDeEvento(2);
		for(Object lista: auditoriosXtipo){
			System.out.println(lista);
		}
	
	}
	

}
