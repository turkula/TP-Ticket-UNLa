package datos;

import java.util.Set;

public class Sector {
	private int idSector;
	private String descripcion;
	private Auditorio auditorio;
	private int popularCantidadMaxima;
	private Set<Butaca> butacas;

	public Sector() {
		super();
	}

	public Sector(String descripcion,Auditorio auditorio,int popularCantidadMaxima) {
		super();
		this.auditorio = auditorio;
		this.popularCantidadMaxima = popularCantidadMaxima;
		this.descripcion = descripcion;
	}

	public Sector(String descripcion,Auditorio auditorio) {
		super();
		this.auditorio = auditorio;
		this.descripcion = descripcion;
	}

	public int getIdSector() {
		return idSector;
	}

	public void setIdSector(int idSector) {
		this.idSector = idSector;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Auditorio getAuditorio() {
		return auditorio;
	}

	public void setAuditorio(Auditorio auditorio) {
		this.auditorio = auditorio;
	}

	public int getPopularCantidadMaxima() {
		return popularCantidadMaxima;
	}

	public void setPopularCantidadMaxima(int popularCantidadMaxima) {
		this.popularCantidadMaxima = popularCantidadMaxima;
	}

	public Set<Butaca> getButacas() {
		return butacas;
	}

	public void setButacas(Set<Butaca> butacas) {
		this.butacas = butacas;
	}

	@Override
	public String toString() {
		return "Sector{" +
				"idSector=" + idSector +
				", descripcion='" + descripcion + '\'' +
//				", auditorio=" + auditorio +
				", popularCantidadMaxima=" + popularCantidadMaxima +
				'}';
	}
}
