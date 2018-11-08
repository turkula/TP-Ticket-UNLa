package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import controladores.ControladorHacerGrilla.ButacaX;
import datos.Butaca;
import datos.Sector;
import negocio.ButacaABM;
import negocio.SectorABM;
import negocio.TarifaABM;
import negocio.TicketABM;

public class ControladorTraerTarifa extends HttpServlet {
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
		ButacaABM butacaABM = new ButacaABM();
		SectorABM sectorABM = new SectorABM();
 		TarifaABM tarifaABM = new TarifaABM();
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
		int idSector = Integer.parseInt(request.getParameter("idSector"));
		int idFuncion = Integer.parseInt(request.getParameter("idFuncion"));

		float precio = tarifaABM.traerTarifa(idSector, idFuncion).getPrecio();
		
		out.println(precio);
		
	}
}
