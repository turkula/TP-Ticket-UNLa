package negocio;
import dao.DescuentoDao;
import datos.Codigo;
import datos.Descuento;
public class DescuentoABM {
    DescuentoDao dao = new DescuentoDao();

    public Descuento traerDescuento(int idDescuento)throws Exception{
        Descuento d=dao.traerDescuento(idDescuento);
        if(d==null)
            throw new Exception("Error:el Descuento no existe");
        return d;
    }

    public int agregarCodigo(int porcentaje,String codigo)throws Exception{
        Codigo d = new Codigo(porcentaje,codigo);
        return dao.agregar(d);
    }

    public void modificar(Descuento d)throws Exception{
        dao.actualizar(d);
    }

    public void eliminar(int idDescuento){
        Descuento d = dao.traerDescuento(idDescuento);
        dao.eliminar(d);
    }
}