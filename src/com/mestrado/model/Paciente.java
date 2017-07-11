package com.mestrado.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "registro", name = "registropaciente_uk"))
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codPaciente")
    private Long codPaciente;
    
    @Column(name = "dtNascimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtNascimento;
    
    @Column(name = "nomePaciente")
    private String nomePaciente;
    
    @Column(name = "registro")
    private String registro;
    
    @OneToMany(mappedBy = "paciente")
    private List<Planejamento> planejamentos;
	
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
	public void setregistro(String registro) {
		this.registro = registro;
	}
	public List<Planejamento> getPlanejamentos() {
		return planejamentos;
	}
	public void setPlanejamentos(List<Planejamento> planejamentos) {
		this.planejamentos = planejamentos;
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
