package negocio;

import java.util.GregorianCalendar;
import java.util.Set;

import dao.EventoDao;


import datos.Evento;
import datos.Funcion;

import datos.Auditorio;
	

public class EventoABM {
	EventoDao dao = new EventoDao();

	public Evento traerEvento(int idEvento) throws Exception {
		Evento c = dao.traerEvento(idEvento);
		if (c == null)
			throw new Exception("Error: el Evento no existe");
		return c;
	}
	

	public int agregar(String descripcion, TipoEvento tipo, Evento evento, Set<Funcion> funciones, Auditorio auditorio) throws Exception{

			Evento c = new Evento(descripcion, tipo, funciones, auditorio);
			return dao.agregar(c);
		}
	

	public void modificar(Evento c)throws Exception {
		dao.actualizar(c);
	}

	public void eliminar(int idEvento) { 
		Evento c = dao.traerEvento(idEvento);
		// Implementar que si es null que arroje la excepción la Excepción
		dao.eliminar(c);
	}
}
