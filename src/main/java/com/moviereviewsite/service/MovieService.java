package com.moviereviewsite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moviereviewsite.dto.MovieReviewResponse;
import com.moviereviewsite.entities.Movie;
import com.moviereviewsite.exceptionhandling.ResourceNotFoundException;


public interface MovieService {
	
	public String addMovieInfo(Movie m) throws Exception;
	
	public List<Movie> getAllMovies();
	
	public boolean isMovieExists(int id);
	
	public String updateMovieInfo(Movie m) throws Exception;
	
	public String deleteMovie(int id) throws Exception;
	
	public List<MovieReviewResponse> getAllReviews();

}
