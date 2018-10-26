package negocio;

import java.util.Set;


import dao.TipoAuditorioDao;
import datos.Auditorio;


import datos.TipoAuditorio;

public class TipoAuditorioABM {
	TipoAuditorioDao dao = new TipoAuditorioDao();

	public TipoAuditorio traerTipoAuditorio(int idTipoAuditorio) throws Exception {
		TipoAuditorio ta = dao.traerTipoAuditorio(idTipoAuditorio);
		if (ta == null)
			throw new Exception("Error: el TipoAuditorio no existe");
		return ta;
	}
	

	public int agregar(String nombre) throws Exception{

			TipoAuditorio ta = new TipoAuditorio(nombre);
			return dao.agregar(ta);
		}
	

	public void modificar(TipoAuditorio ta)throws Exception {
		dao.actualizar(ta);
	}

	public void eliminar(int idTipoAuditorio) { 
		TipoAuditorio ta = dao.traerTipoAuditorio(idTipoAuditorio);
		// Implementar que si es null que arroje la excepción la Excepción
		dao.eliminar(ta);
	}
}
