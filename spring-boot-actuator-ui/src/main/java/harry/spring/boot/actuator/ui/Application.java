package harry.spring.boot.actuator.ui;

import java.util.Date;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author harry
 *
 */
@SpringBootApplication
@Controller
public class Application {
	@GetMapping("/")
	public String home(Map<String, Object> model) {
		model.put("message", "Hello harry");
		model.put("title", "Hello Home");
		model.put("date", new Date());
		
		return "home";
	}
	
	@RequestMapping("/foo")
	public String foo() {
		throw new RuntimeException("Expected exception in controller");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
