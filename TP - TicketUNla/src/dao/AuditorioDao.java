package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Auditorio;
import datos.TipoAuditorio;

public class AuditorioDao {
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

	public int agregar(Auditorio objeto) {
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

	public void actualizar(Auditorio objeto) throws HibernateException {
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

	public void eliminar(Auditorio objeto) throws HibernateException {
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

	
	public Auditorio traerAuditorio(int idauditorio) throws HibernateException {
		Auditorio objeto = null;
		try {
			iniciaOperacion();
			objeto = (Auditorio) session.get(Auditorio.class, idauditorio);
		} finally {
			cerrarSesion(session);
		}
		return objeto;
	}
	
	public Auditorio traerAuditorioCompleto(int idauditorio) throws HibernateException {
		Auditorio objeto = null;
		try {
			iniciaOperacion();
			String hql ="from Auditorio a inner join fetch a.tipoAuditorio"
					+ " inner join fetch a.eventos"
					+ " inner join fetch a.sectores"
					+ " where a.idAuditorio =" + idauditorio;
			objeto = (Auditorio) session.createQuery(hql).uniqueResult();
		} finally {
			cerrarSesion(session);
		}
		return objeto;
	}
	
	public List<Object> traerAuditoriosPorTipo (int idTipoAuditorio) throws HibernateException {
		List<Object> objeto = null;
		try {
			iniciaOperacion();
			String hql ="from Auditorio a inner join fetch a.tipoAuditorio t "
					+ "where t.idTipoAuditorio ="+idTipoAuditorio;
			objeto = (List<Object>) session.createQuery(hql).list();
		} finally {
			cerrarSesion(session);
		}
		return objeto;
	}
	
	public List<Object> traerAuditoriosPorTipoDeEvento (int idTipoEvento) throws HibernateException {
		List<Object> objeto = null;
		try {
			iniciaOperacion();
			String hql ="from Auditorio a inner join fetch a.eventos e "
					+ "inner join fetch e.tipoEvento t"
					+ "where t.idTipoEvento ="+idTipoEvento;
			objeto = (List<Object>) session.createQuery(hql).list();
		} finally {
			cerrarSesion(session);
		}
		return objeto;
	}	

	private void cerrarSesion(Session session) {
		if (session != null) {
			session.close();
		}
	}
}
