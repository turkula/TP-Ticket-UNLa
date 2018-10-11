package test;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import funciones.Funciones;
import negocio.FuncionABM;
import datos.Tarifa;
import datos.Descuento;
import datos.Evento;

public class testAgregarFuncion {

	public static void main(String[] args) throws Exception {

		String descripcion= "Fito Paez";
		GregorianCalendar fecha= Funciones.traerFecha(2018,20,10);
		Set<Tarifa> tarifas =new HashSet<Tarifa>(); 
		Set<Descuento> descuentos = new HashSet<Descuento>();
		Evento evento= new Evento();
		FuncionABM abm= new FuncionABM();

		int ultimoIdFuncion = abm.agregar( descripcion,fecha,evento,tarifas,descuentos);
		System.out.println(ultimoIdFuncion);


		}
	

}
