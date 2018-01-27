package fr.fo.ud.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import fr.fo.ud.data.api.IDaoSyndicat;
import fr.fo.ud.entity.Syndicat;

@Component
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

	public Syndicat getById(Integer paramId) {
	    Query q = em.createQuery("select s from Syndicat s where s.id =:pId");
	    q.setParameter("pId", paramId);
	    return (Syndicat) q.getSingleResult();
	}

	public List<Syndicat> getByMotCle(String paramMotCle) {
	    Query q = em.createQuery("select s from Syndicat s where s.libelle like :pLibelle order by s.libelle");
	    q.setParameter("pLibelle", paramMotCle + "%");
	    return q.getResultList();
	}

    public List<Syndicat> getAll() {
        Query q = em.createQuery("select s from Syndicat s order by s.libelle");
        return q.getResultList();
    }


}
