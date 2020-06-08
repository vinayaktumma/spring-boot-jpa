package com.moviereviewsite.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.moviereviewsite.entities.Review;

public interface ReviewRespository extends JpaRepository<Review, Integer>{
	
	Review findById(int id);
	
	@Query(value=" select  r.movie_review_id,r.movie_id,r.reviewer_name,r.movie_rating,r.movie_review_comments from  movie_review_mst r inner join movie_mst m on r.movie_id = m.movie_id where r.movie_review_comments like :reviewComment ",nativeQuery=true)
	public List<Review> getAllReviews(@Param("reviewComment") String reviewComment);
	

	

}
