package com.tesco.retail.domain.entites;

import javax.persistence.*;

@Table(name = "AbuseStatus")
@Entity
public class AbuseStatus {
	@Id
	private int abuseId;
	@OneToOne
	@JoinColumn(name = "reviewRatingId")
	private ReviewRating review;

	public AbuseStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AbuseStatus(int abuseId, ReviewRating review) {
		super();
		this.abuseId = abuseId;
		this.review = review;
	}

	public int getAbuseId() {
		return abuseId;
	}

	public void setAbuseId(int abuseId) {
		this.abuseId = abuseId;
	}

	public ReviewRating getReview() {
		return review;
	}

	public void setReview(ReviewRating review) {
		this.review = review;
	}

}
