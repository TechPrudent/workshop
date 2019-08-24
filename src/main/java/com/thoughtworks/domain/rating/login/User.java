package com.thoughtworks.domain.rating.login;

public class User {

	private String id;
	private String name;
	private String type;
	private String password;
	private String sessionId;
	private String preferredPaymentMethod;

	public User() {
		super();
	}

	public User(String name, String type, String id) {
		super();
		this.name = name;
		this.type = type;
		this.id = id;
	}

	public User(String id, String name, String type, String password) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getPreferredPaymentMethod() {
		return preferredPaymentMethod;
	}

	public String getSessionId() {
		return sessionId;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPreferredPaymentMethod(String preferredPaymentMethod) {
		this.preferredPaymentMethod = preferredPaymentMethod;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public void setType(String type) {
		this.type = type;
	}

}
