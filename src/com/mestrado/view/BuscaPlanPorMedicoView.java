package com.mestrado.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.mestrado.Dao.MedicoDao;
import com.mestrado.Dao.PlanejamentoDao;
import com.mestrado.model.Medicos;
import com.mestrado.model.Planejamento;

public class BuscaPlanPorMedicoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbplanPorMed;
	private Date dtIni;
	private Date dtFinal;
	Medicos selectMedico = new Medicos();
	@SuppressWarnings("rawtypes")
	JComboBox cmbMedico = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaPlanPorMedicoView frame = new BuscaPlanPorMedicoView();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				//	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "serial", "unchecked" })
	public BuscaPlanPorMedicoView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscaPlanPorMedicoView.class.getResource("/imagens/1482302223_personal.png")));
		setTitle("Busca Planejamentos Por M\u00E9dico");
		setResizable(false);
		setBounds(100, 100, 1337, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataInicial = new JLabel("Data inicial:");
		lblDataInicial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataInicial.setBounds(10, 11, 70, 14);
		contentPane.add(lblDataInicial);
		
		JLabel lblDataFinal = new JLabel("Data Final:");
		lblDataFinal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataFinal.setBounds(170, 11, 65, 14);
		contentPane.add(lblDataFinal);
		
		MedicoDao mDAO = new MedicoDao();
		cmbMedico.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String mdSelecionado = cmbMedico.getSelectedItem().toString();
				String arrayMd[] = new String[2];
				arrayMd = mdSelecionado.split("-");
				if(arrayMd.length > 0){
					selectMedico = mDAO.buscar(arrayMd[0], new String());	
				}
			}
		});
		
		cmbMedico.setBounds(398, 9, 239, 20);
		contentPane.add(cmbMedico);
		List<Medicos> lista = mDAO.buscaTodos(null, null);
		cmbMedico.addItem("0000" + "-" + "SELECIONE UM MÉDICO!");
		for (Medicos medicos : lista) {
			cmbMedico.addItem(medicos.getCRM() + "-" + medicos.getNome());

		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 1311, 551);
		contentPane.add(scrollPane);
		
		tbplanPorMed = new JTable();
		tbplanPorMed.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Registro", "Paciente", "Cli Origem", "Regiao Anat\u00F4mica", "Data Cadastro", "Data Inicio", "Observa\u00E7\u00F5es", "Dias Fila"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbplanPorMed.getColumnModel().getColumn(0).setResizable(false);
		tbplanPorMed.getColumnModel().getColumn(0).setPreferredWidth(90);
		tbplanPorMed.getColumnModel().getColumn(1).setResizable(false);
		tbplanPorMed.getColumnModel().getColumn(1).setPreferredWidth(170);
		tbplanPorMed.getColumnModel().getColumn(2).setResizable(false);
		tbplanPorMed.getColumnModel().getColumn(2).setPreferredWidth(95);
		tbplanPorMed.getColumnModel().getColumn(3).setResizable(false);
		tbplanPorMed.getColumnModel().getColumn(3).setPreferredWidth(100);
		tbplanPorMed.getColumnModel().getColumn(4).setResizable(false);
		tbplanPorMed.getColumnModel().getColumn(4).setPreferredWidth(95);
		tbplanPorMed.getColumnModel().getColumn(5).setResizable(false);
		tbplanPorMed.getColumnModel().getColumn(5).setPreferredWidth(95);
		tbplanPorMed.getColumnModel().getColumn(6).setResizable(false);
		tbplanPorMed.getColumnModel().getColumn(6).setPreferredWidth(150);
		tbplanPorMed.getColumnModel().getColumn(7).setResizable(false);
		tbplanPorMed.getColumnModel().getColumn(7).setPreferredWidth(56);
		scrollPane.setViewportView(tbplanPorMed);
		
		MaskFormatter dtIniFmtd = null;
		try {
			dtIniFmtd = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MaskFormatter dtFimFmtd = null;
		try {
			dtFimFmtd = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		JFormattedTextField fmtdDtInicio = new JFormattedTextField(dtIniFmtd);
		fmtdDtInicio.setBounds(90, 9, 70, 20);
		contentPane.add(fmtdDtInicio);
		
		JFormattedTextField fmtdDtFinal = new JFormattedTextField(dtFimFmtd);
		fmtdDtFinal.setBounds(245, 9, 70, 20);
		contentPane.add(fmtdDtFinal);
		
		JLabel lblMdico = new JLabel("M\u00E9dico:");
		lblMdico.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMdico.setBounds(344, 11, 58, 14);
		contentPane.add(lblMdico);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unused" })
			public void actionPerformed(ActionEvent e) {
				String dataIni = fmtdDtInicio.getText();
				String dataFinal = fmtdDtFinal.getText();
				
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				
				if(dataIni==null){
					JOptionPane.showMessageDialog(null, "Favor Digitar a data inicial para realizar a busca!");
				}else{
					try {
						dtIni= new Date(format.parse(dataIni).getTime());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						dtFinal = new Date(format.parse(dataFinal).getTime());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					PlanejamentoDao pDao2 = new PlanejamentoDao();
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					int Fila;
					Date d = new Date();
					DefaultTableModel modelo = (DefaultTableModel) tbplanPorMed.getModel();
					modelo.setRowCount(0);
					List<Planejamento> planejamentos = pDao2.buscaPorMedico(dtIni, dtFinal, selectMedico);
					int i =0;
					for(Planejamento p: planejamentos){
						long dias = (d.getTime() - p.getData_cad().getTime()) + 3600000;
						modelo.addRow(new Object[]{
								p.getPaciente().getregistro().toString(),
								p.getPaciente().getNomePaciente().toString(),
								p.getOrigem()!=null ? p.getOrigem().getSigla().toString().toUpperCase() :null,
								p.getRegiao()!=null ? p.getRegiao().getDescricao().toString():null,
								p.getData_cad()  !=null ? df.format( p.getData_cad().getTime()) :null,
								p.getData_inicio() !=null ? df.format( p.getData_inicio().getTime()) :null,
								p.getObservacoes().toString(),
								Fila = (int) (dias / 86400000L),
						});
						i++;
					}
					
					JOptionPane.showMessageDialog(null, i + " - Planejamento(s) no período! ");
				}
			}
		});
		btnBuscar.setBounds(652, 8, 89, 23);
		contentPane.add(btnBuscar);
	}
}
