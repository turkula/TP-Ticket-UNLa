package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import datos.Cliente;
import datos.Funcion;
import datos.Sector;
import negocio.ButacaABM;
import negocio.FuncionABM;
import negocio.SectorABM;
import negocio.TicketABM;
import negocio.UsuarioABM;

public class ControladorReservaPopular extends HttpServlet {
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
		TicketABM ticketABM = new TicketABM();
		UsuarioABM usuarioABM =  new UsuarioABM();
		FuncionABM funcionABM = new FuncionABM();
		SectorABM sectorABM = new SectorABM();
		ButacaABM butacaABM = new ButacaABM();
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
		int idSector = Integer.parseInt(request.getParameter("idSector"));
		int idFuncion = Integer.parseInt(request.getParameter("idFuncion"));
		int cantidadButacas = Integer.parseInt(request.getParameter("array"));
		
		
		Cliente cliente = (Cliente) new UsuarioABM().traer(1);
		Funcion funcion = funcionABM.traerFuncion(idFuncion);
		Sector sector = sectorABM.traerSector(idSector);
		
		for(int i=1;i<=cantidadButacas;i++) {
			ticketABM.agregarTicket(cliente, funcion, sector);
		}
		
		out.println("OK");	

	}
	
}