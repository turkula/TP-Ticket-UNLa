package negocio;
import dao.ButacaDao;
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


    public void modificar(Sector d)throws Exception{
        dao.actualizar(d);
    }

    public void eliminar(int idSector){
        Sector d = dao.traerSector(idSector);
        dao.eliminar(d);
    }

    public void agregarSector(String descripcion,Auditorio auditorio,int cantMaxima){
//        System.out.println(auditorio.toString());
        Sector sector = new Sector(descripcion,auditorio,cantMaxima);
        dao.agregar(sector);
    }

    public void agregarSector(String descripcion,Auditorio auditorio,int cantidadFilas,int cantidadColumnas)throws Exception{
        Sector sector = new Sector(descripcion,auditorio);
        dao.agregar(sector);
        ButacaABM butacaABM = new ButacaABM();
        for(int i = 1;i<=cantidadFilas;i++){
            for(int y =1;y<=cantidadColumnas;y++){
                butacaABM.agregarButaca(i,y,sector);
            }
        }
    }
}