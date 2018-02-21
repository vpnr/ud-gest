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

import fr.fo.ud.business.api.IBusinessBranche;
import fr.fo.ud.business.api.IBusinessEntreprise;
import fr.fo.ud.business.api.IBusinessEvent;
import fr.fo.ud.business.api.IBusinessFederation;
import fr.fo.ud.business.api.IBusinessSection;
import fr.fo.ud.business.api.IBusinessSyndicat;
import fr.fo.ud.business.api.IBusinessUd;
import fr.fo.ud.entity.Event;

@Controller
public class IndexController {
	
	@Autowired
	private IBusinessEvent buEvent;
	
	@Autowired
	private IBusinessBranche buBranche;
	
	@Autowired
	private IBusinessEntreprise buEntreprise;
	
	@Autowired
	private IBusinessFederation buFederation;
	
	@Autowired
	private IBusinessSection buSection;
	
	@Autowired
	private IBusinessSyndicat buSyndicat;
	
	@Autowired
	private IBusinessUd buUd;
	
	@RequestMapping(value="/ud-gest/show-index", method=RequestMethod.GET)
	public String showIndex(Model model) {
		model.addAttribute("branches", buBranche.getAllLibellesBranche());
		model.addAttribute("entreprises", buEntreprise.getAllLibelles());
		model.addAttribute("federations", buFederation.getAllLibelles());
		model.addAttribute("sections", buSection.getAllLibelles());
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
