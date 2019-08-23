package com.thoughtworks.service;

import java.util.List;

import com.thoughtworks.domain.rating.UserRating;
import com.thoughtworks.domain.rating.restaurant.Restaurant;

public interface RestaurantService {

	Restaurant getRestaurantById(int id);

	List<Restaurant> getRestaurants();

	Restaurant rateRestaurant(UserRating userRating);

}
