package com.thoughtworks.service;

import com.thoughtworks.domain.rating.login.User;

public interface UserService {

	boolean register(User user);

	User saveUserPaymentMethod(User user);

}
