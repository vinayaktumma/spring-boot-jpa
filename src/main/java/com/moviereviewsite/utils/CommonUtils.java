package com.moviereviewsite.utils;

import org.springframework.stereotype.Component;

@Component
public class CommonUtils {
	
	public boolean isValidRating(Double rating) {
		System.out.println("isValidRating");
		boolean result= false;
		if(rating <=10.00)
			result= true;
		return result;
	}

}
