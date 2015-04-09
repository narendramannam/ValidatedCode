package com.tesco.retail.domain.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Table(name="Product")
@Entity
//@NamedQuery(name="Product.findAll", query="SELECT pro FROM Product pro WHERE pro.id = :productId")
@NamedQueries({
    @NamedQuery(name="Product.findAll",
                query="SELECT c FROM Product c"),
    @NamedQuery(name="Product.findByName",
                query="SELECT c FROM Product c WHERE c.productId = :productName"),
}) 
public class Product implements Serializable {
	// Image
	@Id
	private int productId;
	@Column (nullable=false)
	private String productName;
	private String productDescription;
	private double price;
	private Date expiryDate;
	private int reOrderLevel;
	@OneToOne
	@JoinColumn(name="categoryId")
	private Category category;
	@OneToOne
	@JoinColumn(name="brandId")
	
	private Brand brand;
	
	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName,
			String productDescription, double price, Date expiryDate,
			int reOrderLevel, Category category , Brand brand) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.expiryDate = expiryDate;
		this.reOrderLevel = reOrderLevel;
		this.category = category;
		this.setBrand(brand);
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getReOrderLevel() {
		return reOrderLevel;
	}

	public void setReOrderLevel(int reOrderLevel) {
		this.reOrderLevel = reOrderLevel;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

}
