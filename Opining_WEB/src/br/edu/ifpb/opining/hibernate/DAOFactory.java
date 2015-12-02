package br.edu.ifpb.opining.hibernate;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class DAOFactory {
	
	public static Session session;
	
	public DAOFactory(){
		Configuration config = new Configuration().configure();
		session = config.buildSessionFactory().openSession();
	}
	
	public void dispose(){
		session.disconnect();
	}
}