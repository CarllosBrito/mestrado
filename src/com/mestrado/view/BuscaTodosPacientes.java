package com.mestrado.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mestrado.Dao.PacientesDao;
import com.mestrado.model.Paciente;

public class BuscaTodosPacientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JTextField txtQtdePacientes;
	private JTable tbPacientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaTodosPacientes frame = new BuscaTodosPacientes();
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
	@SuppressWarnings({ "serial" })
	public BuscaTodosPacientes() {
		setTitle("Lista de Pacientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscaTodosPacientes.class.getResource("/imagens/busca_peq.png")));
		setBounds(100, 100, 547, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 511, 217);
		contentPane.add(scrollPane);
		
		tbPacientes = new JTable();
		tbPacientes.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
				},
				new String[] {
					"Codigo", "Registro", "Nome Paciente", "Data Nascimento"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		tbPacientes.getColumnModel().getColumn(1).setPreferredWidth(100);
		tbPacientes.getColumnModel().getColumn(2).setPreferredWidth(250);
		tbPacientes.getColumnModel().getColumn(3).setPreferredWidth(101);
		tbPacientes.setBounds(5, 35, 504, 174);
		scrollPane.setViewportView(tbPacientes);
		
		lblNewLabel = new JLabel("Quantidade de pacientes cadastrados:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 12, 240, 14);
		contentPane.add(lblNewLabel);
		
		txtQtdePacientes = new JTextField();
		txtQtdePacientes.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtQtdePacientes.setEditable(false);
		txtQtdePacientes.setBounds(250, 9, 66, 20);
		contentPane.add(txtQtdePacientes);
		txtQtdePacientes.setColumns(10);
		
		readJTable();
		 
	}
	
	public void readJTable(){
		DefaultTableModel modelo = (DefaultTableModel) tbPacientes.getModel();
		modelo.setNumRows(0);
		PacientesDao pacDao = new PacientesDao();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		int i=0;
		for(Paciente p: pacDao.buscaTodos(null, null)){
			i++;
			modelo.addRow(new Object[]{
					p.getCodPaciente(),
					p.getregistro(),
					p.getNomePaciente(),
					df.format(p.getDtNascimento().getTime())
					
			});
			
		}
		
		txtQtdePacientes.setText(Integer.toString(i));
		
	}
}
