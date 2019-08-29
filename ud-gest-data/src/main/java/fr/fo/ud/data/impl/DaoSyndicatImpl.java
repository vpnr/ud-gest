package fr.fo.ud.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.fo.ud.data.api.IDaoSyndicat;
import fr.fo.ud.entity.Syndicat;

@Transactional
@Repository
public class DaoSyndicatImpl implements IDaoSyndicat {

    @PersistenceContext
    private EntityManager em;
    
	public Syndicat add(Syndicat paramSyndicat) {
	    em.persist(paramSyndicat);
	    return paramSyndicat;
	}

	public Syndicat update(Syndicat paramSyndicat) {
	    em.merge(paramSyndicat);
        return paramSyndicat;
	}

	public Syndicat delete(Syndicat paramSyndicat) {
	    em.remove(paramSyndicat);
        return paramSyndicat;
	}

	public Syndicat findById(Integer paramId) {
	    return em.createQuery("select s from Syndicat s where s.id =:pId", Syndicat.class).setParameter("pId", paramId).getSingleResult();
	}

	public List<Syndicat> findByMotCle(String paramMotCle) {
	    return em.createQuery("select s from Syndicat s where s.libelle like :pLibelle order by s.libelle", Syndicat.class).setParameter("pLibelle", "%" + paramMotCle + "%").getResultList();
	}

    public List<Syndicat> findAll() {
        return em.createQuery("select s from Syndicat s order by s.libelle", Syndicat.class).getResultList();
    }

	@Override
	public List<String> findAllLibelles() {
		return em.createQuery("select s.libelle from Syndicat s order by s.libelle", String.class).getResultList();
	}

	@Override
	public Syndicat findByLibelle(String libelle) {
		return em.createQuery("select s from Syndicat s where s.libelle = :libelle", Syndicat.class).setParameter("libelle", libelle).getSingleResult();
	}

	@Override
	public Long count(String libelle) {
		return em.createQuery("select count(s) from Syndicat s where s.libelle = :libelle", Long.class).setParameter("libelle", libelle).getSingleResult();
	}

}
