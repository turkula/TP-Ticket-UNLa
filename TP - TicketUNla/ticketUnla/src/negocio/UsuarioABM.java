package negocio;
import java.util.List;
import dao.UsuarioDao;
import datos.Usuario;


public class UsuarioABM {
	
	private static UsuarioABM instancia = null; // Patrón Singleton
	protected UsuarioABM(){}
	public static UsuarioABM getInstance(){
	if (instancia==null)
	instancia=new UsuarioABM();
	return instancia ;
	}
	
	
	
	public Usuario traer(int idUsuario){
	return UsuarioDao. getInstance ().traer(idUsuario);
	}
	
	
	public List<Usuario> traer(){
	return UsuarioDao. getInstance ().traer();
	}

}
