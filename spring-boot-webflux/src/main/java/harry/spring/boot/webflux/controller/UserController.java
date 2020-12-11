package harry.spring.boot.webflux.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Harry
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/{username}")
	public String getUser(@PathVariable String username){
		
		return username;
	}
}
