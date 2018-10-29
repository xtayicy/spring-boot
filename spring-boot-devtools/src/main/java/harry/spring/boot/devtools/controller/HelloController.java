package harry.spring.boot.devtools.controller;

import harry.spring.boot.devtools.constant.Message;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author harry
 *
 */
@Controller
public class HelloController {
	@PostConstruct
	public void slowRestart() throws InterruptedException {
		System.out.println("invoked");
		Thread.sleep(5000);
	}
	
	@GetMapping("/")
	public ModelAndView get(HttpSession session) {
		Object sessionVar = session.getAttribute("var");
		if (sessionVar == null) {
			sessionVar = new Date();
			session.setAttribute("var", sessionVar);
		}
		
		ModelMap model = new ModelMap("message", Message.MESSAGE)
				.addAttribute("sessionVar", sessionVar);
		
		return new ModelAndView("hello", model);
	}
}
