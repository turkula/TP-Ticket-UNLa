package datos;



public class Administrador extends Usuario{
	private int idAdministrador;
	private Auditorio auditorio;
	private TipoAdministrador tipo;

	public Administrador(){};
	
	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}


	public Administrador(String nombreUsuario, String clave, Persona persona, Auditorio auditorio,
			TipoAdministrador tipo) {
		super(nombreUsuario, clave, persona);
		this.auditorio = auditorio;
		this.tipo = tipo;
	}

	public Auditorio getAuditorio() {
		return auditorio;
	}

	public void setAuditorio(Auditorio auditorio) {
		this.auditorio = auditorio;
	}

	public TipoAdministrador getTipoAdministrador() {
		return tipo;
	}

	public void setTipoAdministrador(TipoAdministrador tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "Administrador [auditorio=" + auditorio + ", tipo=" + tipo + "]";
	}
	
	


	
	
	

}
