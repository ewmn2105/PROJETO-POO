package br.com.projeto.model.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.projeto.model.dao.LembraSenhaDAO;
import br.com.projeto.model.vo.LembrarSenhaVO;
import br.com.projeto.model.vo.LoginVO;
public class LembrarSenhaBO {
	private LembraSenhaDAO lembraDAO;
	public LembrarSenhaBO() {
		lembraDAO = new LembraSenhaDAO();
	}
	public boolean alterarSenha (LembrarSenhaVO alter) {
		return lembraDAO.alterarSenha(alter);
	}
}
