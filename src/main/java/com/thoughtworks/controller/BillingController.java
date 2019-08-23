package com.thoughtworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.domain.billing.BillingResponse;
import com.thoughtworks.domain.cart.Cart;
import com.thoughtworks.service.BillingService;

@RestController
public class BillingController {

	private BillingService billingService;

	@Autowired
	public BillingController(BillingService billingService) {
		super();
		this.billingService = billingService;
	}

	@PostMapping("/billing")
	public BillingResponse getBillingResponse(@RequestBody Cart cart) {

		return this.billingService.getBillingResponse(cart);
	}
}
