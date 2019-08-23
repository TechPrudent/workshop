package com.thoughtworks.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.thoughtworks.domain.rating.Rating;
import com.thoughtworks.domain.rating.UserRating;
import com.thoughtworks.domain.rating.restaurant.Dish;
import com.thoughtworks.domain.rating.restaurant.Restaurant;
import com.thoughtworks.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	public static Map<Integer, Restaurant> map = null;
	static {
		map = new HashMap<>();
		map.put(1, new Restaurant(1, "res1", Arrays.asList(new Dish(1, "dish1", 20, "veg")), new ArrayList<>()));
		map.put(2, new Restaurant(2, "res2", Arrays.asList(new Dish(2, "dish2", 80, "veg"),
				new Dish(10, "dish10", 45, "veg"), new Dish(9, "dish9", 100, "veg")), new ArrayList<>()));
		map.put(3,
				new Restaurant(
						3, "res3", Arrays.asList(new Dish(3, "dish3", 45, "non veg"),
								new Dish(5, "dish5", 85, "non veg"), new Dish(6, "dish6", 25, "non veg")),
						new ArrayList<>()));

	}

	private Rating getRating(UserRating userRating) {
		return new Rating(userRating.getRating(), userRating.getUserType());
	}

	@Override
	public Restaurant getRestaurantById(int id) {
		return map.get(id);
	}

	@Override
	public List<Restaurant> getRestaurants() {
		return map.entrySet().stream().map(m -> m.getValue()).collect(Collectors.toList());
	}

	@Override
	public Restaurant rateRestaurant(UserRating userRating) {
		Restaurant res = getRestaurantById(userRating.getId());
		res.getRatings().add(getRating(userRating));
		return res;
	}

}
