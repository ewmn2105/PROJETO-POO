package br.com.projeto.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.projeto.model.vo.ADMVO;
import br.com.projeto.model.vo.CadastroVO;

public class ADMDAO {
	private String url = "jdbc:mysql://localhost:3306/READ7NOVO";
	public boolean removecad (ADMVO removeLogin) {
		try {
			Connection conexao = DriverManager.getConnection (url, "root", "root");
			String sql = "DELETE FROM Login WHERE email = ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, removeLogin.getEmail());
			int rowsAffected = statement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            return false;
	        }
	}
}
