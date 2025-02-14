package harry.spring.security.oauth2.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	@RequestMapping("/hello")
	public String hello() {
		
		return "hello";
	}
	
	@GetMapping("/index")
    public Object index(Authentication authentication){
        return authentication;
    }
}
