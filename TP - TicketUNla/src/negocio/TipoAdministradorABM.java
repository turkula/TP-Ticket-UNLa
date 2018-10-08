package negocio;

import dao.TipoAdministradorDao;
import datos.TipoAdministrador;


public class TipoAdministradorABM {

	TipoAdministradorDao dao = new TipoAdministradorDao();

	public TipoAdministrador traerTipoAdministrador(int idTipoAdministrador) throws Exception {
		TipoAdministrador tad = dao.traerTipoAdministrador(idTipoAdministrador);
		if (tad == null)
			throw new Exception("Error: el TipoAuditorio no existe");
		return tad;
	}
	

	public int agregar(String nombre) throws Exception{

			TipoAdministrador tad = new TipoAdministrador(nombre);
			return dao.agregar(tad);
		}
	

	public void modificar(TipoAdministrador tad)throws Exception {
		dao.actualizar(tad);
	}

	public void eliminar(int idTipoAdministrador) { 
		TipoAdministrador tad = dao.traerTipoAdministrador(idTipoAdministrador);
		// Implementar que si es null que arroje la excepción la Excepción
		dao.eliminar(tad);
	}
	
}
