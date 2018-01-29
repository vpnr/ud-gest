package fr.fo.ud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.fo.ud.business.api.IBusinessFederation;

@Controller
public class FederationController {

	@Autowired
	IBusinessFederation buFederation;
	
	@RequestMapping(value="/show-federation-search", method=RequestMethod.GET)
	public String showFederationSearch(Model model) {
		try {
			model.addAttribute("federations", buFederation.getAll());
			return "federation-search";
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value="/show-federation-detail/{id}", method=RequestMethod.GET)
	public String showFederationDetail(@PathVariable(name="id") int id, Model model) {
		try {
			model.addAttribute("federation", buFederation.getById(id));
			return "federation-detail";
		} catch (Exception e) {
			return "error";
		}
	}
}
