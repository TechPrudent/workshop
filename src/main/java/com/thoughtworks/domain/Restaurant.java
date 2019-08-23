package com.thoughtworks.domain;

import java.util.List;

public class Restaurant {

	private int id;
	private String name;
	private List<Dish> dishes;

	public Restaurant() {
		super();
	}

	public Restaurant(int id, String name, List<Dish> dishes) {
		super();
		this.id = id;
		this.name = name;
		this.dishes = dishes;
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