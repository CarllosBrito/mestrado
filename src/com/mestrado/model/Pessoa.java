package com.mestrado.model;

import java.util.Date;

public class Pessoa {
	
	private Long codigo;
	private String Nome;
	private Date DataNasimento;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Date getDataNasimento() {
		return DataNasimento;
	}
	public void setDataNasimento(Date dataNasimento) {
		DataNasimento = dataNasimento;
	}
	
	

}
