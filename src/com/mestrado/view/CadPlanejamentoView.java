package com.mestrado.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.mestrado.Dao.AparelhoDao;
import com.mestrado.Dao.FisicosDao;
import com.mestrado.Dao.MedicoDao;
import com.mestrado.Dao.OrigemDao;
import com.mestrado.Dao.PacientesDao;
import com.mestrado.Dao.PlanejamentoDao;
import com.mestrado.Dao.Regiao_AnatomicaDao;
import com.mestrado.Dao.Sistema_GerenciamentoDao;
import com.mestrado.model.Aparelho;
import com.mestrado.model.Fisicos;
import com.mestrado.model.Medicos;
import com.mestrado.model.Origem;
import com.mestrado.model.Paciente;
import com.mestrado.model.Planejamento;
import com.mestrado.model.Regiao_Anatomica;
import com.mestrado.model.Sistema_Gerenciamento;

public class CadPlanejamentoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRegistro;
	private JTextField txtNomePaciente;
	private JFormattedTextField fmtData_1Paciente;
	private JFormattedTextField fmtdDataCT_1;
	private JFormattedTextField fmtdDataBlocos_1;
	private JFormattedTextField fmtdDataBlocoschegada_1;
	private JLabel lblStatus;
	private JTextField txtQtdeBlocos;
	private JTextField txtTecnica;
	private JTextField txtObs;
	private JFormattedTextField fmtdDTInicio_1;

	Paciente objBusca = new Paciente();
	Aparelho selectAparelho = new Aparelho();
	Sistema_Gerenciamento selectSisGerencia = new Sistema_Gerenciamento();
	Regiao_Anatomica selectRegiao = new Regiao_Anatomica();

	Origem selectOrigem = new Origem();
	Medicos selectMedico = new Medicos();
	Fisicos selectfisico1 = new Fisicos();
	Fisicos selectfisico2 = new Fisicos();
	String contorno;
	String alvo;
	String plano;
	String impressao;
	String tecnica;
	Boolean status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadPlanejamentoView frame = new CadPlanejamentoView();
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
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public CadPlanejamentoView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				CadPlanejamentoView.class
						.getResource("/imagens/1483156433_8.png")));
		setTitle("Cadastro de Planejamento");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblRegistro = new JLabel("Registro:");
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblDataDeNascimento = new JLabel("Dta Nasc.");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblOrigem = new JLabel("Origem:");
		lblOrigem.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(CadPlanejamentoView.class
				.getResource("/imagens/1482301942_Save_Icon.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtNomePaciente.getText().trim().equals("")
						|| txtRegistro.getText().trim().equals("")|| fmtData_1Paciente.getText().trim().equals("  /  /    ")) {
					JOptionPane.showMessageDialog(null,
							"Favor preencher os dados do Paciente!!");

				} else {
					Planejamento plan = new Planejamento();
					PlanejamentoDao pDAO = new PlanejamentoDao();

					String bloco = txtQtdeBlocos.getText();
					String dtBlocoEnvio = fmtdDataBlocos_1.getText();
					String dtBlocoChegada = fmtdDataBlocoschegada_1.getText();
					String dtNasc = fmtData_1Paciente.getText();
					String dtInicio = fmtdDTInicio_1.getText();
					String dtCT = fmtdDataCT_1.getText();
					
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date dtnas, dtinicio = null, dtblocoEnvio = null, dtblocoChegada = null, dtct = null;

					// data nascimento paciente
					
					try {
						dtnas = new Date(format.parse(dtNasc).getTime());
					} catch (ParseException e) {
						dtnas = null;
					}
					
					// Data cadastro
					plan.setData_cad(new Date());

					// Data inicio
				
					try {
						dtinicio = new Date(format.parse(dtInicio).getTime());
					} catch (ParseException e) {
						dtinicio = null;
					}
					plan.setData_inicio(dtinicio);
					
					// Data CT
					
					try {
						dtct = new Date(format.parse(dtCT).getTime());
					} catch (ParseException e1) {
						dtct = null;
					}
					
					// Qtde Blocos
					plan.setQtde_blocos(bloco !=null && !bloco.equals("") ? Integer.parseInt(bloco): plan.getQtde_blocos());

					// Datas blocos
					// envio
					try {
						dtblocoEnvio = dtBlocoEnvio != null && !dtBlocoEnvio.equals("  /  /    ") ? new Date(format.parse(dtBlocoEnvio)
								.getTime()) : null;
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					plan.setBloco_envio(dtblocoEnvio);

					// chegada
					try {
						dtblocoChegada = dtBlocoChegada != null && !dtBlocoChegada.equals("  /  /    ") ? new Date(format.parse(dtBlocoChegada)
								.getTime()):null;
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					plan.setBloco_chegada(dtblocoChegada);

					// Entidades
				
					plan.setAparelho(selectAparelho != null && selectAparelho.getCodigo() != null ? selectAparelho : null);
					plan.setPaciente(objBusca != null && objBusca.getCodPaciente() !=null ? objBusca :null);
					plan.setOrigem(selectOrigem != null && selectOrigem.getCodigo() !=null ? selectOrigem :null);
					plan.setMedicos(selectMedico !=null && selectMedico.getCodigo() !=null ? selectMedico :null);
					plan.setPrimeira_ass(selectfisico1 !=null && selectfisico1.getCodigo() != null? selectfisico1 : null);
					plan.setSegunda_ass(selectfisico2 !=null && selectfisico2.getCodigo() != null ? selectfisico2 :null);
					plan.setSis_gerenciamento(selectSisGerencia !=null && selectSisGerencia.getCodigo() !=null ? selectSisGerencia :null);

					// Strings
					plan.setContorno(contorno);
					plan.setImpressao(impressao);
					plan.setPlano(plano);
					plan.setAlvo(alvo);
					plan.setTecnica(txtTecnica.getText().toUpperCase());
					plan.setObservacoes(txtObs.getText());
					
					// DATAS
					plan.setCt(dtct);
					plan.setBloco_envio(dtblocoEnvio);
					plan.setBloco_chegada(dtblocoChegada);

					// Boolean

					plan.setStatus_inativo(status);

					try {
						pDAO.salvar(plan);
					} catch (Exception e) {
						e.printStackTrace();
						JOptionPane
						.showMessageDialog(null,
								"Registro de paciente, já existe, Favor verificar e tentar novamente");
					}

				}
			}
		});

		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(CadPlanejamentoView.class
				.getResource("/imagens/1482302103_txt2.png")));

		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(CadPlanejamentoView.class
				.getResource("/imagens/1482302067_Magnifier.png")));

		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(CadPlanejamentoView.class
				.getResource("/imagens/1482302161_10.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		txtRegistro = new JTextField();
		txtRegistro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtRegistro.setFocusable(true);
			}
		});
		txtRegistro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_TAB) {
					PacientesDao pDAO = new PacientesDao();
					String registro = txtRegistro.getText().toUpperCase();
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

					// Paciente objBusca = new Paciente();
					objBusca = pDAO.buscar(registro, new String());

					if (registro == null || registro.trim().equals("")) {
						JOptionPane
								.showMessageDialog(null,
										"Registro em branco, favor digitar um registro para realização da busca!!");
					} else if (registro.trim().equals(objBusca.getregistro())) {

						txtRegistro.setText(objBusca.getregistro()
								.toUpperCase());
						txtNomePaciente.setText(objBusca.getNomePaciente()
								.toUpperCase());
						fmtData_1Paciente.setText(format.format(objBusca
								.getDtNascimento().getTime()));
					} else {
						JOptionPane.showMessageDialog(null,
								"Paciente não encontrado!");
					}
				}
			}
		});
		txtRegistro.setToolTipText("Digite o Registro HC do Paciente");
		txtRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtRegistro.setColumns(10);

		txtNomePaciente = new JTextField();
		txtNomePaciente.setToolTipText("Digite o Nome do Paciente!");
		txtNomePaciente.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNomePaciente.setColumns(10);

		try {
			MaskFormatter data = new MaskFormatter("##/##/####");
			fmtData_1Paciente = new JFormattedTextField(data);
			fmtData_1Paciente
					.setToolTipText("Digite a data de nascimento do paciente!");
			fmtData_1Paciente.setFont(new Font("Tahoma", Font.BOLD, 14));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JComboBox cmbOrigem = new JComboBox();
		cmbOrigem
				.setToolTipText("Selecione a cl\u00EDnica de origem do paciente");
		cmbOrigem.setFont(new Font("Tahoma", Font.BOLD, 12));
		OrigemDao orDAO = new OrigemDao();
		List<Origem> listaor = orDAO.buscaTodos(null, null);
		for (Origem origem : listaor) {
			cmbOrigem.addItem(origem.getSigla()+"-"+ origem.getDescricao());
		}
		String OrSelecionada = (String) cmbOrigem.getSelectedItem().toString();
		String arrayOR[] = new String[2];
		arrayOR = OrSelecionada.split("-");
		selectOrigem = orDAO.buscar(arrayOR[0], new String());


		JLabel lblMedico = new JLabel("M\u00E9dico");
		lblMedico.setFont(new Font("Tahoma", Font.BOLD, 12));

		JComboBox cmbMedico = new JComboBox();
		cmbMedico.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbMedico.setToolTipText("Selcione o M\u00E9dico Respons\u00E1vel");
		MedicoDao mDAO = new MedicoDao();
		cmbMedico.setToolTipText("Selcione o M\u00E9dico Respons\u00E1vel");
		List<Medicos> lista = mDAO.buscaTodos(null, null);
		for (Medicos medicos : lista) {
			cmbMedico.addItem(medicos.getCRM() + "-" + medicos.getNome());

		}
		String mdSelecionado = (String) cmbMedico.getSelectedItem().toString();
		String arrayMd[] = new String[2];
		arrayMd = mdSelecionado.split("-");
		selectMedico = mDAO.buscar(arrayMd[0], new String());

		JLabel lblRegiaoanat = new JLabel("Regi\u00E3o Anat.");
		lblRegiaoanat.setFont(new Font("Tahoma", Font.BOLD, 12));

		JComboBox cmbRegiaoAnat = new JComboBox();
		cmbRegiaoAnat.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbRegiaoAnat.setToolTipText("Selecione a Regi\u00E3o Anat\u00F4mica");
		Regiao_AnatomicaDao reDAO = new Regiao_AnatomicaDao();
		List<Regiao_Anatomica> listaRegioes = reDAO.buscaTodos(null, null);
		for (Regiao_Anatomica regioes : listaRegioes) {
			cmbRegiaoAnat.addItem(regioes.getCodigo()+"-"+ regioes.getDescricao());

		}
		String reSelecionado = cmbRegiaoAnat.getSelectedItem()
				.toString();
		String arrayRE[] = new String[2];
		arrayRE = reSelecionado.split("-");
		selectRegiao = reDAO.buscar(arrayRE[0], new String());

		JLabel lblDataCT = new JLabel("Data CT");
		lblDataCT.setFont(new Font("Tahoma", Font.BOLD, 12));

		try {
			MaskFormatter dataCT = new MaskFormatter("##/##/####");
			fmtdDataCT_1 = new JFormattedTextField(dataCT);
			fmtdDataCT_1
					.setToolTipText("Digite a data da realiza\u00E7\u00E3o da tomografia!");
			fmtdDataCT_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblContorno = new JLabel("Contorno");
		lblContorno.setFont(new Font("Tahoma", Font.BOLD, 12));

		JComboBox cmbContorno = new JComboBox();
		cmbContorno.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbContorno.setModel(new DefaultComboBoxModel(new String[] {
				"N\u00E3o", "Sim" }));
		cmbContorno
				.setToolTipText("Selecione o sistema onde o contorno foi realizado!");
		contorno = (String) cmbContorno.getSelectedItem();

		JLabel lblAlvo = new JLabel("Alvo");
		lblAlvo.setFont(new Font("Tahoma", Font.BOLD, 12));

		JComboBox cmbAlvo = new JComboBox();
		cmbAlvo.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbAlvo.setModel(new DefaultComboBoxModel(new String[] { "N\u00E3o",
				"Sim" }));
		cmbAlvo.setToolTipText("Selecione se o alvo foi definido!");
		alvo = cmbAlvo.getSelectedItem().toString();

		JLabel lblPlano = new JLabel("Plano");
		lblPlano.setFont(new Font("Tahoma", Font.BOLD, 12));

		JComboBox cmbPlano = new JComboBox();
		cmbPlano.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbPlano.setModel(new DefaultComboBoxModel(new String[] { "N\u00E3o",
				"Aprovado" }));
		cmbPlano.setToolTipText("Selecione se o plano foi definido!");
		plano = cmbPlano.getSelectedItem().toString();

		JLabel lblImpressao = new JLabel("Impress\u00E3o");
		lblImpressao.setFont(new Font("Tahoma", Font.BOLD, 12));

		JComboBox cmbImpressao = new JComboBox();
		cmbImpressao.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbImpressao.setModel(new DefaultComboBoxModel(new String[] {
				"N\u00E3o", "Sim" }));
		cmbImpressao.setToolTipText("Selcione se a ficha floi impressa!");
		String impressao = cmbImpressao.getSelectedItem().toString();

		JLabel lbl1Assinatura = new JLabel("1\u00AA Assinatura");
		lbl1Assinatura.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lbl2Assinatura = new JLabel("2\u00AA Assinatura");
		lbl2Assinatura.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblBlocos = new JLabel("Blocos");
		lblBlocos.setFont(new Font("Tahoma", Font.BOLD, 12));

		JComboBox cmb1Ass = new JComboBox();
		cmb1Ass.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmb1Ass.setToolTipText("1\u00AA assinatura F\u00EDsica M\u00E9dica");
		FisicosDao fDAO = new FisicosDao();
		List<Fisicos> listaFis1Ass = fDAO.buscaTodos(null, null);
		for (Fisicos fisico : listaFis1Ass) {
			cmb1Ass.addItem(fisico.getABFM() + "-" + fisico.getnome());
		}
		String fisSeleceao = cmb1Ass.getSelectedItem().toString();
		String array1ass[] = new String[2];
		array1ass = fisSeleceao.split("-");
		selectfisico1 = fDAO.buscar(array1ass[0], null);

		JComboBox cmb2Ass = new JComboBox();
		cmb2Ass.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmb2Ass.setToolTipText("2\u00AA assinatura F\u00EDsica M\u00E9dica");
		List<Fisicos> listaFis2Ass = fDAO.buscaTodos(null, null);
		for (Fisicos fisico : listaFis2Ass) {
			cmb2Ass.addItem(fisico.getABFM() + "-" + fisico.getnome());
		}
		String fisSeleceao2 = cmb2Ass.getSelectedItem().toString();
		String array2ass[] = new String[2];
		array2ass = fisSeleceao2.split("-");
		selectfisico2 = fDAO.buscar(array2ass[0], null);

		JLabel lblSisGerenciamento = new JLabel("Sist. Gerenciamento");
		lblSisGerenciamento.setFont(new Font("Tahoma", Font.BOLD, 12));

		JComboBox cmbSisGerenciamento = new JComboBox();
		cmbSisGerenciamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbSisGerenciamento
				.setToolTipText("Selecione o Sistema de Gerenciamento para este paciente!");
		Sistema_GerenciamentoDao sisDAO = new Sistema_GerenciamentoDao();
		List<Sistema_Gerenciamento> listaSisGer = sisDAO.buscatodos(null, null);
		for (Sistema_Gerenciamento sistemas : listaSisGer) {
			cmbSisGerenciamento.addItem(sistemas.getCodigo()+ "-" + sistemas.getDescricao());
		}
		String sisSelecao = cmbSisGerenciamento.getSelectedItem()
				.toString();
		String arraySis[] = new String[2];
		arraySis = sisSelecao.split("-");
		selectSisGerencia = sisDAO.buscaPOrCodigo(new Long(arraySis[0]));

		JLabel lblDtaBlocosEnvio = new JLabel("Data Envio");
		lblDtaBlocosEnvio.setFont(new Font("Tahoma", Font.BOLD, 12));

		JFormattedTextField fmtdDataBlocos = new JFormattedTextField();
		fmtdDataBlocos.setFont(new Font("Tahoma", Font.BOLD, 12));

		try {
			MaskFormatter dataBlocos = new MaskFormatter("##/##/####");
			fmtdDataBlocos_1 = new JFormattedTextField(dataBlocos);
			fmtdDataBlocos_1
					.setToolTipText("Selecione a data de envio dos blocos!");
			fmtdDataBlocos_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblBlocosChegada = new JLabel("Data Chegada");
		lblBlocosChegada.setFont(new Font("Tahoma", Font.BOLD, 12));

		JFormattedTextField fmtdDataBlocoschegada = new JFormattedTextField();
		fmtdDataBlocoschegada
				.setToolTipText("Selecione a data de envio dos blocos!");
		try {
			MaskFormatter dataBlocoschegada = new MaskFormatter("##/##/####");
			fmtdDataBlocoschegada_1 = new JFormattedTextField(dataBlocoschegada);
			fmtdDataBlocoschegada_1
					.setToolTipText("Selecione a data de envio dos blocos!");
			fmtdDataBlocoschegada_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lblStatus = new JLabel("Status do Paciente:");
		lblStatus
				.setToolTipText("Selecione se o paciente est\u00E1 ativo ou inativo! ");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));

		JCheckBox chbInativo = new JCheckBox("Inativar Paciente");
		status = chbInativo.isSelected();

		txtQtdeBlocos = new JTextField();
		txtQtdeBlocos.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtQtdeBlocos.setColumns(10);

		JLabel lblTcnica = new JLabel("T\u00E9cnica");
		lblTcnica.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblAparelho = new JLabel("Aparelho");
		lblAparelho.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtTecnica = new JTextField();
		txtTecnica.setToolTipText("Digite a T\u00E9cnica de tratamento!");
		txtTecnica.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTecnica.setColumns(10);

		JComboBox cmbAparelho = new JComboBox();
		cmbAparelho.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmbAparelho.setToolTipText("Selecione o Aparelho desejado!");
		AparelhoDao apDAO = new AparelhoDao();
		List<Aparelho> listaAP = apDAO.buscaTodos(null, null);
		for (Aparelho aparelhos : listaAP) {
			cmbAparelho.addItem(aparelhos.getCodigo()+"-"+ aparelhos.getDescricao());

		}
		String apSelecao = cmbAparelho.getSelectedItem().toString();
		String arrayAp[] = new String[2];
		arrayAp = apSelecao.split("-");
		selectAparelho = apDAO.buscar(arrayAp[0], null);

		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservaes.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtObs = new JTextField();
		txtObs.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtObs.setColumns(10);

		JButton btnBuscapaciente = new JButton("");
		btnBuscapaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadPacienteView cadPaciente = null;
				try {
					cadPaciente = new CadPacienteView();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cadPaciente.setVisible(true);
			}
		});
		btnBuscapaciente.setIcon(new ImageIcon(CadPlanejamentoView.class
				.getResource("/imagens/1498121290_Add.png")));

		JLabel lblNewLabel = new JLabel("Data de In\u00EDcio");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

		JFormattedTextField fmtdDTInicio = new JFormattedTextField();
		fmtdDTInicio.setFont(new Font("Tahoma", Font.BOLD, 14));
		MaskFormatter dataInicio = null;
		try {
			dataInicio = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fmtdDTInicio_1 = new JFormattedTextField(dataInicio);
		fmtdDTInicio_1.setFont(new Font("Tahoma", Font.BOLD, 14));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblOrigem)
																						.addComponent(
																								cmbOrigem,
																								GroupLayout.PREFERRED_SIZE,
																								213,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addComponent(
																												cmbRegiaoAnat,
																												0,
																												131,
																												Short.MAX_VALUE)
																										.addGap(14))
																						.addComponent(
																								lblRegiaoanat))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblDataCT,
																								GroupLayout.PREFERRED_SIZE,
																								57,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								fmtdDataCT_1,
																								GroupLayout.PREFERRED_SIZE,
																								95,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(18)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addComponent(
																												cmbContorno,
																												GroupLayout.PREFERRED_SIZE,
																												107,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												cmbAlvo,
																												GroupLayout.PREFERRED_SIZE,
																												93,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addComponent(
																												lblContorno,
																												GroupLayout.PREFERRED_SIZE,
																												80,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(33)
																										.addComponent(
																												lblAlvo,
																												GroupLayout.PREFERRED_SIZE,
																												38,
																												GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblPlano,
																								GroupLayout.PREFERRED_SIZE,
																								47,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								cmbPlano,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblRegistro)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addComponent(
																												txtRegistro,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												btnBuscapaciente,
																												GroupLayout.PREFERRED_SIZE,
																												30,
																												GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								txtNomePaciente,
																								GroupLayout.PREFERRED_SIZE,
																								295,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblNome))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblDataDeNascimento)
																						.addComponent(
																								fmtData_1Paciente,
																								GroupLayout.PREFERRED_SIZE,
																								95,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addComponent(
																												lblMedico,
																												GroupLayout.PREFERRED_SIZE,
																												47,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED,
																												144,
																												Short.MAX_VALUE))
																						.addComponent(
																								cmbMedico,
																								0,
																								191,
																								Short.MAX_VALUE)))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																lblAparelho)
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addComponent(
																																				btnSalvar,
																																				GroupLayout.PREFERRED_SIZE,
																																				60,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addGap(18)
																																		.addComponent(
																																				btnAlterar,
																																				GroupLayout.PREFERRED_SIZE,
																																				60,
																																				GroupLayout.PREFERRED_SIZE))
																														.addComponent(
																																cmbAparelho,
																																GroupLayout.PREFERRED_SIZE,
																																158,
																																GroupLayout.PREFERRED_SIZE))
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addGroup(
																																				gl_contentPane
																																						.createParallelGroup(
																																								Alignment.LEADING)
																																						.addGroup(
																																								gl_contentPane
																																										.createSequentialGroup()
																																										.addGap(19)
																																										.addComponent(
																																												lblSisGerenciamento,
																																												GroupLayout.PREFERRED_SIZE,
																																												140,
																																												GroupLayout.PREFERRED_SIZE))
																																						.addGroup(
																																								gl_contentPane
																																										.createSequentialGroup()
																																										.addGap(18)
																																										.addComponent(
																																												cmbSisGerenciamento,
																																												GroupLayout.PREFERRED_SIZE,
																																												182,
																																												GroupLayout.PREFERRED_SIZE))))
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addGap(2)
																																		.addComponent(
																																				btnBuscar,
																																				GroupLayout.PREFERRED_SIZE,
																																				60,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addGap(26)
																																		.addComponent(
																																				btnSair,
																																				GroupLayout.PREFERRED_SIZE,
																																				60,
																																				GroupLayout.PREFERRED_SIZE))))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																lblTcnica)
																														.addComponent(
																																txtTecnica,
																																GroupLayout.PREFERRED_SIZE,
																																112,
																																GroupLayout.PREFERRED_SIZE))
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																cmbImpressao,
																																GroupLayout.PREFERRED_SIZE,
																																121,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																lblImpressao,
																																GroupLayout.PREFERRED_SIZE,
																																80,
																																GroupLayout.PREFERRED_SIZE))
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addGap(18)
																																		.addComponent(
																																				lbl1Assinatura,
																																				GroupLayout.PREFERRED_SIZE,
																																				92,
																																				GroupLayout.PREFERRED_SIZE))
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addPreferredGap(
																																				ComponentPlacement.UNRELATED)
																																		.addComponent(
																																				cmb1Ass,
																																				GroupLayout.PREFERRED_SIZE,
																																				119,
																																				GroupLayout.PREFERRED_SIZE)))))
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addGap(10)
																																		.addGroup(
																																				gl_contentPane
																																						.createParallelGroup(
																																								Alignment.LEADING)
																																						.addGroup(
																																								gl_contentPane
																																										.createSequentialGroup()
																																										.addGap(18)
																																										.addComponent(
																																												lbl2Assinatura,
																																												GroupLayout.PREFERRED_SIZE,
																																												93,
																																												GroupLayout.PREFERRED_SIZE))
																																						.addGroup(
																																								gl_contentPane
																																										.createSequentialGroup()
																																										.addPreferredGap(
																																												ComponentPlacement.UNRELATED)
																																										.addComponent(
																																												cmb2Ass,
																																												GroupLayout.PREFERRED_SIZE,
																																												116,
																																												GroupLayout.PREFERRED_SIZE)))
																																		.addGap(8)
																																		.addGroup(
																																				gl_contentPane
																																						.createParallelGroup(
																																								Alignment.LEADING)
																																						.addGroup(
																																								gl_contentPane
																																										.createSequentialGroup()
																																										.addPreferredGap(
																																												ComponentPlacement.RELATED)
																																										.addComponent(
																																												txtQtdeBlocos,
																																												GroupLayout.PREFERRED_SIZE,
																																												67,
																																												GroupLayout.PREFERRED_SIZE)
																																										.addPreferredGap(
																																												ComponentPlacement.RELATED)
																																										.addComponent(
																																												fmtdDataBlocos_1,
																																												GroupLayout.PREFERRED_SIZE,
																																												95,
																																												GroupLayout.PREFERRED_SIZE))
																																						.addGroup(
																																								gl_contentPane
																																										.createSequentialGroup()
																																										.addGap(8)
																																										.addComponent(
																																												lblBlocos,
																																												GroupLayout.PREFERRED_SIZE,
																																												53,
																																												GroupLayout.PREFERRED_SIZE)
																																										.addPreferredGap(
																																												ComponentPlacement.UNRELATED)
																																										.addComponent(
																																												lblDtaBlocosEnvio))))
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addGap(1)
																																		.addGroup(
																																				gl_contentPane
																																						.createParallelGroup(
																																								Alignment.LEADING)
																																						.addComponent(
																																								txtObs,
																																								GroupLayout.DEFAULT_SIZE,
																																								301,
																																								Short.MAX_VALUE)
																																						.addComponent(
																																								lblObservaes))))
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																gl_contentPane
																																		.createParallelGroup(
																																				Alignment.TRAILING)
																																		.addComponent(
																																				fmtdDTInicio_1,
																																				Alignment.LEADING,
																																				GroupLayout.DEFAULT_SIZE,
																																				95,
																																				Short.MAX_VALUE)
																																		.addComponent(
																																				lblNewLabel,
																																				Alignment.LEADING))
																														.addComponent(
																																lblBlocosChegada)
																														.addComponent(
																																fmtdDataBlocoschegada_1,
																																GroupLayout.PREFERRED_SIZE,
																																95,
																																GroupLayout.PREFERRED_SIZE)))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.TRAILING,
																																false)
																														.addComponent(
																																chbInativo,
																																Alignment.LEADING,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																lblStatus,
																																Alignment.LEADING,
																																GroupLayout.PREFERRED_SIZE,
																																127,
																																GroupLayout.PREFERRED_SIZE))))))
										.addGap(118)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_contentPane
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				lblRegistro)
																		.addComponent(
																				lblNome))
														.addGroup(
																gl_contentPane
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				lblMedico,
																				GroupLayout.PREFERRED_SIZE,
																				15,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				lblDataDeNascimento)))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtRegistro,
																GroupLayout.PREFERRED_SIZE,
																25,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																txtNomePaciente,
																GroupLayout.PREFERRED_SIZE,
																25,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																fmtData_1Paciente,
																GroupLayout.PREFERRED_SIZE,
																25,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																cmbMedico,
																GroupLayout.PREFERRED_SIZE,
																23,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnBuscapaciente,
																GroupLayout.PREFERRED_SIZE,
																25,
																GroupLayout.PREFERRED_SIZE))
										.addGap(13)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblContorno,
																GroupLayout.PREFERRED_SIZE,
																15,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblAlvo,
																GroupLayout.PREFERRED_SIZE,
																15,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblOrigem)
														.addComponent(
																lblRegiaoanat,
																GroupLayout.PREFERRED_SIZE,
																15,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblDataCT,
																GroupLayout.PREFERRED_SIZE,
																15,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblPlano,
																GroupLayout.PREFERRED_SIZE,
																15,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				cmbContorno,
																				GroupLayout.PREFERRED_SIZE,
																				24,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				cmbAlvo,
																				GroupLayout.PREFERRED_SIZE,
																				24,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				cmbPlano,
																				GroupLayout.PREFERRED_SIZE,
																				24,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				fmtdDataCT_1,
																				GroupLayout.PREFERRED_SIZE,
																				25,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																cmbOrigem,
																GroupLayout.PREFERRED_SIZE,
																24,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																cmbRegiaoAnat,
																GroupLayout.PREFERRED_SIZE,
																24,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				lblTcnica)
																		.addComponent(
																				lbl1Assinatura,
																				GroupLayout.PREFERRED_SIZE,
																				15,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				lbl2Assinatura,
																				GroupLayout.PREFERRED_SIZE,
																				15,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				lblBlocos,
																				GroupLayout.PREFERRED_SIZE,
																				15,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				lblBlocosChegada,
																				GroupLayout.PREFERRED_SIZE,
																				15,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				lblDtaBlocosEnvio,
																				GroupLayout.PREFERRED_SIZE,
																				15,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																lblImpressao,
																GroupLayout.PREFERRED_SIZE,
																15,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtQtdeBlocos,
																GroupLayout.PREFERRED_SIZE,
																25,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																fmtdDataBlocos_1,
																GroupLayout.PREFERRED_SIZE,
																25,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																fmtdDataBlocoschegada_1,
																GroupLayout.PREFERRED_SIZE,
																25,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																txtTecnica,
																GroupLayout.PREFERRED_SIZE,
																25,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																cmbImpressao,
																GroupLayout.PREFERRED_SIZE,
																24,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																cmb1Ass,
																GroupLayout.PREFERRED_SIZE,
																24,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																cmb2Ass,
																GroupLayout.PREFERRED_SIZE,
																24,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								lblAparelho)
																						.addGroup(
																								gl_contentPane
																										.createParallelGroup(
																												Alignment.BASELINE)
																										.addComponent(
																												lblSisGerenciamento,
																												GroupLayout.PREFERRED_SIZE,
																												15,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												lblObservaes)))
																		.addGap(7)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								cmbAparelho,
																								GroupLayout.PREFERRED_SIZE,
																								24,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								cmbSisGerenciamento,
																								GroupLayout.PREFERRED_SIZE,
																								24,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								txtObs,
																								GroupLayout.PREFERRED_SIZE,
																								25,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				lblNewLabel)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				fmtdDTInicio_1,
																				GroupLayout.PREFERRED_SIZE,
																				25,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																btnSalvar,
																GroupLayout.PREFERRED_SIZE,
																60,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnAlterar,
																GroupLayout.PREFERRED_SIZE,
																60,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnBuscar,
																GroupLayout.PREFERRED_SIZE,
																60,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnSair,
																GroupLayout.PREFERRED_SIZE,
																60,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				lblStatus,
																				GroupLayout.PREFERRED_SIZE,
																				15,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				chbInativo)))
										.addContainerGap(40, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
