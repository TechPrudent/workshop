package com.thoughtworks.domain.rating.login;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.thoughtworks.service.SessionValidator;

@Component
public class AuthUserLogin implements LoginStrategy {

	private String generateSessionId() {
		return UUID.randomUUID().toString();
	}

	@Override
	public User login(User user) {

		boolean isUser = user.getType().equals("user");
		if (isUser) {
			SessionValidator.sessionMap.put(user.getId(), generateSessionId());
			user.setSessionId(SessionValidator.sessionMap.get(user.getId()));
		}
		return user;
	}

}