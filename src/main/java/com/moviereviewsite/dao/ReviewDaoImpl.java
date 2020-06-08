package com.moviereviewsite.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.moviereviewsite.dto.MovieReviewResponse;

@Repository
public class ReviewDaoImpl implements ReviewDao{
	
	@Autowired
	EntityManager em;
	
	Query q;

	@Override
	public List<MovieReviewResponse> getAllReviews(String reviewComment) {
		String query=" select  r.movie_review_id as movie_review_id,m.movie_name as movie_name,r.reviewer_name as reviewer_name,r.movie_rating as movie_rating,r.movie_review_comments as movie_review_comments from  movie_review_mst r inner join movie_mst m on r.movie_id = m.movie_id where r.movie_review_comments like :reviewComment  ";
		q=  em.createNativeQuery(query,MovieReviewResponse.class);
		q.setParameter("reviewComment", "%"+reviewComment+"%");
		/*
		 * List<Object[]> result= q.getResultList();
		 * 
		 * JSONArray objArr = new JSONArray(); JSONObject obj; for(Object res[] :
		 * result) { obj = new JSONObject(); }
		 */
		
		
		List<MovieReviewResponse> result= q.getResultList();
		return result;
	}

}
