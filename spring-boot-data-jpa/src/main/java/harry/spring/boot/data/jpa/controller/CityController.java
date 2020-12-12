package harry.spring.boot.data.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import harry.spring.boot.data.jpa.service.CityService;

/**
 * 
 * @author harry
 *
 */
@RestController
public class CityController {
	@Autowired
	private CityService cityService;
	
	@GetMapping("/")
	//@Transactional(readOnly = true)
	public String getCityName() {
		return this.cityService.getCity("Bath", "UK").getName();
	}
}
