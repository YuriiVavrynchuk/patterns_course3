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

import ua.lviv.iot.TripadvisorMVC.model.domain.Restaurant;
import ua.lviv.iot.TripadvisorMVC.model.domain.User;
import ua.lviv.iot.TripadvisorMVC.model.service.RestaurantService;
import ua.lviv.iot.TripadvisorMVC.model.service.UserService;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private UserService userService;

	@GetMapping("/restaurants")
	public String getAll(Model model) {
		model.addAttribute("restaurants", restaurantService.findAll());
		return "restaurants";
	}

	@GetMapping("/showNewRestaurantForm")
	public String showNewRestaurantForm(Model model) {
		Restaurant restaurant = new Restaurant();
		model.addAttribute("restaurant", restaurant);
		return "create_restaurant";
	}

	@GetMapping("/showUpdateRestaurantForm/{id}")
	public String showUpdateRestaurantForm(@PathVariable("id") Integer id, Model model) {
		Restaurant restaurant = restaurantService.getById(id);
		model.addAttribute("restaurant", restaurant);
		return "update_restaurant";
	}

	@PostMapping("/saveRestaurant")
	public String saveRestaurant(@ModelAttribute("restaurant") Restaurant restaurant, Model model) {
		User owner = userService.getById(restaurant.getOwner().getId());
		restaurant.setOwner(owner);
		restaurantService.saveToDatabase(restaurant);
		return "redirect:/restaurants";
	}

	@GetMapping("/deleteRestaurant/{id}")
	public String deleteRestaurant(@PathVariable("id") Integer id) {
		restaurantService.deleteById(id);
		return "redirect:/restaurants";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}