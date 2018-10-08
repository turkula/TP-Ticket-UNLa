package datos;

public class Butaca {
	private int idButaca;
	private int fila;
	private int columna;
	
	public Butaca() {
		super();
	}

	public Butaca(int fila, int columna) {
		super();
		this.fila = fila;
		this.columna = columna;
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

	@Override
	public String toString() {
		return "Butaca [fila=" + fila + ", columna=" + columna + "]";
	}
	
	
}
