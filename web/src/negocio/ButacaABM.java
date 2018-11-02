package negocio;

import dao.ButacaDao;
import datos.Butaca;
import datos.Sector;

import java.util.List;

public class ButacaABM {
    ButacaDao dao = new ButacaDao();

    public Butaca traerButaca(int idButaca)throws Exception{
        Butaca d=dao.traerButaca(idButaca);
        if(d==null)
            throw new Exception("Error:la Butaca no existe");
        return d;
    }

    public int agregarButaca(int fila, int columna, Sector sector)throws Exception{
        Butaca d = new Butaca( fila,  columna, sector);
        return dao.agregar(d);
    }

    public void modificar(Butaca d)throws Exception{
        dao.actualizar(d);
    }

    public void eliminar(int idButaca){
        Butaca d = dao.traerButaca(idButaca);
        dao.eliminar(d);
    }

    public List<Butaca> traeButacas(Sector s){
        return dao.traerButacas(s);
    }
    
//    public List<Butaca> traerButacas(int idFuncion)
//    {
//        return dao.traerButacas(idFuncion);
//    }
}
