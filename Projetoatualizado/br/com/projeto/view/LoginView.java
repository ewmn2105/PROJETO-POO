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
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.projeto.model.bo.LoginBO;
import br.com.projeto.model.vo.LoginVO;

public class LoginView extends JFrame {
	private JLabel image2, image3, image4, fundoLogin;
	private JPanel p;
	private Container container;
	private ImageIcon i1, i2, i3, i4, i5;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 10);
	private JTextField nome;
	private JPasswordField senha;
	private JButton btnLogin, btnCriarCadastro, btnLembrarSenha, btnfechar;
	private JOptionPane JO;

	public LoginView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		setBounds(487, 185, 585, 571);
		setTitle("Read7");
		getContentPane().setBackground(new Color(255, 128, 64));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		nome = new JTextField("Login");
		senha = new JPasswordField("Senha");
		btnLogin = new JButton("Login");
		btnCriarCadastro = new JButton("Criar Conta");
		btnLembrarSenha = new JButton("Alterar Dados");
		btnfechar = new JButton("Sair");
		i1 = new ImageIcon("Imagens/Fundo.jpg");
		i2 = new ImageIcon("Imagens/Fundo1.jpg");
		i3 = new ImageIcon("Imagens/read.png");
		i4 = new ImageIcon("Imagens/FundoLogin.png");
		image2 = new JLabel(i2);
		image3 = new JLabel(i3);
		fundoLogin = new JLabel(i4);
		p = new JPanel();
		container = getContentPane();

		nome.setBounds(108, 214, 350, 45);
		senha.setBounds(108, 294, 350, 45);
		btnLogin.setBounds(211, 359, 145, 45);
		btnCriarCadastro.setBounds(96, 437, 120, 27);
		btnLembrarSenha.setBounds(222, 437, 120, 27);
		btnfechar.setBounds(348, 437, 120, 27);
		image3.setBounds(178, 49, 204, 167);
		fundoLogin.setBounds(20, 83, 525, 441);
		//p.add(image2);

		btnLogin.setBackground(Color.BLUE);
		btnLogin.setForeground(Color.WHITE);
		btnCriarCadastro.setForeground(Color.BLACK);
		btnLembrarSenha.setForeground(Color.BLACK);
		btnfechar.setForeground(Color.BLACK);
		btnLogin.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		btnCriarCadastro.setFont(new Font("Segoe UI Variable", Font.BOLD, 10));
		btnLembrarSenha.setFont(new Font("Segoe UI Variable", Font.BOLD, 10));
		btnfechar.setFont(new Font("Segoe UI Variable", Font.BOLD, 10));
		nome.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		senha.setFont(fonte1);

		btnCriarCadastro.setBackground(new Color(227, 227, 227));
		btnLembrarSenha.setBackground(new Color(227, 227, 227));
		btnfechar.setBackground(new Color(227, 227, 227));
		nome.setForeground(Color.LIGHT_GRAY);
		senha.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(nome);
		getContentPane().add(senha);
		getContentPane().add(btnCriarCadastro);
		getContentPane().add(btnLembrarSenha);
		getContentPane().add(btnfechar);
		getContentPane().add(btnLogin);
		getContentPane().add(image3);
		getContentPane().add(fundoLogin);
		//getContentPane().add(p);
		nome.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (nome.getText().equals("Login")) {
					nome.setText("");
					nome.setForeground(Color.black);
				}
			}

			public void focusLost(FocusEvent e) {
				if (nome.getText().isEmpty()) {
					nome.setText("Login");
					nome.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		senha.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent g) {
				if (senha.getText().equals("Senha")) {
					senha.setText("");
					senha.setForeground(Color.black);
				}

			}

			public void focusLost(FocusEvent e) {
				if (senha.getText().isEmpty()) {
					senha.setText("Senha");
					senha.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		btnfechar.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				btnfechar.setBackground(Color.red);
				btnfechar.setForeground(Color.white);
			}

			public void mousePressed(MouseEvent e) {
				btnfechar.setBackground(Color.LIGHT_GRAY);
				dispose();
			}

			public void mouseReleased(MouseEvent e) {
				btnfechar.setBackground(Color.LIGHT_GRAY);
			}

			public void mouseEntered(MouseEvent e) {
				btnfechar.setBackground(Color.red);
				btnfechar.setForeground(Color.white);
			}

			public void mouseExited(MouseEvent e) {
				btnfechar.setBackground(new Color(227, 227, 227));
				btnfechar.setForeground(Color.black);
			}
		});
	}

	public String getNome() {
		return nome.getText();
	}

	public String getSenha() {
		return new String(senha.getPassword());
	}

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao logar", JOptionPane.ERROR_MESSAGE);
	}

	public void addBtnLoginListener(ActionListener logListener) {
		btnLogin.addActionListener(logListener);
	}

	public void addBtnCriarCadastro(ActionListener cadListener) {
		btnCriarCadastro.addActionListener(cadListener);
	}

	public void addBtnLembrarSenha(ActionListener lembraListener) {
		btnLembrarSenha.addActionListener(lembraListener);
	}

}