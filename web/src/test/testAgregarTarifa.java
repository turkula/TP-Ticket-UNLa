package test;

import datos.Funcion;
import datos.Sector;
import datos.Tarifa;
import negocio.FuncionABM;
import negocio.SectorABM;
import negocio.TarifaABM;

public class testAgregarTarifa {
    public static void main(String[] args) {
        FuncionABM funcionABM = new FuncionABM();
        SectorABM sectorABM=new SectorABM();
        TarifaABM tarifaABM = new TarifaABM();
        try {

            Funcion funcion = funcionABM.traerFuncion(1);
  //          Sector sector = sectorABM.traerSector(7);
  //          funcion.agregarTarifa(50.50f,sector);
            Tarifa tarifa =tarifaABM.traerTarifa(1, 1);
            System.out.println(tarifa);


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
