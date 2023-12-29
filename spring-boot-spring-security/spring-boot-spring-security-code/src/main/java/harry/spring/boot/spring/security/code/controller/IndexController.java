package harry.spring.boot.spring.security.code.controller;

import javax.annotation.security.PermitAll;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {
	@PermitAll
	@RequestMapping("/echo")
	public String echo() {
		
		return "echo";
	}
	
	@RequestMapping("/home")
	public String home() {
		
		return "home";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/admin")
	public String admin() {
		
		return "admin";
	}
	
	@PreAuthorize("hasRole('ROLE_NORMAL')")
	@RequestMapping("/normal")
	public String normal() {
		
		return "normal";
	}
}

