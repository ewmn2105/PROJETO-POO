package br.com.projeto.model.dao;


import java.sql.*;

public class ConexaoDAO {
	public Connection connection = null;
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String DBNAME = "READ7";
	private final String URL = "jdbc:mysql://localhost:3306/READ7NOVO";
	private final String LOGIN = "root";
	private final String SENHA = "root";

	/**
	 * * metodo que faz conexao com o banco de dados retorna true se houve *
	 * sucesso, ou false em caso negativo
	 */
	public boolean getConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, LOGIN, SENHA);
			System.out.println("Conectou");
			return true;
		} catch (ClassNotFoundException erro) {
			System.out.println("Driver nao encontrado " + erro.toString());
			return false;
		} catch (SQLException erro) {
			System.out.println("Falha ao conectar " + erro.toString());
			return false;
		}
	}

	public void close() {
		try {
			connection.close();
			System.out.println("Desconectou");
		} catch (SQLException erro) {
		}
	}
}