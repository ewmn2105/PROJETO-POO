package br.com.projeto.model.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.projeto.model.dao.ConexaoDAO;
import br.com.projeto.model.dao.LoginDAO;
import br.com.projeto.model.dao.TelaADMDAO;
import br.com.projeto.model.vo.LoginVO;
public class LoginBO {
	private LoginDAO loginDAO;
	private TelaADMDAO telaDAO;
	public LoginBO(Connection conexao) {
		loginDAO = new LoginDAO(conexao);
		telaDAO = new TelaADMDAO(conexao);
	}
	public boolean verificaLogin (LoginVO login) {
		return loginDAO.verificaLogin(login.getNome(), login.getSenha());
	}
	public boolean verificarLoginAdm(LoginVO adm) {
		return telaDAO.verificaLoginADM(adm.getNome(), adm.getSenha());
	}

}
