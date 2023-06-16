package ua.lviv.iot.tripadvisor.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.tripadvisor.dal.FeedbackRepository;
import ua.lviv.iot.tripadvisor.domain.Restaurant;
import ua.lviv.iot.tripadvisor.domain.Feedback;
import ua.lviv.iot.tripadvisor.domain.User;

@Service
public class FeedbackService extends AbstractService<Feedback> {

	private final UserService userService;
	private final RestaurantService restaurantService;

	@Autowired
	public FeedbackService(FeedbackRepository feedbackRepository, UserService userService,
						   RestaurantService restaurantService) {
		super(feedbackRepository);
		this.userService = userService;
		this.restaurantService = restaurantService;
	}

	public Feedback mapCsvToObject(String[] objectCsv) {
		User author = userService.getById(Integer.parseInt(objectCsv[1]));
		Restaurant restaurant = restaurantService.getById(Integer.parseInt(objectCsv[2]));
		Float rating = Float.valueOf(objectCsv[3]);
		String review = objectCsv[4];
		String status = objectCsv[5];
		LocalDate dateOfPublishing = LocalDate.parse(objectCsv[6]);

		return new Feedback(author, restaurant, rating, review, status, dateOfPublishing);
	}
}
