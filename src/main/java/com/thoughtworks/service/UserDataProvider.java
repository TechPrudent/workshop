package com.thoughtworks.service;

import org.springframework.stereotype.Service;

import com.thoughtworks.domain.GuestUser;
import com.thoughtworks.domain.User;

@Service
public class UserDataProvider {

	static GuestUser gu = null;

	static {
		gu = new GuestUser();
		gu.setName("guestUser");
		gu.setId("1");
		gu.setType("Guest");
	}

	public User getUser() {
		return gu;
	}

}
