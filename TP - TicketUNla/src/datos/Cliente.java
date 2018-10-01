package datos;

import java.util.GregorianCalendar;
public class Cliente extends Usuario{
	private enum tipoCliente{ESTUDIANTE,NORMAL, JUBILADO};
	private GregorianCalendar fechaNacimiento;
	
	public Cliente() {
		
	}
	public Cliente(GregorianCalendar fechaNacimiento) {
		super();
		this.fechaNacimiento = fechaNacimiento;
	}
	public GregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
	
}
