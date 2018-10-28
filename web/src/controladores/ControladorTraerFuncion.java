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
import datos.Funcion;
import negocio.AuditorioABM;
import negocio.FuncionABM;

public class ControladorTraerFuncion extends HttpServlet {
	
	public class FuncionX {
		public int id;
		public String nombre;
		
		public FuncionX(int id,String nombre){
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
		
		FuncionABM funcionABM= new FuncionABM();
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
		int idEvento = Integer.parseInt(request.getParameter("idEvento"));
		
		List<Funcion> funciones = funcionABM.traerFuncionPorEventos(idEvento);
		List<FuncionX> listaFunciones= new ArrayList<FuncionX>();
		
		for(Funcion funcion: funciones){
			FuncionX x=new FuncionX(funcion.getIdFuncion(),funcion.getDescripcion());
			listaFunciones.add(x);
		}
		
		
        String res = mapper.writeValueAsString(listaFunciones);

//		
		out.println(res);

	}
	  
}


