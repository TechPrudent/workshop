package com.thoughtworks.domain.billing;

import org.springframework.stereotype.Component;

import com.thoughtworks.domain.cart.Cart;

@Component
public class NetBanking implements PaymentStrategy {

	int netBankingFee = 1;

	@Override
	public int calculateBill(Cart cart) {
		int sum = getAmount(cart);
		return sum + netBankingFee;
	}
}
