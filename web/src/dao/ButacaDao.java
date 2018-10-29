package dao;

import datos.Sector;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import datos.Butaca;

public class ButacaDao {
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

	public int agregar(Butaca objeto) {
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

	public void actualizar(Butaca objeto) throws HibernateException {
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

	public void eliminar(Butaca objeto) throws HibernateException {
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

	
	public Butaca traerButaca(int idButaca) throws HibernateException {
		Butaca objeto = null;
		try {
			iniciaOperacion();
			objeto = (Butaca) session.get(Butaca.class, idButaca);
		} finally {
			session.close();
		}
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<Butaca> traerButacas(Sector sector) throws HibernateException {
		List<Butaca> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Butaca b inner join fetch b.sector s where s.idSector="+sector.getIdSector();
			lista = session.createQuery(hql).list();
		} finally {
			session.close();
		}
		return lista;
	}
	

	/*
	@SuppressWarnings("unchecked")
	public List<Empleado> traerEmpleado() throws HibernateException {
		List<Empleado> objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Empleado e order by e.idButaca";
			objeto = (List<Empleado>) session.createQuery(hql).list();
		} finally {
			session.close();
		}
		return objeto;
	}*/
	
}
