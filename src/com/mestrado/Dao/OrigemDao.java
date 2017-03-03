package com.mestrado.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mestrado.model.Origem;


public class OrigemDao {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mestradoPU");
	private EntityManager em = emf.createEntityManager();
	
	public void salvar(String descricao, String sigla){
		Origem OR = new Origem();
		
		OR.setDescricao(descricao);
		OR.setSigla(sigla);
		
		em.getTransaction().begin();
		em.persist(OR);
		em.getTransaction().commit();
		em.close();	
		
	}
	
	
	

}
