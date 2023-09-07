package br.com.projeto.controller;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;

import br.com.projeto.view.*;
public class Main {
	public static void main (String[]args) {
		try {
			String url = "jdbc:mysql://localhost:3306/READ7NOVO";
			Connection conexao = DriverManager.getConnection(url, "root", "root");
			TelaBemVindoView tela = new TelaBemVindoView();
			tela.setVisible(true);
			Thread.sleep(3000);
			tela.setVisible(false);
			LoginView view = new LoginView();
			LoginController controle = new LoginController (view, conexao);
			view.setResizable(false);
			view.setVisible(true);
			}catch (Exception e) {}
		}

	}


