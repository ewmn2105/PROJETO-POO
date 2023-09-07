package br.com.projeto.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.projeto.controller.GenerosController.listener;
import br.com.projeto.controller.GenerosController.salvarListener;
import br.com.projeto.model.dao.AcaoDAO;
import br.com.projeto.model.dao.AcaoRDAO;
import br.com.projeto.model.dao.TerrorRDAO;
import br.com.projeto.view.TelaRAcaoView;
import br.com.projeto.view.TelaTerrorRView;
import br.com.projeto.view.AcaoView;

public class TerrorRController {
	private TelaTerrorRView view;
	private TerrorRDAO trDAO;
	public TerrorRController(TelaTerrorRView view, Connection conexao) {
		this.view = view;
		this.trDAO = new TerrorRDAO();
		//viewa = new AcaoView();
		view.addBtnPegaTxt(new listener());
	}
	class listener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			try {
			String url = "jdbc:mysql://localhost:3306/READ7NOVO";
			Connection conexao = DriverManager.getConnection(url, "root", "root");
			String titulo = view.getTitulo();
			String autor = view.getAutor();
			ResultSet resultado = trDAO.Leitura1(conexao, titulo, autor);
			try {
				if (resultado.next()) {
					String texto = resultado.getNString("Resumo");
					view.setTexto(texto);
				}else {
					JOptionPane.showMessageDialog(null, "Nome ou autor não encontrados nos registros", "Erro ao encontrar o resumo", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}catch(SQLException sqle) {}
			
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

}

	