package fr.fo.ud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fo.ud.business.api.IBusinessMandat;
import fr.fo.ud.entity.Mandat;

@Controller
public class MandatController {

	@Autowired
	private IBusinessMandat buMandat;
	
	@RequestMapping(value="/ud-gest/admin/show-mandat-gestion", method=RequestMethod.GET)
	public String showMandatGestion(Model model) {
		model.addAttribute("mandats", buMandat.getAll());
		model.addAttribute("mandat", new Mandat());
		return "mandat-gestion";
	}
	
	@RequestMapping(value="/ud-gest/admin/save-mandat", method=RequestMethod.POST)
	public String saveMandat(@ModelAttribute("mandat") @Valid Mandat mandat, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "mandat-gestion";
		}
		buMandat.add(mandat);
		return "redirect:/ud-gest/admin/show-mandat-gestion";
	}
	
	@RequestMapping(value="/ud-gest/admin/delete-mandat", method=RequestMethod.POST)
	public String deleteMandat(@RequestParam(name="id") int id) {
		System.out.println("-----------------"+id);
		buMandat.delete(buMandat.getById(id));
		return "redirect:/ud-gest/admin/show-mandat-gestion";
	}
	
}
