package datos;

import enumerados.TipoAdministrador;


public class Administrador extends Usuario{
	private Auditorio auditorio;
	private TipoAdministrador tipo;
	
	public Administrador(String nombreUsuario, String clave, Auditorio auditorio, TipoAdministrador tipo) {
		super(nombreUsuario, clave);
		this.auditorio = auditorio;
		this.tipo = tipo;
	}

	public Auditorio getAuditorio() {
		return auditorio;
	}

	public void setAuditorio(Auditorio auditorio) {
		this.auditorio = auditorio;
	}

	public TipoAdministrador getTipo() {
		return tipo;
	}

	public void setTipo(TipoAdministrador tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Administrador [auditorio=" + auditorio + ", tipo=" + tipo + "]";
	}
	
	


	
	
	

}
