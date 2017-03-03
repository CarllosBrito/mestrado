package com.mestrado.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mestrado.model.Regiao_Anatomica;



public class Regiao_AnatomicaDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mestradoPU");
	private EntityManager em = emf.createEntityManager();
	
	
	public void salvar(String descricao){
		Regiao_Anatomica reg_anat = new Regiao_Anatomica();
				
				reg_anat.setDescricao(descricao);
				em.getTransaction().begin();
				em.persist(reg_anat);
				em.getTransaction().commit();
				em.close();
				
		}
	
	public Regiao_Anatomica buscar(String descricao){
	
		List<Regiao_Anatomica> regioes= em.createQuery("from Regiao_anatomica descricao where descricao = :descricao ", Regiao_Anatomica.class).getResultList();
		
		for(Regiao_Anatomica regiao : regioes){
			regioes.add(regiao);
		}
		
		return (Regiao_Anatomica) regioes;
		
		
	}
	
	public void alterar(String objAlterado){
		Regiao_Anatomica reg_anat = em.find(Regiao_Anatomica.class, objAlterado);
		
		em.getTransaction().begin();
		reg_anat.setDescricao(objAlterado);
		em.getTransaction().commit();
		em.close();
		
	}

}
