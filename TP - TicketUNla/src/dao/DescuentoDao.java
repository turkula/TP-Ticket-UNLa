package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DescuentoDao {
    private static Session session;
    private Transaction tx;
    private static DescuentoDao instancia=null;

    protected DescuentoDao(){};

    public  static  DescuentoDao getInstancia(){
        if(instancia==null)
            instancia=new DescuentoDao();
        return instancia;
    }

    protected void iniciaOperacion()throws HibernateException{
        session = HibernateUtil.getSessionFactory().openSession();
        tx=session.beginTransaction();
    }

    protected void manejaExcepcion(HibernateException he)throws HibernateException{
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos",he);
    }




}
