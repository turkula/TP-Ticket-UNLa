package datos;

public class TipoEvento {
	private int idTipoEvento;
	private String nombre;
	public TipoEvento(String nombre) {
		super();
		this.nombre = nombre;
	}
	public int getIdTipoEvento() {
		return idTipoEvento;
	}
	public void setIdTipoEvento(int idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "TipoEvento [idTipoEvento=" + idTipoEvento + ", nombre=" + nombre + "]";
	}
	
	
}
