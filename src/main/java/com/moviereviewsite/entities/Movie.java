package com.moviereviewsite.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "movie_mst")
public class Movie {
	
	public Movie() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movie_id;
	
	private String movie_name;
	
	private Date movie_release_date;
	
	private Double movie_average_rating;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "movie", fetch = FetchType.LAZY)
	private List<Review> reviews;

	public Integer getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public Date getMovie_release_date() {
		return movie_release_date;
	}

	public void setMovie_release_date(Date movie_release_date) {
		this.movie_release_date = movie_release_date;
	}

	public Double getMovie_average_rating() {
		return movie_average_rating;
	}

	public void setMovie_average_rating(Double movie_average_rating) {
		this.movie_average_rating = movie_average_rating;
	}
	
	
	@JsonBackReference
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", movie_name=" + movie_name + ", movie_release_date="
				+ movie_release_date + ", movie_average_rating=" + movie_average_rating + ", reviews=" + reviews + "]";
	}

	
	
	

}
