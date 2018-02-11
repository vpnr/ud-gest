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

import fr.fo.ud.business.api.IBusinessSection;
import fr.fo.ud.business.api.IBusinessSyndicat;
import fr.fo.ud.entity.Section;

@Controller
public class SectionController {

	@Autowired
	private IBusinessSection buSection;
	
	@Autowired
	private IBusinessSyndicat buSyndicat;
	
	@RequestMapping(value="/ud-gest/show-section-search", method=RequestMethod.GET)
	public String showSectionSearch(Model model) {
		try {
			model.addAttribute("section", buSection.getAll());
			return "section-search";
			
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/show-section-detail/{id}", method=RequestMethod.GET)
	public String showSectionDetails(@PathVariable("id") int id, Model model) {
		try {
			model.addAttribute("section", buSection.getById(id));
			return "section-detail";
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/show-section-form", method=RequestMethod.GET)
	public String showSectionForm(Model model) {
		model.addAttribute("section", new Section());
		return "section-form";
	}
	
	@RequestMapping(value="/ud-gest/save-section", method=RequestMethod.POST)
	public String saveSection(@ModelAttribute Section section, final BindingResult bindingResult, final ModelMap model) {
		try {
			buSection.add(section);
			return "redirect:/ud-gest/show-section-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/update-section", method=RequestMethod.POST)
	public String updateSection(@ModelAttribute Section section, final BindingResult bindingResult, final ModelMap model) {
		try {
			buSection.update(section);
			return "redirect:/ud-gest/show-section-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
//	@RequestMapping(value="/ud-gest/delete-section", method=RequestMethod.POST)
//	public String removeSection(@RequestParam(name="id") int id) {
//		try {
//			buSection.delete(id);
//			return "redirect:/ud-gest/show-section-search";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "error";
//		}
//	}
//	
//	@RequestMapping(value="/ud-gest/remove-syndicat-from-section", method=RequestMethod.POST)
//	public String removeSyndicatFromSection(@RequestParam(name="id") int id) {
//		try {
//			Syndicat syndicat = buSyndicat.getById(id);
//			int idSection = syndicat.getSections().getId();
//			syndicat.setEntreprise(null);
//			buAdherent.update(adherent);
//			return "redirect:/ud-gest/show-entreprise-detail/" + idEntreprise;
//		} catch (Exception e) {
//			return "error";
//		}
//	}

}
