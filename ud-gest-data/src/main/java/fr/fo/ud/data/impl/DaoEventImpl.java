package fr.fo.ud.data.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.fo.ud.data.api.IdaoEvent;
import fr.fo.ud.entity.Event;

@Repository
@Transactional
public class DaoEventImpl implements IdaoEvent {

	@PersistenceContext
	EntityManager em;

	@Override
	public Event add(Event event) {
		em.persist(event);
		return event;
	}

	@Override
	public void delete(Event event) {
		em.remove(event);
		
	}

	@Override
	public List<Event> findAll() {
		return em.createQuery("select e from Event e", Event.class).getResultList();
	}
	
	
}
