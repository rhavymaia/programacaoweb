package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.resteasyapp.entidade.Escola;

public class EscolaDAO extends GenericDao<Integer, Escola>{

	private static EscolaDAO instance;
	
	public static EscolaDAO getInstance() {		
		instance = new EscolaDAO();		
		return instance;
	}

	@Override
	public List<Escola> getAll() throws SQLException {
		return super.getAll("Escola.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return Escola.class;
	}

	@Override
	public Escola find(Escola entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
