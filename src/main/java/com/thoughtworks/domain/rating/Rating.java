package com.thoughtworks.domain.rating;

public class Rating {

	private int reviewRating;
	private String userType;
	private String userId;

	public Rating() {
		super();
	}

	public Rating(int reviewRating, String userType) {
		super();
		this.reviewRating = reviewRating;
		this.userType = userType;
	}

	public Rating(int reviewRating, String userType, String userId) {
		super();
		this.reviewRating = reviewRating;
		this.userType = userType;
		this.userId = userId;
	}

	public int getReviewRating() {
		return reviewRating;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setReviewRating(int reviewRating) {
		this.reviewRating = reviewRating;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
