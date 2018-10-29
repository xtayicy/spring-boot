package harry.spring.boot.data.jpa.service;

import java.util.List;

import harry.spring.boot.data.jpa.entity.City;
import harry.spring.boot.data.jpa.entity.Hotel;
import harry.spring.boot.data.jpa.entity.RatingCount;
import harry.spring.boot.data.jpa.entity.Review;
import harry.spring.boot.data.jpa.entity.ReviewDetails;
import harry.spring.boot.data.jpa.repository.HotelRepository;
import harry.spring.boot.data.jpa.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * 
 * @author harry
 *
 */
@Service("hotelService")
@Transactional
public class HotelServiceImpl implements HotelService{
	private final HotelRepository hotelRepository;

	private final ReviewRepository reviewRepository;

	HotelServiceImpl(HotelRepository hotelRepository, ReviewRepository reviewRepository) {
		this.hotelRepository = hotelRepository;
		this.reviewRepository = reviewRepository;
	}

	@Override
	public Hotel getHotel(City city, String name) {
		Assert.notNull(city, "City must not be null");
		Assert.hasLength(name, "Name must not be empty");
		return this.hotelRepository.findByCityAndName(city, name);
	}

	@Override
	public Page<Review> getReviews(Hotel hotel, Pageable pageable) {
		Assert.notNull(hotel, "Hotel must not be null");
		return this.reviewRepository.findByHotel(hotel, pageable);
	}

	@Override
	public Review getReview(Hotel hotel, int reviewNumber) {
		Assert.notNull(hotel, "Hotel must not be null");
		return this.reviewRepository.findByHotelAndIndex(hotel, reviewNumber);
	}

	@Override
	public Review addReview(Hotel hotel, ReviewDetails details) {
		Review review = new Review(hotel, 1, details);
		return this.reviewRepository.save(review);
	}

	@Override
	public ReviewsSummaryService getReviewSummary(Hotel hotel) {
		List<RatingCount> ratingCounts = this.hotelRepository.findRatingCounts(hotel);
		return new ReviewsSummaryServiceImpl(ratingCounts);
	}

}
