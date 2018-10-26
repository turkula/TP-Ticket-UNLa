package negocio;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import dao.EventoDao;


import datos.Evento;
import datos.Funcion;
import datos.TipoEvento;
import datos.Auditorio;
	

public class EventoABM {
	EventoDao dao = new EventoDao();

	public Evento traerEvento(int idEvento) throws Exception {
		Evento e = dao.traerEvento(idEvento);
		if (e == null)
			throw new Exception("Error: el Evento no existe");
		return e;
	}
	

	public int agregar(String descripcion, TipoEvento tipo, Set<Funcion> funciones, Auditorio auditorio) throws Exception{

			Evento e = new Evento(descripcion, tipo, funciones, auditorio);
			return dao.agregar(e);
		}
	

	public void modificar(Evento e)throws Exception {
		dao.actualizar(e);
	}

	public void eliminar(int idEvento) { 
		Evento e = dao.traerEvento(idEvento);
		// Implementar que si es null que arroje la excepción la Excepción
		dao.eliminar(e);
	}


		public Evento traerEventoCompleto(int idEvento) throws Exception {
			Evento e = dao.traerEventoCompleto(idEvento);
			if (e == null)
				throw new Exception("Error: el Evento no existe");
			return e;
		}	
	
		public List<Evento> traerEventoPorAuditorioYTipoEvento(int idTipoEvento, int idAuditorio) throws Exception {
			List<Evento> e = dao.traerEventoPorAuditorioYTipoEvento(idTipoEvento, idAuditorio);
			if (e == null)
				throw new Exception("Error: el Evento no existe");
			return e;
		}	
}
