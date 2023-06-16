package ua.lviv.iot.TripadvisorMVC.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ua.lviv.iot.TripadvisorMVC.model.domain.User;
import ua.lviv.iot.TripadvisorMVC.model.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String getAll(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}

	@GetMapping("/showNewUserForm")
	public String showNewUserForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "create_user";
	}

	@GetMapping("/showUpdateUserForm/{id}")
	public String showUpdateUserForm(@PathVariable("id") Integer id, Model model) {
		User user = userService.getById(id);
		model.addAttribute("user", user);
		return "update_user";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user, Model model) {
		userService.saveToDatabase(user);
		return "redirect:/users";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		userService.deleteById(id);
		return "redirect:/users";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}