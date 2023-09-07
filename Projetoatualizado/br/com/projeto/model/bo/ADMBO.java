package br.com.projeto.model.bo;
import java.sql.Connection;

import br.com.projeto.model.dao.ADMDAO;
import br.com.projeto.model.dao.CadastroDAO;
import br.com.projeto.model.vo.ADMVO;
import br.com.projeto.model.vo.CadastroVO;
public class ADMBO{
	private ADMDAO admDAO;
	public ADMBO() {
		admDAO = new ADMDAO();
	}
	public boolean removeLogin (ADMVO removelogin) {
		return admDAO.removecad(removelogin);
	}
}

