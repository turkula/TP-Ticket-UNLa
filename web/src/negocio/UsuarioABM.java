package negocio;
import java.util.GregorianCalendar;
import java.util.List;

import dao.DescuentoDao;
import dao.UsuarioDao;
import datos.Cliente;
import datos.Persona;
import datos.TipoCliente;
import datos.Usuario;


public class UsuarioABM {
	
    UsuarioDao dao = new UsuarioDao();
    
    public class UsuarioX{
    	public int idUsuario;
    	public String username;
    	public int tipoCliente;
    	
    	public UsuarioX(int idUsuario,String username,int tipoCliente) {
    		this.idUsuario = idUsuario;
    		this.username = username;
    		this.tipoCliente = tipoCliente;
    	}

		public int getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public int getTipoCliente() {
			return tipoCliente;
		}

		public void setTipoCliente(int tipoCliente) {
			this.tipoCliente = tipoCliente;
		}
    	
    }

//	private static UsuarioABM instancia = null; // Patr�n Singleton
//	protected UsuarioABM(){}
//	public static UsuarioABM getInstance(){
//	if (instancia==null)
//	instancia=new UsuarioABM();
//	return instancia ;
//	}
	
	
	
	public Usuario traer(int idUsuario){
	return dao.traer(idUsuario);
	}
	
	public UsuarioX traerX(int idUsuario) {
		Cliente usuario=(Cliente)dao.traer(idUsuario);
		
		return new UsuarioX(usuario.getIdUsuario(),usuario.getNombreUsuario(),usuario.getTipoCliente().getIdTipoCliente());
	}
	
	public int traerUsuarioLogin(String user,String password) {
		return dao.traerUsuarioLogin(user,password);
	}
	
	public int agregarCliente(String nombreUsuario, String clave, Persona persona, TipoCliente tipo,
			GregorianCalendar fechaNacimiento) {
		Cliente c = new Cliente(nombreUsuario,clave,persona,tipo,fechaNacimiento);
		
		return dao.agregar(c);
		
	}
	
	
	public List<Usuario> traer(){
	return dao.traer();
	}

}
