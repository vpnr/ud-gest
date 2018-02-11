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
public class UserController {

	@Autowired
	IBusinessUser buUser;
	
	@RequestMapping(value="/ud-gest/admin/show-user-search", method=RequestMethod.GET)
	public String showUserSearch(Model model) {
		model.addAttribute("users", buUser.getAllUser());
		return "user-search";
	}
	
	@RequestMapping(value="/ud-gest/admin/show-user-form", method=RequestMethod.GET)
	public String showUserFormAdd(Model model) {
		try {
			model.addAttribute("user", new User());
			model.addAttribute("roles", buUser.getAllRole());
			return "user-form-add";
		} catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/admin/show-user-form/{id}", method=RequestMethod.GET)
	public String updateUser(@PathVariable(name="id") int id, Model model) {
		try {
			model.addAttribute("user", buUser.getUserById(id));
			model.addAttribute("roles", buUser.getAllRole());
			return "user-form-update";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/admin/save-user", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, @RequestParam(name="role_id") int id, final BindingResult bindingResult,final ModelMap model) {
		try {
			buUser.saveUser(user, id);
			return "redirect:/ud-gest/admin/show-user-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/admin/update-user", method=RequestMethod.POST)
	public String updateUser(@ModelAttribute User user, @RequestParam(name="role_id") int id, final BindingResult bindingResult,final ModelMap model) {
		try {
			buUser.updateUser(user, id);
			return "redirect:/ud-gest/admin/show-user-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/admin/delete-user/{id}", method=RequestMethod.GET)
	public String deleteUser(@PathVariable(name="id") int id) {
		try {
			buUser.deleteUser(buUser.getUserById(id));
			return "redirect:/ud-gest/admin/show-user-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/admin/active-user/{id}", method=RequestMethod.GET)
	public String activeUser(@PathVariable(name="id") int id) {
		try {
			buUser.activeUser(id);
			return "redirect:/ud-gest/admin/show-user-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/ud-gest/admin/desactive-user/{id}", method=RequestMethod.GET)
	public String desactiveUser(@PathVariable(name="id") int id) {
		try {
			buUser.desactiveUser(id);
			return "redirect:/ud-gest/admin/show-user-search";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
