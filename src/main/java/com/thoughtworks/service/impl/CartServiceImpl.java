package com.thoughtworks.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.thoughtworks.domain.cart.Cart;
import com.thoughtworks.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	static Map<Integer, Cart> cartMap = null;

	static {
		cartMap = new HashMap<>();
	}

	@Override
	public Cart addItemsToCart(Cart cart) {
		cartMap.put(new Random().nextInt(), cart);
		return cart;
	}
}
