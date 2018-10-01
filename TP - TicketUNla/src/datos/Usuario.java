package datos;

public class Usuario {
	private int idUsuario;
	private String nombreUsuario;
	private String clave;
	
	public Usuario() {
		
	}

	public Usuario(String nombreUsuario, String clave) { 
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
//SIEMPRE VA PROTECTED PARA QUE NO SEA MODIFICADO
	protected void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", clave=" + clave + "]";
	}	
	
}
