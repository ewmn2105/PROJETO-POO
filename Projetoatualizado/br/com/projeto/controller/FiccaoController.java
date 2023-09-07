package br.com.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.projeto.controller.CadastroController.cadListener;
import br.com.projeto.model.bo.CadastroBO;
import br.com.projeto.model.dao.AcaoDAO;
import br.com.projeto.model.dao.TerrorDAO;
import br.com.projeto.model.dao.FiccaoDAO;
import br.com.projeto.model.vo.CadastroVO;
import br.com.projeto.view.AcaoView;
import br.com.projeto.view.CadastroView;
import br.com.projeto.view.TerrorView;
import br.com.projeto.view.FiccaoView;
import br.com.projeto.view.RomanceView;
import br.com.projeto.view.TelaADMView;

import br.com.projeto.model.vo.GenerosVO;
import br.com.projeto.model.bo.GenerosBO;

public class FiccaoController {
	private FiccaoView view;
	private FiccaoDAO fiDAO;
	public FiccaoController(FiccaoView view, Connection conexao) {
		this.view = view;
		this.fiDAO = new FiccaoDAO();
		view.addBtnPegaTxt(new listener());
		view.addBtnSalvar(new salvarListener());
		
	}

	class listener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			ResultSet resultado = fiDAO.Leitura();
			try {
				if (resultado.next()) {
					String texto = resultado.getNString("texto1");
					view.setTexto(texto);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	class salvarListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			String titulo = view.getTitulo();
			String autor = view.getAutor();
			String texto = view.getTexto();
			GenerosVO ficcaoVO = new GenerosVO();
			ficcaoVO.setTitulo(titulo);
			ficcaoVO.setAutor(autor);
			ficcaoVO.setTexto(texto);
			GenerosBO ficBO = new GenerosBO();
			boolean inserido = ficBO.InserirFiccao(ficcaoVO);
			if(inserido) {
				view.mensagem("Texto inserido");
			}else {
				view.mensagem("Texto não inserido");
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		/*public void actionPerformed(ActionEvent e) {
			String titulo = view.getTitulo();
			String autor = view.getAutor();
			String texto = view.getTexto();
			GenerosVO acaoVO = new GenerosVO();
			acaoVO.setTitulo(titulo);
			acaoVO.setAutor(autor);
			acaoVO.setTexto(texto);
			GenerosBO acaoBO = new GenerosBO();
			boolean inserido = acaoBO.InserirAcao(acaoVO);
			if(inserido) {
				view.mensagem("Texto inserido");
			}else {
				view.mensagem("Texto não inserido");
			}
		}*/
	}
}