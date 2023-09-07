package br.com.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.projeto.model.bo.ADMBO;
import br.com.projeto.model.dao.ConexaoDAO;
import br.com.projeto.model.vo.ADMVO;
import br.com.projeto.view.ConfiguracoesView;
import br.com.projeto.view.ExclusaoView;
import br.com.projeto.view.LoginView;
import br.com.projeto.view.TelaADMView;
import br.com.projeto.view.TelaPrincipalView;

public class ExclusaoController {
	private LoginView logview;
	TelaPrincipalView tpview;
	ConfiguracoesView conview;
	private ExclusaoView view;
	private ADMBO admBO;
	private ConexaoDAO conexao;
	public ExclusaoController(ExclusaoView view, Connection conexao) {
		this.view = view;
		admBO = new ADMBO();
		view.addBtnExcluirListener(new excluirListener());
	}
	class excluirListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		 	 String email = view.getEmail();
          	 ADMVO removeLogin = new ADMVO();
          	 removeLogin.setEmail(email);
          	 boolean removido = admBO.removeLogin(removeLogin);
          	 if (removido == true) {
          		view.mensagem("Sua conta foi removida.\nAgora, o aplicativo será fechado");
          		view.mensagem("Foi bom ter você conosco");
          		System.exit(0);
          	 	 
          	 } else if (removido == false){
          		 view.mensagemErro("O e-mail informado não está de acordo com os registros");
          	}
		}
	}
}
