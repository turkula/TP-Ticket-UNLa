package negocio;
import dao.DescuentoDao;
import dao.TarifaDao;
import datos.*;

public class TarifaABM {
    TarifaDao dao = new TarifaDao();

    public Tarifa traerTarifa(int idTarifa)throws Exception{
        Tarifa d=dao.traerTarifa(idTarifa);
        if(d==null)
            throw new Exception("Error:la Tarifa no existe");
        return d;
    }

    public int agregarTarifa(float precio, Sector sector,Funcion funcion)throws Exception{
        Tarifa d = new Tarifa(precio,sector,funcion);
        return dao.agregar(d);
    }

    public void modificar(Tarifa d)throws Exception{
        dao.actualizar(d);
    }

    public void eliminar(int idTarifa){
        Tarifa d = dao.traerTarifa(idTarifa);
        dao.eliminar(d);
    }
}