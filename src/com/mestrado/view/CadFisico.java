package com.mestrado.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.text.ParseException;

public class CadFisico extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtNomeFisico;
	private JTextField txtABFM;
	private JTextField txtUsuario;
	private JPasswordField pswConfSenha;
	private JLabel lblDataNascimento;
	private JPasswordField pswSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadFisico frame = new CadFisico();
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
	public CadFisico() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtNomeFisico = new JTextField();
		txtNomeFisico.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ABFM:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtABFM = new JTextField();
		txtABFM.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Usu\u00E1rio:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblConfirmaoDeSenha = new JLabel("Confirme a senha:");
		lblConfirmaoDeSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		pswConfSenha = new JPasswordField();
		
		lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JFormattedTextField fmtdDataNascFis = new JFormattedTextField();
		fmtdDataNascFis.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		try {
			MaskFormatter dataFisico = new MaskFormatter("  ##/##/####");
			fmtdDataNascFis = new JFormattedTextField(dataFisico);
			fmtdDataNascFis.setToolTipText("Selecione a data de envio dos blocos!");
			fmtdDataNascFis.setFont(new Font("Tahoma", Font.BOLD, 12));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setToolTipText("Salvar Dados");
		btnSalvar.setIcon(new ImageIcon(CadFisico.class.getResource("/imagens/1482301942_Save_Icon.png")));
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setToolTipText("Alterar dados");
		btnAlterar.setIcon(new ImageIcon(CadFisico.class.getResource("/imagens/1482302103_txt2.png")));
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setToolTipText("Busca Fisico por Nome ou ABFM");
		btnBuscar.setIcon(new ImageIcon(CadFisico.class.getResource("/imagens/1482302067_Magnifier.png")));
		
		JButton btnSair = new JButton("");
		btnSair.setToolTipText("Clique para Sair!");
		btnSair.setIcon(new ImageIcon(CadFisico.class.getResource("/imagens/1482302161_10.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		pswSenha = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNomeFisico, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(txtABFM, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)
								.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(pswConfSenha, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblConfirmaoDeSenha, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGap(20)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSenha)
								.addComponent(fmtdDataNascFis, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDataNascimento)
								.addComponent(pswSenha, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))))
					.addGap(23))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(67, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNomeFisico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblDataNascimento, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtABFM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fmtdDataNascFis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pswSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblConfirmaoDeSenha, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pswConfSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnAlterar)
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBuscar))
						.addComponent(btnSair, Alignment.TRAILING))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
