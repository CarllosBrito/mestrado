package com.mestrado.Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.mestrado.model.Regiao_Anatomica;



public class Regiao_AnatomicaDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mestradoPU");
	private EntityManager em = emf.createEntityManager();
	
	
	public void salvar(String descricao){
		Regiao_Anatomica reg_anat = new Regiao_Anatomica();
				
				reg_anat.setDescricao(descricao);
				em.getTransaction().begin();
				em.persist(reg_anat);
				em.getTransaction().commit();
				em.close();
				
		}
	
	  @SuppressWarnings("unchecked")
	public Regiao_Anatomica buscar(String a, String b) {
	
		String descricao;
		Long codigo;
		
		Query query = em.createQuery (" select a from Regiao_Anatomica a where a.descricao = :descr");
		
		query.setParameter("descr", a);
		 List <Regiao_Anatomica > regioes = query . getResultList ();
		 
		 
		
		 for ( Regiao_Anatomica regiao : regioes ) {
			 
			 codigo = regiao.getCodigo();
			 descricao = regiao.getDescricao();
			 
			 System .out . println (" Código da Região: " + regiao.getCodigo());
			 System .out . println (" descrição da Região: " + regiao.getDescricao());
			
			 System .out . println ();
		 }
		
		 return !regioes.isEmpty() ? regioes.get(0) : new Regiao_Anatomica();   
    
	}
	
	

	


	public void alterar(String objAlterado){
		Regiao_Anatomica reg_anat = em.find(Regiao_Anatomica.class, objAlterado);
		
		em.getTransaction().begin();
		reg_anat.setDescricao(objAlterado);
		em.getTransaction().commit();
		em.close();
		
	}

	
	
}
