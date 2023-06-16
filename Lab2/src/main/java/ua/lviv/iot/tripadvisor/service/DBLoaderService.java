package ua.lviv.iot.tripadvisor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.tripadvisor.dal.FileRepository;
import ua.lviv.iot.tripadvisor.domain.Address;
import ua.lviv.iot.tripadvisor.domain.Restaurant;
import ua.lviv.iot.tripadvisor.domain.Feedback;
import ua.lviv.iot.tripadvisor.domain.User;

@Service
public class DBLoaderService {

	@Autowired
	FileRepository repository;

	AddressService addressService;
	UserService userService;
	RestaurantService restaurantService;
	FeedbackService feedbackService;

	@Autowired
	public DBLoaderService(AddressService addressService, UserService userService,
			RestaurantService restaurantService, FeedbackService feedbackService) {
		this.addressService = addressService;
		this.userService = userService;
		this.restaurantService = restaurantService;
		this.feedbackService = feedbackService;
	}

	public void dumpCsvToDB(String filepath) {
		List<String[]> data = repository.readAll(filepath);
		data.forEach(entry -> {
			switch (entry[0]) {
				case "ADDRESS":
					Address address = addressService.mapCsvToObject(entry);
					addressService.saveToDatabase(address);
					break;
				case "USER":
					User user = userService.mapCsvToObject(entry);
					userService.saveToDatabase(user);
					break;
				case "RESTAURANT":
					Restaurant restaurant = restaurantService.mapCsvToObject(entry);
					restaurantService.saveToDatabase(restaurant);
					break;
				case "FEEDBACK":
					Feedback feedback = feedbackService.mapCsvToObject(entry);
					feedbackService.saveToDatabase(feedback);
					break;
			}
		});
	}
}
