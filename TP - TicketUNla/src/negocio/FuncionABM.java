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
		Funcion f = dao.traerfuncion(idFuncion);
		if (f == null)
			throw new Exception("Error: el Funcion no existe");
		return f;
	}


	public int agregar( GregorianCalendar fechaHora, Evento evento, Set<Tarifa> tarifas, Set<Descuento> descuentos) throws Exception{

			Funcion f = new Funcion(fechaHora, evento, tarifas, descuentos);
			return dao.agregar(f);
		}
	

	public void modificar(Funcion f)throws Exception {
		dao.actualizar(f);
	}

	public void eliminar(int idFuncion) { 
		Funcion f = dao.traerfuncion(idFuncion);
		// Implementar que si es null que arroje la excepción la Excepción
		dao.eliminar(f);
	}


	


}
