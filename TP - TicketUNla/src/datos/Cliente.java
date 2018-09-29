package datos;
import java.util.GregorianCalendar;

import enumerados.TipoCliente;
public class Cliente extends Usuario{
	private  TipoCliente tipo;
	private GregorianCalendar fechaNacimiento;
	
	
	
	public Cliente(String nombreUsuario, String clave, TipoCliente tipo, GregorianCalendar fechaNacimiento) {
		super(nombreUsuario, clave);
		this.tipo = tipo;
		this.fechaNacimiento = fechaNacimiento;
	}
	public TipoCliente getTipo() {
		return tipo;
	}
	public void setTipo(TipoCliente tipo) {
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
