package negocio;

import java.util.List;
import java.util.Set;

import dao.ReservaDao;
import datos.Reserva;

import datos.Ticket;

public class ReservaABM {
    ReservaDao dao = new ReservaDao();

    public Reserva traerReserva(int idReserva)throws Exception{
        Reserva d=dao.traerReserva(idReserva);
        if(d==null)
            throw new Exception("Error:la Reserva no existe");
        return d;
    }

    public int agregarReserva(Set<Ticket> tickets)throws Exception{
        Reserva d = new Reserva( tickets);
        return dao.agregar(d);
    }
    

    public void modificar(Reserva d)throws Exception{
        dao.actualizar(d);
    }

    public void eliminar(int idReserva){
        Reserva d = dao.traerReserva(idReserva);
        dao.eliminar(d);
    }
}