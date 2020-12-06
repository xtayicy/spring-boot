package harry.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import harry.web.service.api.UserService;


/**
 * <code>@RestController</code> The class is flagged as a @RestController, meaning it’s ready for use by Spring MVC to handle web requests. 
 * @author harry
 *
 */
@RestController
@RequestMapping("/index")
public class IndexController {
	@Autowired
	private UserService userService;
	
	/**
	 * <code>@RequestMapping</code> maps / to the index() method. When invoked from a browser or using curl on the command line, the method returns pure text. 
	 * That's because <code>@RestController</code> combines <code>@Controller</code> and <code>@ResponseBody</code>, two annotations that results in web requests returning data rather than a view.
	 * @return
	 */
	@RequestMapping("/")
    public String index() {
		
        return "Greetings from Spring Boot!";
    }
	
	@RequestMapping("/users")
	public String users(){
		
		return userService.getAllUsers().toString();
	}
}
