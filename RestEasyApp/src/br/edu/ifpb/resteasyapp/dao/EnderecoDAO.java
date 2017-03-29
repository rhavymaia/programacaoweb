package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifpb.resteasyapp.entidade.Endereco;
import br.edu.ifpb.resteasyapp.hibernate.HibernateUtil;

public class EnderecoDAO extends GenericDao<Integer, Endereco> {

	private static EnderecoDAO instance;
	
	public static EnderecoDAO getInstance() {		
		instance = new EnderecoDAO();		
		return instance;
	}
	
	public List<Endereco> getEnderecoByLogradouro(String logradouro) throws SQLException{

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Endereco> enderecos = new ArrayList<Endereco>();
		
		try {
			// Montar hql e definir os parâmetros;
			String hql = "from Endereco as e"
					+ " where e.logradouro like :logradouro";

			// Inserir os parâmetros na consulta;
			Query query = session.createQuery(hql);
			query.setString("logradouro", "%" + logradouro + "%");
			
			// Executo a pesquisa;
			// Capturo as respostas.			
			enderecos = (List<Endereco>) query.list();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new SQLException(hibernateException);

		} finally {

			session.close();
		}

		return enderecos;
	}

	@Override
	public List<Endereco> getAll() throws SQLException {
		return getAll("Endereco.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return Endereco.class;
	}

	@Override
	public Endereco find(Endereco entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
