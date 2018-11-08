package datos;

public class Codigo extends Descuento{
	private int idCodigo;
	private String codigo;

	public Codigo() {}

	public Codigo(int porcentaje,Sector sector,String codigo) {
		super(porcentaje,sector);
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

//	@Override
//	public String toString() {
//		return "Codigo [idCodigo=" + idCodigo + ", codigo=" + codigo + "]";
//	}


	public int getIdCodigo() {
		return idCodigo;
	}

	public void setIdCodigo(int idCodigo) {
		this.idCodigo = idCodigo;
	}
	
	
}
