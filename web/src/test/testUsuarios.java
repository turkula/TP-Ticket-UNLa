package test;

import datos.Cliente;
import datos.Usuario;
import negocio.TipoClienteABM;
import negocio.UsuarioABM;

public class testUsuarios {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		UsuarioABM usuarioABM =  new UsuarioABM();
		TipoClienteABM tipoClienteABM = new TipoClienteABM();
		
		usuarioABM.agregarCliente("jubilado", "gonza", null, tipoClienteABM.traerTipoCliente(3), null);
		
//		Cliente user = (Cliente)usuarioABM.traer(3);
//		
//		 
//		System.out.println("pija"+ user);
	}

}
