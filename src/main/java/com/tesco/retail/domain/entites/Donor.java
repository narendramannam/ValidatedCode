package com.tesco.retail.domain.entites;

public class Donor {
	private int DonorId;
	private String donorName;
	private String email;
	private String phoneNo;
	private PoolDetails poolDetails;

	public int getDonorId() {
		return DonorId;
	}
	public void setDonorId(int donorId) {
		DonorId = donorId;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public PoolDetails getPoolDetails() {
		return poolDetails;
	}
	public void setPoolDetails(PoolDetails poolDetails) {
		this.poolDetails = poolDetails;
	}

}
