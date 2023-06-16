package ua.lviv.iot.tripadvisor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.tripadvisor.dal.RestaurantRepository;
import ua.lviv.iot.tripadvisor.domain.Address;
import ua.lviv.iot.tripadvisor.domain.Restaurant;
import ua.lviv.iot.tripadvisor.domain.User;

@Service
public class RestaurantService extends AbstractService<Restaurant> {

	private final UserService userService;
	private final AddressService addressService;

	@Autowired
	public RestaurantService(RestaurantRepository restaurantRepository, UserService userService,
			AddressService addressService) {
		super(restaurantRepository);
		this.userService = userService;
		this.addressService = addressService;
	}

	@Override
	public Restaurant mapCsvToObject(String[] objectCsv) {
		String name = objectCsv[1];
		Float rating = Float.valueOf(objectCsv[2]);
		String description = objectCsv[3];
		Double lowerPrice = Double.valueOf(objectCsv[4]);
		Double topPrice = Double.valueOf(objectCsv[5]);
		String menuUrl = objectCsv[6];
		Address address = addressService.getById(Integer.parseInt(objectCsv[7]));
		User owner = userService.getById(Integer.parseInt(objectCsv[8]));

		return new Restaurant(name, rating, description, lowerPrice, topPrice, menuUrl, owner, address);
	}
}
