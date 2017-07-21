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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import com.mestrado.Dao.PlanejamentoDao;
import com.mestrado.model.Paciente;
import com.mestrado.model.Planejamento;

public class PrincipalView {

	private JFrame frame;
	CadMedicoView medicoView = new CadMedicoView();
	private JTable JTablePrincipal;
	DefaultTableModel modelo;
	
	
	public void readJTable(){
		modelo = (DefaultTableModel) JTablePrincipal.getModel();
		modelo.setNumRows(0);
		PlanejamentoDao pDao = new PlanejamentoDao();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		int i =0;
		for(Planejamento plan: pDao.buscaTodosPlan(null, null)){
			modelo.addRow(new Object[]{
					df.format(plan.getData_cad().getTime()),
					plan.getPaciente().getregistro(),
					plan.getPaciente().getNomePaciente(),
					plan.getOrigem().getDescricao(),
					plan.getMedicos().getNome(),
					plan.getRegiao(),
					df.format(plan.getCt().getTime()),
					plan.getContorno(),
					plan.getAlvo(),
					plan.getQtdeCampos(),
					plan.getTecnica(),
					plan.getAparelho(),
					plan.getSis_gerenciamento().getDescricao(),
					plan.getAlvo(),
					plan.getImpressao(),
					plan.getPrimeira_ass(),
					plan.getSegunda_ass(),
					plan.getQtde_blocos(),
					df.format(plan.getBloco_envio().getTime()),
					df.format(plan.getBloco_chegada().getTime()),
					df.format(plan.getData_inicio().getTime()),
					plan.getObservacoes(),
					plan.getFila(),
					 		
			});
			
		}
	}

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
		readJTable();
		

	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		
		
		
		JLabel lblNome = new JLabel("Paciente");

		JLabel lblRegistro = new JLabel("Registro");

		JLabel lblMedico = new JLabel("M\u00E9dico");

		JLabel lblRegiao = new JLabel("Reg. Anat.");

		JLabel lblDataCT = new JLabel("Dt CT");

		JLabel lblContorno = new JLabel("Contorno");

		JLabel lblAlvo = new JLabel("Alvo");

		JLabel lblSistGerenciamento = new JLabel("Sis Gerenc.");

		JLabel lblObs = new JLabel("Obs");

		JLabel lblData = new JLabel("Data");

		JLabel lblClinicaOrigem = new JLabel("Origem");

		JLabel lblQtdeCpos = new JLabel("Campos");

		JLabel lblTcnica = new JLabel("T\u00E9cnica");

		JLabel lblAparelho = new JLabel("Aparelho");

		JLabel lblAprovao = new JLabel("Aprov");

		JLabel lblImpresso = new JLabel("Impr");

		JLabel lblAssinatura = new JLabel("1\u00AA Ass.");

		JLabel lblAssinatura_1 = new JLabel("2\u00AA Ass.");

		JLabel lblDataIncio = new JLabel("Dt in\u00EDcio");
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Alterar Planejamento!");
		btnNewButton.setIcon(new ImageIcon(PrincipalView.class.getResource("/imagens/1482302103_txt2.png")));
		
		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setToolTipText("Sair do Programa!");
		btnSair.setIcon(new ImageIcon(PrincipalView.class.getResource("/imagens/1482302161_10.png")));
		
		JLabel lblFila = new JLabel("Fila");
		
		JLabel lblBlocos = new JLabel("Blocos");
		
		JLabel lblDtEnvio = new JLabel("Dt Envio");
		
		JLabel lblDtCheg = new JLabel("Dt Cheg.");
		
