package fr.fo.ud.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.fo.ud.data.api.IDaoUser;
import fr.fo.ud.entity.User;

@Repository
@Transactional
public class DaoUtilisateurImpl implements IDaoUser {

    @PersistenceContext
    EntityManager em;

	@Override
	public User save(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public void update(User user) {
		em.merge(user);
	}

	@Override
	public void delete(User user) {
		em.remove(user);
	}

	@Override
	public List<User> findAll() {
		return em.createQuery("select u from User u", User.class).getResultList();
	}

	@Override
	public User findById(int id) {
		return em.createQuery("select u from User u where u.id = :id", User.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public User findByPseudo(String pseudo) {
		return em.createQuery("select u from User u where u.pseudo = :pseudo", User.class).setParameter("pseudo", pseudo).getSingleResult();
	}

}
