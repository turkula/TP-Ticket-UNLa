package negocio;
import dao.DescuentoDao;
import dao.SectorDao;
import dao.TarifaDao;
import datos.*;

public class SectorABM {
    SectorDao dao = new SectorDao();

    public Sector traerSector(int idSector)throws Exception{
        Sector d=dao.traerSector(idSector);
        if(d==null)
            throw new Exception("Error:El sector no existe");
        return d;
    }

    public int agregarSector(String descripcion,Auditorio auditorio)throws Exception{
        Sector d = new Sector(descripcion,auditorio);
        return dao.agregar(d);
    }

    public void modificar(Sector d)throws Exception{
        dao.actualizar(d);
    }

    public void eliminar(int idSector){
        Sector d = dao.traerSector(idSector);
        dao.eliminar(d);
    }

    public void agregarSectorPopular(String descripcion,Auditorio auditorio,int cantMaxima){
        System.out.println(auditorio.toString());
        Popular p = new Popular(descripcion,auditorio,cantMaxima);
        dao.agregar(p);
    }
}