package fr.fo.ud.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.fo.ud.data.api.IDaoMandat;
import fr.fo.ud.entity.Mandat;

@Repository
@Transactional
public class DaoMandatImpl implements IDaoMandat{

    @PersistenceContext
    private EntityManager em;
    
    public Mandat add(Mandat mandat) {
        em.persist(mandat);
        return mandat;
    }

    public Mandat update(Mandat mandat) {
        em.merge(mandat);
        return mandat;
    }

    public Mandat delete(Mandat mandat) {
        em.remove(mandat);
        return mandat;
    }

    public Mandat findById(Integer paramId) {
        Query q = em.createQuery("select f from Fonction f where f.id =:pId order by f.libelle");
        q.setParameter("pId", paramId);
        return (Mandat) q.getSingleResult();
    }

    public List<Mandat> findAll() {
        Query q = em.createQuery("select f from Fonction f order by f.libelle");
        return q.getResultList();
    }

    public List<Mandat> findByMotCle(String paramMotCle) {
        Query q = em.createQuery("select f from Fonction f where f.libelle =:pLibelle order by f.libelle");
        q.setParameter("pLibelle", paramMotCle);
        return q.getResultList();
    }

}
