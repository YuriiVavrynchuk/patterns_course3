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

import ua.lviv.iot.TripadvisorMVC.model.domain.Feedback;
import ua.lviv.iot.TripadvisorMVC.model.domain.Restaurant;
import ua.lviv.iot.TripadvisorMVC.model.domain.User;
import ua.lviv.iot.TripadvisorMVC.model.service.RestaurantService;
import ua.lviv.iot.TripadvisorMVC.model.service.FeedbackService;
import ua.lviv.iot.TripadvisorMVC.model.service.UserService;

@Controller
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@Autowired
	private UserService userService;

	@Autowired
	private RestaurantService restaurantService;

	@GetMapping("/feedbacks")
	public String getAll(Model model) {
		model.addAttribute("feedbacks", feedbackService.findAll());
		return "feedbacks";
	}

	@GetMapping("/showNewFeedbackForm")
	public String showNewFeedbackForm(Model model) {
		Feedback feedback = new Feedback();
		model.addAttribute("newFeedback", feedback);
		return "create_feedback";
	}

	@GetMapping("/showUpdateFeedbackForm/{id}")
	public String showUpdateFeedbackForm(@PathVariable("id") Integer id, Model model) {
		Feedback feedback = feedbackService.getById(id);
		model.addAttribute("newFeedback", feedback);
		return "update_feedback";
	}

	@PostMapping("/saveFeedback")
	public String saveFeedback(@ModelAttribute("newFeedback") Feedback feedback, Model model) {
		User author = userService.getById(feedback.getAuthor().getId());
		Restaurant restaurant = restaurantService.getById(feedback.getRestaurant().getId());
		feedback.setAuthor(author);
		feedback.setRestaurant(restaurant);
		feedbackService.saveToDatabase(feedback);
		return "redirect:/feedbacks";
	}

	@GetMapping("/deleteReview/{id}")
	public String deleteReview(@PathVariable("id") Integer id) {
		feedbackService.deleteById(id);
		return "redirect:/reviews";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}