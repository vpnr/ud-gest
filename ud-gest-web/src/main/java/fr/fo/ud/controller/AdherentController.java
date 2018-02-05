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
import fr.fo.ud.business.api.IBusinessSyndicat;
import fr.fo.ud.entity.Adherent;

@Controller
public class AdherentController {

	@Autowired
	IBusinessAdherent buAdherent;
	
	@Autowired
	IBusinessEntreprise buEntreprise;
	
	@Autowired
	IBusinessSyndicat buSyndicat;
	
	@RequestMapping(value="/show-adherent-search", method=RequestMethod.GET)
	public String allAdherent(Model model) {
		try {
//			List<Adherent> adherents = buAdherent.getAll();
//			model.addAttribute("adherents", adherents);
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			System.out.println(auth.getName());
			return "adherent-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/search-adherent-form", method=RequestMethod.POST)
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
	
	@RequestMapping(value="/show-adherent-detail/{id}", method=RequestMethod.GET)
	public String adherentById(Model model, @PathVariable(name="id") int id) {
		try {
			model.addAttribute("adherent", buAdherent.getById(id));
			return "adherent-detail";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/show-adherent-form", method=RequestMethod.GET)
	public String showAdherentForm(Model model) {
		model.addAttribute("adherent", new Adherent());
		return "adherent-form";
	}
	
	@RequestMapping(value="/save-adherent", method=RequestMethod.POST)
	public String saveAdherent(@ModelAttribute Adherent adherent, final BindingResult bindingResult,final ModelMap model) {
		try {
			System.out.println(adherent.toString());
			buAdherent.add(adherent);
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/search-adherent-ajax", method=RequestMethod.POST)
	public @ResponseBody List<String> searchAdherent(@RequestParam(name="motCle") String motCle) {
		List<String> wordsToSend = new ArrayList<>();
		for (String libelleEntreprise : buEntreprise.getAllLibelleByMotCle(motCle)) {
			wordsToSend.add(libelleEntreprise);
		}
		return wordsToSend;
	}
	
}
