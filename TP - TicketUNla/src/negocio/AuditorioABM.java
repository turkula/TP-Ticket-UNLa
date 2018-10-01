package negocio;

import java.util.Set;

import dao.AuditorioDao;
import datos.Auditorio;

import datos.Evento;
import datos.Sector;



public class AuditorioABM {
	AuditorioDao dao = new AuditorioDao();

	public Auditorio traerAuditorio(int idAuditorio) throws Exception {
		Auditorio c = dao.traerAuditorio(idAuditorio);
		if (c == null)
			throw new Exception("Error: el Auditorio no existe");
		return c;
	}
	

	public int agregar(String nombre, TipoAuditorio tipo, Set<Evento> eventos, Set<Sector> sectores) throws Exception{

			Auditorio c = new Auditorio(nombre, tipo, eventos, sectores);
			return dao.agregar(c);
		}
	

	public void modificar(Auditorio c)throws Exception {
		dao.actualizar(c);
	}

	public void eliminar(int idAuditorio) { 
		Auditorio c = dao.traerAuditorio(idAuditorio);
		// Implementar que si es null que arroje la excepción la Excepción
		dao.eliminar(c);
	}
}
