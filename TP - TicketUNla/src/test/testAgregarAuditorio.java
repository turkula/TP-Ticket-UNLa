package test;

import datos.Butaca;
import datos.Sector;
import datos.TipoAuditorio;
import negocio.*;

import java.util.List;

public class testAgregarAuditorio {
    public static void main(String[] args) {
        AuditorioABM auditorioABM = new AuditorioABM();
        TipoAuditorioABM tipoAuditorioABM = new TipoAuditorioABM();
        ButacaABM butacaABM = new ButacaABM();
        SectorABM sectorABM = new SectorABM();
        try {

//            AGREGO AUDITORIO
//        auditorioABM.agregar("village",tipoAuditorioABM.traerTipoAuditorio(1),null,null);

//            AGREGO SECTOR POPULAR
//        auditorioABM.traerAuditorio(1).agregarSectorPopular("sector 1",20);

//            AGREGO SECTOR BUTACAS
            auditorioABM.traerAuditorio(1).agregarSectorButacas("sector A",10,10);


//            TRAER BUTACAS  POR SECTOR
<<<<<<< HEAD
            List<Butaca> butacas = butacaABM.traeButacas(sectorABM.traerSector(2));

            for(Butaca b : butacas){
                System.out.println(b.toString());
            }
=======
//            List<Butaca> butacas = butacaABM.traeButacas(sectorABM.traerSector(23));
//
//            for(Butaca b : butacas){
//                System.out.println(b.toString());
//            }
>>>>>>> db2c127ca679f8c6b554a2f6449aecb65c6f2553

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
