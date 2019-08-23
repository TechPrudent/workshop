package com.thoughtworks.domain.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.thoughtworks.domain.cart.Cart;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class Order {

	private int orderId;
	private Cart cart;
	private String paymentType;
	private String address;
	private int amount;

	public Order() {
		super();
	}

	public Order(int orderId, Cart cart, String paymentType, String address, int amount) {
		super();
		this.orderId = orderId;
		this.cart = cart;
		this.paymentType = paymentType;
		this.address = address;
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public int getAmount() {
		return amount;
	}

	public Cart getCart() {
		return cart;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
