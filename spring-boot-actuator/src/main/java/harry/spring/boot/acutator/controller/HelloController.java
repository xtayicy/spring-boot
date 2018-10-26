package harry.spring.boot.acutator.controller;

import harry.spring.boot.acutator.service.HelloService;

import java.util.Collections;
import java.util.Map;

import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author harry
 *
 */
@Controller
@Description("A controller for handling requests for hello messages")
public class HelloController {
	private final HelloService helloService;

	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, String> hello() {

		return Collections.singletonMap("message",
				this.helloService.getHelloMessage());
	}

	@RequestMapping("/foo")
	@ResponseBody
	public String foo() {
		throw new IllegalArgumentException("Server error");
	}
}
