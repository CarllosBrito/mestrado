package com.mestrado.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mestrado.model.Medicos;

public class MedicoDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mestradoPU");
	private EntityManager em = emf.createEntityManager();
	
	
	public void salvar(String nome,String crm,String sigla){
		Medicos MD = new Medicos();
				
			
			MD.setNome(nome);
			MD.setCRM(crm);
			MD.setSigla(sigla);
				
			em.getTransaction().begin();
			em.persist(MD);
			em.getTransaction().commit();
			em.close();
				
		}
	

}
