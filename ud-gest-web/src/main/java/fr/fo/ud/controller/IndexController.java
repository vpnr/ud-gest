package fr.fo.ud.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.fo.ud.business.api.IBusinessEntreprise;
import fr.fo.ud.business.api.IBusinessEvent;
import fr.fo.ud.business.api.IBusinessFederation;
import fr.fo.ud.business.api.IBusinessSyndicat;
import fr.fo.ud.business.api.IBusinessUd;
import fr.fo.ud.entity.Event;

@Controller
public class IndexController {
	
	private static final int ID_FORM_ENTREPRISE = 2;
	
	private static final int ID_FORM_FEDERATION = 3;
	
	private static final int ID_FORM_SYNDICAT = 4;
	
	private static final int ID_FORM_UD = 5;
	
	
	@Autowired
	private IBusinessEvent buEvent;
	
	@Autowired
	private IBusinessEntreprise buEntreprise;
	
	@Autowired
	private IBusinessFederation buFederation;
	
	@Autowired
	private IBusinessSyndicat buSyndicat;
	
	@Autowired
	private IBusinessUd buUd;
	
	@RequestMapping(value="/ud-gest/show-index", method=RequestMethod.GET)
	public String showIndex(Model model) {
		model.addAttribute("entreprises", buEntreprise.getAllLibelles());
		model.addAttribute("federations", buFederation.getAllLibelles());
		model.addAttribute("syndicats", buSyndicat.getAllLibelles());
		model.addAttribute("uds", buUd.getAllLibelles());
		return "index";
	}
	
	@RequestMapping(value="/ud-gest/fill-calendar", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Event> fillCalendar() {
		List<Event> events = buEvent.getAll();
		return events;
	}
	
	@RequestMapping(value="/ud-gest/add-event", method=RequestMethod.POST)
	public String addEvent(@RequestParam(name="title") String title,
						   @RequestParam(name="start") @DateTimeFormat(pattern="yyyy-MM-dd") Date start,
						   @RequestParam(name="end", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date end,
						   @RequestParam(name="description", required=false) String description,
						   @RequestParam(name="organisation") int organisation,
						   @RequestParam(name="branche", required=false) String branche,
						   @RequestParam(name="entreprise", required=false) String entreprise,
						   @RequestParam(name="federation", required=false) String federation,
						   @RequestParam(name="syndicat", required=false) String syndicat,
						   @RequestParam(name="ud", required=false) String ud) {
		
		Event event = new Event();
		event.setTitle(title);
		Calendar c = Calendar.getInstance();
		if (end == null) {
			c.setTime(start);
			c.add(Calendar.DATE, 1);
			event.setStart(c.getTime());
			c.add(Calendar.DATE, 1);
			event.setEnd(c.getTime());
		}
		else {
			c.setTime(start);
			c.add(Calendar.DATE, 1);
			event.setStart(c.getTime());
			c.setTime(end);
			c.add(Calendar.DATE, 2);
			event.setEnd(c.getTime());
		}
		event.setDescription(description);
		
		if (organisation == ID_FORM_ENTREPRISE) {
			event.setEntreprise(buEntreprise.getByLibelle(entreprise));
		}
		if (organisation == ID_FORM_FEDERATION) {
			event.setFederation(buFederation.getByLibelle(federation));
		}
		if (organisation == ID_FORM_SYNDICAT) {
			event.setSyndicat(buSyndicat.getByLibelle(syndicat));
		}
		if (organisation == ID_FORM_UD) {
			event.setUd(buUd.getByLibelle(ud));
		}
		buEvent.add(event);
		return "redirect:/ud-gest/show-index";
	}
	
}
