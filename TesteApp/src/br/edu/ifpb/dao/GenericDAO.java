package br.edu.ifpb.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<PK, T> {

	public int insert(T entity) throws SQLException;

	public void update(T entity) throws SQLException;

	public int delete(PK pk) throws SQLException;

	public List<T> getAll() throws SQLException;

	public T getById(PK pk) throws SQLException;

	public List<T> find(T entity) throws SQLException;	
}