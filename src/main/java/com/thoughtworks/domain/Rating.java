package com.thoughtworks.domain;

public class Rating {
	private int rating;
	private String userType;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Rating() {
		super();
	}

	public Rating(int rating, String userType) {
		super();
		this.rating = rating;
		this.userType = userType;
	}

}
