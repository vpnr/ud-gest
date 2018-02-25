package fr.fo.ud.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fo.ud.business.api.IBusinessEvent;
import fr.fo.ud.data.api.IDaoEvent;
import fr.fo.ud.entity.Event;

@Service
public class BusinessEventImpl implements IBusinessEvent{

	@Autowired
	IDaoEvent daoEvent;
	
	@Override
	public Event add(Event event) {
		daoEvent.add(event);
		return event;
	}

	@Override
	public Event update(Event event) {
		daoEvent.add(event);
		return null;
	}

	@Override
	public Event delete(Event event) {
		daoEvent.delete(event);
		return event;
	}

	@Override
	public List<Event> getAll() {
		return daoEvent.findAll();
	}

	@Override
	public Event getById(int id) {
//		return daoEvent.findById(id);
		return null;
	}

}
