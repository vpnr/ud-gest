package fr.fo.ud.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;

import fr.fo.ud.business.api.IBusinessSyndicat;
import fr.fo.ud.entity.Entreprise;
import fr.fo.ud.entity.Syndicat;

@Controller
public class SyndicatController {

	@Autowired
	IBusinessSyndicat buSyndicat;
	
	@RequestMapping(value="/show-syndicat-search", method=RequestMethod.GET)
	public String showSyndicatSearch(Model model) {
		try {
			model.addAttribute("syndicats", buSyndicat.getAll());
			return "syndicat-search";
			
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value="/search-syndicat-ajax", method=RequestMethod.POST)
	public @ResponseBody List<Syndicat> rechercherSyndicatAjax(@RequestParam(name="motCle") String motCle) {
		List<Syndicat> syndicats = new ArrayList<>();
		syndicats.addAll(buSyndicat.getByMotCle(motCle));
		return syndicats;
	}
	
	@RequestMapping(value="/show-syndicat-form", method=RequestMethod.GET)
	public String showSyndicatForm(Model model) {
		model.addAttribute("syndicat", new Syndicat());
		return "syndicat-form";
	}
	
	@RequestMapping(value="/show-syndicat-detail/{id}", method=RequestMethod.GET)
	public String showSyndicatDetail(@PathVariable(name="id") int id, Model model) {
		try {
			model.addAttribute("syndicat", buSyndicat.getById(id));
			return "syndicat-detail";
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value="/save-syndicat", method=RequestMethod.POST)
	public String saveSyndicat(@ModelAttribute Syndicat syndicat, final BindingResult bindingResult, final ModelMap model) {
		try {
			System.out.println(syndicat.toString());
			buSyndicat.add(syndicat);
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
