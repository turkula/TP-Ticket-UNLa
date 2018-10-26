package datos;

import java.util.GregorianCalendar;

public class Cliente extends Usuario {
	private int idCliente;
	private TipoCliente tipo;
	private GregorianCalendar fechaNacimiento;

	public Cliente() {
	};



	public Cliente(String nombreUsuario, String clave, Persona persona, TipoCliente tipo,
			GregorianCalendar fechaNacimiento) {
		super(nombreUsuario, clave, persona);
		this.tipo = tipo;
		this.fechaNacimiento = fechaNacimiento;
	}
	
<<<<<<< HEAD
=======
//	
>>>>>>> 307babe4fe03843a33336b03882dd24839994f04

	public int getIdCliente() {
		return idCliente;
	}

<<<<<<< HEAD
	protected void setIdCliente(int idCliente) {
=======


	public void setIdCliente(int idCliente) {
>>>>>>> 307babe4fe03843a33336b03882dd24839994f04
		this.idCliente = idCliente;
	}



	public TipoCliente getTipoCliente() {
		return tipo;
	}

	public void setTipoCliente(TipoCliente tipo) {
		this.tipo = tipo;
	}

	public GregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Cliente [tipo=" + tipo + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
