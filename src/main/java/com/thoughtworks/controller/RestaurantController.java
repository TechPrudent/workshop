package com.thoughtworks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.domain.Restaurant;
import com.thoughtworks.domain.UserRating;
import com.thoughtworks.exceptions.RatingNotBoundException;
import com.thoughtworks.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	private RestaurantService res;

	@Autowired
	public RestaurantController(RestaurantService res) {
		super();
		this.res = res;
	}

	@PostMapping("/all")
	List<Restaurant> getRestaurants() {
		return this.res.getRestaurants();
	}

	@PostMapping("/id")
	Restaurant getRestaurant(@RequestParam int id) {
		return this.res.getRestaurantById(id);
	}

	@PostMapping("/rate")
	Restaurant rateRestaurant(@RequestBody UserRating userRating) {
		if (userRating == null || userRating.getRating() < 1 || userRating.getRating() > 5) {
			throw new RatingNotBoundException("Rating should be between 1 to 5 (both inclusive)");
		}
		return this.res.rateRestaurant(userRating);
	}

}
