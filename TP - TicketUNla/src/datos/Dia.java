package datos;

import java.time.LocalTime;

public class Dia extends Descuento{
	private LocalTime dia;

	public Dia() {
		super();
	}

	public Dia(LocalTime dia) {
		super();
		this.dia = dia;
	}

	public LocalTime getDia() {
		return dia;
	}

	public void setDia(LocalTime dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return "Dia [dia=" + dia + "]";
	}
	
	
	
	
}
