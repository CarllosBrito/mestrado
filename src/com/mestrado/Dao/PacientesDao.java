package com.mestrado.Dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.mestrado.model.Paciente;

public class PacientesDao {

	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("mestradoPU");
	private EntityManager em = emf.createEntityManager();

	public void salvar(String nome, String registro, Date dataNsc)
			throws Exception {
		Paciente paciente = new Paciente();

		paciente.setNomePaciente(nome);
		paciente.setregistro(registro);
		paciente.setDtNascimento(dataNsc);

		em.getTransaction().begin();
		em.persist(paciente);
		em.getTransaction().commit();
		em.close();
	}

	public void alterar(Paciente paciente) {
		@SuppressWarnings("unused")
		Paciente original = new Paciente();
		original = em.find(Paciente.class, paciente.getCodPaciente());

		em.getTransaction().begin();
		em.merge(paciente);
		em.getTransaction().commit();
		em.close();

		JOptionPane.showMessageDialog(null, "Paciente alterado com sucesso!!!");
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Paciente buscar(String a, String b) {
		Long codigo;
		String registro;
		String nome;
		Date dtNascimento;

		Query query = em
				.createQuery(" select a from Paciente a where a.registro = :codigo");
		query.setParameter("codigo", a);

		List<Paciente> Paciente = query.getResultList();

		for (Paciente paciente : Paciente) {
			codigo = paciente.getCodPaciente();
			registro = paciente.getregistro();
			nome = paciente.getNomePaciente();
			dtNascimento = paciente.getDtNascimento();
		}
		return !Paciente.isEmpty() ? Paciente.get(0) : new Paciente();
	}

	@SuppressWarnings("unchecked")
	public List<Paciente> buscaTodos(String a, String b) {
		Query query = em.createQuery("select a from Paciente a");
		List<Paciente> result = query.getResultList();
		return result;
	}
	public List<Paciente> buscaPlan(Paciente paciente) {
		Query query = em.createQuery("select a from Paciente");
		List<Paciente> result = query.getResultList();
		return result;
	}
}
