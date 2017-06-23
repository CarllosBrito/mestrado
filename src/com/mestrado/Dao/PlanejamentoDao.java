package com.mestrado.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mestrado.model.Planejamento;

public class PlanejamentoDao {
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("mestradoPU");
	private EntityManager em = emf.createEntityManager();

	
	public void salvar(Planejamento plan)
			throws Exception {
		
		em.getTransaction().begin();
		em.merge(plan);
		em.getTransaction().commit();
		em.close();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Planejamento> buscaTodos(String a, String b) {
		Query query = em.createQuery("select a from Planejamento a");
		List<Planejamento> result = query.getResultList();
		return result;
	}

}
