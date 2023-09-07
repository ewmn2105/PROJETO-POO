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
import br.com.projeto.controller.AcaoRController;
import br.com.projeto.controller.TerrorRController;
import br.com.projeto.controller.FiccaoRController;
import br.com.projeto.controller.RomanceRController;

public class TelaPrincipalView extends JFrame {
	private String nome;
	private ImageIcon i1, i2, i3, i4, logo, manual1, Con1, sair1;
	private JLabel l1, l2, l3, l4, lblLogo, acao, manual2, con2, sair2, lblNewLabel;
	private Container container;

	public TelaPrincipalView(String nome) {
		super();
		this.nome = nome;
		inicializaComponentes();
	}
	public void inicializaComponentes() {
		Font fontetip = new Font("Segoe UI Variable", Font.BOLD, 17);
		UIManager.put("ToolTip.font", fontetip);
		UIManager.put("ToolTip.background", (new Color(230, 228, 242)));
		
		lblNewLabel = new JLabel("Bem vindo, " + nome);
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 17));
		lblNewLabel.setBounds(294, 93, 238, 63);
		getContentPane().add(lblNewLabel);
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
		l1.setBounds(205, 186, 234, 213);
		l2 = new JLabel(i2);
		l2.setBounds(489, 184, 234, 213);
		l3 = new JLabel(i3);
		l3.setBounds(787, 186, 234, 213);
		l4 = new JLabel(i4);
		l4.setBounds(1085, 185, 234, 206);
		lblLogo = new JLabel(logo);
		manual2 = new JLabel(manual1);
		con2 = new JLabel(Con1);
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
		panel_6.setBounds(174, 166, 458, 2);
		panel_6.setBackground(new Color(255, 128, 64));
		getContentPane().add(panel_6);

		sair2.setBounds(47, 279, 66, 83);
		sair2.setToolTipText("Sair");
		con2.setBounds(47, 186, 66, 83);
		con2.setToolTipText("Configurações");
		manual2.setBounds(47, 93, 66, 83);
		manual2.setToolTipText("Seus Resumos");
		lblLogo.setBounds(191, 77, 93, 71);
		getContentPane().add(lblLogo);
		getContentPane().add(l1);
		getContentPane().add(l2);
		getContentPane().add(l3);
		getContentPane().add(l4);
		getContentPane().add(con2);
		getContentPane().add(manual2);
		getContentPane().add(sair2);

		JLabel l2_1 = new JLabel((Icon) null);
		l2_1.setBounds(774, 186, 234, 213);
		getContentPane().add(l2_1);

		JLabel lblAcao = new JLabel("Ação");
		l1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				AcaoView view = new AcaoView();
				String url = "jdbc:mysql://localhost:3306/textos";
				Connection conexao = DriverManager.getConnection(url, "root", "root");
				GenerosController controller = new GenerosController(view, conexao);
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
				TerrorView view = new TerrorView();
				String url = "jdbc:mysql://localhost:3306/textos";
				Connection conexao = DriverManager.getConnection(url, "root", "root");
				TerrorController controller = new TerrorController(view, conexao);
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
				FiccaoView view = new FiccaoView();
				String url = "jdbc:mysql://localhost:3306/textos";
				Connection conexao = DriverManager.getConnection(url, "root", "root");
				FiccaoController controller = new FiccaoController(view, conexao);
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
				RomanceView view = new RomanceView();
				String url = "jdbc:mysql://localhost:3306/textos";
				Connection conexao = DriverManager.getConnection(url, "root", "root");
				RomanceController controller = new RomanceController(view, conexao);
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
		con2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ConfiguracoesView view = new ConfiguracoesView(nome);
				view.setVisible(true);
				view.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
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
		sair2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);

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
		manual2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ResumosView view = new ResumosView();
				view.setVisible(true);
				view.setExtendedState(JFrame.MAXIMIZED_BOTH);				
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
		lblAcao.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblAcao.setBounds(294, 409, 52, 30);
		getContentPane().add(lblAcao);

		JLabel lblTerror = new JLabel("Terror");
		lblTerror.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblTerror.setBounds(580, 407, 66, 30);
		getContentPane().add(lblTerror);

		JLabel lblRomance = new JLabel("Ficção");
		lblRomance.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblRomance.setBounds(876, 409, 56, 30);
		getContentPane().add(lblRomance);

		JLabel lblFiccao = new JLabel("Romance");
		lblFiccao.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblFiccao.setBounds(1160, 409, 93, 30);
		getContentPane().add(lblFiccao);

		setVisible(true);
	}
}