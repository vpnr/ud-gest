package fr.fo.ud.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.fo.ud.data.api.IDaoBranche;
import fr.fo.ud.entity.Branche;
import fr.fo.ud.entity.Federation;

@Repository
@Transactional
public class DaoBrancheImpl implements IDaoBranche {

    @PersistenceContext
    private EntityManager em;
    
    public Branche add(Branche paramBranche) {
        em.persist(paramBranche);
        return paramBranche;
    }

    public Branche update(Branche paramBranche) {
        em.merge(paramBranche);
        return paramBranche;
    }

    public Branche delete(Branche paramBranche) {
        em.remove(paramBranche);
        return paramBranche;
    }

    public Branche findById(Integer paramId) {
    	return em.createQuery("select b from Branche b where b.id =:pId", Branche.class).setParameter("pId", paramId).getSingleResult();
    }

    public List<Branche> findAll() {
        return em.createQuery("select b from Branche b", Branche.class).getResultList();
    }

    public List<Branche> findByMotCle(String paramMotCle) {
    	return em.createQuery("select b from Branche b where b.libelle like :pLibelle", Branche.class).setParameter("pLibelle", paramMotCle + "%").getResultList();
    }

	@Override
	public List<String> findAllLibelles() {
		return em.createQuery("select b.libelle from Branche b order by b.libelle", String.class).getResultList();
	}

	@Override
	public Branche findByLibelle(String libelle) {
		return em.createQuery("select b.libelle from Branche b where b.libelle = :libelle", Branche.class).setParameter("libelle", libelle).getSingleResult();
	}

}
