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
		UsuarioABM usuarioABM =  UsuarioABM.getInstance();
		FuncionABM funcionABM = new FuncionABM();
		SectorABM sectorABM = new SectorABM();
		ButacaABM butacaABM = new ButacaABM();
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
		int idSector = Integer.parseInt(request.getParameter("idSector"));
		int idFuncion = Integer.parseInt(request.getParameter("idFuncion"));
		String listaButacas = request.getParameter("array");
		
		System.out.println(listaButacas);

		
		listaButacas = listaButacas.replace("]","");
		listaButacas = listaButacas.replace("[","");
		String[] butacas = listaButacas.split(",");
		
		
		Cliente cliente = (Cliente) UsuarioABM.getInstance().traer(1);
		Funcion funcion = funcionABM.traerFuncion(idFuncion);
		Sector sector = sectorABM.traerSector(idSector);
		
		for(String b:butacas){
			int idButaca =Integer.parseInt(b);
			ticketABM.agregarTicket(cliente, funcion, sector, butacaABM.traerButaca(idButaca));
		}
	
		out.println("OK");	

	}
	
	
	
}
