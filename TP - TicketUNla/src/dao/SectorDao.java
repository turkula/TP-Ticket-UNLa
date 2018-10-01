package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class SectorDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he)
			throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(Sector objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Sector objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(Sector objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	
	public Sector traerSector(long idSector) throws HibernateException {
		Sector objeto = null;
		try {
			iniciaOperacion();
			objeto = (Sector) session.get(Sector.class, idSector);
		} finally {
			session.close();
		}
		return objeto;
	}
/*
	
	@SuppressWarnings("unchecked")
	public List<Sector> traerSector() throws HibernateException {
		List<Sector> objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c order by c.idPersona";   //MODIFICAR
			objeto = (List<Sector>) session.createQuery(hql).list();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Sector> traerSector() throws HibernateException {
		List<Sector>objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Empleado e order by e.idPersona";  ///MODIFICAR
			objeto = (List<Sector>) session.createQuery(hql).list();
		} finally {
			session.close();
		}
		return objeto;
	}
	*/
}
