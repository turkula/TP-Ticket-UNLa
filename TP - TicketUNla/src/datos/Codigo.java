package datos;

public class Codigo extends Descuento{
	private String codigo;

	public Codigo() {
		super();
	}

	public Codigo(String codigo) {
		super();
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
