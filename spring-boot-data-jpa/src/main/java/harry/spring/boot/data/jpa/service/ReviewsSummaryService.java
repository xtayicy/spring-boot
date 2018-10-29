package harry.spring.boot.data.jpa.service;

import harry.spring.boot.data.jpa.entity.Rating;

/**
 * 
 * @author harry
 *
 */
public interface ReviewsSummaryService {
	long getNumberOfReviewsWithRating(Rating rating);
}
