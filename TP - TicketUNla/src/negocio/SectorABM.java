package negocio;
import dao.DescuentoDao;
import dao.SectorDao;
import dao.TarifaDao;
import datos.Codigo;
import datos.Descuento;
import datos.Sector;
import datos.Tarifa;

public class SectorABM {
    SectorDao dao = new SectorDao();

    public Sector traerSector(int idSector)throws Exception{
        Sector d=dao.traerSector(idSector);
        if(d==null)
            throw new Exception("Error:El sector no existe");
        return d;
    }

    public int agregarSector(String des)throws Exception{
        Sector d = new Sector(des);
        return dao.agregar(d);
    }

    public void modificar(Sector d)throws Exception{
        dao.actualizar(d);
    }

    public void eliminar(int idSector){
        Sector d = dao.traerSector(idSector);
        dao.eliminar(d);
    }
}