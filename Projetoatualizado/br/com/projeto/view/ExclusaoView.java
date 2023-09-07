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
import javax.swing.Icon;

public class ExclusaoView extends JFrame{
	private JLabel image2, image3, image4, sair2;
	private JPanel p;
	private Container container;
	private ImageIcon i1, i2, i3, i4, i5, sair1;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 10);
	private JTextField nome;
	private JButton btnExcluir;
	private JOptionPane JO;
	private JPanel panel;

	public ExclusaoView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		setBounds(487, 185, 585, 571);
		setTitle("Read7");
		getContentPane().setBackground(new Color(255, 128, 64));
		//getContentPane().setBackground(new Color(230, 228, 242));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		nome = new JTextField("E-mail");
		btnExcluir = new JButton("Deletar");
		i1 = new ImageIcon("Imagens/Fundo.jpg");
		i2 = new ImageIcon("Imagens/Fundo1.jpg");
		i3 = new ImageIcon("Imagens/read.png");
		i4 = new ImageIcon("Imagens/FundoLogin.png");
		sair1 = new ImageIcon("Imagens/Sair.png");
		image2 = new JLabel(i2);
		image3 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo\\Imagens\\Excluir.png"));
		sair2 = new JLabel(sair1);
		p = new JPanel();
		container = getContentPane();

		nome.setBounds(108, 229, 350, 45);
		btnExcluir.setBounds(210, 308, 145, 45);
		image3.setBounds(210, 53, 139, 120);
		sair2.setBounds(422, 10, 139, 102);
		//p.add(image2);

		btnExcluir.setBackground(Color.BLUE);
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		nome.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		nome.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(nome);
		getContentPane().add(btnExcluir);
		getContentPane().add(image3);
		getContentPane().add(sair2);
		
		panel = new JPanel();
		panel.setBackground(new Color(230, 228, 242));
		panel.setBounds(0, 0, 571, 97);
		getContentPane().add(panel);
		
		JLabel fundoLogin = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo\\Imagens\\FundoLogin.png"));
		fundoLogin.setBounds(21, 93, 525, 441);
		getContentPane().add(fundoLogin);
		
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
		sair2.addMouseListener(new MouseListener() {

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
	}

	public String getEmail() {
		return nome.getText();
	}

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Exclusão de conta", JOptionPane.INFORMATION_MESSAGE);
	}

	public void addBtnExcluirListener(ActionListener excluirListener) {
		btnExcluir.addActionListener(excluirListener);
	}
	public void mensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Exclusão de conta não efetuada", JOptionPane.ERROR_MESSAGE);
	}
}


