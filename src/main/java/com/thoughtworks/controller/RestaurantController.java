package com.thoughtworks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.domain.rating.UserRating;
import com.thoughtworks.domain.rating.restaurant.Restaurant;
import com.thoughtworks.exceptions.RatingNotBoundException;
import com.thoughtworks.service.RestaurantService;

@RestController
public class RestaurantController {

	private RestaurantService res;

	@Autowired
	public RestaurantController(RestaurantService res) {
		super();
		this.res = res;
	}

	@GetMapping("/restaurant")
	public Restaurant getRestaurant(@RequestParam int id) {
		return this.res.getRestaurantById(id);
	}

	@GetMapping("/restaurants")
	public List<Restaurant> getRestaurants() {
		return this.res.getRestaurants();
	}

	@PostMapping("/restaurant/rate")
	public Restaurant rateRestaurant(@RequestHeader String userId, @RequestBody UserRating userRating) {

		if (userRating == null || userRating.getRating() < 1 || userRating.getRating() > 5) {
			throw new RatingNotBoundException("Rating should be between 1 to 5 (both inclusive)");
		}
		userRating.setUserId(userId);
		return this.res.rateRestaurant(userRating);
	}

}
