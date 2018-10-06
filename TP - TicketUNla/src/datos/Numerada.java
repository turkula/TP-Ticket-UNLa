package datos;

import java.util.Set;

public class Numerada extends Sector{
	private Set<Butaca>butacas;



	public Numerada(String descripcion, Set<Butaca> butacas) {
		super(descripcion);
		this.butacas = butacas;
	}

	public Set<Butaca> getButacas() {
		return butacas;
	}

	public void setButacas(Set<Butaca> butacas) {
		this.butacas = butacas;
	}

	@Override
	public String toString() {
		return "Numerada [butacas=" + butacas + "]";
	}
	
}
