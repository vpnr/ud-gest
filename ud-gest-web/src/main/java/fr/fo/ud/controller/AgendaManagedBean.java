package fr.fo.ud.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

@ManagedBean
@ViewScoped
public class AgendaManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ScheduleModel eventModel;

	private ScheduleEvent event = new DefaultScheduleEvent();

	@PostConstruct
	public void init(){
		eventModel = new DefaultScheduleModel();
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel paramEventModel) {
		eventModel = paramEventModel;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent paramEvent) {
		event = paramEvent;
	}
	
}