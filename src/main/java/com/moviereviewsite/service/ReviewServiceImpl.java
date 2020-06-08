package com.moviereviewsite.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviereviewsite.dao.ReviewDao;
import com.moviereviewsite.dto.MovieReviewResponse;
import com.moviereviewsite.entities.Review;
import com.moviereviewsite.respository.ReviewRespository;
import com.moviereviewsite.utils.CommonUtils;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	ReviewRespository rresp;
	
	@Autowired
	MovieService mserv;
	
	@Autowired
	ReviewDao revDao;
	
	@Autowired
	CommonUtils comut;

	@Override
	public String addReviewOfMovie(Review r) throws Exception {
		JSONObject resultData= new JSONObject();
		resultData.put("result", "error");
		resultData.put("message", "Review Data not saved. Please try again after some time...!");
		System.out.println(resultData.toString());
		try {
			if(mserv.isMovieExists(r.getMovie().getMovie_id())) {
				if(comut.isValidRating(r.getMovie_rating())) {
					System.out.println("In isValidRating");
					Review r1=rresp.save(r);
					if(r1.getMovie_review_id()!=null) {
						resultData.put("result", "error");
						resultData.put("message", "Review Data successfully saved...!");
					}
				}else {
					resultData.put("result", "error");
					resultData.put("message", "Review Data not saved. Rating should be less than or equal to 10...!");
				}
			}else {
				resultData.put("result", "error");
				resultData.put("message", "Movie Data not found...!");
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
		return resultData.toString();
	}

	

	@Override
	public boolean isReviewExists(int id) {
		System.out.println("isReviewExists");
		Boolean result=false;
		Review r1=rresp.findById(id);
		if(r1!=null)
			result=true;
		return result;
	}

	@Override
	public String updateReview(Review r) throws Exception {
		JSONObject resultData= new JSONObject();
		resultData.put("result", "error");
		resultData.put("message", "Review Data not updated. Please try again after some time...!");
		try {
			if(isReviewExists(r.getMovie_review_id())) {
				if(comut.isValidRating(r.getMovie_rating())) {
					rresp.save(r);
					resultData.put("result", "error");
					resultData.put("message", "Review Data successfully updated...!");
				}else {
					resultData.put("result", "error");
					resultData.put("message", "Review Data not updated. Rating should be less than or equal to 10...!");
				}
			}
			else {
				resultData.put("result", "error");
				resultData.put("message", "Review Data not found...!");
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
		return resultData.toString();
	}

	@Override
	public String deleteReview(int id) throws Exception {
		JSONObject resultData= new JSONObject();
		resultData.put("result", "error");
		resultData.put("message", "Review Data not deleted. Please try again after some time...!");
		try {
			if(isReviewExists(id)) {
				rresp.deleteById(id);
				resultData.put("result", "success");
				resultData.put("message", "Review Data successfully deleted...!");
			}
			else {
				resultData.put("result", "error");
				resultData.put("message", "Review Data not found...!");
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}	
		return resultData.toString();
	}

	@Override
	public List<Review> getAllReviews(String reviewComment) {
		return rresp.getAllReviews("%"+reviewComment+"%");
	}



	@Override
	public List<Review> getAllReviews() {
		return rresp.findAll();
	}

}
