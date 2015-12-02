package br.edu.ifpb.opining.dao;

import java.sql.ResultSet;
import java.util.List;

import org.hibernate.HibernateException;

import br.edu.ifpb.opining.entidades.Pessoa;

public class PessoaDAO implements GenericDAO<Integer, Pessoa>{

	@Override
	public int insert(Pessoa entity) throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Pessoa entity) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(Integer pk) throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Pessoa> getAll() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa getById(Integer pk) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> find(Pessoa entity) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> convertToList(ResultSet rs) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
