package br.edu.ifpb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.entidade.Pessoa;

public class PessoaDAO implements GenericDAO<Integer, Pessoa>{

	static ConnectionFactory banco;
	
	public Connection connection;
	
	private static PessoaDAO instance;

	public static PessoaDAO getInstance() {
		
		banco = ConnectionFactory.getInstance();
		
		instance = new PessoaDAO(banco);
		
		return instance;
	}
	
	public PessoaDAO(ConnectionFactory banco) {
		this.connection = (Connection) banco.getConnection();
	}

	@Override
	public int insert(Pessoa entity) throws SQLException {
		
		Integer id = BancoUtil.IDVAZIO;
		
		try {
			
			String sql = "[DML-Inserção]";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

			// Cadastra e recuperar identificação da Pessoa.
			id = BancoUtil.getGenerateKey(stmt);
		
		} catch (SQLException e) {
			
			connection.close();	
		}
		
		return id;
	}

	@Override
	public void update(Pessoa entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(Integer pk) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Pessoa> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Pessoa> find(Pessoa entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa getById(Integer id) throws SQLException {
		
		Pessoa pessoa = null;

		PreparedStatement stmt = null;
		
		ResultSet rs = null;

		try {

			// Considerar a tabela tb_pessoa composta dos campos id (int) e nome (varchar).
			String sql = "SELECT pessoa.id, pessoa.nome"
					+ "FROM tb_pessoa AS pessoa"
					+ "WHERE pessoa.id = " 
					+ id;

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Pessoa> pessoas = convertToList(rs);

			if (!pessoas.isEmpty())
				pessoa = pessoas.get(0);

		} catch (SQLException sqle) {
			
			throw sqle;
			
		} finally {

			connection.close();
		}

		return pessoa;
	}

	private List<Pessoa> convertToList(ResultSet rs) throws SQLException {
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {

			while (rs.next()) {

				// Pessoa
				Pessoa pessoa = new Pessoa();

				pessoa.setId(rs.getInt("pessoa.id_pessoa"));
				pessoa.setNome(rs.getString("pessoa.nm_pessoa"));
				
				pessoas.add(pessoa);
			}

		} catch (SQLException sqle) {
			
			throw sqle;
		}

		return pessoas;
	}
}
