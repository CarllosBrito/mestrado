package com.mestrado.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JCheckBox;

public class CadFisico extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtNomeFisico;
	private JTextField txtABFM;
	private JTextField txtUsuario;
	private JPasswordField pswConfSenha;
	private JLabel lblDataNascimento;
	private JPasswordField pswSenha;
	private JFormattedTextField fmtdDataNascFis_1;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadFisico.class.getResource("/imagens/1483149248_personal.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 253);
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
			fmtdDataNascFis_1 = new JFormattedTextField(dataFisico);
			fmtdDataNascFis_1.setToolTipText("Selecione a data de envio dos blocos!");
			fmtdDataNascFis_1.setFont(new Font("Tahoma", Font.BOLD, 12));
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
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(CadFisico.class.getResource("/imagens/1482302193_edit-clear.png")));
		
		JCheckBox chkFisicoAtivo = new JCheckBox("Ativo");
		
		JCheckBox chkFisicoInativo = new JCheckBox("Inativo");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGap(13))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(txtNomeFisico, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDataNascimento)
								.addComponent(fmtdDataNascFis_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2)
										.addComponent(txtABFM, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSenha)
										.addComponent(pswSenha, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(58)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(chkFisicoAtivo)
										.addComponent(chkFisicoInativo)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblConfirmaoDeSenha, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
										.addComponent(pswConfSenha, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))))))
					.addGap(18))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblDataNascimento, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNomeFisico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fmtdDataNascFis_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2)
						.addComponent(lblSenha)
						.addComponent(lblConfirmaoDeSenha, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtABFM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pswSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pswConfSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(chkFisicoAtivo)
							.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
							.addComponent(chkFisicoInativo)
							.addGap(102))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnSair, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnLimpar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBuscar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSalvar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAlterar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap(80, Short.MAX_VALUE))))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
