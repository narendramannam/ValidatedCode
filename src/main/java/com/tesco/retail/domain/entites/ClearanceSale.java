package com.tesco.retail.domain.entites;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Table(name="clearancesale")
@Entity
//@NamedQuery(name="clearancesale.findAll",query="SELECT c FROM ClearanceSale c")
@NamedQueries({
    @NamedQuery(name="ClearanceSale.findAll",
                query="SELECT c FROM ClearanceSale c"),
    @NamedQuery(name="ClearanceSale.findByName",
                query="SELECT c FROM ClearanceSale c WHERE c.clearanceSaleName = :clearanceSaleName"),
               /* @NamedQuery(name="ClearanceSale.findByName",
                query="SELECT c FROM ClearanceSale c WHERE c.clearanceSaleId = :clearanceSaleId"),*/
}) 
public class ClearanceSale {
	//Variables Declaration
	@Id
	private int clearanceSaleId;
	private String clearanceSaleName;
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	private Date toDate;
	@OneToOne
	@JoinColumn(name = "InventoryId")
	private Inventory inventory;
	//Constructors
	public ClearanceSale() {
		super();
	}
	public ClearanceSale(int clearanceSaleId, String clearanceSaleName,
			Date fromDate, Date toDate) {
		super();
		this.clearanceSaleId = clearanceSaleId;
		this.clearanceSaleName = clearanceSaleName;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	//Getters and Setters
	public int getClearanceSaleId() {
		return clearanceSaleId;
	}
	public void setClearanceSaleId(int clearanceSaleId) {
		this.clearanceSaleId = clearanceSaleId;
	}

	public String getClearanceSaleName() {
		return clearanceSaleName;
	}

	public void setClearanceSaleName(String clearanceSaleName) {
		this.clearanceSaleName = clearanceSaleName;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	
	
	

}
