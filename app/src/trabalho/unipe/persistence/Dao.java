package trabalho.unipe.persistence;

import java.sql.*;

/**
 * @author Thomas Matheus
 */
public class Dao {
	
	Connection connection;
	PreparedStatement stmt;
	ResultSet result;
	
	private String dbUser = "root";
	private String dbPass = "";
	
	/**
	 * Inicia conexão com o banco de dados
	 */
	public void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", this.dbUser, this.dbPass);
		} catch (Exception e) {
			System.out.println("Ocorreu um problema durante a conexão " + e.getMessage());
		}
	}
	
	/**
	 * Fecha a conexão com o banco de dados
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		connection.close();
	}
}
