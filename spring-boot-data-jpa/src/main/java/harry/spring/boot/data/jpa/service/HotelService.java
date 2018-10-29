package harry.spring.boot.data.jpa.service;

import harry.spring.boot.data.jpa.entity.City;
import harry.spring.boot.data.jpa.entity.Hotel;
import harry.spring.boot.data.jpa.entity.Review;
import harry.spring.boot.data.jpa.entity.ReviewDetails;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author harry
 *
 */
public interface HotelService {
	Hotel getHotel(City city, String name);

	Page<Review> getReviews(Hotel hotel, Pageable pageable);

	Review getReview(Hotel hotel, int index);

	Review addReview(Hotel hotel, ReviewDetails details);

	ReviewsSummaryService getReviewSummary(Hotel hotel);
}
