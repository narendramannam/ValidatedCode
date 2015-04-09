package com.tesco.retail.domain.entites;

import javax.persistence.*;

@Table(name = "Cart")
@Entity
@Embeddable
public class Cart {
	@Id
	private int cartId;
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartId, Customer customer) {
		super();
		this.cartId = cartId;
		this.customer = customer;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
