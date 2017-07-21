package com.mestrado.Dao;

import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.mestrado.model.Sistema_Gerenciamento;

public class Sistema_GerenciamentoDao {
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("mestradoPU");
	private EntityManager em = emf.createEntityManager();

	public void salvar(String descricao) throws Exception {
		Sistema_Gerenciamento SIS = new Sistema_Gerenciamento();

		SIS.setDescricao(descricao);

		em.getTransaction().begin();
		em.persist(SIS);
		em.getTransaction().commit();
		em.close();

		JOptionPane.showMessageDialog(null,
				"Sistema de Gerenciamento salvo com sucesso!!!");

	}

	public void alterar(Sistema_Gerenciamento sis) {
		Sistema_Gerenciamento original = new Sistema_Gerenciamento();

		original = em.find(Sistema_Gerenciamento.class, sis.getCodigo());

		if (original.getDescricao().equals(sis.getDescricao())) {
			JOptionPane
					.showMessageDialog(null,
							"Aparelho já existente, favor verificar e tentar novamente!!");
		} else {
			em.getTransaction().begin();
			em.merge(sis);
			em.getTransaction().commit();
			em.close();
			JOptionPane.showMessageDialog(null,
					"Sistema alterado com sucesso!!!");
		}

	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Sistema_Gerenciamento buscaPOrCodigo(Long a){
		Long codigo =a;
		
		Query query = em
				.createQuery(" select a from Sistema_Gerenciamento a where a.codigo = :cod");
		query.setParameter("cod", a);

		List<Sistema_Gerenciamento> Sistema = query.getResultList();

		
		return !Sistema.isEmpty() ? Sistema.get(0) : new Sistema_Gerenciamento();
		
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	public Sistema_Gerenciamento buscar(String a, String b) {
		Long codigo;
		String descricao;

		Query query = em
				.createQuery(" select a from Sistema_Gerenciamento a where a.descricao = :descr");
		query.setParameter("descr", a);

		List<Sistema_Gerenciamento> Sistema = query.getResultList();

		for (Sistema_Gerenciamento sis : Sistema) {
			descricao = sis.getDescricao();
		}
		return !Sistema.isEmpty() ? Sistema.get(0)
				: new Sistema_Gerenciamento();
	}

	@SuppressWarnings("unchecked")
	public List<Sistema_Gerenciamento> buscatodos(String a, String b) {
		Query query = em.createQuery("select a from Sistema_Gerenciamento a ");

		List<Sistema_Gerenciamento> result = query.getResultList();

		return result;
	}
}
