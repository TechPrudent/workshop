package com.thoughtworks.domain.billing;

import java.util.List;
import java.util.stream.Collectors;

import com.thoughtworks.domain.cart.Cart;
import com.thoughtworks.domain.rating.restaurant.Dish;
import com.thoughtworks.service.impl.RestaurantServiceImpl;

/**
 * strategy pattern to add more payment strategy in the future
 *
 */
public interface PaymentStrategy {

	int calculateBill(Cart cart);

	/**
	 * common method to calculate the cart items amount
	 */
	default int getAmount(Cart cart) {

		List<Dish> dishes = RestaurantServiceImpl.map.entrySet().stream()
				.filter(m -> m.getKey().equals(cart.getRestaurantId())).map(m -> m.getValue().getDishes())
				.flatMap(List::stream).collect(Collectors.toList());

		return dishes.stream().mapToInt(Dish::getPrice).sum();
	}

}