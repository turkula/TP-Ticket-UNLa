package datos;

public class TipoAdministrador {
	private int idTipoAdministrador;
	private String nombre;
	public TipoAdministrador(String nombre) {
		super();
		this.nombre = nombre;
	}
	public int getIdTipoAdministrador() {
		return idTipoAdministrador;
	}
	public void setIdTipoAdministrador(int idTipoAdministrador) {
		this.idTipoAdministrador = idTipoAdministrador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "TipoAdministrador [idTipoAdministrador=" + idTipoAdministrador + ", nombre=" + nombre + "]";
	}
	
	
}
