package br.edu.ifpb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.edu.ifpb.entidade.Veiculo;

public class VeiculoDAO implements GenericDAO<Integer, Veiculo> {

static ConnectionFactory banco;
	
	public Connection connection;
	
	private static VeiculoDAO instance;

	public static VeiculoDAO getInstance() {
		
		banco = ConnectionFactory.getInstance();
		
		instance = new VeiculoDAO(banco);
		
		return instance;
	}
	
	public VeiculoDAO(ConnectionFactory banco) {
		this.connection = (Connection) banco.getConnection();
	}
	
	@Override
	public int insert(Veiculo veiculo) throws SQLException {
		
		Integer id = BancoUtil.IDVAZIO;
		
		try {
			
			// Considerar a tabela tb_pessoa composta dos campos: id (int) e nome (varchar).
			String sql = "INSERT INTO tb_veiculo ("
					+ " marca, "
					+ "placa)"
					+ " VALUES (?,?)";
			
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			
			stmt.setString(1, veiculo.getMarca());
			stmt.setString(2, veiculo.getPlaca());
			
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

			// Cadastra e recuperar identificação da Pessoa.
			id = BancoUtil.getGenerateKey(stmt);
		
		} catch (SQLException e) {
			
			connection.close();	
		}
		
		return id;
	}

	@Override
	public void update(Veiculo entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(Integer pk) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Veiculo> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Veiculo getById(Integer pk) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Veiculo> find(Veiculo entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
