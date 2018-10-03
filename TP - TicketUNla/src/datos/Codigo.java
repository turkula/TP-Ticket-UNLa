package datos;

public class Codigo extends Descuento{
	private int idCodigo;
	private String codigo;

	public Codigo() {}

	public Codigo(int porcentaje,String codigo) {
		super(porcentaje);
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Codigo [codigo=" + codigo + "]";
	}
	
	
	
	
}
