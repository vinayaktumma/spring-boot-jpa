package com.moviereviewsite.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "movie_review_mst")
public class Review {
	
	public Review() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movie_review_id;
	
	private String reviewer_name;
	
	private Double movie_rating;
	
	private String movie_review_comments;
	
	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movie movie;

	public Integer getMovie_review_id() {
		return movie_review_id;
	}

	public void setMovie_review_id(Integer movie_review_id) {
		this.movie_review_id = movie_review_id;
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
	
	@JsonBackReference
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Review [movie_review_id=" + movie_review_id + ", reviewer_name=" + reviewer_name + ", movie_rating="
				+ movie_rating + ", movie_review_comments=" + movie_review_comments + ", movie=" + movie + "]";
	}

	

}
