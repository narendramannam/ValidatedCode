package com.tesco.retail.domain.entites;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tesco.retail.domain.entites.Customer;

@Entity
@Table(name="shipping")
public class Shipping {
	@Id
	private int shippingId;
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	@OneToOne
	@JoinColumn(name="statusId")
	private ProductStatus status;
	
	public Shipping() {
		super();
	}
	public Shipping(int shippingId, Customer customer, ProductStatus status) {
		super();
		this.shippingId = shippingId;
		this.customer = customer;
		this.status = status;
	}
	public int getShippingId() {
		return shippingId;
	}
	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public ProductStatus getStatus() {
		return status;
	}
	public void setStatus(ProductStatus status) {
		this.status = status;
	}
	
}
