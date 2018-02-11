package fr.fo.ud.data.api;

import java.util.List;

import fr.fo.ud.entity.Event;

public interface IdaoEvent {

	public Event add(Event event);
	
	public void delete(Event event);
	
	public List<Event> findAll();
	
	
}
