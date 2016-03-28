package br.edu.ifpb.urnaeletronica.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifpb.urnaeletronica.entidade.Pessoa;
import br.edu.ifpb.urnaeletronica.hibernate.HibernateUtil;

public class PessoaDAO extends GenericDao<Integer, Pessoa> {

	private static PessoaDAO instance;
	
	public static PessoaDAO getInstance() {	
		
		instance = new PessoaDAO();		
		return instance;
	}

	@Override
	public List<Pessoa> getAll() throws HibernateException {
		// TODO Auto-generated method stub
		return getAll("Pessoa.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return Pessoa.class;
	}

	@Override
	public Pessoa find(Pessoa entity) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Pessoa getByKeyAuth(String keyAuth) throws HibernateException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Pessoa pessoa = null;
		
		try {
			
			String hql = "from Pessoa as p"
					+ " where p.keyAuth = :keyAuth";
			
			Query query = session.createQuery(hql);
			query.setParameter("keyAuth", keyAuth);			
			
			pessoa = (Pessoa) query.uniqueResult();
	        
		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
			throw new HibernateException(hibernateException);
			
		} finally {
		
			session.close();
		}
		
		return pessoa;
	}
}
