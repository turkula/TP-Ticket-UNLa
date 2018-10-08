package datos;

public class Ticket {
	private int idTicket;
	private Cliente cliente;
	private Funcion funcion;
	private Sector sector;
	private Butaca butaca;
	
	public Ticket() {
		super();
	}

	public Ticket(Cliente cliente, Funcion funcion, Sector sector, Butaca butaca) {
		super();
		this.cliente = cliente;
		this.funcion = funcion;
		this.sector = sector;
		this.butaca = butaca;
	}

	public int getIdTicket() {
		return idTicket;
	}

	protected void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", cliente=" + cliente + ", funcion=" + funcion + ", sector=" + sector
				+ ", butaca=" + butaca + "]";
	}
	
	
	
	
}
