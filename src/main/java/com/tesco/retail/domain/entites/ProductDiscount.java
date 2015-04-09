package com.tesco.retail.domain.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="productDiscount")
@NamedQueries({
    @NamedQuery(name="ProductDiscount.findAll",
                query="SELECT c FROM ProductDiscount c"),
    @NamedQuery(name="ProductDiscount.findByName",
                query="SELECT c FROM ProductDiscount c WHERE c.product.productId = :productId"),
}) 
public class ProductDiscount {
	
	@Column(nullable=false)
	private int discount;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productDiscountID;
	@OneToOne
	@JoinColumn(name = "productId")	
	private Product product;
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getProductDiscountID() {
		return productDiscountID;
	}
	public void setProductDiscountID(int productDiscountID) {
		this.productDiscountID = productDiscountID;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public ProductDiscount(int discount, Product product) {
		super();
		this.discount = discount;
		this.product = product;
	}
	public ProductDiscount() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductDiscount [discount=" + discount + ", productDiscountID="
				+ productDiscountID + ", product=" + product + "]";
	}
	
	
	
}
