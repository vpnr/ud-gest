package fr.fo.ud.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
	public String saveEntreprise(@ModelAttribute Entreprise entreprise, @RequestParam(name="date_election") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateElection, final BindingResult bindingResult, final ModelMap model) {
		try {
			Event event = new Event();
			event.setTitle("Election");
			event.setDescription("Election de l'entreprise" + entreprise.getLibelle());
			System.out.println(dateElection);
			event.setStart(dateElection);
			event.setEnd(dateElection);
			event.setEntreprise(entreprise);
			buEntreprise.add(entreprise);
			buEvent.add(event);
			return "redirect:/ud-gest/show-entreprise-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/update-entreprise", method=RequestMethod.POST)
	public String updateEntreprise(@ModelAttribute Entreprise entreprise, final BindingResult bindingResult, final ModelMap model) {
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
