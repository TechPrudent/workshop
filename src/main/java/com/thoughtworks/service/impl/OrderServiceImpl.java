package com.thoughtworks.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtworks.domain.billing.BillingResponse;
import com.thoughtworks.domain.order.Order;
import com.thoughtworks.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	static Map<Integer, Order> orderMap = null;

	static {
		orderMap = new HashMap<>();
	}

	@Autowired
	private BillingServiceImpl billingService;

	@Override
	public Order createOrder(Order order) {
		int orderId = Math.negateExact(new Random().nextInt());
		order.setOrderId(orderId);

		BillingResponse billingResponse = this.billingService.getBillingResponse(order.getCart());
		order.setAmount(billingResponse.getAmount());

		orderMap.put(orderId, order);
		return orderMap.get(orderId);
	}

}
