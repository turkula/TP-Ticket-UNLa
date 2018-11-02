package negocio;

import java.util.List;

import dao.TicketDao;
import datos.Ticket;
import datos.Butaca;
import datos.Cliente;
import datos.Funcion;
import datos.Sector;

public class TicketABM {
    TicketDao dao = new TicketDao();

    public Ticket traerTicket(int idTicket)throws Exception{
        Ticket d=dao.traerTicket(idTicket);
        if(d==null)
            throw new Exception("Error:la Ticket no existe");
        return d;
    }

    public int agregarTicket(Cliente cliente, Funcion funcion, Sector sector, Butaca butaca)throws Exception{
        Ticket d = new Ticket( cliente, funcion, sector, butaca);
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
    
    

}
