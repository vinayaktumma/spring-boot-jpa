package com.moviereviewsite.dto;


public class MovieReviewResponse {
	
	public MovieReviewResponse() {
		super();
	}
	
	public MovieReviewResponse(Integer movie_review_id, String movie_name, String reviewer_name, Double movie_rating,
			String movie_review_comments) {
		super();
		this.movie_review_id = movie_review_id;
		this.movie_name = movie_name;
		this.reviewer_name = reviewer_name;
		this.movie_rating = movie_rating;
		this.movie_review_comments = movie_review_comments;
	}

	private Integer movie_review_id;
	
	private String movie_name;
	
	private String reviewer_name;
	
	private Double movie_rating;
	
	private String movie_review_comments;

	public Integer getMovie_review_id() {
		return movie_review_id;
	}

	public void setMovie_review_id(Integer movie_review_id) {
		this.movie_review_id = movie_review_id;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getReviewer_name() {
		return reviewer_name;
	}

	public void setReviewer_name(String reviewer_name) {
		this.reviewer_name = reviewer_name;
	}

	public Double getMovie_rating() {
		return movie_rating;
	}

	public void setMovie_rating(Double movie_rating) {
		this.movie_rating = movie_rating;
	}

	public String getMovie_review_comments() {
		return movie_review_comments;
	}

	public void setMovie_review_comments(String movie_review_comments) {
		this.movie_review_comments = movie_review_comments;
	}

	@Override
	public String toString() {
		return "MovieReviewResponse [movie_review_id=" + movie_review_id + ", movie_name=" + movie_name
				+ ", reviewer_name=" + reviewer_name + ", movie_rating=" + movie_rating + ", movie_review_comments="
				+ movie_review_comments + "]";
	}
	
	
	

}
