package fr.fo.ud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.fo.ud.business.api.IBusinessAdherent;
import fr.fo.ud.entity.Adherent;

@Controller
public class AdherentController {

	@Autowired
	IBusinessAdherent buAdherent;
	
	@RequestMapping(value="/adherent", method=RequestMethod.GET)
	public String allAdherent(Model model) {
		try {
			List<Adherent> adherents = buAdherent.getAll();
			model.addAttribute("adherents", adherents);
			return "rechercher-adherent";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/detail-adherent/{id}", method=RequestMethod.GET)
	public String adherentById(Model model, @PathVariable(name="id") int id) {
		try {
			model.addAttribute("adherent", buAdherent.getById(id));
			return "detail-adherent";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ajouter-adherent/{id}", method=RequestMethod.POST)
	public String ajouterAdherent(Model model, @PathVariable(name="id") int id) {
		
		System.out.println("Dans le controller de accueil");
		System.out.println("test hot swap");
		try {
			System.out.println(buAdherent.getById(id));
			model.addAttribute("adherent", buAdherent.getById(id));
			return "detail-adherent";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
