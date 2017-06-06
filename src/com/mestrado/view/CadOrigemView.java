package com.mestrado.view;

import java.awt.EventQueue;
import java.awt.Font;

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

import com.mestrado.Dao.OrigemDao;
import com.mestrado.model.Fisicos;
import com.mestrado.model.Origem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadOrigemView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodOrigem;
	private JTextField txtDescOrigem;
	private JTextField txtSiglaOrigem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadOrigemView frame = new CadOrigemView();
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
	public CadOrigemView() {
		setTitle("Cadastro Clinica de Origem");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtCodOrigem = new JTextField();
		txtCodOrigem.setEditable(false);
		txtCodOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodOrigem.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtDescOrigem = new JTextField();
		txtDescOrigem.setToolTipText("Digite a Cl\u00EDnica de Origem!");
		txtDescOrigem.setColumns(10);
		
		JLabel lblSigla = new JLabel("Sigla:");
		lblSigla.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtSiglaOrigem = new JTextField();
		txtSiglaOrigem.setToolTipText("Digite a sigla da Cl\u00EDnica de Origem!");
		txtSiglaOrigem.setColumns(10);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setToolTipText("Salvar Origem!!");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrigemDao orDAO = new OrigemDao();
				
				String desc = txtDescOrigem.getText().toUpperCase();
				String sigla = txtSiglaOrigem.getText().toUpperCase();
				
				if(desc==null|| desc.trim().equals("")){
					JOptionPane.showMessageDialog(null, "Favor digitar Clinica de Origem!!");
					
				}else
					if(sigla==null|| sigla.trim().equals("")){
						JOptionPane.showMessageDialog(null, "Favor digitar a Sigla da Clinica de Origem!!");
					}
					else{
						orDAO.salvar(desc, sigla);
						Limpar();
						
					}
				
			}
		});
		btnSalvar.setIcon(new ImageIcon(CadOrigemView.class.getResource("/imagens/1482301942_Save_Icon.png")));
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setToolTipText("Alterar dados!!");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrigemDao orDAO = new OrigemDao();
				Origem or = new Origem();
				
				Long cod = Long.parseLong(txtCodOrigem.getText());
				String descr = txtDescOrigem.getText().toUpperCase();
				String sigla = txtSiglaOrigem.getText().toUpperCase();
				
				if(sigla==null || sigla.trim().equals("")){
					JOptionPane.showMessageDialog(null, "A Sigla é obrigatória!!");
					Limpar();
				}else{
					or.setCodigo(cod);
					or.setDescricao(descr);
					or.setSigla(sigla);
										
					orDAO.alterar(or);
					
					Limpar();
					btnSalvar.setVisible(true);
						
					}
				
			}
		});
		btnAlterar.setIcon(new ImageIcon(CadOrigemView.class.getResource("/imagens/1482302103_txt2.png")));
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setToolTipText("Busca atrav\u00E9s da sigla!!");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrigemDao orDAO = new OrigemDao();
				String sigla = txtSiglaOrigem.getText().toUpperCase();
				
				if(sigla==null|| sigla.trim().equals("")){
					
					JOptionPane.showMessageDialog(null, "Sigla Inválida!!");
					
				}else{
					Origem objBusca = new Origem();
					objBusca = orDAO.buscar(sigla, new String());
					
					txtCodOrigem.setText(objBusca.getCodigo().toString());
					txtDescOrigem.setText(objBusca.getDescricao());
					txtSiglaOrigem.setText(objBusca.getSigla());
					
					btnSalvar.setVisible(false);
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon(CadOrigemView.class.getResource("/imagens/1482302067_Magnifier.png")));
		
		JButton btnSair = new JButton("");
		btnSair.setToolTipText("Fechar Janela!!");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadOrigemView.this.setVisible(false);
		
			}
		});
		btnSair.setIcon(new ImageIcon(CadOrigemView.class.getResource("/imagens/1482302161_10.png")));
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setToolTipText("Limpar Campos!!");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(CadOrigemView.class.getResource("/imagens/1482302193_edit-clear.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblDescrio, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCodOrigem, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(lblSigla, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSiglaOrigem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtDescOrigem))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCodOrigem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDescrio, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtDescOrigem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSair)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblSigla, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtSiglaOrigem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnSalvar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAlterar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnLimpar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void  Limpar() {
		txtDescOrigem.setText("");
		txtCodOrigem.setText("");
		txtSiglaOrigem.setText("");
		txtDescOrigem.requestFocus();
		
	}
}
