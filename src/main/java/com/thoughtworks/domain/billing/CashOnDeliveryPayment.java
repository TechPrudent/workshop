package com.thoughtworks.domain.billing;

import org.springframework.stereotype.Component;

import com.thoughtworks.domain.cart.Cart;

@Component
public class CashOnDeliveryPayment implements PaymentStrategy {

	@Override
	public int calculateBill(Cart cart) {
		return getAmount(cart);
	}
}