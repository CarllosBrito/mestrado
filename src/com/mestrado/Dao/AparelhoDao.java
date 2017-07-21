package com.mestrado.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.mestrado.model.Aparelho;

public class AparelhoDao {

	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("mestradoPU");
	private EntityManager em = emf.createEntityManager();

	public void salvar(String descricao) throws Exception {
		Aparelho aparelho = new Aparelho();

		aparelho.setDescricao(descricao);

		em.getTransaction().begin();
		em.persist(aparelho);
		em.getTransaction().commit();
		em.close();

		JOptionPane.showMessageDialog(null, "Aparelho Salvo com sucesso!!!");

	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	public Aparelho buscaPOrCodigo(Long a){
		Long codigo =a;
		
		Query query = em
				.createQuery(" select a from Sistema_Gerenciamento a where a.codigo = :cod");
		query.setParameter("cod", a);

		List<Aparelho> ap = query.getResultList();

		
		return !ap.isEmpty() ? ap.get(0) : new Aparelho();
		
	}


	public void alterar(Aparelho aparelho) {
		Aparelho original = new Aparelho();

		original = em.find(Aparelho.class, aparelho.getCodigo());

		if (original.getDescricao().equals(aparelho.getDescricao())) {
			JOptionPane
					.showMessageDialog(null,
							"Aparelho já existente, favor verificar e tentar novamente!!");

		} else {
			em.getTransaction().begin();
			em.merge(aparelho);
			em.getTransaction().commit();
			em.close();

			JOptionPane.showMessageDialog(null,
					"Aparelho alterado com sucesso!!!");
		}
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Aparelho buscar(String a, String b) {
		Long codigo;
		String descricao;

		Query query = em
				.createQuery(" select a from Aparelho a where a.Descricao = :descr");
		query.setParameter("descr", a);

		List<Aparelho> Aparelho = query.getResultList();

		for (Aparelho aparelho : Aparelho) {

			descricao = aparelho.getDescricao();

		}
		return !Aparelho.isEmpty() ? Aparelho.get(0) : new Aparelho();
	}

	public List<Aparelho> buscaTodos(String a, String b) {
		Query query = em.createQuery("select a from Aparelho a");
		@SuppressWarnings("unchecked")
		List<Aparelho> result = query.getResultList();
		return result;
	}

}
