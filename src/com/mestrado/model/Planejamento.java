package com.mestrado.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Planejamento {

	private Long codigo;
	private int qtde_blocos;
	private Date bloco_envio;
	private Date bloco_chegada;
	private Calendar data_cad;
	private Date data_inicio;
	private Date ct;
	private String impressao;
	private String tecnica;
	private String plano;
	private String observacoes;
	private Boolean status_ativo;
	private Boolean status_inativo;

	private Paciente paciente;
	private Medicos medicos;
	private Fisicos primeira_ass;
	private Fisicos segunda_ass;
	private Aparelho aparelho;
	private Sistema_Gerenciamento sis_gerenciamento;
	private Origem origem;
	private String alvo;
	private String contorno;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public int getQtde_blocos() {
		return qtde_blocos;
	}

	public void setQtde_blocos(int qtde_blocos) {
		this.qtde_blocos = qtde_blocos;
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
	public Calendar getData_cad() {
		return data_cad;
	}

	public void setData_cad(Calendar data_cad) {
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

	@ManyToOne
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@ManyToOne
	public Medicos getMedicos() {
		return medicos;
	}

	public void setMedicos(Medicos medicos) {
		this.medicos = medicos;
	}

	@ManyToOne
	public Fisicos getPrimeira_ass() {
		return primeira_ass;
	}

	public void setPrimeira_ass(Fisicos primeira_ass) {
		this.primeira_ass = primeira_ass;
	}

	@ManyToOne
	public Fisicos getSegunda_ass() {
		return segunda_ass;
	}

	public void setSegunda_ass(Fisicos segunda_ass) {
		this.segunda_ass = segunda_ass;
	}

	@ManyToOne
	public Aparelho getAparelho() {
		return aparelho;
	}

	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
	}

	@ManyToOne
	public Sistema_Gerenciamento getSis_gerenciamento() {
		return sis_gerenciamento;
	}

	public void setSis_gerenciamento(Sistema_Gerenciamento sis_gerenciamento) {
		this.sis_gerenciamento = sis_gerenciamento;
	}

	@ManyToOne
	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
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

	public Boolean getStatus_ativo() {
		return status_ativo;
	}

	public void setStatus_ativo(Boolean status_ativo) {
		this.status_ativo = status_ativo;
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
