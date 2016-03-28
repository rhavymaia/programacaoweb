package br.edu.ifpb.urnaeletronica.dao;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifpb.urnaeletronica.hibernate.HibernateUtil;

public abstract class GenericDao<PK, T> {
	
	public abstract List<T> getAll() throws HibernateException;
	
	public abstract Class<?> getEntityClass();
	
	public int insert(T entity) throws HibernateException {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Integer id;
		
		try {
			
			session.beginTransaction();
			id = (Integer) session.save(entity);
			session.getTransaction().commit();

		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
			throw new HibernateException(hibernateException);
			
		} finally {
			
			session.close();
		}
		
		return id;
	}
	
	public boolean insertOrUpdate(T entity) throws HibernateException {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		boolean success = false;
		
		try {
			
			session.beginTransaction();
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
			
			success = true;

		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
			throw new HibernateException(hibernateException);
			
		} finally {
			
			session.close();
		}
		
		return success;
	}

	public T update(T entity) throws HibernateException{
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			
			session.beginTransaction();
			entity = (T) session.merge(entity);
			session.getTransaction().commit();

		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
			throw new HibernateException(hibernateException);
			
		} finally {
			
			session.close();
		}
		
		return entity;
	}

	public void delete(T entity) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();

		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
			throw new HibernateException(hibernateException);
			
		} finally {
			
			session.close();
		}
	}
	
	public List<T> getAll(String namedQuery) throws HibernateException {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<T> list = null;

		try {
			
			session.beginTransaction();
			Query query = session.getNamedQuery(namedQuery);
			list = (List<T>) query.list();
			session.getTransaction().commit();
			
		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
			throw new HibernateException(hibernateException);
			
		} finally {
			
			session.close();
		}

		return list;
	}

	public T getById(Integer pk) throws HibernateException {		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		T entity = null;
		
		try {
		
			session.beginTransaction();
			entity = (T) session.get(getEntityClass(), pk);
	        Hibernate.initialize(entity);
	        session.getTransaction().commit();
	        
		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
			throw new HibernateException(hibernateException);
			
		} finally {
		
			session.close();
		}
		
		return entity;
	}
	
	public abstract T find(T entity) throws HibernateException;
}