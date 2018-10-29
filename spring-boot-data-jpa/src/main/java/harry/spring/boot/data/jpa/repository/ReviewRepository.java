package harry.spring.boot.data.jpa.repository;

import harry.spring.boot.data.jpa.entity.Hotel;
import harry.spring.boot.data.jpa.entity.Review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

/**
 * 
 * @author harry
 *
 */
public interface ReviewRepository extends Repository<Review, Long> {
	Page<Review> findByHotel(Hotel hotel, Pageable pageable);

	Review findByHotelAndIndex(Hotel hotel, int index);

	Review save(Review review);
}
