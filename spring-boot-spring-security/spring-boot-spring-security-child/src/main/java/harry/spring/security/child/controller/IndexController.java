package harry.spring.security.child.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	@GetMapping("/hello")
    public String hello() {
        return "hello spring security";
    }
}
