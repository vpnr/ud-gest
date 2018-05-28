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

    public Mandat findById(Integer id) {
        return em.createQuery("select m from Mandat m where m.id =:id", Mandat.class).setParameter("id", id).getSingleResult();
    }

    public List<Mandat> findAll() {
        return em.createQuery("select m from Mandat m order by m.libelle", Mandat.class).getResultList();
    }

    public List<Mandat> findByMotCle(String motCle) {
        return em.createQuery("select m from Mandat m where m.libelle =:libelle order by m.libelle", Mandat.class).setParameter("motCle", motCle).getResultList();
    }

}
