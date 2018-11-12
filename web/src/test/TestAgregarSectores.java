package test;

import datos.Auditorio;
import negocio.AuditorioABM;
import negocio.SectorABM;

public class TestAgregarSectores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		AuditorioABM auditorioABM = new AuditorioABM();
		SectorABM sectorABM = new SectorABM();
			try {
				Auditorio auditorio = auditorioABM.traerAuditorio(1);
//				sectorABM.agregarSector("PLATEA", auditorio, 4, 4);
				sectorABM.agregarSector("Popular", auditorio, 100);
				
			} catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	}

}
