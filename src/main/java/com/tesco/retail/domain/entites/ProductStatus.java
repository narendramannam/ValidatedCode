package com.tesco.retail.domain.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProductStatus")
public class ProductStatus {
	@Id
	@Column(name="productstatusId")
	private int productstatusId;
	private String productstatusInfo;
	
	public ProductStatus() {
		super();
	}
	public ProductStatus(int statusId, String statusInfo) {
		super();
		this.productstatusId = statusId;
		this.productstatusInfo = statusInfo;
	}
	public int getStatusId() {
		return productstatusId;
	}
	public void setStatusId(int statusId) {
		this.productstatusId = statusId;
	}
	public String getStatusInfo() {
		return productstatusInfo;
	}
	public void setStatusInfo(String statusInfo) {
		this.productstatusInfo = statusInfo;
	}

}
