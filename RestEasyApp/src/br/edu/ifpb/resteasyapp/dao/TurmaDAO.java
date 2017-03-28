package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.resteasyapp.entidade.Turma;

public class TurmaDAO extends GenericDao<Integer, Turma>{

	@Override
	public List<Turma> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return getAll("Turma.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		return Turma.class;
	}

	@Override
	public Turma find(Turma entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
