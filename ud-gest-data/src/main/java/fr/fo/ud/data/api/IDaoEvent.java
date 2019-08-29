package fr.fo.ud.data.api;

import java.util.List;

import fr.fo.ud.entity.Entreprise;
import fr.fo.ud.entity.Event;

public interface IDaoEvent {

	public Event add(Event event);
	
	public void delete(Event event);
	
	public List<Event> findAll();
	
	public List<Event> findByEntreprise(Entreprise entreprise);
	
	
}
