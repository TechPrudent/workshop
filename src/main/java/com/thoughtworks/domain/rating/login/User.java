package com.thoughtworks.domain.rating.login;

public class User {

	private String id;
	private String name;
	private String type;

	public User() {
		super();
	}

	public User(String name, String type, String id) {
		super();
		this.name = name;
		this.type = type;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

}
