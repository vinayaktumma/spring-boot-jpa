package com.moviereviewsite.dao;

import java.util.List;

import com.moviereviewsite.dto.MovieReviewResponse;

public interface ReviewDao {
	
	public List<MovieReviewResponse> getAllReviews(String reviewComment);
}
