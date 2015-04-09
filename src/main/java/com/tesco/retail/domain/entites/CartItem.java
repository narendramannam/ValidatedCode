package com.tesco.retail.domain.entites;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "CartItem")
@Entity
public class CartItem implements Serializable {
	@OneToOne
	@JoinColumn(name = "productId")
	private Product product;
	private int quantity;
	@OneToOne
	@JoinColumn(name = "cartId")
	 @EmbeddedId
	private Cart cart;

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItem(Product product, int quantity, Cart cart) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
