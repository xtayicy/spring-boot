package harry.spring.security.sso.application.two.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	@RequestMapping("/hello")
	public String hello() {
		
		return "hello2";
	}
}
