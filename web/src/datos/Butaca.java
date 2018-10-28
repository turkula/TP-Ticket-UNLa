package datos;

public class Butaca {
	private int idButaca;
	private int fila;
	private int columna;
	private Sector sector;
	
	public Butaca() {
		super();
	}

	public Butaca(int fila, int columna,Sector sector) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.sector = sector;
	}

	public int getIdButaca() {
		return idButaca;
	}

	protected void setIdButaca(int idButaca) {
		this.idButaca = idButaca;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	@Override
	public String toString() {
		return "Butaca [fila=" + fila + ", columna=" + columna + "]";
	}
	
	
}
