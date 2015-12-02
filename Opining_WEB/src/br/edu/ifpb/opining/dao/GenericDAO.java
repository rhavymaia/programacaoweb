package br.edu.ifpb.opining.dao;

import java.sql.ResultSet;
import java.util.List;

import org.hibernate.HibernateException;

public interface GenericDAO<PK, T> {

	public int insert(T entity) throws HibernateException;

	public void update(T entity) throws HibernateException;

	public int delete(PK pk) throws HibernateException;

	public List<T> getAll() throws HibernateException;

	public T getById(PK pk) throws HibernateException;

	public List<T> find(T entity) throws HibernateException;

	public List<T> convertToList(ResultSet rs) throws HibernateException;
	
}