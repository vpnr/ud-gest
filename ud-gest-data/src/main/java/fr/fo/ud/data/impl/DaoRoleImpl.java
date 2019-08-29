package fr.fo.ud.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.fo.ud.data.api.IDaoRole;
import fr.fo.ud.entity.Role;

@Repository
@Transactional
public class DaoRoleImpl implements IDaoRole{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Role save(Role role) {
		em.persist(role);
		return role;
	}

	@Override
	public void update(Role role) {
		em.merge(role);
	}

	@Override
	public void delete(Role role) {
		em.remove(role);
	}

	@Override
	public List<Role> findAll() {
		return em.createQuery("select r from Role r", Role.class).getResultList();
	}

	@Override
	public Role findById(int id) {
		return em.createQuery("select r from Role r where r.id = :id", Role.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public Role findByRole(String role) {
		return em.createQuery("select r from Role r where r.role = :role", Role.class).setParameter("role", role).getSingleResult();
	}

}
