package com.thoughtworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.domain.order.Order;
import com.thoughtworks.service.OrderService;

@RestController
public class OrderController {

	private OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@PostMapping("/order")
	public Order createOrder(@RequestHeader String userId, @RequestBody Order order) {

		order.setUserId(userId);
		return this.orderService.createOrder(order);
	}

}
