package datos;

public class Popular extends Sector{
	private int cantidadMaxima;

	public Popular() {
		super();
	}

	public Popular(String descripcion,Auditorio auditorio,int cantidadMaxima) {
		super(descripcion,auditorio);
		this.cantidadMaxima = cantidadMaxima;
	}

	public int getCantidadMaxima() {
		return cantidadMaxima;
	}

	public void setCantidadMaxima(int cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}

	@Override
	public String toString() {
		return "Popular{" +
				"cantidadMaxima=" + cantidadMaxima +
				"} " + super.toString();
	}
}
