package negocio;

import dao.TipoEventoDao;
import datos.TipoEvento;

public class TipoEventoABM {
	TipoEventoDao dao = new TipoEventoDao();

	public TipoEvento traerTipoEvento(int idTipoEvento) throws Exception {
		TipoEvento te = dao.traerTipoEvento(idTipoEvento);
		if (te == null)
			throw new Exception("Error: el TipoEvento no existe");
		return te;
	}
	

	public int agregar(String nombre) throws Exception{

			TipoEvento te = new TipoEvento(nombre);
			return dao.agregar(te);
		}
	

	public void modificar(TipoEvento te)throws Exception {
		dao.actualizar(te);
	}

	public void eliminar(int idTipoEvento) { 
		TipoEvento te = dao.traerTipoEvento(idTipoEvento);
		// Implementer que si es null que arroje la excepción la Excepción
		dao.eliminar(te);
	}
}
