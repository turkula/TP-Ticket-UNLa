package negocio;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import dao.FuncionDao;
import datos.Descuento;
import datos.Evento;
import datos.Funcion;
import datos.Tarifa;

public class FuncionABM {
	FuncionDao dao = new FuncionDao();

	public Funcion traerFuncion(int idFuncion) throws Exception {
		Funcion c = dao.traerfuncion(idFuncion);
		if (c == null)
			throw new Exception("Error: el Funcion no existe");
		return c;
	}


	public int agregar(String descripcion, GregorianCalendar fechaHora, Evento evento, Set<Tarifa> tarifas, Set<Descuento> descuentos) throws Exception{

			Funcion c = new Funcion(descripcion, fechaHora, evento, tarifas, descuentos);
			return dao.agregar(c);
		}
	

	public void modificar(Funcion c)throws Exception {
		dao.actualizar(c);
	}

	public void eliminar(int idFuncion) { 
		Funcion c = dao.traerfuncion(idFuncion);
		// Implementar que si es null que arroje la excepción la Excepción
		dao.eliminar(c);
	}


	


}
