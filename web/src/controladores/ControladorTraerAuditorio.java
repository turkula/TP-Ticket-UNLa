package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import datos.Auditorio;
import negocio.AuditorioABM;

public class ControladorTraerAuditorio extends HttpServlet {
	
	public class AuditorioX {
		public int id;
		public String nombre;
		
		public AuditorioX(int id,String nombre){
			this.id=id;
			this.nombre=nombre;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		
	}
	
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

//		response.setContentType("text/html;charset=UTF8");
		response.setContentType("text/plain");
		
		AuditorioABM auditorioABM = new AuditorioABM();
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
		int idTipo = Integer.parseInt(request.getParameter("tipo"));
		
		List<Auditorio> auditoriosXtipo = auditorioABM.traerAuditoriosPorTipo(3);
		List<AuditorioX> listaAuditorios= new ArrayList<AuditorioX>();
		
		for(Auditorio auditorio: auditoriosXtipo){
			AuditorioX x=new AuditorioX(auditorio.getIdAuditorio(),auditorio.getNombre());
			listaAuditorios.add(x);
		}
		
		
        String res = mapper.writeValueAsString(listaAuditorios);

//		
		out.println(res);

	}
	  
}


