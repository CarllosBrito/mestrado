package com.mestrado.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "planejamento", uniqueConstraints = @UniqueConstraint(columnNames = "codigo", name = "codigo_uk"))
public class Planejamento implements Serializable{
	
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Long codigo;
    
    @Column(name = "qtdeCampos")
    private Integer qtdeCampos;
    
	@Column(name = "alvo")
    private String alvo;
    
    @Column(name = "bloco_chegada")
    @Temporal(TemporalType.DATE)
    private Date bloco_chegada;
    
    @Column(name = "bloco_envio")
    @Temporal(TemporalType.DATE)
    private Date bloco_envio;
    
    @Column(name = "contorno")
    private String contorno;
    
    @Basic(optional = false)
    @Column(name = "data_cad")
    @Temporal(TemporalType.DATE)
    private Date data_cad;
    
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date data_inicio;
    
    @Column(name = "impressao")
    private String impressao;
    
    @Column(name = "observacoes")
    private String observacoes;
    
    @Column(name = "plano")
    private String plano;
    
    @Column(name = "qtde_blocos")
    private Integer qtde_blocos;
    
    @Column(name = "fila")
    private Integer fila;
    
   
	@Column(name = "tecnica")
    private String tecnica;
    
    
    
    @Column(name = "status_inativo")
    private Boolean status_inativo;
    
    @Column(name = "ct")
    @Temporal(TemporalType.DATE)
    private Date ct;
    
    @JoinColumn(name = "segunda_ass_codigo", referencedColumnName = "codigo")
    @ManyToOne
    private Fisicos segunda_ass;
    
    @JoinColumn(name = "aparelho_codigo", referencedColumnName = "codigo")
    @ManyToOne
    private Aparelho aparelho;
    
    @JoinColumn(name = "origem_codigo", referencedColumnName = "codigo")
    @ManyToOne
    private Origem origem;
    
    @JoinColumn(name = "paciente_codPaciente", referencedColumnName = "codPaciente")
    @ManyToOne
    private Paciente paciente;
    
    @JoinColumn(name = "primeira_ass_codigo", referencedColumnName = "codigo")
    @ManyToOne
    private Fisicos primeira_ass;
    
    @JoinColumn(name = "medicos_codigo", referencedColumnName = "codigo")
    @ManyToOne
    private Medicos medicos;
    
    @JoinColumn(name = "sis_gerenciamento_codigo", referencedColumnName = "codigo")
    @ManyToOne
    private Sistema_Gerenciamento sis_gerenciamento;
    
    
	@JoinColumn(name = "regiao_codigo", referencedColumnName = "codigo")
    @ManyToOne
    private Regiao_Anatomica regiao;
    
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public Integer getQtdeCampos() {
		return qtdeCampos;
	}

	public void setQtdeCampos(Integer qtdeCampos) {
		this.qtdeCampos = qtdeCampos;
	}

	public int getQtde_blocos() {
		return qtde_blocos;
	}

	public void setQtde_blocos(int qtde_blocos) {
		this.qtde_blocos = qtde_blocos;
	}

	 public Integer getFila() {
			return fila;
		}

		public void setFila(Integer fila) {
			this.fila = fila;
		}
	@Temporal(TemporalType.DATE)
	public Date getBloco_envio() {
		return bloco_envio;
	}

	public void setBloco_envio(Date bloco_envio) {
		this.bloco_envio = bloco_envio;
	}

	@Temporal(TemporalType.DATE)
	public Date getBloco_chegada() {
		return bloco_chegada;
	}

	public void setBloco_chegada(Date bloco_chegada) {
		this.bloco_chegada = bloco_chegada;
	}

	@Temporal(TemporalType.DATE)
	public Date getData_cad() {
		return data_cad;
	}

	public void setData_cad(Date data_cad) {
		this.data_cad = data_cad;
	}

	@Temporal(TemporalType.DATE)
	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}
	
	
	@Temporal(TemporalType.DATE)
	public Date getCt() {
		return ct;
	}

	public void setCt(Date ct) {
		this.ct = ct;
	}

	public String getImpressao() {
		return impressao;
	}

	public void setImpressao(String impressao) {
		this.impressao = impressao;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	
		public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medicos getMedicos() {
		return medicos;
	}

	public void setMedicos(Medicos medicos) {
		this.medicos = medicos;
	}

	public Fisicos getPrimeira_ass() {
		return primeira_ass;
	}

	public void setPrimeira_ass(Fisicos primeira_ass) {
		this.primeira_ass = primeira_ass;
	}

	public Fisicos getSegunda_ass() {
		return segunda_ass;
	}

	public void setSegunda_ass(Fisicos segunda_ass) {
		this.segunda_ass = segunda_ass;
	}

	public Aparelho getAparelho() {
		return aparelho;
	}

	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
	}

	public Sistema_Gerenciamento getSis_gerenciamento() {
		return sis_gerenciamento;
	}

	public void setSis_gerenciamento(Sistema_Gerenciamento sis_gerenciamento) {
		this.sis_gerenciamento = sis_gerenciamento;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}
	
	public Regiao_Anatomica getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao_Anatomica regiao) {
		this.regiao = regiao;
	}

	public String getAlvo() {
		return alvo;
	}

	public void setAlvo(String alvo) {
		this.alvo = alvo;
	}

	public String getContorno() {
		return contorno;
	}

	public void setContorno(String contorno) {
		this.contorno = contorno;
	}

	public Boolean getStatus_inativo() {
		return status_inativo;
	}

	public void setStatus_inativo(Boolean status_inativo) {
		this.status_inativo = status_inativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planejamento other = (Planejamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
