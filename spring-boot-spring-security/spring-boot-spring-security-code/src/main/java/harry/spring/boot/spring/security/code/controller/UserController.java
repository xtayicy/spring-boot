package harry.spring.boot.spring.security.code.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/echo")
	public String echo(){
		
		return "echo";
	}
	
	@RequestMapping("/home")
	public String home(){
		
		return "home";
	}
	
	@RequestMapping("/admin")
	public String admin(){
		
		return "admin";
	}
	
	@RequestMapping("/normal")
	public String normal(){
		
		return "normal";
	}
}

