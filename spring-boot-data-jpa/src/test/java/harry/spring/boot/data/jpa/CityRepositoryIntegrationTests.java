package harry.spring.boot.data.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import harry.spring.boot.data.jpa.entity.City;
import harry.spring.boot.data.jpa.repository.CityRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integration tests for {@link CityRepository}.
 *
 * @author harry
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRepositoryIntegrationTests {

	@Autowired
	CityRepository repository;
	
	@Test
	public void findsFirstPageOfCities() {
		Page<City> cities = this.repository.findAll(PageRequest.of(0, 10));
		assertThat(cities.getTotalElements()).isGreaterThan(20L);
	}

}
