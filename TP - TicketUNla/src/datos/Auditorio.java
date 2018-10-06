package datos;

import java.util.Set;



public class Auditorio {
	private int idAuditorio;
	private String nombre;
	private TipoAuditorio tipo;
	private Set<Evento>eventos;
	private Set<Sector>sectores;
	
	public Auditorio(String nombre, TipoAuditorio tipo, Set<Evento> eventos, Set<Sector> sectores) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.eventos = eventos;
		this.sectores = sectores;
	}

	public int getIdAuditorio() {
		return idAuditorio;
	}

	public void setIdAuditorio(int idAuditorio) {
		this.idAuditorio = idAuditorio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoAuditorio getTipo() {
		return tipo;
	}

	public void setTipo(TipoAuditorio tipo) {
		this.tipo = tipo;
	}

	public Set<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

	public Set<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(Set<Sector> sectores) {
		this.sectores = sectores;
	}

	@Override
	public String toString() {
		return "Auditorio [idAuditorio=" + idAuditorio + ", nombre=" + nombre + ", tipo=" + tipo + ", eventos="
				+ eventos + ", sectores=" + sectores + "]";
	}
	
	

	
	
}
