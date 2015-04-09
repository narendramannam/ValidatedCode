package com.tesco.retail.domain.entites;

import javax.persistence.*;

@Table(name = "ReviewRating")
@Entity
public class ReviewRating {
	@Id
	private int reviewRatingId;
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	private String reviewComments;
	private int rating;
	@OneToOne
	@JoinColumn(name = "productId")
	private Product product;

	public ReviewRating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewRating(int reviewRatingId, Customer customer,
			String reviewComments, int rating, Product product) {
		super();
		this.reviewRatingId = reviewRatingId;
		this.customer = customer;
		this.reviewComments = reviewComments;
		this.rating = rating;
		this.product = product;
	}

	public int getReviewRatingId() {
		return reviewRatingId;
	}

	public void setReviewRatingId(int reviewRatingId) {
		this.reviewRatingId = reviewRatingId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getReviewComments() {
		return reviewComments;
	}

	public void setReviewComments(String reviewComments) {
		this.reviewComments = reviewComments;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
