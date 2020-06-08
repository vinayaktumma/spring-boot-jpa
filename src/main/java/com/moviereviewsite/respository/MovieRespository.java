package com.moviereviewsite.respository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.moviereviewsite.dto.MovieReviewResponse;
import com.moviereviewsite.entities.Movie;

@Component
public interface MovieRespository extends JpaRepository<Movie, Integer>{
	
	Movie findById(int id);
	
	@Modifying
	@Query(" update Movie set movie_name= ?2,movie_release_date= ?3,movie_average_rating= ?4 where movie_id= ?1 ")
	public void updateMovie(Integer id,String name,Date release_date,Double rating);
	
	/*
	 * @Query(value =
	 * " SELECT NEW com.moviereviewsite.dto.MovieReviewResponse(r.movie_review_id,m.movie_name,"
	 * +
	 * " r.reviewer_name,r.movie_rating,r.movie_review_comments) FROM Movie m LEFT JOIN m.movie_id r "
	 * ) public List<MovieReviewResponse> getAllReview();
	 */
	
}
