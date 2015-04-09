package com.tesco.retail.domain.entites;

import javax.persistence.*;

@Table(name = "Invoice")
@Entity
public class Invoice {
	@Id
	private int invoiceId;
	private double cost;
	private double vat;
	private double finalAmount;
	private String paymentMode;
	@OneToOne
	@JoinColumn(name = "paymentId")
	private PaymentGateway paymentGateway;

	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invoice(int invoiceId, double cost, double vat, double finalAmount,
			String paymentMode, PaymentGateway paymentGateway) {
		super();
		this.invoiceId = invoiceId;
		this.cost = cost;
		this.vat = vat;
		this.finalAmount = finalAmount;
		this.paymentMode = paymentMode;
		this.paymentGateway = paymentGateway;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public PaymentGateway getPaymentGateway() {
		return paymentGateway;
	}

	public void setPaymentGateway(PaymentGateway paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

}
