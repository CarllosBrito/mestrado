package com.mestrado.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.mestrado.model.Fisicos;

public class FisicosDao {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mestradoPU");
	private EntityManager em = emf.createEntityManager();
	
	
	public void salvar(String nome, String abfm, String sigla, String senha){
		Fisicos fisico = new Fisicos();
				
				fisico.setNome(nome);
				fisico.setABFM(abfm);
				fisico.setSenha(senha);
				fisico.setSigla(sigla);
				
				em.getTransaction().begin();
				em.persist(fisico);
				em.getTransaction().commit();
				em.close();
				
		}
	

}
