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
		setBounds(100, 100, 434, 250);
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
		
		JLabel lblNewLabel_3 = new JLabel("Sigla");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtUserSigla = new JTextField();
		txtUserSigla.setColumns(10);
		
		JFormattedTextField fmtdDataNascFis = new JFormattedTextField();
		fmtdDataNascFis.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FisicosDao fisicodao = new FisicosDao();
			
			String nome = txtNomeFisico.getText().toUpperCase();
			String abfm = txtABFM.getText();
			String userSigla = txtUserSigla.getText().toUpperCase();
			
			
				if(txtNomeFisico.getText().trim().equals(null)||txtABFM.getText().trim().equals("")||txtUserSigla.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Favor digitar todos os dados");
				}else{
				try {
					fisicodao.salvar(nome, abfm, userSigla);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Físico, já existe, Favor verificar e tentar novamente!");
				}
				
				limpar();	
				}
				
			}
		});
		btnSalvar.setToolTipText("Salvar Dados");
		btnSalvar.setIcon(new ImageIcon(CadFisicoView.class.getResource("/imagens/1482301942_Save_Icon.png")));
		
		JButton btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtNomeFisico.getText().trim().equals("")||txtUserSigla.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "O Favor preencher todos os Campos!!");
				}else{
				FisicosDao fisdao = new FisicosDao();
				Fisicos fisico = new Fisicos();
				
				String abfm = txtABFM.getText().toUpperCase();
				Long codigo = Long.parseLong(txtCodigo.getText());
				String nome = txtNomeFisico.getText().toUpperCase();
				String sigla = txtUserSigla.getText().toUpperCase();
						
				if(abfm==null || abfm.trim().equals("")){
					JOptionPane.showMessageDialog(null, "O Favor preencher o Campo ABFM!!");
				}else{
					fisico.setCodigo(codigo);
					fisico.setABFM(abfm);
					fisico.setNome(nome);
					fisico.setSigla(sigla);
					
					
					fisdao.alterar(fisico);
					btnSalvar.setVisible(true);
					limpar();
					
					txtNomeFisico.setFocusable(true);
				}
				}
			}
		});
		btnAlterar.setToolTipText("Alterar dados");
		btnAlterar.setIcon(new ImageIcon(CadFisicoView.class.getResource("/imagens/1482302103_txt2.png")));	
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FisicosDao fDao = new FisicosDao();					
				String abfm = txtABFM.getText().toUpperCase();
					
				Fisicos objBusca = new Fisicos();
				objBusca = fDao.buscar(abfm, new String());
				
				if(abfm==null || abfm.trim().equals("")){
					JOptionPane.showMessageDialog(null, "Favor digitar um ABFM Inválido!!");
				}else 
					if(abfm.trim().equals(objBusca.getABFM())){					
					txtCodigo.setText(objBusca.getCodigo().toString());
					txtABFM.setText(objBusca.getABFM());
					txtNomeFisico.setText(objBusca.getnome());
					txtUserSigla.setText(objBusca.getSigla());
					
					btnSalvar.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null, "Físico nãio encontrado!");
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
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
				btnSalvar.setVisible(true);
			}
		});
		btnLimpar.setIcon(new ImageIcon(CadFisicoView.class.getResource("/imagens/1482302193_edit-clear.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
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
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_3)
								.addComponent(txtUserSigla, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(89, Short.MAX_VALUE))
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
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtABFM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtUserSigla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addComponent(btnLimpar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addComponent(btnBuscar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addComponent(btnAlterar, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addComponent(btnSalvar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
					.addGap(87))
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
	public void limpar() {
		txtNomeFisico.setText("");
		txtABFM.setText("");
		txtUserSigla.setText("");
		txtCodigo.setText("");
		
	}
}
