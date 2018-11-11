package negocio;

import java.util.List;


import dao.TicketDao;
import datos.Ticket;
import datos.Butaca;
import datos.Cliente;
import datos.Funcion;
import datos.Sector;

public class TicketABM {
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
	
    TicketDao dao = new TicketDao();

    public Ticket traerTicket(int idTicket)throws Exception{
        Ticket d=dao.traerTicket(idTicket);
        if(d==null)
            throw new Exception("Error:la Ticket no existe");
        return d;
    }

    public int agregarTicket(Cliente cliente, Funcion funcion, Sector sector, Butaca butaca )throws Exception{
        Ticket d = new Ticket( cliente, funcion, sector, butaca);
        return dao.agregar(d);
    }
    
    public int agregarTicket(Cliente cliente, Funcion funcion, Sector sector )throws Exception{
        Ticket d = new Ticket( cliente, funcion, sector, null);
        return dao.agregar(d);
    }

    public void modificar(Ticket d)throws Exception{
        dao.actualizar(d);
    }

    public void eliminar(int idTicket){
        Ticket d = dao.traerTicket(idTicket);
        dao.eliminar(d);
    }

    public List<Butaca> traerButacasXfuncionYSector(int idFuncion, int idSector){
        return dao.traerButacasXfuncionYSector(idFuncion, idSector);
    }
    
    
    public long traerCantidadTickerPorSectorPopular(int idFuncion,int idSector) {
    	return dao.traerTicketsPorSectorPopular(idFuncion,idSector);
    }
    
    public String hacerReservaNumerada(int idSector,int idFuncion,String listaButacas,int idUsuario) throws Exception {
		UsuarioABM usuarioABM = new UsuarioABM();
		FuncionABM funcionABM = new FuncionABM();
		SectorABM sectorABM = new SectorABM();
		ButacaABM butacaABM = new ButacaABM();
    	
    	listaButacas = listaButacas.replace("]","");
		listaButacas = listaButacas.replace("[","");
		String[] butacas = listaButacas.split(",");
		
		Cliente cliente = (Cliente) usuarioABM.traer(idUsuario);
		Funcion funcion = funcionABM.traerFuncion(idFuncion);
		Sector sector = sectorABM.traerSector(idSector);
		
		for(String b:butacas){
			int idButaca =Integer.parseInt(b);
			agregarTicket(cliente, funcion, sector, butacaABM.traerButaca(idButaca));
		}
		
		return "OK";
    }
    
    public String hacerReservaPopular(int idSector,int idFuncion,int cantidadButacas,int idUsuario) throws Exception {
    	UsuarioABM usuarioABM =  new UsuarioABM();
		FuncionABM funcionABM = new FuncionABM();
		SectorABM sectorABM = new SectorABM();
		Cliente cliente = (Cliente)usuarioABM.traer(idUsuario);
		
		Funcion funcion = funcionABM.traerFuncion(idFuncion);
		Sector sector = sectorABM.traerSector(idSector);
		
		for(int i=1;i<=cantidadButacas;i++) {
			agregarTicket(cliente, funcion, sector);
		}
		return "OK";
    }

}
