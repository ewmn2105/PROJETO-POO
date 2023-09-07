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
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class TelaRAcaoView extends JFrame {

	private JLabel image2, image3, txt1, sair, livro1, pesquisa;
	private JPanel p, p1, p2;
	private JButton b, btnSalvar, btnLer, btnLimpar, btnTxt1;
	private Container container;
	private ImageIcon i1, i2, i3, i, save, clean, book1, search;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 9);
	private JTextArea nome;
	private JScrollPane pane;
	private JPasswordField senha;
	private JButton btnLogin, btnCriarCadastro;
	private String texto;
	private JTextField txtA;
	private JTextField txtAutor;
	private JLabel l1;

	public TelaRAcaoView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		setBounds(0, 0, 1920, 1080);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(230, 228, 242));
		Font fontetip = new Font("Segoe UI Variable", Font.BOLD, 17);
		UIManager.put("ToolTip.font", fontetip);
		UIManager.put("ToolTip.background", (new Color(230, 228, 242)));
		b = new JButton("Voltar");
		btnSalvar = new JButton("Salvar");
		btnLer = new JButton("Ler");
		btnLimpar = new JButton("Limpar");
		btnTxt1 = new JButton("Texto 1");
		nome = new JTextArea();
		senha = new JPasswordField("Senha");
		pane = new JScrollPane(nome);
		btnLogin = new JButton("Login");
		btnCriarCadastro = new JButton("Criar");
		txt1 = new JLabel("Não possui cadastro?");
		i = new ImageIcon("Imagens/SairTR.png");
		save = new ImageIcon("Imagens/Salvar.png");
		clean = new ImageIcon("Imagens/Borracha.png");
		book1 = new ImageIcon("Imagens/manual.png");
		i1 = new ImageIcon("Imagens/Fundo2.jpg");
		i2 = new ImageIcon("Imagens/Fundo1.jpg");
		i3 = new ImageIcon("Imagens/read.png");
		search = new ImageIcon("Imagens/Lupa.png");
		sair = new JLabel(i);
		// livro1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de
		// Trabalho\\MVC\\Projetonovo\\Imagens\\livro1.png"));
		pesquisa = new JLabel(
				new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo\\Imagens\\Lupa.png"));
		image2 = new JLabel(i2);
		livro1 = new JLabel(book1);
		image3 = new JLabel(i3);
		p = new JPanel();

		pane.setBounds(538, 221, 558, 433);
		nome.setLineWrap(true);
		senha.setBounds(597, 395, 350, 45);
		image3.setBounds(575, 65, 390, 320);
		txt1.setBounds(740, 537, 125, 20);
		p.setBounds(575, 250, 390, 315);
		sair.setBounds(1400, 0, 130, 113);
		pesquisa.setBounds(142, 437, 100, 102);
		livro1.setBounds(152, 0, 100, 102);
		p.add(image2);

		btnLogin.setBackground(Color.BLUE);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(fonte);
		nome.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		senha.setFont(fonte1);
		getContentPane().add(sair);
		getContentPane().add(pesquisa);
		getContentPane().add(livro1);
		getContentPane().add(pane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		panel.setBounds(418, 0, 2, 845);
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 64));
		panel_1.setBounds(-10, 110, 1550, 2);
		getContentPane().add(panel_1);

		txtA = new JTextField();
		txtA.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		txtA.setText("Título");
		txtA.setForeground(Color.LIGHT_GRAY);
		txtA.setBounds(60, 221, 270, 50);
		getContentPane().add(txtA);
		txtA.setColumns(10);

		txtAutor = new JTextField();
		txtAutor.setHorizontalAlignment(SwingConstants.LEFT);
		txtAutor.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		txtAutor.setText("Autor (Seu e-mail)");
		txtAutor.setForeground(Color.LIGHT_GRAY);
		txtAutor.setColumns(10);
		txtAutor.setBounds(60, 326, 270, 50);
		getContentPane().add(txtAutor);

		JLabel lblNewLabel = new JLabel("Informe o título do resumo");
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		lblNewLabel.setBounds(60, 188, 270, 23);
		getContentPane().add(lblNewLabel);

		JLabel lblInformeONome = new JLabel("Informe o nome do autor (Login)");
		lblInformeONome.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		lblInformeONome.setBounds(60, 293, 270, 23);
		getContentPane().add(lblInformeONome);

		JLabel lblNewLabel_1 = new JLabel("Leia os teus resumos!");
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 27));
		lblNewLabel_1.setBounds(430, 10, 519, 90);
		getContentPane().add(lblNewLabel_1);
		
		pesquisa.setToolTipText("Pesquisar Resumo");
		
		l1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo\\Imagens\\acao.png"));
		l1.setBounds(1186, 318, 234, 213);
		getContentPane().add(l1);

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
		setVisible(true);
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
		nome.setText(texto);
	}

	public void addBtnPegaTxt(MouseListener listener) {
		pesquisa.addMouseListener(listener);
	}

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public void mostrarMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao logar", JOptionPane.ERROR_MESSAGE);
	}
}
