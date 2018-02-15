package fr.fo.ud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.fo.ud.business.api.IBusinessFederation;
import fr.fo.ud.entity.Federation;

@Controller
public class FederationController {

	@Autowired
	IBusinessFederation buFederation;
	
	@RequestMapping(value="/ud-gest/show-federation-search", method=RequestMethod.GET)
	public String showFederationSearch(Model model) {
			model.addAttribute("federations", buFederation.getAll());
			return "federation-search";
	}
	
	@RequestMapping(value="/ud-gest/show-federation-form", method=RequestMethod.GET)
	public String showFederationForm(Model model) {
			model.addAttribute("federation", new Federation());
			return "federation-form";
	}
	
	@RequestMapping(value="/ud-gest/show-federation-detail/{id}", method=RequestMethod.GET)
	public String showFederationDetail(@PathVariable(name="id") int id, Model model) {
		try {
			model.addAttribute("federation", buFederation.getById(id));
			return "federation-detail";
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/save-federation", method=RequestMethod.POST)
	public String saveFederation(@ModelAttribute Federation federation) {
		try {
			buFederation.add(federation);
		} catch (Exception e) {
			return "error";
		}
		
		return "redirect:/ud-gest/show-federation-search";
	}
}
