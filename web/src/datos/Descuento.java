package datos;

public class Descuento {
	private int idDescuento;
	private int porcentaje;
	private boolean usado;
	private Sector sector;

	
	public Descuento() { }

	public Descuento(int porcentaje,Sector sector) {
		super();
		this.porcentaje = porcentaje;
		this.usado = false;
		this.sector = sector;
	}

	public int getIdDescuento() {
		return idDescuento;
	}

	protected void setIdDescuento(int idDescuento) {
		this.idDescuento = idDescuento;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	@Override
	public String toString() {
		return "Descuento [idDescuento=" + idDescuento + ", porcentaje=" + porcentaje + ", usado=" + usado + "]";
	}
	
	
	

}
