package fr.fo.ud.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.fo.ud.data.api.IDaoAdherent;
import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Entreprise;
import fr.fo.ud.entity.Mandat;
import fr.fo.ud.entity.Formation;
import fr.fo.ud.entity.Syndicat;

@Repository
@Transactional
public class DaoAdherentImpl implements IDaoAdherent {

	@PersistenceContext
	private EntityManager em;
	
	@Override
    public Adherent add(Adherent paramAdh) {
       em.persist(paramAdh);
       return paramAdh; 
    }

    @Override
	public Adherent update(Adherent paramAdh) {
		Adherent adh = null;
		return null;
	}

	@Override
	public Adherent delete(Adherent paramAdh) {
		em.remove(paramAdh);
		return paramAdh;
	}

	@Override
	public List<Adherent> findAll() {
		return em.createQuery("select a from Adherent a", Adherent.class).getResultList();
	}
	
	public Adherent findById(Integer paramId) {
		return em.createQuery("select a from Adherent a where id =:pId", Adherent.class).setParameter("pId", paramId).getSingleResult();
	}
	
	@Override
	public List<Adherent> findByNom(String paramNom) {
		List<Adherent> adherents = null;
		Query q = em.createQuery("select a from Adherent a where nom =:pNom", Adherent.class);
		q.setParameter("pNom", paramNom);
		adherents = q.getResultList();
		return adherents;
	}

	@Override
	public List<Adherent> findByMotCle(String paramMotCle) {
		return em.createQuery("select distinct a from Adherent a "
				+ "left join a.syndicat.sections s "
				+ "left join a.syndicat.federation.branches b where a.nom like :nom or "
				+ "a.prenom like :prenom or "
				+ "a.entreprise.libelle like :entreprise or "
				+ "a.syndicat.libelle like :syndicat or "
				+ "s.libelle like :section or "
				+ "a.syndicat.federation.libelle like :federation or "
				+ "b.libelle like :branche"
				,Adherent.class)
				.setParameter("nom", "%" + paramMotCle + "%")
				.setParameter("prenom", "%" + paramMotCle + "%")
				.setParameter("entreprise", "%" + paramMotCle + "%")
				.setParameter("syndicat", "%" + paramMotCle + "%")
				.setParameter("section", "%" + paramMotCle + "%")
				.setParameter("federation", "%" + paramMotCle + "%")
				.setParameter("branche", "%" + paramMotCle + "%")
				.getResultList();
	}

	@Override
	public List<Adherent> findByVille(String ville) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adherent> findByCodePostal(String codePostal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adherent> findByEntreprise(Entreprise entreprise) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adherent> findBySyndicat(Syndicat syndicat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adherent> findByFormation(Formation formation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adherent> findByMandat(Mandat mandat) {
		// TODO Auto-generated method stub
		return null;
	}


}
