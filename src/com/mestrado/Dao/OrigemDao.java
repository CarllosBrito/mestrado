package com.mestrado.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import com.mestrado.model.Origem;


public class OrigemDao {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mestradoPU");
	private EntityManager em = emf.createEntityManager();
	
	public void salvar(String descricao, String sigla)throws Exception{
		Origem OR = new Origem();
		
		OR.setDescricao(descricao);
		OR.setSigla(sigla);
		
		em.getTransaction().begin();
		em.persist(OR);
		em.getTransaction().commit();
		em.close();	
		
		JOptionPane.showMessageDialog(null, "Clinica de Origem Salva com sucesso!!!");
	}
	
	public void alterar(Origem origem){
		@SuppressWarnings("unused")
		Origem original = new Origem();
				
		original = em.find(Origem.class, origem.getCodigo());
		
		em.getTransaction().begin();
		em.merge(origem);
		em.getTransaction().commit();
		em.close();
		System.out.println(origem);
		
		JOptionPane.showMessageDialog(null, "Clinica de Origem alterada com sucesso!!!");
		
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	public Origem buscar(String a, String b) {
		Long codigo;
		String descr;
		String Sigla;
		
		Query query = em.createQuery (" select a from Origem a where a.sigla = :Sigla");
		query.setParameter("Sigla", a);
		
		List <Origem > Origem = query.getResultList();
		 	
		 for ( Origem origem : Origem ) {
			 codigo = origem.getCodigo();
			 descr = origem.getDescricao();
			 Sigla = origem.getSigla();
					 
		 }
		
		 return !Origem.isEmpty() ? Origem.get(0) : new Origem();   
    
	}
	

}
