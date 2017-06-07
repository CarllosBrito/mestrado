package com.mestrado.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.mestrado.Dao.PacientesDao;
import com.mestrado.model.Paciente;

public class CadPacienteView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRegistro;
	private JTextField txtNomePaciente;
	private JFormattedTextField fmtdDataNasc_1;
	private JTextField txtCodigo;

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
	 * @throws ParseException 
	 */
	public CadPacienteView() throws ParseException {
		setTitle("Cadastro de Pacientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadPacienteView.class.getResource("/imagens/1483156433_8.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCodPaciente = new JLabel("Registro:");
		lblCodPaciente.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtRegistro = new JTextField();
		txtRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRegistro.setColumns(10);
		
		JLabel lblNomePaciente = new JLabel("Nome:");
		lblNomePaciente.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtNomePaciente = new JTextField();
		txtNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNomePaciente.setColumns(10);
		
		//JFormattedTextField fmtdDataNasc = null; 
		MaskFormatter fmtData;
		fmtData = new MaskFormatter("##/##/####");
		fmtdDataNasc_1 = new JFormattedTextField(fmtData);
		
		
		
		
		JLabel lblDtNasc = new JLabel("Data Nasc.");
		lblDtNasc.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PacientesDao dao = new PacientesDao();
				
				
				String Nome = txtNomePaciente.getText().toUpperCase();
				String registro = txtRegistro.getText().toUpperCase();
				String dtnasc=fmtdDataNasc_1.getText();
				
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				Date d = null;
				try {
					d = new Date(format.parse(dtnasc).getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
							
			
				if(txtNomePaciente.getText().trim().equals(null)||txtRegistro.getText().trim().equals(null)){
					JOptionPane.showMessageDialog(null, "Favor digitar todos os dados");
				}else{
				try {
					dao.salvar(Nome, registro, d);
					JOptionPane.showMessageDialog(null, "Paciente salvo com sucesso");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Registro de paciente, já existe, Informe outro");
				}
				 
			}

			
			}
		});
		btnSalvar.setIcon(new ImageIcon(CadPacienteView.class.getResource("/imagens/1482301942_Save_Icon.png")));
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(CadPacienteView.class.getResource("/imagens/1482302103_txt2.png")));
		
		JButton btnBusca = new JButton("");
		btnBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PacientesDao pDAO = new PacientesDao();
				String registro = txtRegistro.getText().toUpperCase();
			
				
				
				if(registro==null|| registro.trim().equals("")){
					
					JOptionPane.showMessageDialog(null, "Registro Inválido!!");
					
				}else{
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					
					Paciente objBusca = new Paciente();
					objBusca = pDAO.buscar(registro, new String());
					
					System.out.println(objBusca.getNomePaciente());
					System.out.println(objBusca.getregistro());
					System.out.println(objBusca.getCodPaciente());
					System.out.println(format.format(objBusca.getDtNascimento().getTime()));
					 
					txtCodigo.setText(objBusca.getCodPaciente().toString());
					txtRegistro.setText(objBusca.getregistro().toUpperCase());
					txtNomePaciente.setText(objBusca.getNomePaciente().toUpperCase());
					fmtdDataNasc_1.setText(format.format(objBusca.getDtNascimento().getTime()));
					
					
					btnSalvar.setVisible(false);
				}
				
			}
		});
		btnBusca.setIcon(new ImageIcon(CadPacienteView.class.getResource("/imagens/1482302067_Magnifier.png")));
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(CadPacienteView.class.getResource("/imagens/1482302193_edit-clear.png")));
		
				
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(CadPacienteView.class.getResource("/imagens/1482302161_10.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadPacienteView.this.setVisible(false);
			}
			
		});
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCdigo))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtCodigo, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(lblCodPaciente, Alignment.LEADING)
								.addComponent(txtRegistro, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(btnBusca, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNomePaciente)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDtNasc, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtNomePaciente, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
										.addComponent(fmtdDataNasc_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNomePaciente)
								.addComponent(lblCdigo))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNomePaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblDtNasc, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fmtdDataNasc_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCodPaciente)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtRegistro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAlterar)
						.addComponent(btnSair)
						.addComponent(btnBusca)
						.addComponent(btnLimpar))
					.addGap(2))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

