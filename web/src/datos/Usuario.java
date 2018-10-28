package datos;

public class Usuario {
	private int idUsuario;
	private String nombreUsuario;
	private String clave;
	private Persona persona;
	
	public Usuario() {
		
	}


	public Usuario(String nombreUsuario, String clave, Persona persona) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.persona = persona;
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
	
	

	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", clave=" + clave
				+ ", persona=" + persona + "]";
	}


	
}
