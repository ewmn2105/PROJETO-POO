package br.com.projeto.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.controller.LoginController;
import br.com.projeto.model.bo.LoginBO;
import br.com.projeto.model.vo.LoginVO;
import br.com.projeto.controller.*;

public class TelaADMView extends JFrame {
	private JLabel image1, image2, image3, txt1, txt2;
	private JPanel p, p2, p3;
	private Container container;
	private ImageIcon i1, i2, i3;
	private Font fonte = new Font("Calibri", Font.BOLD, 30);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Calibri", Font.BOLD, 27);
	private Font fonte3 = new Font("Calibri", Font.BOLD, 40);
	private Font fonte4 = new Font("Calibri", Font.BOLD, 12);
	private JTextField email, SQL;
	private JButton btnDeletar, btnVoltar, Extrair;
	private String contaCad;
	private JScrollPane tabela;

	public TelaADMView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		setTitle("Acesso ADM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		email = new JTextField("E-mail do usuário que você deseja remover");
		SQL = new JTextField(50);
		btnDeletar = new JButton("Deletar");
		btnVoltar = new JButton("Sair");
		Extrair = new JButton("Extrair");
		txt1 = new JLabel("Bem Vindo, ADM");
		txt2 = new JLabel("Remoção de Usuários");
		i1 = new ImageIcon("Imagens/Fundo.jpg");
		i2 = new ImageIcon("Imagens/Fundo1.jpg");
		i3 = new ImageIcon("Imagens/read.png");
		image1 = new JLabel(i1);
		image2 = new JLabel(i2);
		image3 = new JLabel(i3);
		p = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		tabela = new JScrollPane();
		container = getContentPane();
		tabela.setBounds(50, 100, 500, 300);

		txt1.setBounds(100, 85, 450, 45);
		txt2.setBounds(130, 230, 450, 45);
		email.setBounds(130, 320, 350, 45);
		SQL.setBounds(920, 205, 350, 45);
		btnDeletar.setBounds(130, 400, 152, 45);
		btnVoltar.setBounds(1290, 85, 130, 27);
		Extrair.setBounds(1280, 210, 130, 27);
		image1.setBounds(0, 0, 1920, 1090);
		image3.setBounds(95, -60, 390, 320);
		tabela.setBounds(920, 250, 500, 300);
		p.setBounds(90, 200, 500, 350);
		p2.setBounds(0, 130, 500, 5);
		p3.setBounds(920, 200, 500, 350);
		p.add(image2);
		p3.add(image2);
		p2.setBackground(Color.black);

		btnDeletar.setFont(fonte2);
		btnVoltar.setFont(fonte4);
		email.setFont(fonte1);
		btnDeletar.setBackground(Color.BLUE);
		btnDeletar.setForeground(Color.WHITE);
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(new Color(227, 227, 227));
		txt1.setFont(fonte3);
		txt2.setFont(fonte);
		email.setForeground(Color.LIGHT_GRAY);
		txt1.setForeground(Color.BLACK);
		txt2.setForeground(Color.BLACK);

		add(SQL);
		add(tabela);
		add(txt1);
		add(txt2);
		add(email);
		add(btnVoltar);
		add(btnDeletar);
		add(Extrair);
		add(p);
		add(p2);
		add(p3);
		container.add(image1);
		setVisible(true);
		email.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (email.getText().equals("E-mail do usuário que você deseja remover")) {
					email.setText("");
					email.setForeground(Color.black);
				}
			}

			public void focusLost(FocusEvent e) {
				if (email.getText().isEmpty()) {
					email.setText("E-mail do usuário que você deseja remover");
					email.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		btnVoltar.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				btnVoltar.setBackground(Color.red);
				btnVoltar.setForeground(Color.white);
			}

			public void mousePressed(MouseEvent e) {
				btnVoltar.setBackground(Color.LIGHT_GRAY);
				dispose();
			}

			public void mouseReleased(MouseEvent e) {
				btnVoltar.setBackground(Color.LIGHT_GRAY);
			}

			public void mouseEntered(MouseEvent e) {
				btnVoltar.setBackground(Color.red);
				btnVoltar.setForeground(Color.white);
			}

			public void mouseExited(MouseEvent e) {
				btnVoltar.setBackground(new Color(227, 227, 227));
				btnVoltar.setForeground(Color.black);
			}
		});
	}

	public String getEmail() {
		return email.getText();
	}

	public String getSQL() {
		return SQL.getText();
	}

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Usuário Removido", JOptionPane.INFORMATION_MESSAGE);
	}

	public void mensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Remoção não realizada", JOptionPane.WARNING_MESSAGE);
	}

	public void addBtnADM(ActionListener removeListener) {
		btnDeletar.addActionListener(removeListener);
	}
	public void addBtnExtrair(ActionListener extrairListener) {
		Extrair.addActionListener(extrairListener);
	}
}