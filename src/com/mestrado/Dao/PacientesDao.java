package com.mestrado.Dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mestrado.model.Paciente;

public class PacientesDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mestradoPU");
	private EntityManager em = emf.createEntityManager();
	
	
	public void salvar(String nome, String registro, Date dataNsc){
		Paciente paciente = new Paciente();
		
				
		paciente.setNomePaciente(nome);
		paciente.setregistro(registro);
		paciente.setDtNascimento(dataNsc);
			
		em.getTransaction().begin();
		em.persist(paciente);
		em.getTransaction().commit();
		em.close();	
	
	}
}
