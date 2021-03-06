package datos;

import java.util.Set;



public class Evento {
	private int idEvento;
	private String descripcion;
	private TipoEvento tipo;
	private Set<Funcion>funciones;
	private Auditorio auditorio;
	
	
	public Evento(String descripcion, TipoEvento tipo, Set<Funcion> funciones, Auditorio auditorio) {
		super();
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.funciones = funciones;
		this.auditorio = auditorio;
	}



	public Evento() {
		// TODO Auto-generated constructor stub
	}

	public int getIdEvento() {
		return idEvento;
	}

	protected void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoEvento getTipoEvento() {
		return tipo;
	}

	public void setTipoEvento(TipoEvento tipo) {
		this.tipo = tipo;
	}

	public Set<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(Set<Funcion> funciones) {
		this.funciones = funciones;
	}

	public Auditorio getAuditorio() {
		return auditorio;
	}

	public void setAuditorio(Auditorio auditorio) {
		this.auditorio = auditorio;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", descripcion=" + descripcion +    "]";
	}






}
