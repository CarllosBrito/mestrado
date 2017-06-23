package com.mestrado.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.mestrado.model.Fisicos;

public class FisicosDao {

	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("mestradoPU");
	private EntityManager em = emf.createEntityManager();
	Fisicos fisico = new Fisicos();

	public void salvar(String nome, String abfm, String sigla) throws Exception {

		fisico.setNome(nome);
		fisico.setABFM(abfm);
		fisico.setSigla(sigla);

		em.getTransaction().begin();
		em.persist(fisico);
		em.getTransaction().commit();
		em.close();

		JOptionPane.showMessageDialog(null, "Físico Salvo com Sucesso!!");

	}

	public void alterar(Fisicos fisico) {
		@SuppressWarnings("unused")
		Fisicos original = new Fisicos();

		original = em.find(Fisicos.class, fisico.getCodigo());

		em.getTransaction().begin();
		em.merge(fisico);
		em.getTransaction().commit();
		em.close();
		System.out.println(fisico);
		JOptionPane
				.showMessageDialog(null, "Físico alterado(a) com sucesso!!!");
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public Fisicos buscar(String a, String b) {

		String ABFM;
		Long codigo;
		String nome;
		String sigla;
		String senha;

		Query query = em
				.createQuery(" select a from Fisicos a where a.ABFM = :ABFM");

		query.setParameter("ABFM", a);
		List<Fisicos> Fisicos = query.getResultList();

		for (Fisicos fisico : Fisicos) {

			codigo = fisico.getCodigo();
			ABFM = fisico.getABFM();
			nome = fisico.getnome();
			sigla = fisico.getSigla();
		}

		return !Fisicos.isEmpty() ? Fisicos.get(0) : new Fisicos();

	}

	@SuppressWarnings("unchecked")
	public List<Fisicos> buscaTodos(String a, String b) {
		Query query = em.createQuery("select a from Fisicos a");
		List<Fisicos> result = query.getResultList();
		return result;
	}

}
