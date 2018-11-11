package datos;

public class AuxiliaresX {
	public class SectorX {
		public int id;
		public String nombre;
		public int capacidad;
		
		public SectorX(int id,String nombre,int capacidad){
			this.id=id;
			this.nombre=nombre;
			this.capacidad=capacidad;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getCapacidad() {
			return capacidad;
		}
			
	}
	
	public class ButacaX{
		public int id;
		public int fila;
		public int columna;
		
		public ButacaX(int id, int fila, int columna) {
			super();
			this.id = id;
			this.fila = fila;
			this.columna = columna;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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
	}
}
