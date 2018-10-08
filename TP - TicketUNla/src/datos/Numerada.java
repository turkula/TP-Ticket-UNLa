package datos;

import java.util.Set;

public class Numerada extends Sector{
	private Set<Butaca>butacas;

	public Numerada() {
		super();
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
