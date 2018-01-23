package fr.fo.ud.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fr.fo.ud.entity.Personne;
import fr.fo.ud.repository.api.IPersonneRepository;

@Component
public class PersonneRepository implements IPersonneRepository {

	@Autowired
	EntityManager em;
	
	@Override
	public List<Personne> findAll() {
		return null;
	}

	@Override
	public Personne findById(int id) {
		return null;
//		return em.createQuery("aa", Personne.class).getSingleResult();
	}

	@Override
	public void save(Personne p) {
//		em.persist(p);
	}

	@Override
	public void delete(Personne p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Personne findByNom(String nom) {
		em.getTransaction().begin();
		Personne p = new Personne();
		p = em.createQuery("from personne where nom = :nom", Personne.class).getSingleResult();
		em.close();
		return p;
	}
	
	

	
}
