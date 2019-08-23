package com.thoughtworks.domain.rating.login;

import org.springframework.stereotype.Component;

@Component
public class UserLogin implements LoginStrategy {

	@Override
	public boolean login(User user) {
		return user.getType().equals("user");
	}

}