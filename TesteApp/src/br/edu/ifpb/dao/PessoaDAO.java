package br.edu.ifpb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.entidade.Pessoa;

/**
 * Estrutura da tabela `tb_pessoa`
 * CREATE TABLE IF NOT EXISTS `tb_pessoa` (
 * 	`id_pessoa` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave de pessoa.',
 * 	`nm_pessoa` varchar(80) NOT NULL COMMENT 'Nome da pessoa',
 * 	`nm_endereco` varchar(150) NOT NULL COMMENT 'Endereço completo da pessoa.',
 * 	PRIMARY KEY (`id_pessoa`)
 * ) ENGINE=InnoDB  DEFAULT CHARSET=latin1;
 * 	
 * @author Rhavy
 *
 */
public class PessoaDAO implements GenericDAO<Integer, Pessoa> {

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
	public int insert(Pessoa pessoa) throws SQLException {
		
		Integer id = BancoUtil.IDVAZIO;
		
		try {
			
			// Considerar a tabela tb_pessoa composta dos campos: id_pessoa (int), nm_pessoa (varchar) e nm_endereco (varchar).
			String sql = "INSERT INTO tb_pessoa ("
					+ " nm_pessoa, "
					+ " nm_endereco)"
					+ " VALUES (?,?)";
			
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEndereco());
			
			stmt.execute();

			// Cadastra e recuperar identificação da Pessoa.
			id = BancoUtil.getGenerateKey(stmt);
		
		} catch (SQLException e) {
			
			System.out.println(e);
				
		} finally {
			
			connection.close();
		}
		
		return id;
	}

	@Override
	public Pessoa getById(Integer id) throws SQLException {
		
		Pessoa pessoa = null;

		PreparedStatement stmt = null;
		
		ResultSet rs = null;

		try {

			// Considerar a tabela tb_pessoa composta dos campos: id (int) e nome (varchar).
			String sql = "SELECT pessoa.id_pessoa,"
					+ " pessoa.nm_pessoa,"
					+ " pessoa.nm_endereco"
					+ " FROM tb_pessoa AS pessoa"
					+ " WHERE pessoa.id_pessoa = " 
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
				pessoa.setEndereco(rs.getString("pessoa.nm_endereco"));
				
				pessoas.add(pessoa);
			}

		} catch (SQLException sqle) {
			
			throw sqle;
		}

		return pessoas;
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
}
