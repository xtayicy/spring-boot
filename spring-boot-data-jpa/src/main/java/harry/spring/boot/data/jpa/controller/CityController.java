package harry.spring.boot.data.jpa.controller;

import harry.spring.boot.data.jpa.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author harry
 *
 */
@Controller
public class CityController {
	@Autowired
	private CityService cityService;
	
	@GetMapping("/")
	@ResponseBody
	@Transactional(readOnly = true)
	public String getCityName() {
		return this.cityService.getCity("Bath", "UK").getName();
	}
}
