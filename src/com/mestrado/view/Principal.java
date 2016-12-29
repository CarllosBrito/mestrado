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

public class Principal {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Sistema de Gerenciamento de Pacientes");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagens/1482302223_personal.png")));
		frame.setResizable(false);
		
		Toolkit thekit =frame.getToolkit();
		frame.setBounds(new Rectangle(thekit.getScreenSize()));
		frame.setVisible(true);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, "", "", null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"nome", "registro", "medico", "Regiao", "Data CT", "Contorno", "Alvo", "Aprovacao", "Impressao", "1 assinatura", "2 assinatura", "Bloco", "SIstema Gerenciamento", "Observacoes"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(65);
		table.getColumnModel().getColumn(12).setPreferredWidth(100);
		table.getColumnModel().getColumn(13).setPreferredWidth(120);
		
		JLabel lblNome = new JLabel("Nome Paciente");
		
		JLabel lblRegistro = new JLabel("Registro");
		
		JLabel lblMedico = new JLabel("M\u00E9dico");
		
		JLabel lblRegiao = new JLabel("Regi\u00E3o Anat.");
		
		JLabel lblDataCT = new JLabel("Data CT");
		
		JLabel lblContorno = new JLabel("Contorno");
		
		JLabel lblAlvo = new JLabel("Alvo");
		
		JLabel lblAprovacao = new JLabel("Aprova\u00E7\u00E3o");
		
		JLabel lblImpressao = new JLabel("Impress\u00E3o");
		
		JLabel lbl1Assinatura = new JLabel("1\u00AA Assinatura");
		
		JLabel lbl2Assinatura = new JLabel("2\u00AA Assinatura");
		
		JLabel lblBloco = new JLabel("Bloco");
		
		JLabel lblSistGerenciamento = new JLabel("Sist. Gerenciamento");
		
		JLabel lblObs = new JLabel("Observa\u00E7\u00F5es");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
					.addComponent(lblRegistro)
					.addGap(51)
					.addComponent(lblMedico)
					.addGap(50)
					.addComponent(lblRegiao)
					.addGap(37)
					.addComponent(lblDataCT)
					.addGap(33)
					.addComponent(lblContorno)
					.addGap(50)
					.addComponent(lblAlvo)
					.addGap(44)
					.addComponent(lblAprovacao)
					.addGap(33)
					.addComponent(lblImpressao)
					.addGap(27)
					.addComponent(lbl1Assinatura)
					.addGap(18)
					.addComponent(lbl2Assinatura)
					.addGap(26)
					.addComponent(lblBloco)
					.addGap(35)
					.addComponent(lblSistGerenciamento)
					.addGap(31)
					.addComponent(lblObs)
					.addGap(53))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblObs)
						.addComponent(lblNome)
						.addComponent(lblRegistro)
						.addComponent(lblMedico)
						.addComponent(lblRegiao)
						.addComponent(lblDataCT)
						.addComponent(lblContorno)
						.addComponent(lblAprovacao)
						.addComponent(lblAlvo)
						.addComponent(lbl2Assinatura)
						.addComponent(lblImpressao)
						.addComponent(lbl1Assinatura)
						.addComponent(lblBloco)
						.addComponent(lblSistGerenciamento))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE)
					.addGap(91))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem mniCadPaciente = new JMenuItem("Cadastro de Pacientes");
		mniCadPaciente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				CadPaciente paciente = new CadPaciente();
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
					CadFisico fisico = new CadFisico();
					fisico.setTitle("Cadastro de Físicos");
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
				JOptionPane.showMessageDialog(mniSistSobre, "Sistema desenvolvido para mestrado profisional em Física Médica \n"
												+ "Aluno: Carlos de Brito \n"
												+ "Orientador: Prof. Dr. Harley Francisco Oliveira \n"
												+ "Ano de conclusão: 2017 - Usp Ribeirão Preto");
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
