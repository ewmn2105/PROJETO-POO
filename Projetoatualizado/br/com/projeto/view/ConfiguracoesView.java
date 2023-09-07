package br.com.projeto.view;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.Component;
import java.awt.event.MouseAdapter;

import br.com.projeto.controller.GenerosController;
import br.com.projeto.controller.TerrorController;
import br.com.projeto.controller.FiccaoController;
import br.com.projeto.controller.RomanceController;
import br.com.projeto.controller.ExclusaoController;
import br.com.projeto.controller.DataConfigController;

public class ConfiguracoesView extends JFrame{
		private String nome;
		private ImageIcon i1, i2, i3, i4, logo, manual1, Con1, sair1, fundocon, excluir, lápis;
		private JLabel lblLogo, acao, sair2, log, del, pencil;
		private Container container;
		TelaPrincipalView login;

		public ConfiguracoesView(String nome) {
			this.nome = nome;
			this.login = login;
			JLabel lblNewLabel = new JLabel("Configurações");
			lblNewLabel.setForeground(new Color(255, 128, 64));
			lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 19));
			lblNewLabel.setBounds(294, 113, 238, 63);
			getContentPane().add(lblNewLabel);
			setBounds(0, 0, 1900, 1080);
			container = getContentPane();
			getContentPane().setBackground(new Color(230, 228, 242));
			logo = new ImageIcon("Imagens/LogoTela.png");
			i1 = new ImageIcon("Imagens/read.png");
			manual1 = new ImageIcon("Imagens/Manual.png");
			Con1 = new ImageIcon("Imagens/Config.png");
			sair1 = new ImageIcon("Imagens/Sair.png");
			fundocon = new ImageIcon("Imagens/FundoCon.png");
			excluir = new ImageIcon("Imagens/Excluir.png");
			lápis = new ImageIcon("Imagens/Lápis.png");
			lblLogo = new JLabel(logo);
			sair2 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo\\Imagens\\Sair.png"));
			log = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo\\Imagens\\read.png"));
			del = new JLabel(excluir);
			pencil = new JLabel(lápis);
			getContentPane().setLayout(null);

			JPanel panel_4 = new JPanel();
			panel_4.setBounds(0, 0, 0, 0);
			getContentPane().add(panel_4);

			JPanel panel_5 = new JPanel();
			panel_5.setBounds(0, 0, 0, 0);
			getContentPane().add(panel_5);

			JPanel panel = new JPanel();
			panel.setBounds(174, 0, 2, 845);
			panel.setBackground(new Color(255, 128, 64));
			getContentPane().add(panel);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(0, 93, 1540, 2);
			panel_1.setBackground(new Color(255, 128, 64));
			getContentPane().add(panel_1);

			JPanel panel_6 = new JPanel();
			panel_6.setBounds(174, 186, 458, 2);
			panel_6.setBackground(new Color(255, 128, 64));
			getContentPane().add(panel_6);

			sair2.setBounds(47, 107, 66, 83);
			sair2.setToolTipText("Sair");
			lblLogo.setBounds(186, 105, 93, 71);
			log.setBounds(196, 189, 206, 183);
			del.setBounds(50, 214, 63, 83);
			pencil.setBounds(50, 321, 63, 83);
		     
			Font fontetip = new Font("Segoe UI Variable", Font.BOLD, 17);
			UIManager.put("ToolTip.font", fontetip);
			UIManager.put("ToolTip.background", (new Color(230, 228, 242)));
			sair2.setToolTipText("Voltar para a tela principal");
			del.setToolTipText("Exclusão de conta");
			pencil.setToolTipText("Alteração de seus dados");
		
			getContentPane().add(lblLogo);
			getContentPane().add(sair2);
			getContentPane().add(log);
			getContentPane().add(del);
			getContentPane().add(pencil);
			
			JLabel l2_1 = new JLabel((Icon) null);
			l2_1.setBounds(774, 186, 234, 213);
			getContentPane().add(l2_1);
			
			String log = nome;
			JLabel lblNewLabel_1 = new JLabel(log);
			lblNewLabel_1.setForeground(new Color(0, 0, 0));
			lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 33));
			lblNewLabel_1.setBounds(413, 251, 533, 63);
			getContentPane().add(lblNewLabel_1);
			
			sair2.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();

				}

				@Override
				public void mousePressed(MouseEvent e) {
					setForeground(Color.ORANGE);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					setForeground(Color.ORANGE);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

			});
			del.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					try {
					String url = "jdbc:mysql://localhost:3306/READ7NOVO";
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					ExclusaoView view = new ExclusaoView();
					ExclusaoController controle = new ExclusaoController(view, conexao);
					view.setVisible(true);
					JOptionPane.showMessageDialog(null, "Esta sessão envolve a exclusão de sua conta\n Se decidir seguir, poderás deletar sua conta e perder todos\nos teus registros", "Exclusão de conta", JOptionPane.WARNING_MESSAGE);
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
				
			});
			pencil.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					try {
					String url = "jdbc:mysql://localhost:3306/READ7NOVO";
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					DataConfigView view = new DataConfigView();
					DataConfigController controle = new DataConfigController(view, conexao);
					view.setVisible(true);
					view.setResizable(false);
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
				
			});
			setVisible(true);
		}
		public String getLogin(String nome) {
			return nome; 
		}
}
