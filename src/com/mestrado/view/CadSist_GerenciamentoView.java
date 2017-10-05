package com.mestrado.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.mestrado.Dao.Sistema_GerenciamentoDao;
import com.mestrado.model.Sistema_Gerenciamento;
import java.awt.Toolkit;

public class CadSist_GerenciamentoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCod;
	private JTextField txtDescr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadSist_GerenciamentoView frame = new CadSist_GerenciamentoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadSist_GerenciamentoView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadSist_GerenciamentoView.class.getResource("/imagens/1482302223_personal.png")));
		setTitle("Cadastro Sistemas Gerenciamento");
		setBounds(100, 100, 426, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCod.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtDescr = new JTextField();
		txtDescr.setToolTipText("Digite a descri\u00E7\u00E3o do Sistema");
		txtDescr.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDescr.setColumns(10);
		txtDescr.requestFocus();

		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema_GerenciamentoDao sisDAO = new Sistema_GerenciamentoDao();

				if (txtDescr.getText().trim().equals("")) {
					JOptionPane
							.showMessageDialog(null,
									"Favor digitar um Sistema de gerenciamento válido!");
				} else {
					String descr = txtDescr.getText().toUpperCase();

					try {
						sisDAO.salvar(descr);
						limpar();

					} catch (Exception e1) {
						JOptionPane
								.showMessageDialog(null,
										"Sistema já cadastrado, Favor verificar e tentar novamente!!");
					}
				}
			}
		});
		btnSalvar.setToolTipText("Salvar dados!");
		btnSalvar.setIcon(new ImageIcon(CadSist_GerenciamentoView.class
				.getResource("/imagens/1482301942_Save_Icon.png")));

		JButton btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtDescr.getText().trim().equals("")
						|| txtCod.getText().trim().equals("")) {
					JOptionPane
							.showMessageDialog(null,
									"Necessário Realizar uma busca para alteração dos dados");
					limpar();
				} else {
					Sistema_GerenciamentoDao sisDAO = new Sistema_GerenciamentoDao();
					Sistema_Gerenciamento sistema = new Sistema_Gerenciamento();

					Long cod = Long.parseLong(txtCod.getText());
					String descr = txtDescr.getText().toUpperCase();

					if (descr == null || descr.trim().equals("")) {
						JOptionPane
								.showMessageDialog(null,
										"É necessário um nome de aparelho para realizar alteração!");
					} else {
						sistema.setCodigo(cod);
						sistema.setDescricao(descr);

						sisDAO.alterar(sistema);
						limpar();
						btnSalvar.setVisible(true);
					}
				}
			}
		});
		btnAlterar.setToolTipText("Alterar dados");
		btnAlterar.setIcon(new ImageIcon(CadSist_GerenciamentoView.class
				.getResource("/imagens/1482302103_txt2.png")));

		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema_GerenciamentoDao sisDAO = new Sistema_GerenciamentoDao();
				Sistema_Gerenciamento objBusca = new Sistema_Gerenciamento();
				String descr = txtDescr.getText().toUpperCase();
				objBusca = sisDAO.buscar(descr, new String());

				if (txtDescr.getText().trim().equals("")) {
					JOptionPane
							.showMessageDialog(null,
									"Necessário digitar o nome do sistema para realizar a busca!!");
				} else if (descr.trim().equals(objBusca.getDescricao())) {
					txtCod.setText(objBusca.getCodigo().toString());
					txtDescr.setText(objBusca.getDescricao());

					btnSalvar.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null,
							"Sistema não encontrado!");
				}

			}
		});
		btnBuscar.setToolTipText("Busca pele Descri\u00E7\u00E3o!");
		btnBuscar.setIcon(new ImageIcon(CadSist_GerenciamentoView.class
				.getResource("/imagens/1482302067_Magnifier.png")));

		JButton btnSair = new JButton("");
		btnSair.setToolTipText("Click para Sair!");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadSist_GerenciamentoView.this.setVisible(false);;
			}
		});
		btnSair.setIcon(new ImageIcon(CadSist_GerenciamentoView.class
				.getResource("/imagens/1482302161_10.png")));

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
				btnSalvar.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(CadSist_GerenciamentoView.class
				.getResource("/imagens/1482302193_edit-clear.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addComponent(
																lblNewLabel)
														.addComponent(
																txtCod,
																GroupLayout.PREFERRED_SIZE,
																70,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel_1)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				btnSalvar,
																				GroupLayout.PREFERRED_SIZE,
																				60,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				btnAlterar,
																				GroupLayout.PREFERRED_SIZE,
																				60,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				btnBuscar,
																				GroupLayout.PREFERRED_SIZE,
																				60,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				btnNewButton,
																				GroupLayout.PREFERRED_SIZE,
																				60,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				btnSair,
																				GroupLayout.PREFERRED_SIZE,
																				60,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(txtDescr))
										.addContainerGap(38, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addComponent(lblNewLabel)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(txtCod,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblNewLabel_1)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(txtDescr,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																btnSair,
																GroupLayout.PREFERRED_SIZE,
																60,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_contentPane
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				btnSalvar,
																				GroupLayout.PREFERRED_SIZE,
																				60,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				btnAlterar,
																				GroupLayout.PREFERRED_SIZE,
																				60,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				btnBuscar,
																				GroupLayout.PREFERRED_SIZE,
																				60,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																btnNewButton,
																GroupLayout.PREFERRED_SIZE,
																60,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)));
		contentPane.setLayout(gl_contentPane);
	}

	public void limpar() {
		txtCod.setText("");
		txtDescr.setText("");
		txtDescr.requestFocus();
	}
}
