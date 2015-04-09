package com.tesco.retail.domain.entites;

import java.util.Date;

public class Payment {

	private Date date;
	private String paymentType;
	private double amount;
	private GiftPoolProduct giftProduct;
	private PoolDetails poolDetails;
	private Donor donor;

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public GiftPoolProduct getGiftProduct() {
		return giftProduct;
	}
	public void setGiftProduct(GiftPoolProduct giftProduct) {
		this.giftProduct = giftProduct;
	}
	public PoolDetails getPoolDetails() {
		return poolDetails;
	}
	public void setPoolDetails(PoolDetails poolDetails) {
		this.poolDetails = poolDetails;
	}
	public Donor getDonor() {
		return donor;
	}
	public void setDonor(Donor donor) {
		this.donor = donor;
	}



}
