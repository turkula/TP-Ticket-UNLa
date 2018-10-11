package datos;

public class Sector {
	private int idSector;
	private String descripcion;


	public Sector() {
		super();
	}

	public Sector(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public int getIdSector() {
		return idSector;
	}

	protected void setIdSector(int idSector) {
		this.idSector = idSector;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Sector [idSector=" + idSector + ", descripcion=" + descripcion + "]";
	}

}
