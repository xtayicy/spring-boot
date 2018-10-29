package harry.spring.boot.data.jpa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import harry.spring.boot.data.jpa.entity.Rating;
import harry.spring.boot.data.jpa.entity.RatingCount;

/**
 * 
 * @author harry
 *
 */
public class ReviewsSummaryServiceImpl implements ReviewsSummaryService{
	private final Map<Rating, Long> ratingCount;

	ReviewsSummaryServiceImpl(List<RatingCount> ratingCounts) {
		this.ratingCount = new HashMap<>();
		for (RatingCount ratingCount : ratingCounts) {
			this.ratingCount.put(ratingCount.getRating(), ratingCount.getCount());
		}
	}

	@Override
	public long getNumberOfReviewsWithRating(Rating rating) {
		Long count = this.ratingCount.get(rating);
		return (count != null) ? count : 0;
	}

}
