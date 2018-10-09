package datos;

import java.time.LocalTime;

public class Dia extends Descuento{
	private int id;
	private LocalTime dia;

	public Dia() {}

	public Dia(int porcentaje,LocalTime dia) {
		super(porcentaje);
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
