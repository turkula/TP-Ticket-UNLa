package datos;

public class Popular extends Sector{
	private int cantidadMaxima;


	public Popular(String descripcion, int cantidadMaxima) {
		super(descripcion);
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
		return "Popular [cantidadMaxima=" + cantidadMaxima + "]";
	}
}
