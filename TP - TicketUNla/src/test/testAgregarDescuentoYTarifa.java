package test;

import datos.Sector;
import datos.Tarifa;
import negocio.DescuentoABM;
import negocio.SectorABM;
import negocio.TarifaABM;

public class testAgregarDescuentoYTarifa {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DescuentoABM descuentoABM = new DescuentoABM();
        SectorABM sectorABM = new SectorABM();
        TarifaABM tarifaABM = new TarifaABM();

        try {
            Sector sector1 = sectorABM.traerSector(1);
//          System.out.println(sector1);
//          int ultimoIdDescuento = descuentoABM.agregarCodigo(5,sector1,"codigo");
            int ultimoIdTarifa = tarifaABM.agregarTarifa(2.0f,sector1);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
