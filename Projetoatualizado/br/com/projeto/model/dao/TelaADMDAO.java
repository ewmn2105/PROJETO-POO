package br.com.projeto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaADMDAO {
	private Connection conexao;
	public TelaADMDAO(Connection conexao) {
		this.conexao = conexao;
	}
	public boolean verificaLoginADM(String nome, String senha) {
		try {
			String sql = "SELECT * FROM LoginADM WHERE nome = ? AND senha = ?";
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
