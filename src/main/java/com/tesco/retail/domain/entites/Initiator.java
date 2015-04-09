package com.tesco.retail.domain.entites;

import java.util.List;

public class Initiator {

	private int initiatorId;
	private boolean status;
	private Customer customer;
	private List<PoolDetails> poolDetails;

	public int getInitiatorId() {
		return initiatorId;
	}
	public void setInitiatorId(int initiatorId) {
		this.initiatorId = initiatorId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<PoolDetails> getPoolDetails() {
		return poolDetails;
	}
	public void setPoolDetails(List<PoolDetails> poolDetails) {
		this.poolDetails = poolDetails;
	}



}
