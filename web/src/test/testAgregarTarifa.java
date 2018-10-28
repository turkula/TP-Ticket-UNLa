package test;

import datos.Funcion;
import datos.Sector;
import negocio.FuncionABM;
import negocio.SectorABM;

public class testAgregarTarifa {
    public static void main(String[] args) {
        FuncionABM funcionABM = new FuncionABM();
        SectorABM sectorABM=new SectorABM();
        try {

            Funcion funcion = funcionABM.traerFuncion(1);
            Sector sector = sectorABM.traerSector(7);
            funcion.agregarTarifa(50.50f,sector);



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
