package br.com.projeto.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import br.com.projeto.view.*;
import br.com.projeto.model.bo.LoginBO;
import br.com.projeto.model.vo.LoginVO;
public class LoginController {
	private LoginView view;
	private LoginVO vo;
	private LoginBO loginBO;
	String url = "jdbc:mysql://localhost:3306/READ7NOVO";
	public LoginController (LoginView view, Connection conexao) {
		this.view = view;
		loginBO = new LoginBO (conexao);
		view.addBtnLoginListener(new logListener());
		view.addBtnCriarCadastro(new cadListener());
		view.addBtnLembrarSenha(new lembraListener());
	}
	class logListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			String nome = view.getNome();
			String senha = view.getSenha();
			LoginVO login = new LoginVO();
			login.setNome(nome);
			login.setSenha(senha);
			LoginVO adm = new LoginVO();
			adm.setNome(nome);
			adm.setSenha(senha);
			boolean logado = loginBO.verificaLogin(login);
	        boolean admLogado = loginBO.verificarLoginAdm(login);
	        if (logado == true) {
	        	try {
	        		Connection conexao = DriverManager.getConnection(url, "root", "root");
	                view.dispose();
	                TelaPrincipalView tela2 = new TelaPrincipalView(nome);
	                AcaoView roman = new AcaoView();
	                tela2.setVisible(true);
	                tela2.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        	}catch(Exception g) {}
	        }else if(admLogado == true) {
	        	try {
	        	Connection conexao = DriverManager.getConnection(url, "root", "root");
	        	TelaADMView telaADM = new TelaADMView();
	        	ADMController controle = new ADMController(telaADM, conexao);
	        	telaADM.setVisible(true);
	        	telaADM.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        }catch(SQLException e5) {}
	        }else if (logado == false && admLogado == false) {
        		view.mensagem("Nome ou senha incorretos");
	        }
		}
	}
	class cadListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			try {
		    Connection conexao = DriverManager.getConnection(url, "root", "root");
			CadastroView cad = new CadastroView();
			CadastroController controle = new CadastroController(cad, conexao);
			cad.setVisible(true);
			cad.setResizable(false);
		}catch(SQLException e3) {}
		}
	}
	class lembraListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			try {
			Connection conexao = DriverManager.getConnection(url, "root", "root");
			LembrarSenhaView leb = new LembrarSenhaView();
			LembrarSenhaController lembra = new LembrarSenhaController(leb, conexao);
			leb.setVisible(true);
			leb.setResizable(false);
		}catch (SQLException e2) {} 
		}
	}
}

