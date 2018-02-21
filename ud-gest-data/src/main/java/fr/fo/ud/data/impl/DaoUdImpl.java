package fr.fo.ud.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.fo.ud.data.api.IDaoUd;
import fr.fo.ud.entity.UnionDepartemental;

@Repository
@Transactional
public class DaoUdImpl implements IDaoUd {

    @PersistenceContext
    EntityManager em;
    
    public UnionDepartemental add(UnionDepartemental paramUd) {
        em.persist(paramUd);
        return paramUd;
    }

    public UnionDepartemental update(UnionDepartemental paramUd) {
        em.merge(paramUd);
        return paramUd;
    }

    public UnionDepartemental delete(UnionDepartemental paramUd) {
        em.remove(paramUd);
        return paramUd;
    }

    public List<UnionDepartemental> findAll() {
        return em.createQuery("select u from UnionDepartemental u", UnionDepartemental.class).getResultList();
    }

    public UnionDepartemental findById(Integer paramId) {
    	return em.createQuery("select u from UnionDepartemental u where u.id =:pId", UnionDepartemental.class).setParameter("pId", paramId).getSingleResult();
    }

    public List<UnionDepartemental> findByMotCle(String paramMotCle) {
        Query q = em.createQuery("select u from UnionDepartemental u where u.libelle like :pLibelle or u.ville.libelle like :pVille order by u.libelle");
        q.setParameter("pLibelle", paramMotCle + "%");
        q.setParameter("pVille", paramMotCle + "%");
        return q.getResultList();
    }

	@Override
	public List<String> findAllLibelles() {
		return em.createQuery("select u.libelle from UnionDepartemental u order by u.libelle", String.class).getResultList();
	}
    
}
