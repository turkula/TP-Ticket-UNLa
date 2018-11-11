package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import dao.FuncionDao;
import datos.Descuento;
import datos.Evento;
import datos.Funcion;
import datos.Tarifa;

public class FuncionABM {
	
	public class FuncionX {
		public int id;
		public String nombre;
		
		public FuncionX(int id,String nombre){
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
	FuncionDao dao = new FuncionDao();

	public Funcion traerFuncion(int idFuncion) throws Exception {
		Funcion f = dao.traerfuncion(idFuncion);
		if (f == null)
			throw new Exception("Error: el Funcion no existe");
		return f;
	}


	public int agregar(String descripcion, GregorianCalendar fechaHora, Evento evento, Set<Tarifa> tarifas, Set<Descuento> descuentos) throws Exception{

			Funcion f = new Funcion(descripcion, fechaHora, evento, tarifas, descuentos);
			return dao.agregar(f);
		}
	

	public void modificar(Funcion f)throws Exception {
		dao.actualizar(f);
	}

	public void eliminar(int idFuncion) { 
		Funcion f = dao.traerfuncion(idFuncion);
		// Implementar que si es null que arroje la excepci�n la Excepci�n
		dao.eliminar(f);
	}

	public List<Funcion> traerFuncionPorEventos(int idEvento) throws Exception {
		List<Funcion> e = dao.traerFuncionPorEvento(idEvento);
		if (e == null)
			throw new Exception("Error: la Funcion no existe");
		return e;
	}	
	
	public List<FuncionX> traerFuncionPorEventosX(int idEvento)throws Exception{
		List<Funcion> funciones = traerFuncionPorEventos(idEvento);
		List<FuncionX> listaFunciones= new ArrayList<FuncionX>();
		
		for(Funcion funcion: funciones){
			FuncionX x=new FuncionX(funcion.getIdFuncion(),funcion.getDescripcion());
			listaFunciones.add(x);
		}
		
		return listaFunciones;
	}

}
