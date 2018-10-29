package harry.spring.boot.data.jpa.repository;

import harry.spring.boot.data.jpa.entity.City;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

/**
 * 
 * @author harry
 *
 */
public interface CityRepository extends Repository<City, Long>{
	City findByNameAndCountryAllIgnoringCase(String name, String country);
	
	Page<City> findAll(Pageable pageable);
	
	Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name,
			String country, Pageable pageable);
}
