package com.thoughtworks.domain.rating.restaurant;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.thoughtworks.domain.rating.Rating;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class Restaurant {

	private int id;
	private String name;
	private List<Dish> dishes;
	private double overallRating = 0.0;
	private List<Rating> ratings;

	public Restaurant() {
		super();
	}

	public Restaurant(int id, String name, List<Dish> dishes, List<Rating> ratings) {
		super();
		this.id = id;
		this.name = name;
		this.dishes = dishes;
		this.ratings = ratings;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getOverallRating() {
		int ratingCount = this.ratings.size();
		int ratingSum = this.ratings.stream().mapToInt(r -> r.getReviewRating()).sum();
		this.overallRating = (ratingSum * 1.0) / (ratingCount * 1.0);
		return this.overallRating;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}
