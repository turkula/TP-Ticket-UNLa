package test;

import datos.Sector;
import datos.TipoAuditorio;
import negocio.*;

public class testAgregarAuditorio {
    public static void main(String[] args) {
        AuditorioABM auditorioABM = new AuditorioABM();
        TipoAuditorioABM tipoAuditorioABM = new TipoAuditorioABM();
        try {

//        auditorioABM.agregar("village",tipoAuditorioABM.traerTipoAuditorio(1),null,null);
//        auditorioABM.traerAuditorio(1).agregarSectorPopular("sector 1",20);
            auditorioABM.traerAuditorio(1).agregarSectorButacas("sector A",10,10);


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
