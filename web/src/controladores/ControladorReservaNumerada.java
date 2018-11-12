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

public class ControladorReservaNumerada extends HttpServlet {
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
		PrintWriter out = response.getWriter();
		
		int idSector = Integer.parseInt(request.getParameter("idSector"));
		int idFuncion = Integer.parseInt(request.getParameter("idFuncion"));
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		int precioTotal = Integer.parseInt(request.getParameter("precioTotal"));
		String listaButacas = request.getParameter("array");
		
		String respuesta = ticketABM.hacerReservaNumerada(idSector, idFuncion, listaButacas,idUsuario,precioTotal);
	
		out.println(respuesta);	

	}
	
	
	
}
