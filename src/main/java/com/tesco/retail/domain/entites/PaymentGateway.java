package com.tesco.retail.domain.entites;

import javax.persistence.*;

@Table(name = "PaymentGateway")
@Entity
public class PaymentGateway {
	@Id
	private int paymentId;
	private int cardNumber;
	private double paymentAmount;
	private String cardHolderName;
	@OneToOne
	@JoinColumn(name = "invoiceId")
	private Invoice invoice;

	public PaymentGateway() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentGateway(int paymentId, int cardNumber, double paymentAmount,
			String cardHolderName, Invoice invoice) {
		super();
		this.paymentId = paymentId;
		this.cardNumber = cardNumber;
		this.paymentAmount = paymentAmount;
		this.cardHolderName = cardHolderName;
		this.invoice = invoice;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
