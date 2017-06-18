package com.mestrado.Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import com.mestrado.model.Regiao_Anatomica;

public class Regiao_AnatomicaDao {
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("mestradoPU");
	private EntityManager em = emf.createEntityManager();
	Regiao_Anatomica regiao = new Regiao_Anatomica();

	public void salvar(Regiao_Anatomica regiao) throws Exception {

		em.getTransaction().begin();
		em.persist(regiao);
		em.getTransaction().commit();
		em.close();
	}

	public void alterar(Regiao_Anatomica regiao) {
		Regiao_Anatomica original = new Regiao_Anatomica();

		original = em.find(Regiao_Anatomica.class, regiao.getCodigo());

		if (original.getDescricao().equals(regiao.getDescricao())) {
			JOptionPane
					.showMessageDialog(null,
							"Região já existente, favor verificar e tentar novamente!!");

		} else {
			em.getTransaction().begin();
			em.merge(regiao);
			em.getTransaction().commit();
			em.close();
			// System.out.println(regiao);
			JOptionPane.showMessageDialog(null,
					"Região Anatômica alterada com sucesso!!!");
		}
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public Regiao_Anatomica buscar(String a, String b) {

		String descricao;
		Long codigo;
		Query query = em
				.createQuery(" select a from Regiao_Anatomica a where a.descricao = :descr");

		query.setParameter("descr", a);
		List<Regiao_Anatomica> regioes = query.getResultList();

		for (Regiao_Anatomica regiao : regioes) {

			codigo = regiao.getCodigo();
			descricao = regiao.getDescricao();

		}

		return !regioes.isEmpty() ? regioes.get(0) : new Regiao_Anatomica();

	}

	@SuppressWarnings("unchecked")
	public List<Regiao_Anatomica> buscaTodos(String a, String b) {
		Query query = em.createQuery("select a from Regiao_anatomica a");
		List<Regiao_Anatomica> result = query.getResultList();
		return result;
	}
}
