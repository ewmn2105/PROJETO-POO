package br.com.projeto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	private Connection conexao;

	public LoginDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public boolean verificaLogin(String nome, String senha) {
		try {
			String sql = "SELECT * FROM Login WHERE nome = ? AND senha = ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, nome);
			statement.setString(2, senha);
			ResultSet resultado = statement.executeQuery();
			return resultado.next();
		} catch (SQLException e) {
			return false;
		}
	}
}
