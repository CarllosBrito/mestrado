package com.mestrado.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "ABFM", name = "ABFMFisico_uk"))
public class Fisicos implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Long codigo;
    
    @Column(name = "ABFM")
    private String ABFM;
    
    @Column(name = "sigla")
    private String sigla;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "senha")
    private String senha;
    
    @OneToMany(mappedBy = "segunda_ass")
    private List<Planejamento> planejamentoList;
    
    @OneToMany(mappedBy = "primeira_ass")
    private List<Planejamento> planejamentoList1;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getnome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Fisicos other = (Fisicos) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
