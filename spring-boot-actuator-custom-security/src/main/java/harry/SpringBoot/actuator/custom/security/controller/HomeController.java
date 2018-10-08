package harry.SpringBoot.actuator.custom.security.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author harry
 *
 */
@Controller
public class HomeController {
	@GetMapping("/")
	public String home(Map<String, Object> model) {
		model.put("message", "Hello");
		model.put("title", "Hello Home");
		model.put("date", new Date());
		
		return "home";
	}
	
	@RequestMapping("/foo")
	public String foo() {
		throw new RuntimeException("Expected exception in controller");
	}
}
