package datos;

import java.time.LocalTime;

public class Dia extends Descuento{
	private int id;
	private LocalTime dia;

	public Dia() {}

	public Dia(int porcentaje,Sector sector,LocalTime dia) {
		super(porcentaje,sector);
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
