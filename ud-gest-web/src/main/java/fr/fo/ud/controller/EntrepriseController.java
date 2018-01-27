package fr.fo.ud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.fo.ud.business.api.IBusinessEntreprise;
import fr.fo.ud.entity.Entreprise;

@Controller
public class EntrepriseController {

	@Autowired
	IBusinessEntreprise buEntreprise;
	
	@RequestMapping(value="/search-entreprise-ajax", method=RequestMethod.POST)
	public @ResponseBody List<Entreprise> rechercherEntreprise(@RequestParam("motCle") String motCle) {
		List<Entreprise> entreprises = new ArrayList<>();
		entreprises.addAll(buEntreprise.getByMotCle(motCle));
		return entreprises;
	}
}
