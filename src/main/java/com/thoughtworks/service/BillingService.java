package com.thoughtworks.service;

import com.thoughtworks.domain.billing.BillingResponse;
import com.thoughtworks.domain.cart.Cart;

public interface BillingService {

	BillingResponse getBillingResponse(Cart cart);

}
