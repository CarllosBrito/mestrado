package com.mestrado.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.mestrado.Dao.PacientesDao;
import com.mestrado.model.Paciente;
import java.awt.Toolkit;

public class BuscaPaciente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jTablePaciente;
	private JLabel lblCdigo;
	private JLabel lblRegistroHc;
	private JLabel lblNomePaciente;
	private JLabel lblDataNascimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaPaciente frame = new BuscaPaciente();
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
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	public BuscaPaciente() {
		setTitle("Lista de Pacientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscaPaciente.class.getResource("/imagens/busca_peq.png")));
		setBounds(100, 100, 535, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jTablePaciente = new JTable();
		jTablePaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Paciente pac = new Paciente();
				int indiceLinha = jTablePaciente.getSelectedRow();
				int codigo = (int) jTablePaciente.getValueAt(indiceLinha, 0);
				Long cod = Long.valueOf(codigo) ;
				DateFormat df = new SimpleDateFormat("dd/MM//yyyy");
				String data = df.format(jTablePaciente.getValueAt(indiceLinha, 3));
				Date d = null;
				try {
					d = df.parse(data);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				pac.setCodPaciente(cod);
				pac.setregistro(jTablePaciente.getValueAt(indiceLinha, 1).toString());
				pac.setNomePaciente(jTablePaciente.getValueAt(indiceLinha, 2).toString());
				pac.setDtNascimento(d);
				
			}
		});
		jTablePaciente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Codigo", "Registro", "Nome Paciente", "Data Nascimento"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(100);
		jTablePaciente.getColumnModel().getColumn(2).setPreferredWidth(250);
		jTablePaciente.getColumnModel().getColumn(3).setPreferredWidth(101);
		jTablePaciente.setBounds(5, 35, 504, 174);
		contentPane.add(jTablePaciente);
		DefaultTableModel modelo = (DefaultTableModel) jTablePaciente.getModel();
		jTablePaciente.setRowSorter(new TableRowSorter(modelo));
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CadPacienteView CadPac = new CadPacienteView();
					CadPac.setVisible(true);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnAlterar.setBounds(5, 227, 89, 23);
		contentPane.add(btnAlterar);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCdigo.setBounds(10, 11, 46, 14);
		contentPane.add(lblCdigo);
		
		lblRegistroHc = new JLabel("Registro HC");
		lblRegistroHc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegistroHc.setBounds(80, 11, 77, 14);
		contentPane.add(lblRegistroHc);
		
		lblNomePaciente = new JLabel("Nome Paciente");
		lblNomePaciente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomePaciente.setBounds(177, 11, 121, 14);
		contentPane.add(lblNomePaciente);
		
		lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataNascimento.setBounds(411, 11, 108, 14);
		contentPane.add(lblDataNascimento);
		
		readJTable();
	}
	
	public void readJTable(){
		DefaultTableModel modelo = (DefaultTableModel) jTablePaciente.getModel();
		modelo.setNumRows(0);
		PacientesDao pacDao = new PacientesDao();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for(Paciente p: pacDao.buscaTodos(null, null)){
			modelo.addRow(new Object[]{
					p.getCodPaciente(),
					p.getregistro(),
					p.getNomePaciente(),
					df.format(p.getDtNascimento().getTime())
					
			});
		}
		
	}
}
