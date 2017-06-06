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
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.mestrado.Dao.FisicosDao;
import com.mestrado.model.Fisicos;

public class CadFisicoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNomeFisico;
	private JTextField txtABFM;
	private JTextField txtUserSigla;
	private JPasswordField pswConfSenha;
	private JPasswordField pswSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadFisicoView frame = new CadFisicoView();
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
	public CadFisicoView() {
		setTitle("Cadastro de F\u00EDsicos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadFisicoView.class.getResource("/imagens/1483149248_personal.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodigo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtNomeFisico = new JTextField();
		txtNomeFisico.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ABFM:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtABFM = new JTextField();
		txtABFM.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Usu\u00E1rio:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtUserSigla = new JTextField();
		txtUserSigla.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblConfirmaoDeSenha = new JLabel("Confirme a senha:");
		lblConfirmaoDeSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		pswConfSenha = new JPasswordField();
		
		JFormattedTextField fmtdDataNascFis = new JFormattedTextField();
		fmtdDataNascFis.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FisicosDao fisicodao = new FisicosDao();
				Fisicos fisico = new Fisicos();
				
			
		//	String confSenha =  new String (pswConfSenha.getPassword());
			
			String nome = txtNomeFisico.getText().toUpperCase();
			String abfm = txtABFM.getText();
			String userSigla = txtUserSigla.getText().toUpperCase();
			String senha = new String (pswSenha.getPassword()).trim();
			
				fisicodao.salvar(nome, abfm, userSigla, senha);
				//JOptionPane.showMessageDialog(null, "Físico salvo com Sucesso!");
				limpar();	
				
				
			}
		});
		btnSalvar.setToolTipText("Salvar Dados");
		btnSalvar.setIcon(new ImageIcon(CadFisicoView.class.getResource("/imagens/1482301942_Save_Icon.png")));
		
		JButton btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FisicosDao fisdao = new FisicosDao();
				Fisicos fisico = new Fisicos();
				
				String abfm = txtABFM.getText().toUpperCase();
				Long codigo = Long.parseLong(txtCodigo.getText());
				String nome = txtNomeFisico.getText().toUpperCase();
				String sigla = txtUserSigla.getText().toUpperCase();
				String senha = new String(pswSenha.getPassword());
				
				if(abfm==null || abfm.trim().equals("")){
					JOptionPane.showMessageDialog(null, "O núbero ABFM é obrigatório!!");
					limpar();
				}else{
					fisico.setCodigo(codigo);
					fisico.setABFM(abfm);
					fisico.setNome(nome);
					fisico.setSigla(sigla);
					fisico.setSenha(senha);
					
					fisdao.alterar(fisico);
					
					limpar();
					btnSalvar.setVisible(true);
						
					}
				}
				
			
		});
		btnAlterar.setToolTipText("Alterar dados");
		btnAlterar.setIcon(new ImageIcon(CadFisicoView.class.getResource("/imagens/1482302103_txt2.png")));
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FisicosDao fDao = new FisicosDao();	
				Fisicos fisico = new Fisicos();
				
				String abfm = txtABFM.getText().toUpperCase();
					
				
				if(abfm==null|| abfm.trim().equals("")){
					
					JOptionPane.showMessageDialog(null, "ABFM Inválido!!");
					
				}else{
					Fisicos objBusca = new Fisicos();
					objBusca = fDao.buscar(abfm, new String());
					
					txtCodigo.setText(objBusca.getCodigo().toString());
					txtABFM.setText(objBusca.getABFM());
					txtNomeFisico.setText(objBusca.getnome());
					txtUserSigla.setText(objBusca.getSigla());
					
					btnSalvar.setVisible(false);
				}
				
			}
		});
		btnBuscar.setToolTipText("Busca Físico pelo número ABFM");
		btnBuscar.setIcon(new ImageIcon(CadFisicoView.class.getResource("/imagens/1482302067_Magnifier.png")));
		
		JButton btnSair = new JButton("");
		btnSair.setToolTipText("Clique para Sair!");
		btnSair.setIcon(new ImageIcon(CadFisicoView.class.getResource("/imagens/1482302161_10.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		pswSenha = new JPasswordField();
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(CadFisicoView.class.getResource("/imagens/1482302193_edit-clear.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
											.addGap(13))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel)
											.addGap(18)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtNomeFisico, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel_2)
											.addComponent(txtABFM, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_3)
												.addComponent(txtUserSigla, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblSenha)
												.addComponent(pswSenha, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
											.addGap(11)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblConfirmaoDeSenha, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
												.addComponent(pswConfSenha, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(29)
											.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
											.addGap(119)
											.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
											.addGap(27)
											.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(199)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNomeFisico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtABFM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtUserSigla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(pswSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(pswConfSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSenha)
								.addComponent(lblConfirmaoDeSenha, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
							.addGap(26)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLimpar, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addComponent(btnAlterar, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addComponent(btnSalvar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(87))
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
	public void limpar() {
		txtNomeFisico.setText("");
		txtABFM.setText("");
		txtUserSigla.setText("");
		pswSenha.setText("");
		pswConfSenha.setText("");
		txtCodigo.setText("");
		
	}
}
