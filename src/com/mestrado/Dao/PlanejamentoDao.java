package com.mestrado.Dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.mestrado.model.Medicos;
import com.mestrado.model.Planejamento;

public class PlanejamentoDao {
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("mestradoPU");
	private EntityManager em = emf.createEntityManager();

	public void salvar(Planejamento planejamento) throws Exception {
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

		JOptionPane.showMessageDialog(null,
				"Planejamento alterado com sucesso!!!");
	}

	@SuppressWarnings("unchecked")
	public Planejamento buscaPorCodigo(Long cod){
		
		Query query = em
				.createQuery("from Planejamento where codigo = :cod");
		query.setParameter("cod", cod);
		
		List <Planejamento> plan = query.getResultList();
		
		return !plan.isEmpty() ? plan.get(0) : new Planejamento();
		
	}
	@SuppressWarnings("unchecked")
	public List<Planejamento> buscaTodos(String a, String b) {
		Query query = em
				.createQuery("select a from Planejamento a where a.status_inativo = :status_inativo OR a.status_inativo is null");
		query.setParameter("status_inativo", false);
		List<Planejamento> result = query.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Planejamento> BuscaPlanporPaciente(Long id) {

		Query query = em
				.createQuery("select a from Planejamento a left join fetch a.paciente p where p.codPaciente = :id");
		query.setParameter("id", id);
		List<Planejamento> result = query.getResultList();

		return result;

	}

	@SuppressWarnings("unchecked")
	public List<Planejamento> buscaPorData(Date dtIni, Date dtFinal) {

	
			StringBuilder cond = new StringBuilder();
			this.definirCondicoes(dtIni, dtFinal, cond);
			Query query = em.createQuery(" from Planejamento p " + cond.toString()+ " order by p.data_cad ");
			this.definirParametros(dtIni, dtFinal, query);
			List<Planejamento> result = query.getResultList();		
		
		return result;
	}

	public void definirCondicoes(Date dtIni, Date dtFinal, StringBuilder cond) {

		if (dtIni != null) {
			cond.append(cond.length() == 0 ? " where " : " and ").append(
					" p.data_cad >= :dtIni ");

		}
		if (dtFinal != null) {
			cond.append(cond.length() == 0 ? " where " : " and ").append(
					" p.data_cad <= :dtFinal ");

		}

	}

	public void definirParametros(Date dtIni, Date dtFinal, Query query) {

		if (dtIni != null) {
			query.setParameter("dtIni", dtIni);

		}
		if (dtFinal != null) {
			query.setParameter("dtFinal", dtFinal);

		}

	}

	
	@SuppressWarnings("unchecked")
	public List<Planejamento> buscaPorMedico(Date dtIni, Date dtFinal, Medicos md) {

		
		StringBuilder cond = new StringBuilder();
		this.definirCondicoesMD(dtIni, dtFinal,md, cond);
		Query query = em.createQuery(" from Planejamento a left join fetch a.medicos p " + cond.toString() + " order by a.data_cad ");
		this.definirParametrosMD(dtIni, dtFinal, md, query);
		List<Planejamento> result = query.getResultList();		
	
	return result;
}
	
	public void definirCondicoesMD(Date dtIni, Date dtFinal, Medicos md, StringBuilder cond) {

		if (dtIni != null) {
			cond.append(cond.length() == 0 ? " where " : " and ").append(
					" a.data_cad >= :dtIni ");

		}
		if (dtFinal != null) {
			cond.append(cond.length() == 0 ? " where " : " and ").append(
					" a.data_cad <= :dtFinal ");

		}
		if(md.getCRM() !=null && !md.getCRM().equals("0000")){
			
			cond.append(cond.length() == 0 ? " where " : " and ").append(
					" p.CRM = :md ");
			
		}

	}
	public void definirParametrosMD(Date dtIni, Date dtFinal,Medicos md, Query query){
		if(md == null){
			JOptionPane.showMessageDialog(null, "Favor Selecionar O médico para realizar a busca!");
			
		}else{
		if (dtIni != null) {
			query.setParameter("dtIni", dtIni);

		}
		if (dtFinal != null) {
			query.setParameter("dtFinal", dtFinal);

		}
		if (md.getCRM() !=null){
			query.setParameter("md", md.getCRM());
			
		}
		}
	}

}
