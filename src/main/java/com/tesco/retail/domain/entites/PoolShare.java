package com.tesco.retail.domain.entites;

import java.util.List;

public class PoolShare {
	private double shareAmount;
	private List<Product> products;
	private List<PoolDetails> pooldetails;

	public double getShareAmount() {
		return shareAmount;
	}
	public void setShareAmount(double shareAmount) {
		this.shareAmount = shareAmount;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<PoolDetails> getPooldetails() {
		return pooldetails;
	}
	public void setPooldetails(List<PoolDetails> pooldetails) {
		this.pooldetails = pooldetails;
	}

}