		JTablePrincipal = new JTable();
		JTablePrincipal.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Data Cad", "registroPaciente", "nomePaciente", "origem", "medico", "regiao", "dataCt", "contorno", "alvo", "campos", "tecnica", "aparelho", "sisGerenciamento", "aprovacao", "impressao", "primAss", "segAss", "blocos", "dataEnvio", "dataCheg", "dataInicio", "observacoes", "fila"
			}
		));
		JTablePrincipal.getColumnModel().getColumn(0).setPreferredWidth(94);
		JTablePrincipal.getColumnModel().getColumn(1).setPreferredWidth(81);
		JTablePrincipal.getColumnModel().getColumn(2).setPreferredWidth(170);
		JTablePrincipal.getColumnModel().getColumn(4).setPreferredWidth(85);
		JTablePrincipal.getColumnModel().getColumn(5).setPreferredWidth(100);
		JTablePrincipal.getColumnModel().getColumn(6).setPreferredWidth(90);
		JTablePrincipal.getColumnModel().getColumn(7).setPreferredWidth(65);
		JTablePrincipal.getColumnModel().getColumn(8).setPreferredWidth(65);
		JTablePrincipal.getColumnModel().getColumn(9).setPreferredWidth(47);
		JTablePrincipal.getColumnModel().getColumn(10).setPreferredWidth(67);
		JTablePrincipal.getColumnModel().getColumn(12).setPreferredWidth(90);
		JTablePrincipal.getColumnModel().getColumn(13).setPreferredWidth(65);
		JTablePrincipal.getColumnModel().getColumn(14).setPreferredWidth(65);
		JTablePrincipal.getColumnModel().getColumn(17).setPreferredWidth(47);
		JTablePrincipal.getColumnModel().getColumn(18).setPreferredWidth(94);
		JTablePrincipal.getColumnModel().getColumn(19).setPreferredWidth(94);
		JTablePrincipal.getColumnModel().getColumn(20).setPreferredWidth(94);
		JTablePrincipal.getColumnModel().getColumn(21).setPreferredWidth(95);
		JTablePrincipal.getColumnModel().getColumn(22).setPreferredWidth(47);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(1093))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblData)
					.addGap(28)
					.addComponent(lblRegistro)
					.addGap(18)
					.addComponent(lblNome)
					.addGap(65)
					.addComponent(lblClinicaOrigem)
					.addGap(18)
					.addComponent(lblMedico)
					.addGap(18)
					.addComponent(lblRegiao)
					.addGap(18)
					.addComponent(lblDataCT)
					.addGap(26)
					.addComponent(lblContorno)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAlvo)
					.addGap(14)
					.addComponent(lblQtdeCpos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTcnica)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAparelho)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblSistGerenciamento)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAprovao)
					.addGap(22)
					.addComponent(lblImpresso)
					.addGap(18)
					.addComponent(lblAssinatura)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAssinatura_1)
					.addGap(18)
					.addComponent(lblBlocos)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDtEnvio)
					.addGap(24)
					.addComponent(lblDtCheg)
					.addGap(18)
					.addComponent(lblDataIncio)
					.addGap(30)
					.addComponent(lblObs)
					.addGap(18)
					.addComponent(lblFila, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(2)
					.addComponent(JTablePrincipal, GroupLayout.DEFAULT_SIZE, 1231, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(lblData)
						.addComponent(lblRegistro)
						.addComponent(lblObs)
						.addComponent(lblDataIncio)
						.addComponent(lblDtEnvio)
						.addComponent(lblDtCheg)
						.addComponent(lblBlocos)
						.addComponent(lblAssinatura)
						.addComponent(lblImpresso)
						.addComponent(lblTcnica)
						.addComponent(lblRegiao)
						.addComponent(lblMedico)
						.addComponent(lblClinicaOrigem)
						.addComponent(lblAparelho)
						.addComponent(lblSistGerenciamento)
						.addComponent(lblAprovao)
						.addComponent(lblDataCT)
						.addComponent(lblQtdeCpos)
						.addComponent(lblAlvo)
						.addComponent(lblContorno)
						.addComponent(lblAssinatura_1)
						.addComponent(lblFila))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(JTablePrincipal, GroupLayout.PREFERRED_SIZE, 547, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);

		JMenuItem mniCadPaciente = new JMenuItem("Cadastro de Pacientes");
		mniCadPaciente.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent arg0) {
				CadPacienteView paciente = null;
				try {
					paciente = new CadPacienteView();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				paciente.setVisible(true);
				paciente.setLocationRelativeTo(null);
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
				fisico.setTitle("Cadastro de Físicos");
				fisico.setResizable(false);
				// paciente.setSize(800, 600);
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

		JMenuItem mniCadRegAnat = new JMenuItem(
				"Cadastro de Regi\u00F5es Anat.");
		mnCadastros.add(mniCadRegAnat);

		JSeparator separator_4 = new JSeparator();
		mnCadastros.add(separator_4);

		JMenuItem mniCadProcedimentos = new JMenuItem(
				"Cadastro de Planejamentos");
		mniCadProcedimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadPlanejamentoView plan = new CadPlanejamentoView();
				plan.setVisible(true);
				plan.setLocationRelativeTo(null);
			}
		});
		mnCadastros.add(mniCadProcedimentos);

		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);

		JMenuItem mniSistSobre = new JMenuItem("Sobre o Sistema!");
		mniSistSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(
								mniSistSobre,
								"Sistema desenvolvido para mestrado profisional em Física Médica \n"
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
	

