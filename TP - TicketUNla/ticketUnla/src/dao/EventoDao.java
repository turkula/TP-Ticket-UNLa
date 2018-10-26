package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Evento;

public class EventoDao {
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

	public int agregar(Evento objeto) {
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

	public void actualizar(Evento objeto) throws HibernateException {
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

	public void eliminar(Evento objeto) throws HibernateException {
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

	
	public Evento traerEvento(int idEvento) throws HibernateException {
		Evento objeto = null;
		try {
			iniciaOperacion();
			objeto = (Evento) session.get(Evento.class, idEvento);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Evento traerEventoCompleto(int idEvento) throws HibernateException {
		Evento objeto = null;
		try {
			iniciaOperacion();
			String hql ="from Evento e inner join fetch e.tipoEvento t"
					+ " inner join fetch e.funciones f"
					+ " inner join fetch e.auditorio a"
					+ " where e.idEvento ="+ idEvento;
			objeto = (Evento) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public List<Evento> traerEventoPorAuditorioYTipoEvento(int idAuditorio, int idTipoEvento) throws HibernateException {
		List<Evento> objeto = null;
		try {
			iniciaOperacion();
			String hql ="from Evento e inner join fetch e.tipoEvento t"
					+ " inner join fetch e.auditorio a"
					+ " where t.idTipoEvento = :idTipoEvento"
					+ " and a.idAuditorio= :idAuditorio" ;
			objeto = (List<Evento>) session.createQuery(hql).setInteger("idTipoEvento", idTipoEvento).setInteger("idAuditorio", idAuditorio).list();
		} finally {
			session.close();
		}
		return objeto;
	}
}
