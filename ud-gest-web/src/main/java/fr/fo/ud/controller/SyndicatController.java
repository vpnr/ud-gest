package fr.fo.ud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.fo.ud.business.api.IBusinessSyndicat;
import fr.fo.ud.entity.Syndicat;

@Controller
public class SyndicatController {

	@Autowired
	IBusinessSyndicat buSyndicat;
	
	@RequestMapping(value="/search-syndicat-ajax", method=RequestMethod.POST)
	public @ResponseBody List<Syndicat> rechercherSyndicatAjax(@RequestParam(name="motCle") String motCle) {
		List<Syndicat> syndicats = new ArrayList<>();
		syndicats.addAll(buSyndicat.getByMotCle(motCle));
		return syndicats;
	}
	
}
