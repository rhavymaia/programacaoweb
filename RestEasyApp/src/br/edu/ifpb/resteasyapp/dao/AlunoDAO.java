package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifpb.resteasyapp.entidade.Aluno;
import br.edu.ifpb.resteasyapp.hibernate.HibernateUtil;

public class AlunoDAO extends GenericDao<Integer, Aluno>{

	private static AlunoDAO instance;
	
	public static AlunoDAO getInstance() {		
		instance = new AlunoDAO();		
		return instance;
	}
	
	public List<Aluno> getByName(String nome) throws SQLException{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Aluno> alunos = null;
		
		try {
			
			String hql = "from Aluno as a"
					+ " where a.nome like :nome";
			
			Query query = session.createQuery(hql);
			query.setParameter("nome", "%" + nome + "%");
			
			alunos = (List<Aluno>) query.list();
	        
		} catch (HibernateException hibernateException) {
			
			session.getTransaction().rollback();
			
			throw new SQLException(hibernateException);
			
		} finally {
		
			session.close();
		}
		
		return alunos;
	}
	
	@Override
	public List<Aluno> getAll() throws SQLException {
		return super.getAll("Aluno.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return Aluno.class;
	}

	@Override
	public Aluno find(Aluno entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
