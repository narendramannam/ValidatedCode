package com.tesco.retail.domain.entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "inventory")
@Entity
@NamedQuery(name="inventory.findAll",query="SELECT c FROM Inventory c")
public class Inventory implements Serializable{
	@OneToOne
	@JoinColumn(name = "productId")
	private Product product;
	private Date dateOfPurchase;
	private int quantity;
	@Id
	@Column(name="InventoryId")
	private int InventoryId;

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventory(int InventoryId,Product product, Date dateOfPurchase, int quantity) {
		super();
		this.product = product;
		this.dateOfPurchase = dateOfPurchase;
		this.quantity = quantity;
		this.setInventoryId(InventoryId);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getInventoryId() {
		return InventoryId;
	}

	public void setInventoryId(int inventoryId) {
		InventoryId = inventoryId;
	}

}
