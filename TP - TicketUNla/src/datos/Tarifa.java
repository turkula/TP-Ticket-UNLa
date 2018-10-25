package datos;

public class Tarifa {
	private int idTarifa;
	private float precio;
	private Sector sector;
	private Funcion funcion;
	
	public Tarifa() {
		super();
	}
	public Tarifa(float precio,Sector sector,Funcion funcion) {
		super();
		this.precio = precio;
		this.sector = sector;
		this.funcion = funcion;
	}
	public int getIdTarifa() {
		return idTarifa;
	}
	protected void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	@Override
	public String toString() {
		return "Tarifa{" +
				"idTarifa=" + idTarifa +
				", precio=" + precio +
				", sector=" + sector +
				", funcion=" + funcion +
				'}';
	}
}
