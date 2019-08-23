package com.thoughtworks.domain;

import java.util.List;

public class Restaurant {

	private int id;
	private String name;
	private List<Dish> dishes;
	private double overallRating;
	private List<Rating> ratings;

	public Restaurant() {
		super();
	}

	public double getOverallRating() {
		int ratingCount = this.ratings.size();
		int ratingSum = this.ratings.stream().mapToInt(r -> r.getRating()).sum();
		this.overallRating = (ratingSum * 1.0) / (ratingCount * 1.0);
		return this.overallRating;
	}

	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}

	public Restaurant(int id, String name, List<Dish> dishes, List<Rating> ratings) {
		super();
		this.id = id;
		this.name = name;
		this.dishes = dishes;
		this.ratings = ratings;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

}
