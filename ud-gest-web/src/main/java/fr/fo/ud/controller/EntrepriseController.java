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

import fr.fo.ud.business.api.IBusinessEntreprise;
import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Entreprise;

@Controller
public class EntrepriseController {

	@Autowired
	IBusinessEntreprise buEntreprise;
	
	@RequestMapping(value="/show-entreprise-search", method=RequestMethod.GET)
	public String showEntrepriseSearch(Model model) {
		try {
			model.addAttribute("entreprises", buEntreprise.getAll());
			return "entreprise-search";
			
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value="/search-entreprise-ajax", method=RequestMethod.POST)
	public @ResponseBody List<Entreprise> rechercherEntreprise(@RequestParam("motCle") String motCle) {
		List<Entreprise> entreprises = new ArrayList<>();
		entreprises.addAll(buEntreprise.getByMotCle(motCle));
		return entreprises;
	}
	
	@RequestMapping(value="/show-entreprise-detail/{id}", method=RequestMethod.GET)
	public String showEntrepriseDetails(@PathVariable("id") int id, Model model) {
		try {
			model.addAttribute("entreprise", buEntreprise.getById(id));
			return "entreprise-detail";
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value="/show-entreprise-form", method=RequestMethod.GET)
	public String showEntrepriseForm(Model model) {
		model.addAttribute("entreprise", new Entreprise());
		return "entreprise-form";
	}
	
	@RequestMapping(value="/save-entreprise", method=RequestMethod.POST)
	public String saveEntreprise(@ModelAttribute Entreprise entreprise, final BindingResult bindingResult, final ModelMap model) {
		try {
			System.out.println(entreprise.toString());
			buEntreprise.add(entreprise);
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
