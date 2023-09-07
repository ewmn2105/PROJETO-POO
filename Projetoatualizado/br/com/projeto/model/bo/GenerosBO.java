package br.com.projeto.model.bo;

import br.com.projeto.model.dao.AcaoDAO;
import br.com.projeto.model.dao.CadastroDAO;
import br.com.projeto.model.dao.RomanceDAO;
import br.com.projeto.model.vo.CadastroVO;
import br.com.projeto.model.dao.FiccaoDAO;
import br.com.projeto.model.dao.TerrorDAO;
import br.com.projeto.model.vo.GenerosVO;

public class GenerosBO {
	private AcaoDAO acaoDAO;
	private RomanceDAO RomanDAO;
	private TerrorDAO TerrorDAO;
	private FiccaoDAO FicDAO;
	public GenerosBO() {
		acaoDAO = new AcaoDAO();
		TerrorDAO = new TerrorDAO();
		FicDAO = new FiccaoDAO();
		RomanDAO = new RomanceDAO();
	}
	public boolean InserirAcao (GenerosVO textoAcao) {
		return acaoDAO.InserirAcao(textoAcao);
	}
	public boolean InserirTerror (GenerosVO textoterror) {
		return TerrorDAO.InserirTerror(textoterror);
	}
	public boolean InserirFiccao (GenerosVO textofic) {
		return RomanDAO.InserirRomance(textofic);
	}
	public boolean InserirRomance (GenerosVO textoroman) {
		return FicDAO.InserirFiccao(textoroman);
	}

}
