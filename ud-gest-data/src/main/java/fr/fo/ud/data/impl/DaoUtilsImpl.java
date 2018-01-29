package fr.fo.ud.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.fo.ud.data.api.IDaoUtils;

@Repository
@Transactional
public class DaoUtilsImpl implements IDaoUtils {
	
	@PersistenceContext
	private EntityManager em;
	
//	@Override
//	public List<String> findKeyWords(String key) {
//		em.createQuery("select distinct a.nom, e.libelle, s.libelle from Adherent adherent, Entreprise e)");
//		return null;
//	}

}
