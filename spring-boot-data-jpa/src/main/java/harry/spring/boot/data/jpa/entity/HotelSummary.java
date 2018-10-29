package harry.spring.boot.data.jpa.entity;

/**
 * 
 * @author harry
 *
 */
public interface HotelSummary {

	City getCity();

	String getName();

	Double getAverageRating();

	default Integer getAverageRatingRounded() {
		return (getAverageRating() != null) ? (int) Math.round(getAverageRating()) : null;
	}

}
