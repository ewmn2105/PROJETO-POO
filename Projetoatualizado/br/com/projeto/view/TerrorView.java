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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TerrorView extends JFrame {
	private JLabel image2, image3, txt1, sair, salvar, limpar, livro1, livro2, livro3;
	private JPanel p, p1, p2;
	private JButton b, btnSalvar, btnLer, btnLimpar, btnTxt1;
	private Container container;
	private ImageIcon i1, i2, i3, i, save, clean, book1, book2, book3;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 9);
	private JTextArea nome, text;
	private JScrollPane pane, pane1;
	private JPasswordField senha;
	private JButton btnLogin, btnCriarCadastro;
	private String texto;
	private JTextField txtA;
	private JTextField txtAutor;
	private JLabel livro1_1;
	private JLabel livro1_2;

	public TerrorView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		setBounds(0, 0, 1920, 1080);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(230, 228, 242));
		b = new JButton("Voltar");
		btnSalvar = new JButton("Salvar");
		btnLer = new JButton("Ler");
		btnLimpar = new JButton("Limpar");
		btnTxt1 = new JButton("Texto 1");
		nome = new JTextArea();
		text = new JTextArea();
		senha = new JPasswordField("Senha");
		pane = new JScrollPane(nome);
		pane1 = new JScrollPane(text);
		btnLogin = new JButton("Login");
		btnCriarCadastro = new JButton("Criar");
		txt1 = new JLabel("Não possui cadastro?");
		i = new ImageIcon("Imagens/SairTR.png");
		save = new ImageIcon("Imagens/Salvar.png");
		clean = new ImageIcon("Imagens/Borracha.png");
		book1 = new ImageIcon("Imagens/livro1.png");
		book2 = new ImageIcon("Imagens/livro2.png");
		book3 = new ImageIcon("Imagens/livro3.png");
		i1 = new ImageIcon("Imagens/Fundo2.jpg");
		i2 = new ImageIcon("Imagens/Fundo1.jpg");
		i3 = new ImageIcon("Imagens/read.png");
		sair = new JLabel(i);
		salvar = new JLabel(save);
		limpar = new JLabel(clean);
		livro1 = new JLabel(book1);
		livro2 = new JLabel(book2);
		livro3 = new JLabel(book3);
		image2 = new JLabel(i2);
		image3 = new JLabel(i3);
		p = new JPanel();

		pane.setBounds(825, 217, 558, 433);
		pane1.setBounds(199, 150, 590, 500);
		nome.setLineWrap(true);
		text.setLineWrap(true);
		senha.setBounds(597, 395, 350, 45);
		image3.setBounds(575, 65, 390, 320);
		txt1.setBounds(740, 537, 125, 20);
		p.setBounds(575, 250, 390, 315);
		sair.setBounds(1400, 0, 130, 113);
		salvar.setBounds(1384, 217, 130, 102);
		limpar.setBounds(1384, 329, 130, 102);
		livro1.setBounds(36, 186, 100, 102);
		livro2.setBounds(36, 298, 100, 102);
		livro3.setBounds(36, 410, 100, 102);
		p.add(image2);

		btnLogin.setBackground(Color.BLUE);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(fonte);
		nome.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		text.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		senha.setFont(fonte1);
		getContentPane().add(sair);
		getContentPane().add(salvar);
		getContentPane().add(limpar);
		getContentPane().add(livro1);
		getContentPane().add(livro2);
		getContentPane().add(livro3);
		getContentPane().add(pane);
		getContentPane().add(pane1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		panel.setBounds(174, 0, 2, 845);
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 64));
		panel_1.setBounds(-10, 110, 1540, 2);
		getContentPane().add(panel_1);

		txtA = new JTextField();
		txtA.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		txtA.setText("Título");
		txtA.setForeground(Color.LIGHT_GRAY);
		txtA.setBounds(825, 157, 270, 50);
		getContentPane().add(txtA);
		txtA.setColumns(10);

		txtAutor = new JTextField();
		txtAutor.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		txtAutor.setText("Autor (Seu e-mail)");
		txtAutor.setForeground(Color.LIGHT_GRAY);
		txtAutor.setColumns(10);
		txtAutor.setBounds(1113, 157, 270, 50);
		getContentPane().add(txtAutor);

		JLabel lblNewLabel = new JLabel("Terror");
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 25));
		lblNewLabel.setBounds(54, 21, 81, 78);
		getContentPane().add(lblNewLabel);

		livro1.setToolTipText("Texto 1");
		livro2.setToolTipText("Texto 2");
		livro3.setToolTipText("Texto 3");
		salvar.setToolTipText("Salvar");
		limpar.setToolTipText("Limpar");

		txtA.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (txtA.getText().equals("Título")) {
					txtA.setText("");
					txtA.setForeground(Color.black);
				}
			}

			public void focusLost(FocusEvent e) {
				if (txtA.getText().isEmpty()) {
					txtA.setText("Título");
					txtA.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtAutor.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent g) {
				if (txtAutor.getText().equals("Autor (Seu e-mail)")) {
					txtAutor.setText("");
					txtAutor.setForeground(Color.black);
				}

			}

			public void focusLost(FocusEvent e) {
				if (txtAutor.getText().isEmpty()) {
					txtAutor.setText("Autor (Seu e-mail)");
					txtAutor.setForeground(Color.LIGHT_GRAY);
				}
			}
		});

		sair.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();

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

		limpar.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				nome.setText("");

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
	}

	public String getTitulo() {
		return txtA.getText();
	}

	public String getTexto() {
		return nome.getText();
	}

	public String getAutor() {
		return txtAutor.getText();
	}

	public void setTexto(String texto) {
		text.setText(texto);
	}

	public void addBtnPegaTxt(MouseListener listener) {
		livro1.addMouseListener(listener);
	}

	public void addBtnSalvar(MouseListener salvarListener) {
		salvar.addMouseListener(salvarListener);
	}

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public void mostrarMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao logar", JOptionPane.ERROR_MESSAGE);
	}
}