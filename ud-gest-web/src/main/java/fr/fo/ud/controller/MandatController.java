package fr.fo.ud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.fo.ud.business.api.IBusinessMandat;

@Controller
public class MandatController {

	@Autowired
	private IBusinessMandat buMandat;
	
	@RequestMapping(value="/ud-gest/admin/show-mandat-gestion")
	public String showMandatGestion(Model model) {
		model.addAttribute("mandats", buMandat.getAll());
		return "mandat-gestion";
	}
	
}
