package com.mestrado.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mestrado.Dao.AparelhoDao;
import com.mestrado.model.Aparelho;
import java.awt.Toolkit;

public class CadAparelhoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private static JTextField txtDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadAparelhoView frame = new CadAparelhoView();
					frame.setVisible(true);
					txtDescricao.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadAparelhoView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadAparelhoView.class.getResource("/imagens/1483156433_8.png")));
		setTitle("Cadastro de Aparelho");
		setBounds(100, 100, 383, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodigo.setBounds(10, 36, 46, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDescricao.setBounds(10, 88, 325, 20);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 67, 73, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AparelhoDao apDAO = new AparelhoDao();

				if (txtDescricao.getText().trim().equals("")) {
					JOptionPane
							.showMessageDialog(null,
									"Favor digitar o Nome de um aparelho para ser salvo!");
				} else {
					String descr = txtDescricao.getText().toUpperCase();
					try {
						apDAO.salvar(descr);
						limpar();
					} catch (Exception e1) {
						JOptionPane
								.showMessageDialog(null,
										"Aparelho já cadastrado, Favor verificar e tentar novamente!!");
					}
				}

			}
		});
		btnSalvar.setToolTipText("Click Para salvar o Aparelho!");
		btnSalvar.setIcon(new ImageIcon(CadAparelhoView.class
				.getResource("/imagens/1482301942_Save_Icon.png")));
		btnSalvar.setBounds(10, 131, 53, 56);
		contentPane.add(btnSalvar);

		JButton btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtDescricao.getText().trim().equals("")) {
					JOptionPane
							.showMessageDialog(null,
									"Necessário realizar uma busca para alteração de dados!!");
					limpar();
				} else {
					AparelhoDao apDAO = new AparelhoDao();
					Aparelho ap = new Aparelho();

					Long cod = Long.parseLong(txtCodigo.getText());
					String descr = txtDescricao.getText().toUpperCase();

					if (descr == null || descr.trim().equals("")) {
						JOptionPane
								.showMessageDialog(null,
										"É necessário um nome de aparelho para realizar alteração!");
					} else {
						ap.setCodigo(cod);
						ap.setDescricao(descr);

						apDAO.alterar(ap);
						limpar();
						btnSalvar.setVisible(true);
					}

				}
			}
		});
		btnAlterar.setIcon(new ImageIcon(CadAparelhoView.class
				.getResource("/imagens/1482302103_txt2.png")));
		btnAlterar.setToolTipText("Click Para alterar os dados!");
		btnAlterar.setBounds(74, 131, 53, 56);
		contentPane.add(btnAlterar);

		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AparelhoDao apDAO = new AparelhoDao();

				String descr = txtDescricao.getText().toUpperCase();
				Aparelho objBusca = new Aparelho();
				objBusca = apDAO.buscar(descr, new String());

				if (txtDescricao.getText().trim().equals("")) {
					JOptionPane
							.showMessageDialog(null,
									"Necessário digitar o nome do aparelho para realizar a busca!!");
				} else if (descr.trim().equals(objBusca.getDescricao())) {
					txtCodigo.setText(objBusca.getCodigo().toString());
					txtDescricao.setText(objBusca.getDescricao());

					btnSalvar.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null,
							"Aparelho não encontrado!");
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon(CadAparelhoView.class
				.getResource("/imagens/1482302067_Magnifier.png")));
		btnBuscar.setToolTipText("Click Para buscar pela descri\u00E7\u00E3o!");
		btnBuscar.setBounds(137, 131, 53, 56);
		contentPane.add(btnBuscar);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
				btnSalvar.setVisible(true);
			}
		});
		btnLimpar.setIcon(new ImageIcon(CadAparelhoView.class
				.getResource("/imagens/1482302193_edit-clear.png")));
		btnLimpar.setToolTipText("Click Para limpar os campos!");
		btnLimpar.setBounds(205, 131, 53, 56);
		contentPane.add(btnLimpar);

		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(CadAparelhoView.class
				.getResource("/imagens/1482302161_10.png")));
		btnSair.setToolTipText("Click para fechar a janela!");
		btnSair.setBounds(268, 131, 53, 56);
		contentPane.add(btnSair);

	}

	public void limpar() {
		txtCodigo.setText("");
		txtDescricao.setText("");
		txtDescricao.requestFocus();
	}
}
