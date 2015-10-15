package trabalho.unipe.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import trabalho.unipe.entity.Pessoa;

/**
 * @author Thomas Matheus
 */
public class PessoaDao extends Dao {
	
	/**
	 * 
	 * @param pessoa
	 * @throws SQLException
	 */
	public void insert(Pessoa pessoa) throws SQLException{
		openConnection();
			
		stmt = connection.prepareStatement("INSERT INTO pessoa VALUES(null, ?, ?, ?, ?, ?)");
		stmt.setString(1, pessoa.getNome());
		stmt.setString(2, pessoa.getCpf());
		stmt.setString(3, pessoa.getCep());
		stmt.setString(4, pessoa.getLogradouro());
		stmt.setString(5, pessoa.getBairro());
		stmt.execute();
		stmt.close();
		
		closeConnection();
	}
	
	/**
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public void delete(int id) throws SQLException{
		openConnection();
		
		stmt = connection.prepareStatement("DELETE FROM pessoa WHERE id = ?");
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		
		closeConnection();
	}
	
	/**
	 * 
	 * @param pessoa
	 * @throws SQLException
	 */
	public void update(Pessoa pessoa) throws SQLException{
		openConnection();
		
		stmt = connection.prepareStatement("UPDATE pessoa SET nome = ?, cpf = ?, cep = ?, logradouro = ?, bairro = ? WHERE id = ? ");
		stmt.setString(1, pessoa.getNome());
		stmt.setString(2, pessoa.getCpf());
		stmt.setString(3, pessoa.getCep());
		stmt.setString(4, pessoa.getLogradouro());
		stmt.setString(5, pessoa.getBairro());
		stmt.setInt(6, pessoa.getId());
		stmt.execute();
		stmt.close();
		
		closeConnection();
	}
	
	/**
	 * 
	 * @return List pessoa
	 * @throws SQLException
	 */
	public List findAll() throws SQLException {
		openConnection();
			
		stmt = connection.prepareStatement("SELECT * FROM pessoa");
		result = stmt.executeQuery();
		
		List lista = new ArrayList<>();
		
		while(result.next()) {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(result.getInt("id"));
			pessoa.setNome(result.getString("nome"));
			pessoa.setCpf(result.getString("cpf"));
			pessoa.setCep(result.getString("cep"));
			pessoa.setLogradouro(result.getString("logradouro"));
			pessoa.setBairro(result.getString("bairro"));
			lista.add(pessoa);
		}
		stmt.close();
		
		closeConnection();
		return lista;
	}
	
	/**
	 * 
	 * @param id
	 * @return pessoa
	 * @throws SQLException
	 */
	public Pessoa findByOne(int id) throws SQLException{
		openConnection();
		
		stmt = connection.prepareStatement("SELECT * FROM pessoa WHERE id = ?");
		stmt.setInt(1, id);
		result = stmt.executeQuery();
		
		Pessoa pessoa = new Pessoa();
		
		if(result.next()) {
			pessoa.setId(result.getInt("id"));
			pessoa.setNome(result.getString("nome"));
			pessoa.setCpf(result.getString("cpf"));
			pessoa.setCep(result.getString("cep"));
			pessoa.setLogradouro(result.getString("logradouro"));
			pessoa.setBairro(result.getString("bairro"));
		}
		stmt.close();
		closeConnection();
		
		return pessoa;
	}
}
