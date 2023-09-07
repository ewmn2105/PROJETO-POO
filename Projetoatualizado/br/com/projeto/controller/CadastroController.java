package br.com.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.projeto.controller.LembrarSenhaController.lembraListener;
import br.com.projeto.model.bo.CadastroBO;
import br.com.projeto.model.bo.LembrarSenhaBO;
import br.com.projeto.model.vo.CadastroVO;
import br.com.projeto.model.vo.LembrarSenhaVO;
import br.com.projeto.view.CadastroView;
import br.com.projeto.view.LembrarSenhaView;
import br.com.projeto.view.TelaADMView;

public class CadastroController {
	private CadastroView view;
	private TelaADMView view2;
	private CadastroBO cadastroBO;
	public CadastroController (CadastroView view, Connection conexao) {
		this.view = view;
		cadastroBO = new CadastroBO ();
		view.addBtnCadastrar(new cadListener());
	}
	class cadListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
          	 String nome = view.getNome();
          	 String senha = view.getSenha();
          	 String email = view.getEmail();
          	 CadastroVO novoLogin = new CadastroVO();
          	 novoLogin.setNome(nome);
          	 novoLogin.setSenha(senha);
          	 novoLogin.setEmail(email);
          	 CadastroBO cadastroBO = new CadastroBO();
          	 boolean cadastrado = cadastroBO.cadLogin(novoLogin);
          	 if (cadastrado) {
          		 view.mensagem("Cadastro Efetuado");
          	 	 view.dispose();
          	 } else {
          	 JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário.");
          	}
   	 }
	}

}