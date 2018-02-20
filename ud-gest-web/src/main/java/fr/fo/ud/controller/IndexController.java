package fr.fo.ud.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.fo.ud.business.api.IBusinessEvent;
import fr.fo.ud.entity.Event;

@Controller
public class IndexController {
	
	@Autowired
	IBusinessEvent buEvent;
	
	@RequestMapping(value="/ud-gest/show-index", method=RequestMethod.GET)
	public String showIndex(Model model) {
		return "index";
	}
	
	@RequestMapping(value="/ud-gest/fill-calendar", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Event> fillCalendar() {
		List<Event> events = buEvent.getAll();
		return events;
	}
	
	@RequestMapping(value="/ud-gest/add-event", method=RequestMethod.POST)
	public String addEvent(@RequestParam(name="title") String title,
						   @RequestParam(name="start") Date start,
						   @RequestParam(name="start") Date end,
						   @RequestParam(name="start") String description,
						   @RequestParam(name="organisation") String organisation,
						   @RequestParam(name="mot-cle") String motCle) {
		Event event = new Event();
		event.setTitle(title);
		event.setStart(start);
		event.setEnd(end);
		event.setDescription(description);
		return "redirect:/ud-gest/show-index";
	}
	
}
