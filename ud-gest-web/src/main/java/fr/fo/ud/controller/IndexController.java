package fr.fo.ud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping(value="/ud-gest/show-index", method=RequestMethod.GET)
	public String showIndex(Model model) {
		return "index";
	}
	
}
