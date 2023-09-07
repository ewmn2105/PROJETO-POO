package br.com.projeto.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import br.com.projeto.controller.AcaoRController;
import br.com.projeto.controller.FiccaoController;
import br.com.projeto.controller.FiccaoRController;
import br.com.projeto.controller.GenerosController;
import br.com.projeto.controller.RomanceController;
import br.com.projeto.controller.RomanceRController;
import br.com.projeto.controller.TerrorController;
import br.com.projeto.controller.TerrorRController;
import br.com.projeto.controller.FiccaoRController;

public class ResumosView extends JFrame{
	private String nome;
	private ImageIcon i1, i2, i3, i4, logo, manual1, Con1, sair1;
	private JLabel l1, l2, l3, l4, lblLogo, acao, sair2;
	private Container container;

	public ResumosView() {
		super();
		this.nome = nome;
		inicializaComponentes();
	}
	public void inicializaComponentes() {
		Font fontetip = new Font("Segoe UI Variable", Font.BOLD, 17);
		UIManager.put("ToolTip.font", fontetip);
		UIManager.put("ToolTip.background", (new Color(230, 228, 242)));
		setBounds(0, 0, 1900, 1080);
		container = getContentPane();
		getContentPane().setBackground(new Color(230, 228, 242));
		logo = new ImageIcon("Imagens/LogoTela.png");
		i1 = new ImageIcon("Imagens/acao.png");
		i2 = new ImageIcon("Imagens/Terror.png");
		i3 = new ImageIcon("Imagens/Ficção.png");
		i4 = new ImageIcon("Imagens/Romance.png");
		manual1 = new ImageIcon("Imagens/Manual.png");
		Con1 = new ImageIcon("Imagens/Config.png");
		sair1 = new ImageIcon("Imagens/Sair.png");
		l1 = new JLabel(i1);
		l1.setBounds(205, 204, 234, 213);
		l2 = new JLabel(i2);
		l2.setBounds(489, 202, 234, 213);
		l3 = new JLabel(i3);
		l3.setBounds(787, 204, 234, 213);
		l4 = new JLabel(i4);
		l4.setBounds(1085, 203, 234, 206);
		lblLogo = new JLabel(logo);
		sair2 = new JLabel(sair1);
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
		panel_1.setBounds(0, 70, 1540, 2);
		panel_1.setBackground(new Color(255, 128, 64));
		getContentPane().add(panel_1);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(174, 166, 750, 2);
		panel_6.setBackground(new Color(255, 128, 64));
		getContentPane().add(panel_6);

		sair2.setBounds(48, 96, 66, 83);
		sair2.setToolTipText("Sair");
		lblLogo.setBounds(191, 77, 93, 71);
		getContentPane().add(lblLogo);
		getContentPane().add(l1);
		getContentPane().add(l2);
		getContentPane().add(l3);
		getContentPane().add(l4);
		getContentPane().add(sair2);

		JLabel l2_1 = new JLabel((Icon) null);
		l2_1.setBounds(774, 186, 234, 213);
		getContentPane().add(l2_1);

		JLabel lblAcao = new JLabel("Ação");
		l1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaRAcaoView view = new TelaRAcaoView();
					String url = "jdbc:mysql://localhost:3306/textos";
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					AcaoRController controle = new AcaoRController(view, conexao);
					/*TerrorRController controle2 = new TerrorRController(view, conexao);
					FiccaoRController controle3 = new FiccaoRController(view, conexao);
					RomanceRController controle4 = new RomanceRController(view, conexao);*/
					view.setVisible(true);
					view.setExtendedState(JFrame.MAXIMIZED_BOTH);
					}catch(SQLException sqle) {}

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
		l2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaTerrorRView view = new TelaTerrorRView();
					String url = "jdbc:mysql://localhost:3306/textos";
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					TerrorRController controle2 = new TerrorRController(view, conexao);
					/*FiccaoRController controle3 = new FiccaoRController(view, conexao);
					RomanceRController controle4 = new RomanceRController(view, conexao);*/
					view.setVisible(true);
					view.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}catch(SQLException sqle) {}

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
		l3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaFiccaoRView view = new TelaFiccaoRView();
					String url = "jdbc:mysql://localhost:3306/textos";
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					FiccaoRController controle2 = new FiccaoRController(view, conexao);
					
					//RomanceRController controle4 = new RomanceRController(view, conexao);*/
					view.setVisible(true);
					view.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}catch(SQLException sqle) {}

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
		l4.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaRomanceRView view = new TelaRomanceRView();
					String url = "jdbc:mysql://localhost:3306/textos";
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					RomanceRController controle = new RomanceRController(view, conexao);
					view.setVisible(true);
					view.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}catch(SQLException sqle) {}

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
		lblAcao.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblAcao.setBounds(289, 439, 52, 30);
		getContentPane().add(lblAcao);

		JLabel lblTerror = new JLabel("Terror");
		lblTerror.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblTerror.setBounds(575, 437, 66, 30);
		getContentPane().add(lblTerror);

		JLabel lblRomance = new JLabel("Ficção");
		lblRomance.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblRomance.setBounds(871, 439, 56, 30);
		getContentPane().add(lblRomance);

		JLabel lblFiccao = new JLabel("Romance");
		lblFiccao.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblFiccao.setBounds(1155, 439, 93, 30);
		getContentPane().add(lblFiccao);
		
		JLabel lblEscolhaQualO = new JLabel("Escolha qual o gênero para pesquisar o teu resumo");
		lblEscolhaQualO.setFont(new Font("Segoe UI Variable", Font.PLAIN, 27));
		lblEscolhaQualO.setBounds(301, 76, 678, 88);
		getContentPane().add(lblEscolhaQualO);

		setVisible(true);
	}
}

