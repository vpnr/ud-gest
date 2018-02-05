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
import org.springframework.web.bind.annotation.RequestParam;

import fr.fo.ud.business.api.IBusinessUser;
import fr.fo.ud.entity.User;

@Controller
public class AdministrationController {

	@Autowired
	IBusinessUser buUser;
	
	@RequestMapping(value="/admin/show-user-search", method=RequestMethod.GET)
	public String showUserSearch(Model model) {
		model.addAttribute("users", buUser.getAllUser());
		return "user-search";
	}
	
	@RequestMapping(value="/admin/show-user-form-add", method=RequestMethod.GET)
	public String showUserFormAdd(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("roles", buUser.getAllRole());
		return "user-form-add";
	}
	
	@RequestMapping(value="/admin/show-user-form-pwd/{id}", method=RequestMethod.GET)
	public String showUserFormPwd(@PathVariable(name="id") int id, Model model) {
		User user = buUser.getUserById(id);
		model.addAttribute("user", user);
		return "user-form-pwd";
	}
	
	@RequestMapping(value="/admin/save-user", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, @RequestParam(name="role_id") int id, final BindingResult bindingResult,final ModelMap model) {
		try {
			buUser.saveUser(user, id);
			return "redirect:/admin/show-user-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/admin/update-user", method=RequestMethod.POST)
	public String updateUser(@RequestParam(name="id") int id, @RequestParam(name="pwd") String pwd) {
		try {
			buUser.updateUser(id, pwd);
			return "redirect:/admin/show-user-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
