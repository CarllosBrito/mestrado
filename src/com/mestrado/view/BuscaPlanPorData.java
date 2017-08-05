package com.mestrado.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.mestrado.Dao.PlanejamentoDao;
import com.mestrado.model.Planejamento;

public class BuscaPlanPorData extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1235819906107580870L;
	private JPanel contentPane;
	private JTable tbPlanejamentos;
	private Date dataIni;
	private Date dataFinal;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					BuscaPlanPorData frame = new BuscaPlanPorData();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public BuscaPlanPorData() {
		setResizable(false);
		setTitle("Planejamentos por data");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscaPlanPorData.class.getResource("/imagens/1482302067_Magnifier.png")));
		setBounds(100, 100, 1354, 755);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataInicial = new JLabel("Data Inicial:");
		lblDataInicial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataInicial.setBounds(10, 11, 92, 14);
		contentPane.add(lblDataInicial);
		
		JLabel lblDataFinal = new JLabel("Data Final:");
		lblDataFinal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataFinal.setBounds(199, 11, 69, 14);
		contentPane.add(lblDataFinal);
		
		MaskFormatter dtIniFmtd = null;
		try {
			dtIniFmtd = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		JFormattedTextField fmtdDtInicial = new JFormattedTextField(dtIniFmtd);
		fmtdDtInicial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fmtdDtInicial.setBounds(97, 8, 92, 20);
		contentPane.add(fmtdDtInicial);
		
		MaskFormatter dtFimFmtd = null;
		try {
			dtFimFmtd = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFormattedTextField fmtdDtFinal = new JFormattedTextField(dtFimFmtd);
		fmtdDtFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fmtdDtFinal.setBounds(278, 8, 92, 20);
		contentPane.add(fmtdDtFinal);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
					String dtini= fmtdDtInicial.getText();
					String dtFim = fmtdDtFinal.getText();
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					
					try {
						dataIni=  new Date(format.parse(dtini).getTime());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					try {
						dataIni= new Date(format.parse(dtFim).getTime());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					PlanejamentoDao pDao = new PlanejamentoDao();
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					DefaultTableModel modelo = (DefaultTableModel) tbPlanejamentos.getModel();
					modelo.setRowCount(0);
					for (Planejamento plan : pDao.buscaPorData(dataIni, dataFinal)) {	
						modelo.addRow(new Object[] {
								plan.getData_cad() !=null ? df.format( plan.getData_cad().getTime()) :null,
								plan.getPaciente().getNomePaciente().toString(),
								plan.getPaciente().getregistro().toString(),
								plan.getMedicos() !=null ?plan.getMedicos().getNome().toString():null,
								plan.getRegiao() !=null ?plan.getRegiao().getDescricao().toString():null,
							    plan.getCt() !=null ? df.format(plan.getCt().getTime()) :null,
								plan.getAparelho() !=null ?plan.getAparelho().getDescricao().toString():null,
								plan.getTecnica()!=null ? plan.getTecnica().toString():null,
								plan.getContorno() !=null ?plan.getContorno().toString():null,
								plan.getAlvo() !=null ? plan.getAlvo().toString():null, 
								plan.getPlano() !=null ?plan.getPlano().toString():null,
								plan.getSis_gerenciamento() !=null ?plan.getSis_gerenciamento().getDescricao().toString():null,
								plan.getImpressao() !=null ?plan.getImpressao().toString():null,
								plan.getPrimeira_ass() !=null ?plan.getPrimeira_ass().getSigla().toString():null,
								plan.getSegunda_ass() !=null ? plan.getSegunda_ass().getSigla().toString():null, 
								plan.getQtdeCampos() !=null ?plan.getQtdeCampos().toString():null,
								plan.getQtde_blocos() !=null ?plan.getQtde_blocos().toString():null ,
								plan.getBloco_envio() != null ? df.format(plan.getBloco_envio().getTime()) : null,
								plan.getBloco_chegada() !=null ? df.format(plan.getBloco_chegada().getTime()) :null,
								plan.getData_inicio() !=null ? df.format( plan.getData_inicio().getTime()) :null,
								plan.getObservacoes(),
								
						});
							
					fmtdDtInicial.setText("");
					fmtdDtFinal.setText("");
					}
				}
			
		});
		btnNewButton.setBounds(384, 8, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 1338, 679);
		contentPane.add(scrollPane);
		
		tbPlanejamentos = new JTable();
		tbPlanejamentos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(tbPlanejamentos);
		
		tbPlanejamentos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Data cad", "Paciente", "Registro", "M\u00E9dico", "Reg. Anatomica", "Data CT", "Aparelho", "T\u00E9cnica", "Contorno", "Alvo", "Plano", "Sis. Gerenciamento", "Impressao", "1 Ass.", "2 Ass.", "Cpos", "Blocos", "Data Envio", "Data Chegada", "Data Inicio", "Observa\u00E7\u00F5es"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		}
			
		);
		tbPlanejamentos.getColumnModel().getColumn(0).setPreferredWidth(120);
		tbPlanejamentos.getColumnModel().getColumn(1).setPreferredWidth(200);
		tbPlanejamentos.getColumnModel().getColumn(1).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(2).setPreferredWidth(85);
		tbPlanejamentos.getColumnModel().getColumn(2).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(3).setPreferredWidth(150);
		tbPlanejamentos.getColumnModel().getColumn(3).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(4).setPreferredWidth(140);
		tbPlanejamentos.getColumnModel().getColumn(4).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(5).setPreferredWidth(115);
		tbPlanejamentos.getColumnModel().getColumn(5).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(6).setPreferredWidth(115);
		tbPlanejamentos.getColumnModel().getColumn(6).setMinWidth(85);
		tbPlanejamentos.getColumnModel().getColumn(7).setPreferredWidth(70);
		tbPlanejamentos.getColumnModel().getColumn(7).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(8).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(9).setPreferredWidth(70);
		tbPlanejamentos.getColumnModel().getColumn(9).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(10).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(11).setPreferredWidth(110);
		tbPlanejamentos.getColumnModel().getColumn(11).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(12).setPreferredWidth(90);
		tbPlanejamentos.getColumnModel().getColumn(12).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(13).setPreferredWidth(70);
		tbPlanejamentos.getColumnModel().getColumn(13).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(14).setPreferredWidth(70);
		tbPlanejamentos.getColumnModel().getColumn(14).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(15).setPreferredWidth(50);
		tbPlanejamentos.getColumnModel().getColumn(15).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(16).setPreferredWidth(53);
		tbPlanejamentos.getColumnModel().getColumn(16).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(17).setPreferredWidth(120);
		tbPlanejamentos.getColumnModel().getColumn(17).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(18).setPreferredWidth(120);
		tbPlanejamentos.getColumnModel().getColumn(18).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(19).setPreferredWidth(120);
		tbPlanejamentos.getColumnModel().getColumn(19).setMinWidth(20);
		tbPlanejamentos.getColumnModel().getColumn(20).setPreferredWidth(115);
		tbPlanejamentos.getColumnModel().getColumn(20).setMinWidth(20);
		scrollPane.setViewportView(tbPlanejamentos);
			
			
	}
	
	
		
}
