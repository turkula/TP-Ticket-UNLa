package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Ticket;

import java.util.List;




public class TicketDao {
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

	public int agregar(Ticket objeto) {
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

	public void actualizar(Ticket objeto) throws HibernateException {
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

	public void eliminar(Ticket objeto) throws HibernateException {
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

	
	public Ticket traerTicket(long idTicket) throws HibernateException {
		Ticket objeto = null;
		try {
			iniciaOperacion();
			objeto = (Ticket) session.get(Ticket.class, idTicket);
		} finally {
			session.close();
		}
		return objeto;
	}
/*
	
	@SuppressWarnings("unchecked")
	public List<Ticket> traerTicket() throws HibernateException {
		List<Ticket> objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Cliente c order by c.idPersona"; ///////////////MODIFICAR
			objeto = (List<Ticket>) session.createQuery(hql).list();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ticket>traerTicket() throws HibernateException {
		List<Ticket>objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Empleado e order by e.idPersona"; ///////////////MODIFICAR
			objeto = (List<Ticket>)session.createQuery(hql).list();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	*/
}