package ua.lviv.iot.tripadvisor.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.jeasy.random.EasyRandom;

import com.opencsv.CSVWriter;

import ua.lviv.iot.tripadvisor.domain.Address;
import ua.lviv.iot.tripadvisor.domain.Restaurant;
import ua.lviv.iot.tripadvisor.domain.Feedback;
import ua.lviv.iot.tripadvisor.domain.User;

public class CsvGenerator {

	public static void main(String[] args) throws IOException {
		List<String[]> data = new LinkedList<>();

		generateAddressData(data);
		generateUserData(data);
		generateRestaurantData(data);
		generateFeedbackData(data);

		try (CSVWriter writer = new CSVWriter(new FileWriter("data.csv"))) {
			writer.writeAll(data);
		}
	}

	private static void generateAddressData(List<String[]> data) {
		EasyRandom generator = new EasyRandom();
		List<Address> addresses = generator.objects(Address.class, 200).collect(Collectors.toList());

		for (Address address : addresses) {
			data.add(address.toCsvFormat());
		}
	}

	private static void generateUserData(List<String[]> data) {
		EasyRandom generator = new EasyRandom();
		List<User> users = generator.objects(User.class, 200).collect(Collectors.toList());

		for (User user : users) {
			Integer addressId = Math.abs(user.getAddress().getId() % 200);
			if (addressId == 0) addressId++;
			
			user.getAddress().setId(addressId);
			data.add(user.toCsvFormat());
		}
	}

	private static void generateRestaurantData(List<String[]> data) {
		EasyRandom generator = new EasyRandom();
		List<Restaurant> restaurants = generator.objects(Restaurant.class, 200).collect(Collectors.toList());

		for (Restaurant restaurant : restaurants) {
			Integer addressId = Math.abs(restaurant.getAddress().getId() % 200);
			Integer ownerId = Math.abs(restaurant.getOwner().getId() % 200);
			if (addressId == 0) addressId++;
			if (ownerId == 0) ownerId++;
			
			restaurant.getAddress().setId(addressId);
			restaurant.getOwner().setId(ownerId);
			
			data.add(restaurant.toCsvFormat());
		}
	}

	private static void generateFeedbackData(List<String[]> data) {
		EasyRandom generator = new EasyRandom();
		List<Feedback> feedbacks = generator.objects(Feedback.class, 200).collect(Collectors.toList());

		for (Feedback feedback : feedbacks) {
			Integer authorId = Math.abs(feedback.getAuthor().getId() % 200);
			Integer restaurantId = Math.abs(feedback.getRestaurant().getId() % 200);
			if (authorId == 0) authorId++;
			if (restaurantId == 0) restaurantId++;
			
			feedback.getAuthor().setId(authorId);
			feedback.getRestaurant().setId(restaurantId);
			
			data.add(feedback.toCsvFormat());
		}
	}
}
