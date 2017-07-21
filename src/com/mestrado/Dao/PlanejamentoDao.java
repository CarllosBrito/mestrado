package com.mestrado.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.mestrado.model.Paciente;
import com.mestrado.model.Planejamento;

public class PlanejamentoDao {
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("mestradoPU");
	private EntityManager em = emf.createEntityManager();

	
	public void salvar(Planejamento planejamento)
			throws Exception {
		
		em.getTransaction().begin();
		em.persist(planejamento);
		em.getTransaction().commit();
		em.close();
		JOptionPane.showMessageDialog(null, "Planejamento salvo com sucesso!");
	}
	public void alterar(Planejamento planejamento) {
		@SuppressWarnings("unused")
		Planejamento original = new Planejamento();
		original = em.find(Planejamento.class, planejamento.getCodigo());

		em.getTransaction().begin();
		em.merge(planejamento);
		em.getTransaction().commit();
		em.close();

		JOptionPane.showMessageDialog(null, "Planejamento alterado com sucesso!!!");
	}
	
	@SuppressWarnings("unchecked")
	public List<Planejamento> buscaTodos(String a, String b) {
		Query query = em.createQuery("select a from Planejamento a");
		List<Planejamento> result = query.getResultList();
		return result;
	}
	@SuppressWarnings("unchecked")
	public List<Planejamento> buscaTodosPlan(String a, String b) {
		Query query = em.createQuery("from Planejamento");
		List<Planejamento> result = query.getResultList();
		return result;
	}

}
