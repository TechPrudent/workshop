package com.thoughtworks.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.thoughtworks.domain.Dish;
import com.thoughtworks.domain.Rating;
import com.thoughtworks.domain.Restaurant;
import com.thoughtworks.domain.UserRating;

@Service
public class RestaurantService {

//	private final String[] ratingArr = new String[] { "NORATING", "WORST", "WORSE", "POOR", "GOOD", "BEST" };

	static Map<Integer, Restaurant> map = null;
	static {
		map = new HashMap<>();
		map.put(1, new Restaurant(1, "res1", Arrays.asList(new Dish("dish1", 1, 10), new Dish("dish2", 2, 20)),
				new ArrayList<>()));
		map.put(2, new Restaurant(2, "res2", Arrays.asList(new Dish("dish3", 3, 10), new Dish("dish4", 4, 20)),
				new ArrayList<>()));
	}

	public List<Restaurant> getRestaurants() {
		return map.entrySet().stream().map(m -> m.getValue()).collect(Collectors.toList());
	}

	public Restaurant getRestaurantById(int id) {
		return map.get(id);
	}

	public Restaurant rateRestaurant(UserRating userRating) {
		Restaurant res = getRestaurantById(userRating.getId());
		res.getRatings().add(getRating(userRating));
		return res;
	}

	private Rating getRating(UserRating userRating) {
		return new Rating(userRating.getRating(), userRating.getUserType());
	}

}
