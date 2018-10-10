package test;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import funciones.Funciones;
import negocio.AuditorioABM;
import negocio.FuncionABM;
import negocio.TipoAuditorioABM;
import datos.Tarifa;
import datos.TipoAuditorio;
import datos.Descuento;
import datos.Evento;

public class testAgregarFuncion {

	public static void main(String[] args) throws Exception {

		String nombre= "Maipo";
		GregorianCalendar fecha= Funciones.traerFecha(2018,20,10);
		Set<Tarifa> tarifas =new HashSet<Tarifa>(); 
		Set<Descuento> descuentos = new HashSet<Descuento>();
		Evento evento= new Evento();
		FuncionABM abm= new FuncionABM();
		AuditorioABM auABM =new AuditorioABM();
		TipoAuditorioABM taABM=new TipoAuditorioABM();
		TipoAuditorio ta= taABM.traerTipoAuditorio(2);
		
		auABM.agregarSimple(nombre, ta);

		//int ultimoIdFuncion = abm.agregar( descripcion,fecha,evento,tarifas,descuentos);
		//System.out.println(ultimoIdFuncion);


		}
	

}
