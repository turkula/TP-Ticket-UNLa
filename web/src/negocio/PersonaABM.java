package negocio;
import java.util.GregorianCalendar;
import java.util.List;

import dao.PersonaDao;
import datos.Persona;
import datos.Usuario;

public class PersonaABM {
	PersonaDao dao = new PersonaDao();
	
	public Persona traerPersona(int idPersona)throws Exception{
	Persona p= dao.traerPersona(idPersona);
	if (p == null) throw new Exception("Error: el Auditorio no existe");
	return p;
	}
	
	public int agregar(String nombre, String apellido, int dni, Usuario usuario)throws Exception{
			// consultar si existe un cliente con el mismo dni , si existe arrojar la Excepcion
		Persona p = new Persona(nombre, apellido, dni, usuario);
		return dao.agregar(p);

	}	
	
	public void modificar(Persona p)throws Exception {
		dao.actualizar(p);
	}
	
	public void eliminar(int idPersona)throws Exception { 
		Persona p = dao.traerPersona(idPersona);
		// Implementar que si es null que arroje la excepción la Excepción
		if (p == null)
			throw new Exception("Error: La persona no existe");
		dao.eliminar(p);
	}
	
	
	
}
	
	
	
