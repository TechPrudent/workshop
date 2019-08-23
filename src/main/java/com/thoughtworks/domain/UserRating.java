package com.thoughtworks.domain;

public class UserRating {

	private int id;
	private int rating;
	private String userType;

	public UserRating(int id, int rating, String userType) {
		super();
		this.id = id;
		this.rating = rating;
		this.userType = userType;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public UserRating() {
		super();
	}

}
