package com.thoughtworks.domain.rating;

public class UserRating {

	private int id;
	private int rating;
	private String userType;
	private String userId;

	public UserRating() {
		super();
	}

	public UserRating(int id, int rating, String userType) {
		super();
		this.id = id;
		this.rating = rating;
		this.userType = userType;
	}

	public UserRating(int id, int rating, String userType, String userId) {
		super();
		this.id = id;
		this.rating = rating;
		this.userType = userType;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public int getRating() {
		return rating;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
