package br.edu.ifpb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static ConnectionFactory connFactory;
	
	public static ConnectionFactory getInstance() {
		
		if (connFactory == null)
			connFactory = new ConnectionFactory();
		
		return connFactory;
	}
	
	public Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			// Endereço do Banco, Usuário e Senha. Substituir: [BANCO], [USUARIO], [SENHA]
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/[BANCO]", 
					"[USUARIO]", 
					"[SENHA]");
			
		} catch (SQLException | ClassNotFoundException e) {
			
			throw new RuntimeException(e);
		}
	}
}