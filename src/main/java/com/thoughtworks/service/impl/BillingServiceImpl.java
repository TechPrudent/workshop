package com.thoughtworks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtworks.domain.billing.BillingResponse;
import com.thoughtworks.domain.billing.CashOnDeliveryPayment;
import com.thoughtworks.domain.billing.NetBanking;
import com.thoughtworks.domain.billing.Paypal;
import com.thoughtworks.domain.cart.Cart;
import com.thoughtworks.domain.rating.login.User;
import com.thoughtworks.service.BillingService;

@Service
public class BillingServiceImpl implements BillingService {

	private static final int DELIVERY_CHARGES = 20;
	private static final int DELIVERY_CHARGES_LIMIT = 200;
	private CashOnDeliveryPayment cod;
	private NetBanking nb;
	private Paypal pp;

	@Autowired
	public BillingServiceImpl(CashOnDeliveryPayment cod, NetBanking nb, Paypal pp) {
		super();
		this.cod = cod;
		this.nb = nb;
		this.pp = pp;
	}

	private int calculateDeliveryCharges(int amount) {
		return (amount < DELIVERY_CHARGES_LIMIT) ? amount + DELIVERY_CHARGES : amount;
	}

	@Override
	public BillingResponse getBillingResponse(Cart cart) {
		int amount = 0;

		String userId = cart.getUserId();
		User user = UserServiceImpl.users.get(userId);
		if (user.getPreferredPaymentMethod() != null) {
			cart.setPaymentType(user.getPreferredPaymentMethod());
		}

		if (cart.getPaymentType().equals("cod")) {
			amount = cod.getAmount(cart);
		} else if (cart.getPaymentType().equals("nb")) {
			amount = nb.getAmount(cart);
		} else if (cart.getPaymentType().equals("pp")) {
			amount = pp.getAmount(cart);
		}

		amount = calculateDeliveryCharges(amount);
		return new BillingResponse(amount);
	}

}