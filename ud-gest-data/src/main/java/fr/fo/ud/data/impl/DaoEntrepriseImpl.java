package fr.fo.ud.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.fo.ud.data.api.IDaoEntreprise;
import fr.fo.ud.entity.Entreprise;

@Repository
@Transactional
public class DaoEntrepriseImpl implements IDaoEntreprise {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Entreprise add(Entreprise paramEntreprise) {
		em.persist(paramEntreprise);
		return paramEntreprise;
	}

	@Override
	public Entreprise update(Entreprise paramEntreprise) {
		em.merge(paramEntreprise);
		return paramEntreprise;
	}

	@Override
	public Entreprise delete(Entreprise paramEntreprise) {
		em.remove(paramEntreprise);
		return paramEntreprise;
	}

	@Override
	public List<Entreprise> findAll() {
		Query q = em.createQuery("select e from Entreprise e order by e.libelle");
		return q.getResultList();
	}
	
	@Override
	public Entreprise findById(Integer paramId) {
		return em.createQuery("select e from Entreprise e where e.id =:pId", Entreprise.class).setParameter("pId", paramId).getSingleResult();
	}
	
	@Override
	public Entreprise findByLibelle(String libelle) {
		em.createQuery("select e from Entreprise e where e.libelle = :libelle").setParameter("libelle", libelle).getSingleResult();
		return null;
	}

	@Override
	public List<Entreprise> findByMotCle(String paramMotCle) {
		Query q = em.createQuery("select e from Entreprise e  where e.libelle like :pLibelle order by e.libelle");
		q.setParameter("pLibelle", paramMotCle + "%");
		return q.getResultList();
	}

	@Override
	public List<String> findAllLibelleByMotCle(String motCle) {
		return em.createQuery("select libelle from Entreprise e where e.libelle like :motCle", String.class).setParameter("motCle", "%" + motCle + "%").getResultList();
	}


	

}
