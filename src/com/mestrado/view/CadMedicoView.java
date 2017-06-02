package com.mestrado.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import com.mestrado.Dao.MedicoDao;

public class CadMedicoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNomeMed;
	private JTextField txtCRM;
	private JTextField txtSigla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadMedicoView frame = new CadMedicoView();
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
	public CadMedicoView() {
		setFont(new Font("Tahoma", Font.BOLD, 12));
		setTitle("Cadastro de M\u00E9dicos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadMedicoView.class.getResource("/imagens/1483149248_personal.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtNomeMed = new JTextField();
		txtNomeMed.setColumns(10);
		
		JLabel lblCrm = new JLabel("CRM:");
		lblCrm.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtCRM = new JTextField();
		txtCRM.setColumns(10);
		
		JLabel lblSigla = new JLabel("Sigla");
		lblSigla.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtSigla = new JTextField();
		txtSigla.setColumns(10);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MedicoDao MDdao = new MedicoDao();
			
				
				String NomeMD = txtNomeMed.getText().toUpperCase();
				String CRM = txtCRM.getText();
				String Sigla = txtSigla.getText().toUpperCase();			
				
				if(NomeMD==null|| NomeMD.trim().equals("")){
					JOptionPane.showMessageDialog(null, "Nome do Médico é obrigatório!!");
				
				}else
					if(CRM==null|| CRM.trim().equals("")){
							JOptionPane.showMessageDialog(null, "O CRM é obrigatório!!");
					}else
						if(Sigla==null || Sigla.trim().equals("")){
							JOptionPane.showMessageDialog(null, "A Sigla é obrigatória!!");
						}else{
						MDdao.salvar(NomeMD,CRM,Sigla);
						JOptionPane.showMessageDialog(null, "Médico Salvo com Sucesso!!");					
						limpar();
						txtNomeMed.requestFocus();
						}
					
			}

			
		});
		btnSalvar.setToolTipText("Gravar Dados!");
		btnSalvar.setIcon(new ImageIcon(CadMedicoView.class.getResource("/imagens/1482301942_Save_Icon.png")));
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setToolTipText("Alterar Dados!");
		btnAlterar.setIcon(new ImageIcon(CadMedicoView.class.getResource("/imagens/1482302103_txt2.png")));
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setToolTipText("Buscar M\u00E9dico!");
		btnBuscar.setIcon(new ImageIcon(CadMedicoView.class.getResource("/imagens/1482302067_Magnifier.png")));
		
		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadMedicoView.this.setVisible(false);
			}
		});
		btnSair.setToolTipText("Sair da Tela M\u00E9dicos");
		btnSair.setIcon(new ImageIcon(CadMedicoView.class.getResource("/imagens/1482302161_10.png")));
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(CadMedicoView.class.getResource("/imagens/1482302193_edit-clear.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCdigo)
										.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
									.addGap(29)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 216, Short.MAX_VALUE))
										.addComponent(txtNomeMed, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCrm, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCRM, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSigla, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtSigla, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))))
							.addGap(27))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 53, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(33))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCdigo)
						.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNomeMed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCrm, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCRM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSigla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblSigla, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSalvar)
						.addComponent(btnAlterar)
						.addComponent(btnBuscar)
						.addComponent(btnSair)
						.addComponent(btnLimpar))
					.addGap(52))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void limpar() {
		txtCodigo.setText("");
		txtCRM.setText("");
		txtNomeMed.setText("");
		txtSigla.setText("");
		txtNomeMed.requestFocus();
		
	}
}
