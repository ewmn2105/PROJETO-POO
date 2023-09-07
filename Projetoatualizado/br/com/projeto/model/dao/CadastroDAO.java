package br.com.projeto.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.projeto.model.vo.CadastroVO;

public class CadastroDAO {
	private String url = "jdbc:mysql://localhost:3306/READ7NOVO";
	public boolean novocad (CadastroVO novologin) {
		try {
			Connection conexao = DriverManager.getConnection (url, "root", "root");
			String sql = "INSERT INTO Login (nome, senha, email) VALUE (?, ?, ?)";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, novologin.getNome());
			statement.setString(2, novologin.getSenha());
			statement.setString(3, novologin.getEmail());
			int rowsAffected = statement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            return false;
	        }
	}
}
