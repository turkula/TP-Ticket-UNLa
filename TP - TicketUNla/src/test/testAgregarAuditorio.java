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
        auditorioABM.traerAuditorio(1).agregarSectorPopular("sector 2",45);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
