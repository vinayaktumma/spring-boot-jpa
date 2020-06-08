package com.moviereviewsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moviereviewsite.dto.MovieReviewResponse;
import com.moviereviewsite.entities.Movie;
import com.moviereviewsite.exceptionhandling.ResourceNotFoundException;
import com.moviereviewsite.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	MovieService mserv;
	
	@RequestMapping(value="/addMovie", method=RequestMethod.POST)
	public String addMovie(@RequestBody Movie m) throws Exception {
		return mserv.addMovieInfo(m);
	}
	
	@RequestMapping(value="/getAllMovies", method=RequestMethod.GET)
	public List<Movie> getAllMovies(){
		return mserv.getAllMovies();
	}
	
	@RequestMapping(value="/updateMovie", method=RequestMethod.POST)
	public String updateMovie(@RequestBody Movie m) throws Exception {
		return mserv.updateMovieInfo(m);
	}
	
	@RequestMapping(value="/deleteMovie/{id}", method=RequestMethod.GET)
	public String deleteMovie(@PathVariable int id) throws Exception {
		return mserv.deleteMovie(id);
	}
	
	@RequestMapping(value="/getAllMovieReviews", method=RequestMethod.GET)
	public List<MovieReviewResponse> getAllReviews(){
		return mserv.getAllReviews();
	}

}
