package com.thoughtworks.domain.rating;

public class Rating {

	private int reviewRating;
	private String userType;

	public Rating() {
		super();
	}

	public Rating(int reviewRating, String userType) {
		super();
		this.reviewRating = reviewRating;
		this.userType = userType;
	}

	public int getReviewRating() {
		return reviewRating;
	}

	public String getUserType() {
		return userType;
	}

	public void setReviewRating(int reviewRating) {
		this.reviewRating = reviewRating;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
