package br.com.projeto.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.controller.LembrarSenhaController.lembraListener;
import br.com.projeto.model.bo.ADMBO;
import br.com.projeto.model.bo.CadastroBO;
import br.com.projeto.model.bo.LembrarSenhaBO;
import br.com.projeto.model.vo.CadastroVO;
import br.com.projeto.model.vo.LembrarSenhaVO;
import br.com.projeto.view.CadastroView;
import br.com.projeto.view.LembrarSenhaView;
import br.com.projeto.view.TelaADMView;
import br.com.projeto.model.vo.ADMVO;
import br.com.projeto.model.dao.ConexaoDAO;
	public class ADMController {
		private TelaADMView view;
		private ADMBO admBO;
		private ConexaoDAO conexao;
		private PreparedStatement statement;
		private ResultSet resultSet;
		private JTable table;
		private JScrollPane scrollTable;
		public ADMController (TelaADMView view, Connection conexao) {
			this.view = view;
			admBO = new ADMBO ();
			view.addBtnADM(new removeListener());
			view.addBtnExtrair(new extrairListener());
		}
		class removeListener implements ActionListener{
			public void actionPerformed (ActionEvent e) {
	          	 String email = view.getEmail();
	          	 ADMVO removeLogin = new ADMVO();
	          	 removeLogin.setEmail(email);
	          	 boolean removido = admBO.removeLogin(removeLogin);
	          	 if (removido == true) {
	          	 	 view.mensagem("Usuário removido.");
	          	 	 view.mensagem("ADM, verifique no banco de dados se a remoção foi feita corretamente");
	          	 } else if (removido == false){
	          		 view.mensagemErro("O e-mail informado não está de acordo com os registros");
	          	}
	   	 }
		}
		class extrairListener implements ActionListener{
			public void actionPerformed (ActionEvent e) {
				conexao = new ConexaoDAO();
				if (view.getSQL().equals("")) {
					return;
				}
				try {
					if (!conexao.getConnection()) {
						JOptionPane.showMessageDialog(null, "Falha na conexao, o sistema sera fechado!");
					}
					statement = conexao.connection.prepareStatement(view.getSQL());
					resultSet = statement.executeQuery();
					DefaultTableModel tableModel = new DefaultTableModel(new String[] {}, 0) {
					};
					int qtdeColunas = resultSet.getMetaData().getColumnCount();
					for (int indice = 1; indice <= qtdeColunas; indice++) {
						tableModel.addColumn(resultSet.getMetaData().getColumnName(indice));
					}

					table = new JTable(tableModel);
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();

					while (resultSet.next()) {
						try {
							String[] dados = new String[qtdeColunas];
							for (int i = 1; i <= qtdeColunas; i++) {
								dados[i - 1] = resultSet.getString(i);
								System.out.println(resultSet.getString(i));
							}
							dtm.addRow(dados);
							System.out.println();
						} catch (SQLException erro) {
						}
					}
					resultSet.close();
					statement.close();
					conexao.close();
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.setBounds(920, 250, 500, 300);
					view.add(scrollPane);
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Comando SQL invalido !" + erro.toString());
				}
		}
		}
	}
	