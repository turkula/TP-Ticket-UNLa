package negocio;
import java.util.ArrayList;
import java.util.List;

import dao.ButacaDao;
import dao.DescuentoDao;
import dao.SectorDao;
import dao.TarifaDao;
import datos.*;

public class SectorABM {
	
	public class SectorX {
		public int id;
		public String nombre;
		public int capacidad;
		
		public SectorX(int id,String nombre,int capacidad){
			this.id=id;
			this.nombre=nombre;
			this.capacidad=capacidad;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getCapacidad() {
			return capacidad;
		}
			
	}
	
	public class ButacaX{
		public int id;
		public int fila;
		public int columna;
		
		public ButacaX(int id, int fila, int columna) {
			super();
			this.id = id;
			this.fila = fila;
			this.columna = columna;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getFila() {
			return fila;
		}

		public void setFila(int fila) {
			this.fila = fila;
		}

		public int getColumna() {
			return columna;
		}

		public void setColumna(int columna) {
			this.columna = columna;
		}
		
		
		
	}
	
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
    
    public List<Sector> traerSectoresPorAuditorio(int idAuditorio)throws Exception{
        List<Sector> d=dao.traerSectoresPorAuditorio(idAuditorio);
        if(d==null)
            throw new Exception("Error:El sector no existe");
        return d;
    }
    
    public List<SectorX> traerSectoresPorAuditorioX(int idAuditorio)throws Exception{
    	List<Sector> sectores = traerSectoresPorAuditorio(idAuditorio);
		List<SectorX> listaSectores= new ArrayList<SectorX>();
		
		for(Sector sector: sectores){
			SectorX x=new SectorX(sector.getIdSector(),sector.getDescripcion(),sector.getPopularCantidadMaxima());
			listaSectores.add(x);
		}
		return listaSectores;
    }
    
    public List<Object> hacerGrilla(int idSector,int idFuncion)throws Exception{
		SectorABM sectorABM= new SectorABM();
		TicketABM tiabm =new TicketABM();
		ButacaABM butacaABM = new ButacaABM();

		Sector sector = sectorABM.traerSector(idSector);
		
//		System.out.println(idFuncion);
//		System.out.println(sector.toString());
		
		List<Object> respuesta = new ArrayList<Object>();
		if(sector.getPopularCantidadMaxima()>0) {
			
			int cantidadMaximaSector = sector.getPopularCantidadMaxima();
			
			long cantidadVendida = tiabm.traerCantidadTickerPorSectorPopular(idFuncion, idSector);
						
			respuesta.add(cantidadMaximaSector);
			respuesta.add(cantidadVendida);
			respuesta.add(0);
		}else {
			
			List<ButacaX> listaButacas = new ArrayList<ButacaX>();
			List<Butaca> butacas = butacaABM.traeButacas(sectorABM.traerSector(idSector));
//			
			for(Butaca butaca: butacas){
				ButacaX b=new ButacaX(butaca.getIdButaca(), butaca.getFila(), butaca.getColumna());
				listaButacas.add(b);
			}
			respuesta.add(listaButacas);
			
			//butacas ocupadas
			List<ButacaX> listaButacasOcupadas =new ArrayList<ButacaX>();


			List<Butaca>butacasOcupadas = tiabm.traerButacasXfuncionYSector(idFuncion, idSector);
			
			for(Butaca butaca: butacasOcupadas){
				ButacaX b=new ButacaX(butaca.getIdButaca(), butaca.getFila(), butaca.getColumna());
				listaButacasOcupadas.add(b);
			}
			
			respuesta.add(listaButacasOcupadas);
			respuesta.add(1);
		}
		
		return respuesta;
		
    }
}