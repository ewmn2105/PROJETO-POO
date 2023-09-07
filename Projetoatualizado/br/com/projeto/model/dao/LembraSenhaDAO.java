package br.com.projeto.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.projeto.model.vo.CadastroVO;
import br.com.projeto.model.vo.LembrarSenhaVO;
import br.com.projeto.view.LembrarSenhaView;

public class LembraSenhaDAO {
	private String url = "jdbc:mysql://localhost:3306/READ7NOVO";
	private LembrarSenhaView view;
	private Connection conexao;
	public boolean alterarSenha (LembrarSenhaVO lembraVO) {
		try{
			conexao = DriverManager.getConnection (url, "root", "root");
			String sql = "UPDATE Login SET nome = ?, senha = ? WHERE email = ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, lembraVO.getNome());
			statement.setString(2, lembraVO.getSenha());
			statement.setString(3, lembraVO.getEmail());
			int retorno = statement.executeUpdate();
			return retorno > 0;
	        } catch (SQLException e) {
	            return false;
	        }
	}
}