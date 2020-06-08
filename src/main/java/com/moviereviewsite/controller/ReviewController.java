package com.moviereviewsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviereviewsite.dto.MovieReviewResponse;
import com.moviereviewsite.entities.Movie;
import com.moviereviewsite.entities.Review;
import com.moviereviewsite.respository.ReviewRespository;
import com.moviereviewsite.service.ReviewService;

@RestController
public class ReviewController {
	
	@Autowired
	ReviewService rserv;
	
	@RequestMapping(value="/addReview", method=RequestMethod.POST)
	public String addReview(@RequestBody Review r) throws Exception {
		return rserv.addReviewOfMovie(r);
	}
	
	@RequestMapping(value="/updateReview", method=RequestMethod.POST)
	public String updateReview(@RequestBody Review r) throws Exception {
		return rserv.updateReview(r);
	}
	
	@RequestMapping(value="/deleteReview/{id}", method=RequestMethod.GET)
	public String deleteReview(@PathVariable int id) throws Exception {
		return rserv.deleteReview(id);
	}
	
	@RequestMapping(value="/searchReview", method=RequestMethod.GET)
	public List<Review> searchReview(@RequestParam String reviewComment) throws Exception {
		return rserv.getAllReviews(reviewComment);
	}
	
	@RequestMapping(value="/getAllReviews", method=RequestMethod.GET)
	public List<Review> getAllReviews(@RequestParam String reviewComment) throws Exception {
		return rserv.getAllReviews(reviewComment);
	}

}
