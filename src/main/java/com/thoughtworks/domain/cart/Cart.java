package com.thoughtworks.domain.cart;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.thoughtworks.domain.rating.restaurant.Dish;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class Cart {

	private List<Dish> dishes;
	private String paymentType;
	private int restaurantId;
	private String userId;

	public Cart() {
		super();
	}

	public Cart(List<Dish> dishes, String paymentType, int restaurantId) {
		super();
		this.dishes = dishes;
		this.paymentType = paymentType;
		this.restaurantId = restaurantId;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public String getUserId() {
		return userId;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
