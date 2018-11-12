package test;

import datos.Cliente;
import datos.Funcion;
import datos.Reserva;
import datos.Sector;
import negocio.FuncionABM;
import negocio.ReservaABM;
import negocio.SectorABM;
import negocio.TicketABM;
import negocio.UsuarioABM;

public class TestAgregarReserva {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketABM ticketABM = new TicketABM();
		ReservaABM reservaABM = new ReservaABM();
		UsuarioABM usuarioABM = new UsuarioABM();
		FuncionABM funcionABM = new FuncionABM();
		SectorABM  sectorABM = new SectorABM();
		
		try {
			Cliente cliente =(Cliente)usuarioABM.traer(1);
			Sector sector = sectorABM.traerSector(6);
			Funcion funcion = funcionABM.traerFuncion(1);

			
			int id=reservaABM.agregarReserva(cliente, 100);
			Reserva reserva = reservaABM.traerReserva(id);
			ticketABM.agregarTicket(funcion, sector, reserva);
			
			
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
