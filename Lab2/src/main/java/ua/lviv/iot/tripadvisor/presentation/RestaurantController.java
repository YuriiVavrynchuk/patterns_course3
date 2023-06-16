package ua.lviv.iot.tripadvisor.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.tripadvisor.domain.Restaurant;
import ua.lviv.iot.tripadvisor.service.RestaurantService;

@RequestMapping("/restaurant")
@RestController
public class RestaurantController extends AbstractController<Restaurant> {

	private final RestaurantService restaurantService;

	@Autowired
	public RestaurantController(RestaurantService restaurantService) {
		super(restaurantService);
		this.restaurantService = restaurantService;
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") Integer restaurantId,
			@RequestBody Restaurant restaurant) {
		restaurant.setId(restaurantId);
		Restaurant updatedRestaurant = restaurantService.update(restaurantId, restaurant, new Restaurant());
		if (updatedRestaurant != null) {
			return new ResponseEntity<Restaurant>(updatedRestaurant, HttpStatus.OK);
		} else {
			return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
		}
	}
}
