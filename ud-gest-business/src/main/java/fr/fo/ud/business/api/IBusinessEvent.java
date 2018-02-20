package fr.fo.ud.business.api;

import java.util.List;

import fr.fo.ud.entity.Event;

public interface IBusinessEvent {

	public Event add(Event event);
	
	public Event update(Event event);
	
	public Event delete(Event event);
	
	public List<Event> getAll();
	
	public Event getById(int id);
}
