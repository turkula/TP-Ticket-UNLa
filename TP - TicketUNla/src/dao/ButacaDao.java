package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import datos.Cliente;
import datos.Empleado;
import datos.Persona;
import datos.Sucursal;

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

	public int agregar(Persona objeto) {
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

	public void actualizar(Persona objeto) throws HibernateException {
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

	public void eliminar(Persona objeto) throws HibernateException {
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

	
	public Persona traer(long idPersona) throws HibernateException {
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.get(Persona.class, idPersona);
		} finally {
			session.close();
		}
		return objeto;
	}

	/*@SuppressWarnings("unchecked")
	public List<Cliente> traerCliente() throws HibernateException {
		List<Cliente> objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c order by c.idPersona";  
			objeto = (List<Cliente>) session.createQuery(hql).list();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Empleado> traerEmpleado() throws HibernateException {
		List<Empleado> objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Empleado e order by e.idPersona";
			objeto = (List<Empleado>) session.createQuery(hql).list();
		} finally {
			session.close();
		}
		return objeto;
	}*/
	
}