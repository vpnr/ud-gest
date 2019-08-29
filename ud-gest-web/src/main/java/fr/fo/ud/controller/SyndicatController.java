package fr.fo.ud.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.apache.commons.lang3.time.DateUtils;
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

import fr.fo.ud.business.api.IBusinessEvent;
import fr.fo.ud.business.api.IBusinessSyndicat;
import fr.fo.ud.entity.Event;
import fr.fo.ud.entity.Syndicat;

@Controller
public class SyndicatController {

	@Autowired
	IBusinessSyndicat buSyndicat;
	
	@Autowired
	IBusinessEvent buEvent;
	
	@RequestMapping(value="/ud-gest/show-syndicat-search", method=RequestMethod.GET)
	public String showSyndicatSearch(Model model) {
		try {
			model.addAttribute("syndicats", buSyndicat.getAll());
			return "syndicat-search";
			
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/show-syndicat-form", method=RequestMethod.GET)
	public String showSyndicatForm(Model model) {
		model.addAttribute("syndicat", new Syndicat());
		return "syndicat-form";
	}
	
	@RequestMapping(value="/ud-gest/show-syndicat-detail/{id}", method=RequestMethod.GET)
	public String showSyndicatDetail(@PathVariable(name="id") int id, Model model) {
		try {
			model.addAttribute("syndicat", buSyndicat.getById(id));
			return "syndicat-detail";
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/save-syndicat", method=RequestMethod.POST)
	public String saveSyndicat(@ModelAttribute("syndicat") @Valid Syndicat syndicat,
			final BindingResult bindingResult,
			@RequestParam(name="date_dernier_ag", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dateDernierAg,
			@RequestParam(name="date_prochain_ag", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dateProchainAg,
			final Model model) {
		
		if (bindingResult.hasErrors()) {
			System.out.println("error" + syndicat.getLibelle());
			return "syndicat-form";
		}
		if (buSyndicat.exist(syndicat.getLibelle()) > 0) {
			System.out.println("test");
			model.addAttribute("exist", "L'entreprise " + syndicat.getLibelle() + " existe déja." );
			return "syndicat-form";
		}
		else {
			buSyndicat.add(syndicat);
			System.out.println("test");
		}
		if (dateDernierAg != null) {
			Event event = new Event();
			event.setTitle("Assemblée Générale");
			event.setDescription("Assemblée générale de " + syndicat.getLibelle());
			event.setStart(DateUtils.addDays(dateDernierAg, 1));
			event.setEnd(DateUtils.addDays(dateDernierAg, 2));
			event.setSyndicat(syndicat);
			buEvent.add(event);
		}
		if (dateProchainAg != null) {
			Event event = new Event();
			event.setTitle("Assemblée Générale");
			event.setDescription("Assemblée générale de " + syndicat.getLibelle());
			event.setStart(dateProchainAg);
			event.setEnd(dateProchainAg);
			event.setSyndicat(syndicat);
			buEvent.add(event);
		}
		return "redirect:/ud-gest/show-syndicat-search";
	}
	
}
