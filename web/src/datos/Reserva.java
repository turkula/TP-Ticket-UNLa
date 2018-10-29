package datos;

import java.util.Set;

public class Reserva {
	private int idReserva;
	private Set<Ticket>tickets; //modificar en el diagrama por ubicaciones ELIMINA CLASE UBICACION


	public Reserva() {
		super();
	}
	

	public Reserva(Set<Ticket> tickets) {
		super();
		this.tickets = tickets;
	}


	public int getIdReserva() {
		return idReserva;
	}

	protected void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	
	
	
	
}
