package com.thoughtworks.exceptions;

public class RatingNotBoundException extends RuntimeException {

	private String msg;

	public RatingNotBoundException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
