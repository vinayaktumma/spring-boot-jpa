package com.moviereviewsite.service;

import java.util.List;

import com.moviereviewsite.dto.MovieReviewResponse;
import com.moviereviewsite.entities.Review;

public interface ReviewService {
	
	public String addReviewOfMovie(Review r) throws Exception;
	
	public boolean isReviewExists(int id);
	
	public String updateReview(Review m) throws Exception;
	
	public String deleteReview(int id) throws Exception;
	
	public List<Review> getAllReviews(String reviewComment);
	
	public List<Review> getAllReviews();
	
	

}
