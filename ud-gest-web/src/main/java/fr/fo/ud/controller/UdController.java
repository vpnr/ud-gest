package fr.fo.ud.controller;

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

import fr.fo.ud.business.api.IBusinessSyndicat;
import fr.fo.ud.business.api.IBusinessUd;
import fr.fo.ud.entity.Syndicat;
import fr.fo.ud.entity.UnionDepartemental;

@Controller
public class UdController {

	@Autowired
	IBusinessUd buUd;
	
	@Autowired
	IBusinessSyndicat buSyndicat;
	
	@RequestMapping(value="/ud-gest/show-ud-search", method=RequestMethod.GET)
	public String showUdSearch(Model model) {
		try {
			model.addAttribute("uds", buUd.getAll());
			return "ud-search";
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/show-ud-form", method=RequestMethod.GET)
	public String showEntrepriseForm(Model model) {
		model.addAttribute("ud", new UnionDepartemental());
		return "ud-form";
	}
	
	@RequestMapping(value="/ud-gest/show-ud-detail/{id}", method=RequestMethod.GET)
	public String showUdDetails(@PathVariable("id") int id, Model model) {
		try {
			model.addAttribute("ud", buUd.getById(id));
			return "ud-detail";
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/save-ud", method=RequestMethod.POST)
	public String saveEntreprise(@ModelAttribute UnionDepartemental ud, final BindingResult bindingResult, final ModelMap model) {
		try {
			buUd.add(ud);
			return "redirect:/ud-gest/show-ud-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/update-ud", method=RequestMethod.POST)
	public String updateUd(@ModelAttribute UnionDepartemental ud, final BindingResult bindingResult, final ModelMap model) {
		try {
			buUd.update(ud);
			return "redirect:/ud-gest/show-ud-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/delete-ud", method=RequestMethod.POST)
	public String removeUd(@RequestParam(name="id") int id) {
		try {
			buUd.delete(id);
			return "redirect:/ud-gest/show-ud-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/remove-syndicat-from-ud", method=RequestMethod.POST)
	public String removeSyndicatFromUd(@RequestParam(name="id") int id) {
		try {
			Syndicat syndicat = buSyndicat.getById(id);
			int idUd = syndicat.getUd().getId();
			syndicat.setUd(null);
			buSyndicat.update(syndicat);
			return "redirect:/ud-gest/show-ud-detail/" + idUd;
		} catch (Exception e) {
			return "error";
		}
	}
}
