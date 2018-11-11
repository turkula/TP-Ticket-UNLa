package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dao.AuditorioDao;
import datos.Auditorio;

import datos.Evento;
import datos.Sector;
import datos.TipoAuditorio;



public class AuditorioABM {
	public class AuditorioX {
		public int id;
		public String nombre;
		
		public AuditorioX(int id,String nombre){
			this.id=id;
			this.nombre=nombre;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		
	}
	
	
	AuditorioDao dao = new AuditorioDao();

	public Auditorio traerAuditorio(int idAuditorio) throws Exception {
		Auditorio a = dao.traerAuditorio(idAuditorio);
		if (a == null)
			throw new Exception("Error: el Auditorio no existe");
		return a;
	}
	

	public int agregar(String nombre, TipoAuditorio tipo, Set<Evento> eventos, Set<Sector> sectores) throws Exception{

			Auditorio a = new Auditorio(nombre, tipo, eventos, sectores);
			return dao.agregar(a);
		}
	

	public void modificar(Auditorio a)throws Exception {
		dao.actualizar(a);
	}

	public void eliminar(int idAuditorio) { 
		Auditorio a = dao.traerAuditorio(idAuditorio);
		// Implementar que si es null que arroje la excepci�n la Excepci�n
		dao.eliminar(a);
	}
	
	public Auditorio traerAuditorioCompleto(int idAuditorio) throws Exception {
		Auditorio a = dao.traerAuditorioCompleto(idAuditorio);
		if (a == null)
			throw new Exception("Error: el Auditorio no existe");
		return a;
	}
	
	
	public List<Auditorio> traerAuditoriosPorTipo(int idTipoAuditorio) throws Exception {
		List<Auditorio> a = dao.traerAuditoriosPorTipo(idTipoAuditorio);
		if (a == null)
			throw new Exception("Error: el Auditorio no existe");
		return a;
	}

	public List<AuditorioX> traerAuditoriosPorTipoX(int idTipoAuditorio) throws Exception {
		
		List<Auditorio> auditoriosXtipo = traerAuditoriosPorTipo(3);
		List<AuditorioX> listaAuditorios= new ArrayList<AuditorioX>();
		
		for(Auditorio auditorio: auditoriosXtipo){
			AuditorioX x=new AuditorioX(auditorio.getIdAuditorio(),auditorio.getNombre());
			listaAuditorios.add(x);
		}
		return listaAuditorios;
	}
	
//	public List<Object> traerAuditoriosPorTipoDeEvento(int idTipoEvento) throws Exception {
//		List<Object> a = dao.traerAuditoriosPorTipo(idTipoEvento);
//		if (a == null)
//			throw new Exception("Error: el Auditorio no existe");
//		return a;
//	}
}
