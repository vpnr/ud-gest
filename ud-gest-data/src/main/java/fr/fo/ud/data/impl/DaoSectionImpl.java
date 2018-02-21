package fr.fo.ud.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.fo.ud.data.api.IDaoSection;
import fr.fo.ud.entity.Section;

@Repository
@Transactional
public class DaoSectionImpl implements IDaoSection{

    @PersistenceContext
    private EntityManager em;

    public Section add(Section paramSection) {
        em.persist(paramSection);
        return paramSection;
    }

    public Section update(Section paramSection) {
        em.merge(paramSection);
        return paramSection;
    }

    public Section delete(Section paramSection) {
        em.remove(paramSection);
        return paramSection;
    }

    public Section findById(Integer paramId) {
        return em.createQuery("select s from Section s where s.id =:pId", Section.class).setParameter("pId", paramId).getSingleResult();
    }

    public List<Section> findAll() {
        return em.createQuery("select s from Section s", Section.class).getResultList();
    }

    public List<Section> findByMotCle(String paramMotCle) {
        return em.createQuery("select s from Section s left join fetch s.adherents where s.libelle like :pLibelle", Section.class).setParameter("pLibelle", "%"+paramMotCle+"%").getResultList();
    }

	@Override
	public List<String> findAllLibelles() {
		return em.createQuery("select s.libelle from Section s order by s.libelle", String.class).getResultList();
	}
    
}
