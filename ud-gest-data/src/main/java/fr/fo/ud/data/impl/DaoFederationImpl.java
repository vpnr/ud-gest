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
    	return em.createQuery("select f from Federation f order by f.libelle", Federation.class).getResultList();
    }

    public Federation findById(Integer paramId) {
    	return em.createQuery("select f from Federation f where f.id =:pId", Federation.class).setParameter("pId", paramId).getSingleResult();
    }

    public List<Federation> findByMotCle(String paramMotCle) {
    	return em.createQuery("select f from Federation f where f.libelle like :pLibelle", Federation.class).setParameter("pLibelle", paramMotCle + "%").getResultList();
    }
    
}
