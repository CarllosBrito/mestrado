package com.mestrado.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import com.mestrado.model.Medicos;

public class MedicoDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mestradoPU");
	private EntityManager em = emf.createEntityManager();
	
	Medicos medico = new Medicos();
	
	
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
	
	
	@SuppressWarnings("unused")
	public void alterar(Medicos medico){
		Medicos original = new Medicos();
		
		original = em.find(Medicos.class, medico.getCodigo());
		
		em.getTransaction().begin();
		em.merge(medico);
		em.getTransaction().commit();
		em.close();
		System.out.println(medico);
		JOptionPane.showMessageDialog(null, "Físico alterado(a) com sucesso!!!");		
		
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	public Medicos buscar(String a, String b){
		Long codigo;
		String nome;
		String crm;
		String sigla;
		
		Query query = em.createQuery (" select a from Medicos a where a.CRM = :crm");
		query.setParameter("crm", a);
		
		List <Medicos > Medicos = query.getResultList();
		
		for(Medicos medico: Medicos){
			
			codigo = medico.getCodigo();
			nome = medico.getNome();
			crm = medico.getCRM();
			sigla = medico.getSigla();	
		}
		return !Medicos.isEmpty() ? Medicos.get(0) : new Medicos();
	}
	
	@SuppressWarnings("unchecked")
	public List<Medicos> buscaTodos(String a, String b){
		Query query = em.createQuery("select a from Medicos a");
		List<Medicos> result = query.getResultList();
		return result;
	}
	
}
