package br.com.projeto.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DataConfigView extends JFrame {
	private JLabel image2, image3, image4, fundoLogin, sair2;
	private JPanel p;
	private Container container;
	private ImageIcon i1, i2, i3, i4, i5, sair1;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 10);
	private JTextField nome;
	private JButton btnAlterar;
	private JOptionPane JO;
	private JTextField txtNovoLogin;
	private JTextField txtNovaSenha;

	public DataConfigView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		setBounds(487, 185, 585, 571);
		setTitle("Read7");
		getContentPane().setBackground(new Color(255, 128, 64));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		nome = new JTextField("E-mail");
		btnAlterar = new JButton("Alterar");
		i1 = new ImageIcon("Imagens/Fundo.jpg");
		i2 = new ImageIcon("Imagens/Fundo1.jpg");
		i3 = new ImageIcon("Imagens/read.png");
		i4 = new ImageIcon("Imagens/FundoLogin.png");
		image2 = new JLabel(i2);
		image3 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo\\Imagens\\Lápis.png"));
		fundoLogin = new JLabel(i4);
		sair1 = new ImageIcon("Imagens/Sair.png");
		sair2 = new JLabel(sair1);
		p = new JPanel();
		container = getContentPane();
		
		txtNovoLogin = new JTextField("Novo Login");
		txtNovoLogin.setForeground(Color.LIGHT_GRAY);
		txtNovoLogin.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		txtNovoLogin.setBounds(108, 252, 350, 45);
		
		txtNovaSenha = new JTextField("Nova Senha");
		txtNovaSenha.setForeground(Color.LIGHT_GRAY);
		txtNovaSenha.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		txtNovaSenha.setBounds(108, 336, 350, 45);

		nome.setBounds(108, 168, 350, 45);
		btnAlterar.setBounds(210, 417, 145, 45);
		image3.setBounds(177, 20, 204, 167);
		fundoLogin.setBounds(20, 83, 525, 441);
		sair2.setBounds(433, 10, 128, 107);
		// p.add(image2);

		btnAlterar.setBackground(Color.BLUE);
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		nome.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		nome.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(nome);
		getContentPane().add(txtNovoLogin);
		getContentPane().add(txtNovaSenha);
		getContentPane().add(btnAlterar);
		getContentPane().add(image3);
		getContentPane().add(sair2);
		getContentPane().add(fundoLogin);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 228, 242));
		panel.setBounds(0, 0, 571, 97);
		getContentPane().add(panel);
		
		nome.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (nome.getText().equals("E-mail")) {
					nome.setText("");
					nome.setForeground(Color.black);
				}
			}
			

			public void focusLost(FocusEvent e) {
				if (nome.getText().isEmpty()) {
					nome.setText("E-mail");
					nome.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtNovoLogin.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (txtNovoLogin.getText().equals("Novo Login")) {
					txtNovoLogin.setText("");
					txtNovoLogin.setForeground(Color.black);
				}
			}
			

			public void focusLost(FocusEvent e) {
				if (txtNovoLogin.getText().isEmpty()) {
					txtNovoLogin.setText("Novo Login");
					txtNovoLogin.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtNovaSenha.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (txtNovaSenha.getText().equals("Nova Senha")) {
					txtNovaSenha.setText("");
					txtNovaSenha.setForeground(Color.black);
				}
			}
			

			public void focusLost(FocusEvent e) {
				if (txtNovaSenha.getText().isEmpty()) {
					txtNovaSenha.setText("Nova Senha");
					txtNovaSenha.setForeground(Color.LIGHT_GRAY);
				}
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
	}
	public String getEmail() {
        return nome.getText();
    }
    public String getSenha() {
        return txtNovaSenha.getText();
    }
    public String getNome() {
    	return txtNovoLogin.getText();
    }
	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	public void mensagemAtencao(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao Alterar", JOptionPane.ERROR_MESSAGE);
	}
	public void addBtnLembrarSenha(ActionListener lembraListener) {
		btnAlterar.addActionListener(lembraListener);
	}
}
