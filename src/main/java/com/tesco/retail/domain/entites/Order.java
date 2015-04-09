package com.tesco.retail.domain.entites;

import java.util.Date;
import javax.persistence.*;

@Table(name = "Orders")
@Entity
@NamedQueries({
    @NamedQuery(name="Orders.findAll",
                query="SELECT c FROM Order c"),
    @NamedQuery(name="Orders.findByName",
                query="SELECT c FROM Order c WHERE c.dateOfPurchase = :dateOfPurchase"),
}) 
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	@OneToOne
	@JoinColumn(name = "cartId")
	private Cart cart;
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	private Date dateOfPurchase;
	private String status;
	@OneToOne
	@JoinColumn(name = "invoiceId")
	private Invoice invoice;

	public Order(Cart cart, Customer customer, Date dateOfPurchase,
			String status, Invoice invoice) {
		super();
		this.cart = cart;
		this.customer = customer;
		this.dateOfPurchase = dateOfPurchase;
		this.status = status;
		this.invoice = invoice;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, Cart cart, Customer customer,
			Date dateOfPurchase, String status, Invoice invoice) {
		super();
		this.orderId = orderId;
		this.cart = cart;
		this.customer = customer;
		this.dateOfPurchase = dateOfPurchase;
		this.status = status;
		this.invoice = invoice;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", cart=" + cart + ", customer="
				+ customer + ", dateOfPurchase=" + dateOfPurchase + ", status="
				+ status + ", invoice=" + invoice + "]";
	}

}
