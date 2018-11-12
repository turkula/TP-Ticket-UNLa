package datos;

public class Ticket {
	private int idTicket;
	private Funcion funcion;
	private Sector sector;
	private Butaca butaca;
	private Reserva reserva;
	
	public Ticket() {
		super();
	}

	public Ticket( Funcion funcion, Sector sector, Butaca butaca,Reserva reserva) {
		super();
		this.funcion = funcion;
		this.sector = sector;
		this.butaca = butaca;
		this.reserva = reserva;
	}

	public int getIdTicket() {
		return idTicket;
	}

	protected void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}


	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public Butaca getButaca() {
		return butaca;
	}

	public void setButaca(Butaca butaca) {
		this.butaca = butaca;
	}
	
	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", funcion=" + funcion + ", sector=" + sector
				+ ", butaca=" + butaca + "]";
	}
	
	
	
	
}
