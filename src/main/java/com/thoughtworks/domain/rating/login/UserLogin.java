package com.thoughtworks.domain.rating.login;

import org.springframework.stereotype.Component;

@Component
public class UserLogin implements LoginStrategy {

	@Override
	public User login(User user) {
		boolean isUser = user.getType().equals("user");
		return user;
	}

}