package com.tesco.retail.domain.entites;

import java.util.List;

public class GiftPoolProduct {

	private int giftId;
	private List<PoolDetails> poolDetails;
	public int getGiftId() {
		return giftId;
	}
	public void setGiftId(int giftId) {
		this.giftId = giftId;
	}
	public List<PoolDetails> getPoolDetails() {
		return poolDetails;
	}
	public void setPoolDetails(List<PoolDetails> poolDetails) {
		this.poolDetails = poolDetails;
	}

}
