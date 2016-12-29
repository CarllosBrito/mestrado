package com.mestrado.model;

public class Fisico extends Pessoa {
	
	private Long codigo;
	private String ABFM;
	private String sigla;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getABFM() {
		return ABFM;
	}
	public void setABFM(String aBFM) {
		ABFM = aBFM;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	
}
