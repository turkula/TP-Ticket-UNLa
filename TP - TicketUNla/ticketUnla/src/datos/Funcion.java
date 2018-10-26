package datos;

import java.util.GregorianCalendar;
import java.util.Set;



public class Funcion {
	private int idFuncion;
	private String descripcion;
	private GregorianCalendar fechaHora;
	private Evento evento;
	private Set<Tarifa> tarifas;
	private Set<Descuento> descuentos;
	
	public Funcion() {
		
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Funcion(String descripcion, GregorianCalendar fechaHora, Evento evento, Set<Tarifa> tarifas,
			Set<Descuento> descuentos) {
		super();
		this.descripcion = descripcion;
		this.fechaHora = fechaHora;
		this.evento = evento;
		this.tarifas = tarifas;
		this.descuentos = descuentos;
	}

	public int getIdFuncion() {
		return idFuncion;
	}

	protected void setIdFuncion(int idFuncion) {
		this.idFuncion = idFuncion;
	}

	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Set<Tarifa> getTarifas() {
		return tarifas;
	}

	public void setTarifas(Set<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}

	public Set<Descuento> getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(Set<Descuento> descuentos) {
		this.descuentos = descuentos;
	}

	@Override
	public String toString() {
		return "Funcion [descripcion=" + descripcion + "]";
	}

	public void agregarTarifa(float precio,Sector sector,Funcion funcion){
		
	}


	




	
	
	
	
	
}
