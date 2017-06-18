//http://www.mballem.com/post/utilizando-swing-com-jpahibernate/

package com.mestrado.view;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.SystemColor;

public class PrincipalView {

	private JFrame frame;
	private JTable table;
	CadMedicoView medicoView = new CadMedicoView();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
				try {
					PrincipalView window = new PrincipalView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrincipalView() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Sistema de Gerenciamento de Pacientes");
		frame.getContentPane().setBackground(SystemColor.scrollbar);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalView.class.getResource("/imagens/1482302223_personal.png")));
		frame.setResizable(false);
		
		Toolkit thekit =frame.getToolkit();
		frame.setBounds(new Rectangle(thekit.getScreenSize()));
		frame.setVisible(true);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null, null, "", "", null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Data ", "Registro", "Nome", "Cl\u00EDnica Origem", "Medico Resp.", "Regiao", "Data CT", "Contorno", "Alvo", "Qtde Cpos", "T\u00E9cnica", "Aparelho", "Sistema Gerenciamento", "Aprovacao", "Impressao", "1 assinatura", "2 assinatura", "Bloco", "Data Inicio", "Observacoes"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(195);
		table.getColumnModel().getColumn(3).setPreferredWidth(91);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(95);
		table.getColumnModel().getColumn(6).setPreferredWidth(65);
		table.getColumnModel().getColumn(9).setPreferredWidth(80);
		table.getColumnModel().getColumn(10).setPreferredWidth(85);
		table.getColumnModel().getColumn(11).setPreferredWidth(85);
		table.getColumnModel().getColumn(12).setPreferredWidth(125);
		table.getColumnModel().getColumn(13).setPreferredWidth(85);
		table.getColumnModel().getColumn(14).setPreferredWidth(85);
		table.getColumnModel().getColumn(15).setPreferredWidth(100);
		table.getColumnModel().getColumn(16).setPreferredWidth(100);
		table.getColumnModel().getColumn(17).setPreferredWidth(70);
		table.getColumnModel().getColumn(18).setPreferredWidth(70);
		table.getColumnModel().getColumn(19).setPreferredWidth(120);
		
		JLabel lblNome = new JLabel("Nome Paciente");
		
		JLabel lblRegistro = new JLabel("Registro");
		
		JLabel lblMedico = new JLabel("M\u00E9dico");
		
		JLabel lblRegiao = new JLabel("Regi\u00E3o Anat.");
		
		JLabel lblDataCT = new JLabel("Data CT");
		
		JLabel lblContorno = new JLabel("Contorno");
		
		JLabel lblAlvo = new JLabel("Alvo");
		
		JLabel lblSistGerenciamento = new JLabel("Sist. Gerenc.");
		
		JLabel lblObs = new JLabel("Observa\u00E7\u00F5es");
		
		JLabel lblData = new JLabel("Data");
		
		JLabel lblClinicaOrigem = new JLabel("Clinica Origem");
		
		JLabel lblQtdeCpos = new JLabel("Qtde Cpos");
		
		JLabel lblTcnica = new JLabel("T\u00E9cnica");
		
		JLabel lblAparelho = new JLabel("Aparelho");
		
		JLabel lblAprovao = new JLabel("Aprova\u00E7\u00E3o");
		
		JLabel lblImpresso = new JLabel("Impress\u00E3o");
		
		JLabel lblAssinatura = new JLabel("1\u00AA Assinatura");
		
		JLabel lblAssinatura_1 = new JLabel("2\u00AA Assinatura");
		
		JLabel lblBloco = new JLabel("Bloco");
		
		JLabel lblDataIncio = new JLabel("Dta in\u00EDcio");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblData)
					.addGap(24)
					.addComponent(lblRegistro)
					.addGap(43)
					.addComponent(lblNome)
					.addGap(36)
					.addComponent(lblClinicaOrigem)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMedico)
					.addGap(18)
					.addComponent(lblRegiao)
					.addGap(12)
					.addComponent(lblDataCT)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblContorno)
					.addGap(18)
					.addComponent(lblAlvo)
					.addGap(29)
					.addComponent(lblQtdeCpos)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTcnica)
					.addGap(28)
					.addComponent(lblAparelho)
					.addGap(28)
					.addComponent(lblSistGerenciamento)
					.addGap(18)
					.addComponent(lblAprovao)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblImpresso)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAssinatura)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAssinatura_1)
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addComponent(lblBloco)
					.addGap(18)
					.addComponent(lblDataIncio)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblObs)
					.addGap(24))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblData)
							.addComponent(lblRegistro)
							.addComponent(lblObs)
							.addComponent(lblNome)
							.addComponent(lblClinicaOrigem)
							.addComponent(lblMedico)
							.addComponent(lblContorno)
							.addComponent(lblAlvo)
							.addComponent(lblQtdeCpos)
							.addComponent(lblTcnica)
							.addComponent(lblDataIncio)
							.addComponent(lblRegiao)
							.addComponent(lblDataCT))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblBloco)
							.addComponent(lblAssinatura_1)
							.addComponent(lblAssinatura)
							.addComponent(lblImpresso)
							.addComponent(lblAprovao)
							.addComponent(lblSistGerenciamento)
							.addComponent(lblAparelho)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
					.addGap(230))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem mniCadPaciente = new JMenuItem("Cadastro de Pacientes");
		mniCadPaciente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				CadPlanejamentoView paciente = new CadPlanejamentoView();
				paciente.setTitle("Cadastro de Pacientes");
				paciente.setResizable(false);
				//paciente.setSize(800, 600);
				paciente.setVisible(true);
				paciente.setLocationRelativeTo(null);
				paciente.setAlwaysOnTop(true);
				
			}
		});
		mnCadastros.add(mniCadPaciente);
		
		JSeparator separator_2 = new JSeparator();
		mnCadastros.add(separator_2);
		
		JMenu mnCadFuncionarios = new JMenu("Cadastro de Funcion\u00E1rios");
		mnCadastros.add(mnCadFuncionarios);
		
		JMenuItem mntmFsicos = new JMenuItem("F\u00EDsicos");
		mntmFsicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CadFisicoView fisico = new CadFisicoView();
					fisico.setTitle("Cadastro de F�sicos");
					fisico.setResizable(false);
					//paciente.setSize(800, 600);
					fisico.setVisible(true);
					fisico.setLocationRelativeTo(null);
					fisico.setAlwaysOnTop(true);
			}
		});
		mnCadFuncionarios.add(mntmFsicos);
		
		JSeparator separator = new JSeparator();
		mnCadFuncionarios.add(separator);
		
		JMenuItem mntmMedicos = new JMenuItem("M\u00E9dicos");
		mntmMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				medicoView.setVisible(true);
			}
		});
		mnCadFuncionarios.add(mntmMedicos);
		
		JSeparator separator_3 = new JSeparator();
		mnCadastros.add(separator_3);
		
		JMenuItem mniCadRegAnat = new JMenuItem("Cadastro de Regi\u00F5es Anat.");
		mnCadastros.add(mniCadRegAnat);
		
		JSeparator separator_4 = new JSeparator();
		mnCadastros.add(separator_4);
		
		JMenuItem mniCadProcedimentos = new JMenuItem("Cadastro de Procedimentos");
		mnCadastros.add(mniCadProcedimentos);
		
		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		
		JMenuItem mniSistSobre = new JMenuItem("Sobre o Sistema!");
		mniSistSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(mniSistSobre, "Sistema desenvolvido para mestrado profisional em F�sica M�dica \n"
												+ "Aluno: Carlos de Brito \n"
												+ "Orientador: Prof. Dr. Harley Francisco Oliveira \n"
												+ "Ano de conclus�o: 2017 - Usp Ribeir�o Preto");
			}
		});
		mnSistema.add(mniSistSobre);
		
		JMenuItem mniSistSair = new JMenuItem("Sair!");
		mniSistSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		mnSistema.add(separator_1);
		mnSistema.add(mniSistSair);
	}
}
