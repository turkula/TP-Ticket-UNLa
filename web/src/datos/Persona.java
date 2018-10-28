package datos;

public class Persona {
	private int idPersona;
	private String nombre;
	private String apellido;
	private int dni;

	
	public Persona() {
		
	}

	public Persona(String nombre, String apellido, int dni, Usuario usuario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;

	}

	public int getIdPersona() {
		return idPersona;
	}

	protected void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}


	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ "]";
	}
	
	

}
