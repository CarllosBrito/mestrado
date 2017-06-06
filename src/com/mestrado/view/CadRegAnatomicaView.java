package com.mestrado.view;

import java.awt.EventQueue;
import java.awt.Font;
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
import com.mestrado.Dao.Regiao_AnatomicaDao;
import com.mestrado.model.Regiao_Anatomica;


public class CadRegAnatomicaView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodRegAnatomica;
	private JTextField txtDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadRegAnatomicaView frame = new CadRegAnatomicaView();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public CadRegAnatomicaView() {
		setTitle("Cadastro Regi\u00E3o Anat\u00F4mica");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtCodRegAnatomica = new JTextField();
		txtCodRegAnatomica.setEditable(false);
		txtCodRegAnatomica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodRegAnatomica.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtDescricao = new JTextField();
		txtDescricao.setToolTipText("Digite o Nome da Regi\u00E3o anat\u00F4mica");
		txtDescricao.setColumns(10);
		txtDescricao.requestFocus();
		
		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Regiao_AnatomicaDao dao = new Regiao_AnatomicaDao();
				Regiao_Anatomica regiao = new Regiao_Anatomica();
							
				
				String descricao = txtDescricao.getText().toUpperCase();
				
				if(descricao==null|| descricao.trim().equals("")){
					JOptionPane.showMessageDialog(null, "O nome da Região Anatômica é obrigatório!!");
				}else{
					regiao.setDescricao(descricao);
				dao.salvar(regiao);
				JOptionPane.showMessageDialog(null, "Região Anatômica salva com sucesso!!!");
				Limpar();
				}
						
			}
		});
		btnSalvar.setIcon(new ImageIcon(CadRegAnatomicaView.class.getResource("/imagens/1482301942_Save_Icon.png")));
		
		JButton btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Regiao_AnatomicaDao dao = new Regiao_AnatomicaDao();
				Regiao_Anatomica regiao = new Regiao_Anatomica();
								
				String descricao = txtDescricao.getText().toUpperCase();
				Long cod = Long.parseLong(txtCodRegAnatomica.getText());
						
				if(descricao==null|| descricao.trim().equals("")){
					JOptionPane.showMessageDialog(null, "O nome da Região Anatômica é obrigatório!!");
					Limpar();
				}else{
					regiao.setCodigo(cod);
					regiao.setDescricao(descricao);
				dao.alterar(regiao);
				
				Limpar();
				btnSalvar.setVisible(true);
				}
				
			}
		});
		btnAlterar.setIcon(new ImageIcon(CadRegAnatomicaView.class.getResource("/imagens/1482302103_txt2.png")));
		
		JButton btnBuscar = new JButton((String) null);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String descr = txtDescricao.getText().toUpperCase();	
				Regiao_AnatomicaDao regDAO = new Regiao_AnatomicaDao();

				if(descr == null|| descr.trim().equals("")){
					JOptionPane.showMessageDialog(null, "Região Não encontrada! Digite Novamente!");
					Limpar();		
						
				}else{
					Regiao_Anatomica objBusca= new Regiao_Anatomica ();
					objBusca = (Regiao_Anatomica) regDAO.buscar(descr, new String());
					txtCodRegAnatomica.setText(objBusca.getCodigo().toString());
					txtDescricao.setText(objBusca.getDescricao());
					
					btnSalvar.setVisible(false);
			
				
				}
		}
				
			
		});
		btnBuscar.setIcon(new ImageIcon(CadRegAnatomicaView.class.getResource("/imagens/1482302067_Magnifier.png")));
		
		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadRegAnatomicaView.this.setVisible(false);
			}
		});
		btnSair.setIcon(new ImageIcon(CadRegAnatomicaView.class.getResource("/imagens/1482302161_10.png")));
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(CadRegAnatomicaView.class.getResource("/imagens/1482302193_edit-clear.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtDescricao, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(txtCodRegAnatomica, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
							.addComponent(lblNewLabel)
							.addComponent(lblDescrio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCodRegAnatomica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblDescrio, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLimpar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAlterar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSalvar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(32))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void Limpar() {
		txtCodRegAnatomica.setText("");
		txtDescricao.setText("");
		txtDescricao.requestFocus();
		
	}

}
