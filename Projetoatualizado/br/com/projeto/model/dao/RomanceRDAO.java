package br.com.projeto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RomanceRDAO {
	private Connection conexao;
	private String url = "jdbc:mysql://localhost:3306/READ7NOVO";
	public ResultSet Leitura1(Connection conexao, String title, String autor) {
	    try {
	    	String sql = "SELECT Resumo FROM Romance WHERE titulo = ? AND Autor = ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, title);
			statement.setString(2, autor);
			
    		ResultSet resultado = statement.executeQuery();
       		return resultado;
	    } catch (SQLException slcte) {
	        return null;
	    }
	}

}