package ua.lviv.iot.TripadvisorMVC.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.TripadvisorMVC.model.dal.RestaurantRepository;
import ua.lviv.iot.TripadvisorMVC.model.domain.Restaurant;

@Service
public class RestaurantService extends AbstractService<Restaurant> {


	@Autowired
	public RestaurantService(RestaurantRepository restaurantRepository) {
		super(restaurantRepository);
	}
}
