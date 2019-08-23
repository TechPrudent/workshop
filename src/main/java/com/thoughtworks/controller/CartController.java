package com.thoughtworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.domain.cart.Cart;
import com.thoughtworks.service.CartService;

@RestController
public class CartController {

	private CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}

	@PostMapping("/cart")
	public Cart addItemsToCart(@RequestBody Cart cart) {

		return this.cartService.addItemsToCart(cart);
	}

}