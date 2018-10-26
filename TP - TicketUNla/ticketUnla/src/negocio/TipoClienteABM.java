package negocio;

import dao.TipoClienteDao;
import datos.TipoCliente;

public class TipoClienteABM {

	TipoClienteDao dao = new TipoClienteDao();

	public TipoCliente traerTipoCliente(int idTipoCliente) throws Exception {
		TipoCliente tc = dao.traerTipoCliente(idTipoCliente);
		if (tc == null)
			throw new Exception("Error: el TipoAuditorio no existe");
		return tc;
	}
	

	public int agregar(String nombre) throws Exception{

			TipoCliente tc = new TipoCliente(nombre);
			return dao.agregar(tc);
		}
	

	public void modificar(TipoCliente tc)throws Exception {
		dao.actualizar(tc);
	}

	public void eliminar(int idTipoCliente) { 
		TipoCliente tc = dao.traerTipoCliente(idTipoCliente);
		// Implementar que si es null que arroje la excepción la Excepción
		dao.eliminar(tc);
	}
}
