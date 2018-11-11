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
import datos.Sector;
import negocio.AuditorioABM;
import negocio.FuncionABM;
import negocio.SectorABM;
import negocio.SectorABM.SectorX;

public class ControladorTraerSector extends HttpServlet {
	
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
		
		SectorABM sectorABM= new SectorABM();
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
		int idAuditorio = Integer.parseInt(request.getParameter("idAuditorio"));
		int idFuncion = Integer.parseInt(request.getParameter("idFuncion"));

		List<SectorX> listaSectores=sectorABM.traerSectoresPorAuditorioX(idAuditorio);

        String res = mapper.writeValueAsString(listaSectores);	
		out.println(res);

	}
	  
}


