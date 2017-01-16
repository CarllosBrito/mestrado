package com.mestrado.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;



@SuppressWarnings("serial")
public class CadPacienteView extends JFrame {

	private JPanel contentPane;
	private JTextField txtRegistro;
	private JTextField txtNomePaciente;
	private JFormattedTextField fmtData_1;
	private JFormattedTextField fmtdDataCT_1;
	private JFormattedTextField fmtdDataBlocos_1;
	private JFormattedTextField fmtdDataBlocoschegada_1;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadPacienteView frame = new CadPacienteView();
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
	public CadPacienteView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadPacienteView.class.getResource("/imagens/1483156433_8.png")));
		setTitle("Cadastro de Pacientes\r\n");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblRegistro = new JLabel("Registro:");
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblDataDeNascimento = new JLabel("Dta Nasc.");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblOrigem = new JLabel("Origem:");
		lblOrigem.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(CadPacienteView.class.getResource("/imagens/1482301942_Save_Icon.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(CadPacienteView.class.getResource("/imagens/1482302103_txt2.png")));
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(CadPacienteView.class.getResource("/imagens/1482302067_Magnifier.png")));
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(CadPacienteView.class.getResource("/imagens/1482302161_10.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		txtRegistro = new JTextField();
		txtRegistro.setToolTipText("Digite o Registro HC do Paciente");
		txtRegistro.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtRegistro.setColumns(10);
		//txtRegistro.grabFocus();
		
		
		txtNomePaciente = new JTextField();
		txtNomePaciente.setToolTipText("Digite o Nome do Paciente!");
		txtNomePaciente.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNomePaciente.setColumns(10);
		
	
		try {
			MaskFormatter data = new MaskFormatter("  ##/##/####");
			fmtData_1=new JFormattedTextField(data);
			fmtData_1.setToolTipText("Digite a data de nascimento do paciente!");
			fmtData_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JComboBox cmbOrigem = new JComboBox();
		cmbOrigem.setToolTipText("Selecione a cl\u00EDnica de origem do paciente");
		cmbOrigem.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbOrigem.setModel(new DefaultComboBoxModel(new String[] {"", "CCP", "URO", "PNM", "HEMATO", "GO", "PROCTO", "PEDIATRIA", "ORTOP"}));
		
		JLabel lblMedico = new JLabel("M\u00E9dico");
		lblMedico.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox cmbMedico = new JComboBox();
		cmbMedico.setToolTipText("Selcione o M\u00E9dico Respons\u00E1vel");
		
		JLabel lblRegiaoanat = new JLabel("Regi\u00E3o Anat.");
		lblRegiaoanat.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox cmbRegiaoAnat = new JComboBox();
		cmbRegiaoAnat.setToolTipText("Selecione a Regi\u00E3o Anat\u00F4mica");
		
		JLabel lblDataCT = new JLabel("Data CT");
		lblDataCT.setFont(new Font("Tahoma", Font.BOLD, 12));
		
	
		try {
			MaskFormatter dataCT = new MaskFormatter("  ##/##/####");
			fmtdDataCT_1=new JFormattedTextField(dataCT);
			fmtdDataCT_1.setToolTipText("Digite a data da realiza\u00E7\u00E3o da tomografia!");
			fmtdDataCT_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblContorno = new JLabel("Contorno");
		lblContorno.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox cmbContorno = new JComboBox();
		cmbContorno.setModel(new DefaultComboBoxModel(new String[] {"N\u00E3o", "Sim"}));
		cmbContorno.setToolTipText("Selecione o sistema onde o contorno foi realizado!");
		
		JLabel lblAlvo = new JLabel("Alvo");
		lblAlvo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox cmbAlvo = new JComboBox();
		cmbAlvo.setModel(new DefaultComboBoxModel(new String[] {"N\u00E3o", "Sim"}));
		cmbAlvo.setToolTipText("Selecione se o alvo foi definido!");
		
		JLabel lblPlano = new JLabel("Plano");
		lblPlano.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox cmbPlano = new JComboBox();
		cmbPlano.setModel(new DefaultComboBoxModel(new String[] {"N\u00E3o", "Aprovado"}));
		cmbPlano.setToolTipText("Selecione se o plano foi definido!");
		
		JLabel lblAprovPlano = new JLabel("Aprov. Plano");
		lblAprovPlano.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox cmbAprovPlano = new JComboBox();
		cmbAprovPlano.setModel(new DefaultComboBoxModel(new String[] {"N\u00E3o", "Sim"}));
		cmbAprovPlano.setToolTipText("Selecione se o plano foi aprovado");
		
		JLabel lblImpressao = new JLabel("Impress\u00E3o");
		lblImpressao.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox cmbImpressao = new JComboBox();
		cmbImpressao.setModel(new DefaultComboBoxModel(new String[] {"N\u00E3o", "Sim"}));
		cmbImpressao.setToolTipText("Selcione se a ficha floi impressa!");
		
		JLabel lbl1Assinatura = new JLabel("1\u00AA Assinatura");
		lbl1Assinatura.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lbl2Assinatura = new JLabel("2\u00AA Assinatura");
		lbl2Assinatura.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblBlocos = new JLabel("Blocos");
		lblBlocos.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox cmb1Ass = new JComboBox();
		cmb1Ass.setToolTipText("1\u00AA assinatura F\u00EDsica M\u00E9dica");
		
		JComboBox cmb2Ass = new JComboBox();
		cmb2Ass.setToolTipText("2\u00AA assinatura F\u00EDsica M\u00E9dica");
		
		JComboBox cmbBlocos = new JComboBox();
		cmbBlocos.setModel(new DefaultComboBoxModel(new String[] {"N\u00E3o", "Sim"}));
		cmbBlocos.setToolTipText("Selecione se o paciente possui Blocos!");
		
		JLabel lblSisGerenciamento = new JLabel("Sist. Gerenciamento");
		lblSisGerenciamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox cmbSisGerenciamento = new JComboBox();
		cmbSisGerenciamento.setToolTipText("Selecione o Sistema de Gerenciamento para este paciente!");
		
		JLabel lblDtaBlocosEnvio = new JLabel("Data Envio");
		lblDtaBlocosEnvio.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		JFormattedTextField fmtdDataBlocos = new JFormattedTextField();
		fmtdDataBlocos.setFont(new Font("Tahoma", Font.BOLD, 12));
				
			try {
				MaskFormatter dataBlocos = new MaskFormatter("  ##/##/####");
				fmtdDataBlocos_1 = new JFormattedTextField(dataBlocos);
				fmtdDataBlocos_1.setToolTipText("Selecione a data de envio dos blocos!");
				fmtdDataBlocos_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		JLabel lblBlocosChegada = new JLabel("Data Chegada");
		lblBlocosChegada.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JFormattedTextField fmtdDataBlocoschegada = new JFormattedTextField();
		fmtdDataBlocoschegada.setToolTipText("Selecione a data de envio dos blocos!");
		try {
			MaskFormatter dataBlocoschegada = new MaskFormatter("  ##/##/####");
			fmtdDataBlocoschegada_1 = new JFormattedTextField(dataBlocoschegada);
			fmtdDataBlocoschegada_1.setToolTipText("Selecione a data de envio dos blocos!");
			fmtdDataBlocoschegada_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lblStatus = new JLabel("Status do Paciente:");
		lblStatus.setToolTipText("Selecione se o paciente est\u00E1 ativo ou inativo! ");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JCheckBox chbAtivo = new JCheckBox("Ativo");
		
		JTextArea textArea = new JTextArea();
		
		JLabel lblObs = new JLabel("Observa\u00E7\u00F5es");
		lblObs.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JCheckBox chbInativo = new JCheckBox("Inativo");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRegistro)
								.addComponent(txtRegistro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNomePaciente, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(fmtData_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDataDeNascimento))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(cmbOrigem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblOrigem))
							.addGap(77))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(cmbAprovPlano, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblAprovPlano, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cmbImpressao, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblImpressao, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl1Assinatura, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
										.addComponent(cmb1Ass, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl2Assinatura, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
										.addComponent(cmb2Ass, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblBlocos, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblDtaBlocosEnvio, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblBlocosChegada)
									.addGap(18)
									.addComponent(lblSisGerenciamento, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addGap(37)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(chbAtivo)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chbInativo, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblObs, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
							.addGap(113))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblMedico, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(cmbMedico, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblRegiaoanat)
										.addComponent(cmbRegiaoAnat, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(18)
											.addComponent(fmtdDataCT_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(30)
											.addComponent(lblDataCT, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(6)
											.addComponent(lblContorno, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(cmbContorno, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
									.addGap(14)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(cmbAlvo, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAlvo, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(cmbPlano, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPlano, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(cmbBlocos, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(fmtdDataBlocos_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(fmtdDataBlocoschegada_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(cmbSisGerenciamento, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnSalvar)
											.addGap(18)
											.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblRegistro)
							.addComponent(lblNome))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblDataDeNascimento)
							.addComponent(lblOrigem)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtRegistro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNomePaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fmtData_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbOrigem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRegiaoanat, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDataCT, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPlano, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblContorno, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAlvo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(cmbRegiaoAnat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(fmtdDataCT_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbPlano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbAlvo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbContorno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMedico, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbMedico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAprovPlano, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblImpressao, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl1Assinatura, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl2Assinatura, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbAprovPlano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbImpressao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmb1Ass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmb2Ass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chbAtivo)
						.addComponent(chbInativo))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblBlocos, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblDtaBlocosEnvio, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblBlocosChegada, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblSisGerenciamento, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblObs, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(cmbBlocos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(fmtdDataBlocos_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(fmtdDataBlocoschegada_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbSisGerenciamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
