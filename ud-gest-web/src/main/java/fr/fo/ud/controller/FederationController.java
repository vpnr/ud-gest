package fr.fo.ud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fo.ud.business.api.IBusinessFederation;
import fr.fo.ud.business.api.IBusinessSyndicat;
import fr.fo.ud.entity.Federation;
import fr.fo.ud.entity.Syndicat;

@Controller
public class FederationController {

	@Autowired
	IBusinessFederation buFederation;
	
	@Autowired
	IBusinessSyndicat buSyndicat;
	
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
	public String saveFederation(@ModelAttribute("federation") @Valid Federation federation, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "federation-form";
		}
		try {
			buFederation.add(federation);
		} catch (Exception e) {
			return "error";
		}
		return "redirect:/ud-gest/show-federation-search";
	}
	
	@RequestMapping(value="/ud-gest/update-federation", method=RequestMethod.POST)
	public String updateEntreprise(@ModelAttribute Federation federation, final BindingResult bindingResult, final ModelMap model) {
		try {
			buFederation.update(federation);
			return "redirect:/ud-gest/show-federation-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/delete-federation", method=RequestMethod.POST)
	public String removeFederation(@RequestParam(name="id") int id) {
		try {
			buFederation.delete(id);
			return "redirect:/ud-gest/show-federation-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/remove-syndicat-from-federation", method=RequestMethod.POST)
	public String removeSyndicatFromFederation(@RequestParam(name="id") int id) {
		try {
			Syndicat syndicat = buSyndicat.getById(id);
			int idFederation = syndicat.getFederation().getId();
			syndicat.setFederation(null);
			buSyndicat.update(syndicat);
			return "redirect:/ud-gest/show-federation-detail/" + idFederation;
		} catch (Exception e) {
			return "error";
		}
	}
	
}
