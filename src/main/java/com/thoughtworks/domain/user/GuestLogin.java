package com.thoughtworks.domain.user;

import org.springframework.stereotype.Component;

import com.thoughtworks.domain.LoginStrategy;
import com.thoughtworks.domain.User;

@Component
public class GuestLogin implements LoginStrategy {
	@Override
	public boolean login(User user) {
		return (user.getType().equals("guest"));
	}

}