package datos;

import java.util.Set;

public class Reserva {
	private int idReserva;
	private Cliente cliente;
	private int total;
	
	public Reserva() {};
	
	public Reserva(Cliente cliente, int total) {
		super();
		this.cliente = cliente;
		this.total = total;
	}

	public int getIdReserva() {
		return idReserva;
	}

	protected void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
