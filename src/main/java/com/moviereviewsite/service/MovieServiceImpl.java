package com.moviereviewsite.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moviereviewsite.dto.MovieReviewResponse;
import com.moviereviewsite.entities.Movie;
import com.moviereviewsite.exceptionhandling.ResourceNotFoundException;
import com.moviereviewsite.respository.MovieRespository;
import com.moviereviewsite.utils.CommonUtils;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	MovieRespository mresp;
	
	@Autowired
	CommonUtils comut;

	@Override
	@Transactional
	public String addMovieInfo(Movie m) throws Exception {
		
		JSONObject resultData= new JSONObject();
		resultData.put("result", "error");
		resultData.put("message", "Movie Data not saved. Please try again after some time...!");
		try {
			if(comut.isValidRating(m.getMovie_average_rating())) {
				Movie m1=mresp.save(m);
				
				if(m1.getMovie_id()!=null) {
					resultData.put("result", "success");
					resultData.put("message", "Movie Data successfully saved...!");
				}
			}else {
				resultData.put("result", "warning");
				resultData.put("message", "Movie Data not saved. Rating should be less than or equal to 10...!");
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
		return resultData.toString();
	}

	@Override
	public List<Movie> getAllMovies() {
		return mresp.findAll();
	}

	@Override
	public boolean isMovieExists(int id) {
		Boolean result=false;
		Movie m1=mresp.findById(id);
		if(m1!=null)
			result=true;
		return result;
	}

	@Override
	@Transactional
	public String updateMovieInfo(Movie m) throws Exception {

		JSONObject resultData= new JSONObject();
		resultData.put("result", "error");
		resultData.put("message", "Movie Data not updated. Please try again after some time...!");
		try {
			if(isMovieExists(m.getMovie_id())) {
				if(comut.isValidRating(m.getMovie_average_rating())) {
					mresp.updateMovie(m.getMovie_id(),m.getMovie_name(),m.getMovie_release_date(),m.getMovie_average_rating());
					resultData.put("result", "success");
					resultData.put("message", "Movie Data successfully updated...!");
				}else {
					resultData.put("result", "warning");
					resultData.put("message", "Movie Data not saved. Rating should be less than or equal to 10...!");
				}
			}else {
				resultData.put("result", "warning");
				resultData.put("message", "Movie Data not found...!");
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
		return resultData.toString();
	}
	
	@Override
	@Transactional
	public String deleteMovie(int id) throws Exception {
		JSONObject resultData= new JSONObject();
		resultData.put("result", "error");
		resultData.put("message", "Movie Data not deleted. Please try again after some time...!");
		try {
			if(isMovieExists(id)) {
				mresp.deleteById(id);
				resultData.put("result", "success");
				resultData.put("message", "Movie Data successfully deleted...!");
			}
			else {
				resultData.put("result", "warning");
				resultData.put("message", "Movie Data not found...!");
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
		return resultData.toString();
	}
	
	@Override
	public List<MovieReviewResponse> getAllReviews() {
		//return mresp.getAllReview();
		return null;
	}

}
