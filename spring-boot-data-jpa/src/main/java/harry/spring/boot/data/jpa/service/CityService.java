package harry.spring.boot.data.jpa.service;

import harry.spring.boot.data.jpa.entity.City;
import harry.spring.boot.data.jpa.entity.HotelSummary;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author harry
 *
 */
public interface CityService {
	City getCity(String name, String country);
	
	Page<City> findCities(CitySearchCriteria criteria, Pageable pageable);
	
	Page<HotelSummary> getHotels(City city, Pageable pageable);
}
