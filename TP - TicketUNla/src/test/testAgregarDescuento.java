package test;

import negocio.DescuentoABM;

public class testAgregarDescuento {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DescuentoABM descuentoABM = new DescuentoABM();

        try {
            int ultimoIdDescuento = descuentoABM.agregarCodigo(5,"codigo");


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
