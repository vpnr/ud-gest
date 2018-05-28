package fr.fo.ud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

import fr.fo.ud.business.api.IBusinessAdherent;
import fr.fo.ud.business.api.IBusinessEntreprise;
import fr.fo.ud.business.api.IBusinessFederation;
import fr.fo.ud.business.api.IBusinessSyndicat;
import fr.fo.ud.business.api.IBusinessUd;
import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Entreprise;
import fr.fo.ud.entity.Federation;
import fr.fo.ud.entity.Syndicat;
import fr.fo.ud.entity.UnionDepartemental;

@Controller
public class AdherentController {

	@Autowired
	IBusinessAdherent buAdherent;
	
	@Autowired
	IBusinessEntreprise buEntreprise;
	
	@Autowired
	IBusinessSyndicat buSyndicat;
	
	@Autowired
	IBusinessFederation buFederation;
	
	@Autowired
	IBusinessUd buUd;
	
	@RequestMapping(value="/ud-gest/show-adherent-search", method=RequestMethod.GET)
	public String allAdherent(Model model) {
		try {
			List<Adherent> adherents = buAdherent.getAll();
			model.addAttribute("adherents", adherents);
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			System.out.println(auth.getName());
			return "adherent-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/search-adherent-form", method=RequestMethod.POST)
	public String searchAdherentByMotCle(@RequestParam(name="motCle") String motCle ,Model model) {
		try {
			List<Adherent> adherents = buAdherent.getByMotCle(motCle);
			model.addAttribute("adherents", adherents);
			return "adherent-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/show-adherent-detail/{id}", method=RequestMethod.GET)
	public String adherentById(Model model, @PathVariable(name="id") int id) {
		try {
			model.addAttribute("adherent", buAdherent.getById(id));
			return "adherent-detail";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/show-adherent-form", method=RequestMethod.GET)
	public String showAdherentForm(Model model) {
		model.addAttribute("adherent", new Adherent());
		model.addAttribute("entreprise", new Entreprise());
		model.addAttribute("syndicat", new Syndicat());
		model.addAttribute("uds", buUd.getAllLibelles());
		model.addAttribute("federations", buFederation.getAllLibelles());
		return "adherent-form";
	}
	
	@RequestMapping(value="/ud-gest/save-adherent", method=RequestMethod.POST)
	public String saveAdherent(@ModelAttribute Adherent adherent, final BindingResult bindingResult,final ModelMap model) {
		try {
			buAdherent.add(adherent);
			return "redirect:/ud-gest/show-adherent-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/search-entreprise-ajax", method=RequestMethod.POST)
	public @ResponseBody List<Entreprise> searchEntreprise(@RequestParam(name="motCle") String motCle) {
		List<Entreprise> entreprises = new ArrayList<>();
		for (Entreprise entreprise : buEntreprise.getByMotCle(motCle)) {
			entreprises.add(entreprise);
		}
		return entreprises;
	}
	
	@RequestMapping(value="/ud-gest/search-syndicat-ajax", method=RequestMethod.POST)
	public @ResponseBody List<Syndicat> searchSyndicat(@RequestParam(name="motCle") String motCle) {
		List<Syndicat> syndicats = new ArrayList<>();
		for (Syndicat syndicat : buSyndicat.getByMotCle(motCle)) {
			syndicats.add(syndicat);
		}
		return syndicats;
	}
	
	@RequestMapping(value="/ud-gest/search-federation-ajax", method=RequestMethod.POST)
	public @ResponseBody List<Federation> searchFederation(@RequestParam(name="motCle") String motCle) {
		List<Federation> federations = new ArrayList<>();
		for (Federation federation : buFederation.getByMotCle(motCle)) {
			federations.add(federation);
		}
		return federations;
	}
	
	@RequestMapping(value="/ud-gest/search-ud-ajax", method=RequestMethod.POST)
	public @ResponseBody List<UnionDepartemental> searchUd(@RequestParam(name="motCle") String motCle) {
		List<UnionDepartemental> uds = new ArrayList<>();
		for (UnionDepartemental ud : buUd.getByMotCle(motCle)) {
			uds.add(ud);
		}
		return uds;
	}
	
}
