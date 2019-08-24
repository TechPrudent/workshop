package com.thoughtworks.domain.rating.login;

import org.springframework.stereotype.Component;

@Component
public class GuestLogin implements LoginStrategy {

	@Override
	public User login(User user) {
		boolean isGuest = user.getType().equals("guest");
		return user;
	}

}