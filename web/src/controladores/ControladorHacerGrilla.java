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
import datos.Butaca;
import datos.Funcion;
import datos.Sector;
import negocio.AuditorioABM;
import negocio.ButacaABM;
import negocio.FuncionABM;
import negocio.SectorABM;
import negocio.TicketABM;

public class ControladorHacerGrilla extends HttpServlet {
	
	public class SectorX {
		public int id;
		public String nombre;
		public int capacidad;
		
		public SectorX(int id,String nombre,int capacidad){
			this.id=id;
			this.nombre=nombre;
			this.capacidad=capacidad;
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

		public int getCapacidad() {
			return capacidad;
		}
		
		
	}
	
	public class ButacaX{
		public int id;
		public int fila;
		public int columna;
		
		public ButacaX(int id, int fila, int columna) {
			super();
			this.id = id;
			this.fila = fila;
			this.columna = columna;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getFila() {
			return fila;
		}

		public void setFila(int fila) {
			this.fila = fila;
		}

		public int getColumna() {
			return columna;
		}

		public void setColumna(int columna) {
			this.columna = columna;
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
		ButacaABM butacaABM = new ButacaABM();
		SectorABM sectorABM= new SectorABM();
		TicketABM tiabm =new TicketABM();
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
		int idSector = Integer.parseInt(request.getParameter("idSector"));
		int idFuncion = Integer.parseInt(request.getParameter("idFuncion"));

		Sector sector = sectorABM.traerSector(idSector);
		
		System.out.println(idFuncion);
		System.out.println(sector.toString());
		
		List<Object> respuesta = new ArrayList<Object>();
		if(sector.getPopularCantidadMaxima()>0) {
			
			int cantidadMaximaSector = sector.getPopularCantidadMaxima();
			
			long cantidadVendida = tiabm.traerCantidadTickerPorSectorPopular(idFuncion, idSector);
						
			respuesta.add(cantidadMaximaSector);
			respuesta.add(cantidadVendida);
			respuesta.add(0);
		}else {
			
			List<ButacaX> listaButacas = new ArrayList<ButacaX>();
			List<Butaca> butacas = butacaABM.traeButacas(sectorABM.traerSector(idSector));
//			
			for(Butaca butaca: butacas){
				ButacaX b=new ButacaX(butaca.getIdButaca(), butaca.getFila(), butaca.getColumna());
				listaButacas.add(b);
			}
			respuesta.add(listaButacas);
			
			//butacas ocupadas
			List<ButacaX> listaButacasOcupadas =new ArrayList<ButacaX>();


			List<Butaca>butacasOcupadas = tiabm.traerButacasXfuncionYSector(idFuncion, idSector);
			
			for(Butaca butaca: butacasOcupadas){
				ButacaX b=new ButacaX(butaca.getIdButaca(), butaca.getFila(), butaca.getColumna());
				listaButacasOcupadas.add(b);
			}
			
			respuesta.add(listaButacasOcupadas);
			respuesta.add(1);
		}
		
		
        String res = mapper.writeValueAsString(respuesta);	
		out.println(res);	

	}
	  
}


