package com.mestrado.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "registro", name="registropaciente_uk"))
public class Paciente {
	
	private Long codPaciente;
	private String nomePaciente;
	private String registro;
	private Date dtNascimento;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodPaciente() {
		return codPaciente;
	}
	public void setCodPaciente(Long codPaciente) {
		this.codPaciente = codPaciente;
	}
	
	
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date data) {
		this.dtNascimento = data;
	}
	
	public String getregistro() {
		return registro;
	}
	public void setregistro (String registro) {
		this.registro = registro;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codPaciente == null) ? 0 : codPaciente.hashCode());
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
		Paciente other = (Paciente) obj;
		if (codPaciente == null) {
			if (other.codPaciente != null)
				return false;
		} else if (!codPaciente.equals(other.codPaciente))
			return false;
		return true;
	}


}
