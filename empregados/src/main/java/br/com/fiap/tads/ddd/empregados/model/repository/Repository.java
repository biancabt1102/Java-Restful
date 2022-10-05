package br.com.fiap.tads.ddd.empregados.model.repository;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classe repository
 *
 *
 * @author Francis
 *
 */
public class Repository {

	protected static Connection connection;

	/**
	 * Construtor padao
	 */
	public Repository() {
		super();
		getConnection();
	}

	/**
	 * Consegue uma conexao com o banco de dados
	 *
	 * @see ConnectionFactory#getInstance()
	 *
	 * @return
	 */
	public static Connection getConnection() {
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			return connection;
		} catch (Exception e) {
			System.out.println("Erro nos parametros da conexao com o banco de dados :" + e.getMessage());
		}
		return null;
	}

	/**
	 * Fecha a conexão com o banco de dados
	 */
	public static void closeConnection() {

		try {
			// se a conexão não estiver fechada, feche-a
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao encerrar conexao:" + " \n" + ex.getMessage());
		}
	}

}
