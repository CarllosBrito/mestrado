//http://www.mballem.com/post/utilizando-swing-com-jpahibernate/

package com.mestrado.view;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.mestrado.Dao.PlanejamentoDao;
import com.mestrado.model.Planejamento;

public class PrincipalView {

	private JFrame frame;
	CadMedicoView medicoView = new CadMedicoView();
	CadPacienteView cadPaciente;
	CadAparelhoView cadAparelho;
	CadFisicoView cadFisico;
	CadMedicoView cadMedico;
	CadOrigemView cadOrigem;
	CadPlanejamentoView cadPlan;
	CadRegAnatomicaView cadRegiao;
	CadSist_GerenciamentoView cadSisGer;
	private JTable tabelaPlan;
	
	
	

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
		//readJTable();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame("Sistema de Gerenciamento de Pacientes");
		frame.getContentPane().setBackground(SystemColor.scrollbar);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				PrincipalView.class
						.getResource("/imagens/1482302223_personal.png")));
		frame.setResizable(false);

		Toolkit thekit = frame.getToolkit();
		frame.setBounds(new Rectangle(thekit.getScreenSize()));
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Alterar Planejamento!");
		btnNewButton.setIcon(new ImageIcon(PrincipalView.class
				.getResource("/imagens/1482302103_txt2.png")));

		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setToolTipText("Sair do Programa!");
		btnSair.setIcon(new ImageIcon(PrincipalView.class
				.getResource("/imagens/1482302161_10.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(1093))
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		tabelaPlan = new JTable();
		tabelaPlan.setModel(new DefaultTableModel(
			new Object[][] {null, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null
			},
			new String[] {
				"Paciente","Registro","Médico","Reg. Anatomica","Data CT","Aparelho","Técnica","Contorno","Alvo","Plano","Sis. Gerenciamento",
				"Impressao","1 Ass.","2 Ass.","Campos","Blocos","Data Envio","Data Chegada","Data Inicio","Observações"
			}
			
		){
			boolean[] columnEditables = new boolean[] {
					false, false, false, false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		}
	);
		tabelaPlan.getColumnModel().getColumn(0).setPreferredWidth(200);
		tabelaPlan.getColumnModel().getColumn(0).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(1).setPreferredWidth(75);
		tabelaPlan.getColumnModel().getColumn(1).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(2).setPreferredWidth(150);
		tabelaPlan.getColumnModel().getColumn(2).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(3).setPreferredWidth(140);
		tabelaPlan.getColumnModel().getColumn(3).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(4).setPreferredWidth(95);
		tabelaPlan.getColumnModel().getColumn(4).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(5).setPreferredWidth(150);
		tabelaPlan.getColumnModel().getColumn(5).setMinWidth(85);
		tabelaPlan.getColumnModel().getColumn(6).setPreferredWidth(75);
		tabelaPlan.getColumnModel().getColumn(6).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(7).setPreferredWidth(75);
		tabelaPlan.getColumnModel().getColumn(7).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(8).setPreferredWidth(75);
		tabelaPlan.getColumnModel().getColumn(8).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(9).setPreferredWidth(80);
		tabelaPlan.getColumnModel().getColumn(9).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(10).setPreferredWidth(85);
		tabelaPlan.getColumnModel().getColumn(10).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(11).setPreferredWidth(80);
		tabelaPlan.getColumnModel().getColumn(11).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(12).setPreferredWidth(67);
		tabelaPlan.getColumnModel().getColumn(12).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(13).setPreferredWidth(67);
		tabelaPlan.getColumnModel().getColumn(13).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(14).setPreferredWidth(60);
		tabelaPlan.getColumnModel().getColumn(14).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(15).setPreferredWidth(55);
		tabelaPlan.getColumnModel().getColumn(15).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(16).setPreferredWidth(95);
		tabelaPlan.getColumnModel().getColumn(16).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(17).setPreferredWidth(95);
		tabelaPlan.getColumnModel().getColumn(17).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(18).setPreferredWidth(95);
		tabelaPlan.getColumnModel().getColumn(18).setMinWidth(20);
		tabelaPlan.getColumnModel().getColumn(19).setPreferredWidth(120);
		tabelaPlan.getColumnModel().getColumn(19).setMinWidth(20);
		scrollPane.setViewportView(tabelaPlan);
	
		frame.getContentPane().setLayout(groupLayout);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);

		JMenuItem mniCadPaciente = new JMenuItem("Cadastro de Pacientes");
		mniCadPaciente.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if(cadPaciente == null){
					try {
						cadPaciente = new CadPacienteView();
					} catch (ParseException e) {
						e.printStackTrace();
					}
					cadPaciente.setLocationRelativeTo(null);
				}
				cadPaciente.setVisible(true);
				
			}
		});
		
		mnCadastros.add(mniCadPaciente);

		JSeparator separator_2 = new JSeparator();
		mnCadastros.add(separator_2);

		JMenu mniCadFuncionarios = new JMenu("Cadastro de Funcion\u00E1rios");
		mnCadastros.add(mniCadFuncionarios);

		JMenuItem mniFsicos = new JMenuItem("F\u00EDsicos");
		mniFsicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cadFisico== null){
					cadFisico = new CadFisicoView();
					cadFisico.setLocationRelativeTo(null);					
				}
				cadFisico.setVisible(true);
			}
		});
		mniCadFuncionarios.add(mniFsicos);

		JSeparator separator = new JSeparator();
		mniCadFuncionarios.add(separator);

		JMenuItem mniMedicos = new JMenuItem("M\u00E9dicos");
		mniMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cadMedico== null){
					cadMedico = new CadMedicoView();
					cadMedico.setLocationRelativeTo(null);					
				}
				cadMedico.setVisible(true);
			}
			
		});
		mniCadFuncionarios.add(mniMedicos);

		JSeparator separator_3 = new JSeparator();
		mnCadastros.add(separator_3);

		JMenuItem mniCadRegAnat = new JMenuItem(
				"Cadastro de Regi\u00F5es Anat\u00F4micas");
		mniCadRegAnat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cadRegiao== null){
					cadRegiao = new CadRegAnatomicaView();
					cadRegiao.setLocationRelativeTo(null);					
				}
				cadRegiao.setVisible(true);
			}
			
		});
		mnCadastros.add(mniCadRegAnat);

		JSeparator separator_4 = new JSeparator();
		mnCadastros.add(separator_4);

		JMenuItem mniCadPlanejamentos = new JMenuItem(
				"Cadastro de Planejamentos");
		mniCadPlanejamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cadPlan== null){
					cadPlan = new CadPlanejamentoView();
					cadPlan.setLocationRelativeTo(null);					
				}
				cadPlan.setVisible(true);
			}
			
		});
		mnCadastros.add(mniCadPlanejamentos);
		
		JSeparator separator_5 = new JSeparator();
		mnCadastros.add(separator_5);
		
		JMenuItem mniCadAparelhos = new JMenuItem("Cadastro de Aparelhos");
		mniCadAparelhos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cadAparelho== null){
					cadAparelho = new CadAparelhoView();
					cadAparelho.setLocationRelativeTo(null);					
				}
				cadAparelho.setVisible(true);
			}
			
		});
			
		mnCadastros.add(mniCadAparelhos);
		
		JSeparator separator_6 = new JSeparator();
		mnCadastros.add(separator_6);
		
		JMenuItem mniCadSisGerencia = new JMenuItem("Cadastro de Sistema de Planejamento");
		mniCadSisGerencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cadSisGer== null){
					cadSisGer = new CadSist_GerenciamentoView();
					cadSisGer.setLocationRelativeTo(null);					
				}
				cadSisGer.setVisible(true);
			}
			
		});
			
		mnCadastros.add(mniCadSisGerencia);
		
		JSeparator separator_7 = new JSeparator();
		mnCadastros.add(separator_7);
		
		JMenuItem mniCadOrigem = new JMenuItem("Cadastro de Cl\u00EDnica de Origem");
		mniCadOrigem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cadOrigem==null){
					cadOrigem = new CadOrigemView();
					cadOrigem.setLocationRelativeTo(null);					
				}
				cadOrigem.setVisible(true);
			}
		});
		mnCadastros.add(mniCadOrigem);

		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);

		JMenuItem mniSistSobre = new JMenuItem("Sobre o Sistema!");
		mniSistSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(
								mniSistSobre,
								"Sistema desenvolvido como estudo para mestrado profisional em Física Médica \n"
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
		
		readJTable();

	}
	public void readJTable() {
		PlanejamentoDao pDao = new PlanejamentoDao();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		DefaultTableModel modelo = (DefaultTableModel) tabelaPlan.getModel();
		modelo.setRowCount(0);
		for (Planejamento plan : pDao.buscaTodos(null, null)) {	
			modelo.addRow(new Object[] {
					plan.getPaciente().getNomePaciente().toString(),
					plan.getPaciente().getregistro().toString(),
					plan.getMedicos().getNome().toString(),
					plan.getRegiao().getDescricao().toString(),
					df.format(plan.getCt().getTime()),
					plan.getAparelho().getDescricao().toString(),
					plan.getTecnica().toString(),
					plan.getContorno().toString(),
					plan.getAlvo().toString(), 
					plan.getPlano().toString(),
					plan.getSis_gerenciamento().getDescricao().toString(),
					plan.getImpressao().toString(),
					plan.getPrimeira_ass().getSigla().toString(),
					plan.getSegunda_ass().getSigla().toString(), 
					plan.getQtdeCampos().toString(),
					plan.getQtde_blocos().toString() ,
					df.format(plan.getBloco_envio().getTime()),
					df.format(plan.getBloco_chegada().getTime()),
					df.format(plan.getData_inicio().getTime()),
					plan.getObservacoes(),
					
			});
				
		
		}
	}
	
}
