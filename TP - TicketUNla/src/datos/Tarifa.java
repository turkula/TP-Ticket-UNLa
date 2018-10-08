package datos;

public class Tarifa {
	private int idTarifa;
	private float precio;
	private Sector sector;
	
	public Tarifa() {
		super();
	}
	public Tarifa(float precio, Sector sector) {
		super();
		this.precio = precio;
		this.sector = sector;
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
	@Override
	public String toString() {
		return "Tarifa [idTarifa=" + idTarifa + ", precio=" + precio + ", sector=" + sector + "]";
	}
	
	
	
	
	
	
}
