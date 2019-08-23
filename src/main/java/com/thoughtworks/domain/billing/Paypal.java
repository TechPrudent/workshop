package com.thoughtworks.domain.billing;

import org.springframework.stereotype.Component;

import com.thoughtworks.domain.cart.Cart;

@Component
public class Paypal implements PaymentStrategy {

	int paypalConvenienceFee = 2;

	@Override
	public int calculateBill(Cart cart) {
		int total = getAmount(cart);
		return total + paypalConvenienceFee;
	}
}