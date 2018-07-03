package fr.fo.ud.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fo.ud.business.api.IBusinessAdherent;
import fr.fo.ud.business.api.IBusinessEntreprise;
import fr.fo.ud.business.api.IBusinessEvent;
import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Entreprise;
import fr.fo.ud.entity.Event;

@Controller
public class EntrepriseController {

	@Autowired
	private IBusinessEntreprise buEntreprise;
	
	@Autowired
	private IBusinessAdherent buAdherent;
	
	@Autowired
	private IBusinessEvent buEvent;
	
	@RequestMapping(value="/ud-gest/show-entreprise-search", method=RequestMethod.GET)
	public String showEntrepriseSearch(Model model) {
		try {
			model.addAttribute("entreprises", buEntreprise.getAll());
			return "entreprise-search";
			
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/show-entreprise-detail/{id}", method=RequestMethod.GET)
	public String showEntrepriseDetails(@PathVariable("id") int id, Model model) {
		try {
			model.addAttribute("entreprise", buEntreprise.getById(id));
			model.addAttribute("event", new Event());
			return "entreprise-detail";
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/show-entreprise-form", method=RequestMethod.GET)
	public String showEntrepriseForm(Model model) {
		model.addAttribute("entreprise", new Entreprise());
		return "entreprise-form";
	}
	
	@RequestMapping(value="/ud-gest/save-entreprise", method=RequestMethod.POST)
	public String saveEntreprise(@ModelAttribute("entreprise") @Valid Entreprise entreprise,  BindingResult bindingResult, @RequestParam(name="date_election", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dateElection, Model model) {
		if (bindingResult.hasErrors()) {
			return "entreprise-form";
		}
		
		try {
			if (buEntreprise.exist(entreprise.getLibelle()) > 0) {
				model.addAttribute("exist", "L'entreprise " + entreprise.getLibelle() + " existe déja." );
				return "entreprise-form";
			}
			else {
				buEntreprise.add(entreprise);
			}
			if (dateElection != null) {
				Event event = new Event();
				event.setTitle("Election");
				event.setDescription("Election de l'entreprise" + entreprise.getLibelle());
				event.setStart(dateElection);
				event.setEnd(dateElection);
				event.setEntreprise(entreprise);
				buEvent.add(event);
			}
			return "redirect:/ud-gest/show-entreprise-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/update-entreprise", method=RequestMethod.POST)
	public String updateEntreprise(@ModelAttribute("entreprise") @Valid Entreprise entreprise, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "entreprise-detail";
		}
		try {
			buEntreprise.update(entreprise);
			return "redirect:/ud-gest/show-entreprise-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/delete-entreprise", method=RequestMethod.POST)
	public String removeEntreprise(@RequestParam(name="id") int id) {
		try {
			buEntreprise.delete(id);
			return "redirect:/ud-gest/show-entreprise-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/remove-adherent-from-entreprise", method=RequestMethod.POST)
	public String removeAdherentFromEntreprise(@RequestParam(name="id") int id) {
		try {
			Adherent adherent = buAdherent.getById(id);
			int idEntreprise = adherent.getEntreprise().getId();
			adherent.setEntreprise(null);
			buAdherent.update(adherent);
			return "redirect:/ud-gest/show-entreprise-detail/" + idEntreprise;
		} catch (Exception e) {
			return "error";
		}
	}
}
