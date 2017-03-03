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
		setBounds(100, 100, 432, 300);
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
		txtDescOrigem.setColumns(10);
		
		JLabel lblSigla = new JLabel("Sigla:");
		lblSigla.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtSiglaOrigem = new JTextField();
		txtSiglaOrigem.setColumns(10);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrigemDao orDAO = new OrigemDao();
				
				String desc = txtDescOrigem.getText().toUpperCase();
				String sigla = txtSiglaOrigem.getText().toUpperCase();
				
				if(desc==null){
					JOptionPane.showMessageDialog(null, "Favor digitar Clinica de Origem!!");
					
				}else
					if(sigla==null){
						JOptionPane.showMessageDialog(null, "Favor digitar a Sigla da Clinica de Origem!!");
					}
					else{
						orDAO.salvar(desc, sigla);
						JOptionPane.showMessageDialog(null, "Origem cadastrada com sucesso!!");
						Limpar();
						txtDescOrigem.requestFocus();
					}
				
			}
		});
		btnSalvar.setIcon(new ImageIcon(CadOrigemView.class.getResource("/imagens/1482301942_Save_Icon.png")));
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(CadOrigemView.class.getResource("/imagens/1482302103_txt2.png")));
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(CadOrigemView.class.getResource("/imagens/1482302067_Magnifier.png")));
		
		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadOrigemView.this.setVisible(false);
		
			}
		});
		btnSair.setIcon(new ImageIcon(CadOrigemView.class.getResource("/imagens/1482302161_10.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCodOrigem, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(lblDescrio, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSigla, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSiglaOrigem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSalvar)
							.addGap(18)
							.addComponent(btnAlterar)
							.addGap(18)
							.addComponent(btnBuscar)
							.addGap(18)
							.addComponent(btnSair))
						.addComponent(txtDescOrigem, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(30, Short.MAX_VALUE))
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
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSigla, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtSiglaOrigem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
							.addComponent(btnSalvar))
						.addComponent(btnAlterar)
						.addComponent(btnBuscar)
						.addComponent(btnSair))
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void  Limpar() {
		txtDescOrigem.setText("");
		txtCodOrigem.setText("");
		txtSiglaOrigem.setText("");
		
	}
}
