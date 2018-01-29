package fr.fo.ud.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.fo.ud.data.api.IDaoFederation;
import fr.fo.ud.entity.Federation;

@Transactional
@Repository
public class DaoFederationImpl implements IDaoFederation{

    @PersistenceContext
    EntityManager em;
    
    public Federation add(Federation paramFederation) {
        em.persist(paramFederation);
        return paramFederation;
    }

    public Federation update(Federation paramFederation) {
        em.merge(paramFederation);
        return paramFederation;
    }

    public Federation delete(Federation paramFederation) {
        em.remove(paramFederation);
        return paramFederation;
    }
    
    public List<Federation> findAll() {
    	Query q = em.createQuery("select f from Federation f order by f.libelle");
    	return q.getResultList();
    }

    public Federation findById(Integer paramId) {
        Query q = em.createQuery("select f from Federation f left join fetch f.branches where f.id =:pId ");
        q.setParameter("pId", paramId);
        return (Federation) q.getSingleResult();
    }

    public List<Federation> findByMotCle(String paramMotCle) {
        Query q = em.createQuery("select f from Federation f where f.libelle like :pLibelle order by f.libelle");
        q.setParameter("pLibelle", paramMotCle + "%");
        return q.getResultList();
    }
    
}
