package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import datos.Cliente;
import datos.Usuario;
import negocio.UsuarioABM;
import negocio.UsuarioABM.UsuarioX;

public class ControladorTraerUsuario extends HttpServlet {

	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		try {
			procesarPeticion(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		try {
			procesarPeticion(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void procesarPeticion(HttpServletRequest request,HttpServletResponse response)throws Exception {
		response.setContentType("text/plain");
		UsuarioABM usuarioABM =  new UsuarioABM();
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
		
		String id = request.getParameter("idUser");
		
		UsuarioX cliente = usuarioABM.traerX(Integer.parseInt(id));
				
        String res = mapper.writeValueAsString(cliente);	

		out.println(res);
		
		
	}
	
}
