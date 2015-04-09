package com.tesco.retail.domain.entites;


import javax.persistence.*;


@Table(name = "Brand")
@Entity
public class Brand {
	@Id
	private int brandId;
	private String brandName;



	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Brand(int brandId, String brandName ) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
	
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	
}
