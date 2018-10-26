package datos;

public class TipoAuditorio {
	private int idTipoAuditorio;
	private String nombre;
	public TipoAuditorio(){};

	public TipoAuditorio(String nombre) {
		super();
		this.nombre = nombre;
	}
	public int getIdTipoAuditorio() {
		return idTipoAuditorio;
	}
	public void setIdTipoAuditorio(int idTipoAuditorio) {
		this.idTipoAuditorio = idTipoAuditorio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "TipoAuditorio [idTipoAuditorio=" + idTipoAuditorio + ", nombre=" + nombre + "]";
	}
	
	
}
