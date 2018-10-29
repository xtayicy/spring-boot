package harry.spring.boot.data.rest.repository;

import harry.spring.boot.data.rest.entity.City;
import harry.spring.boot.data.rest.entity.Hotel;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * 
 * @author harry
 *
 */
@RepositoryRestResource(collectionResourceRel = "hotels", path = "hotels")
public interface HotelRepository extends PagingAndSortingRepository<Hotel, Long>{
	Hotel findByCityAndName(City city, String name);
}
