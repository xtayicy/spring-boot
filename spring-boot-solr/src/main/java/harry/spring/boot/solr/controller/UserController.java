package harry.spring.boot.solr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import harry.spring.boot.solr.entity.User;
import harry.spring.boot.solr.service.api.UserService;
import harry.spring.boot.solr.util.Md5Util;

/**
 * 
 * @author Harry
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	@ResponseBody
	public List<User> users(){
		List<User> users = userService.findAll();
		
		return users;
	}
	
	@RequestMapping("/{id}")
	@ResponseBody
	public User user(Model model,@PathVariable("id") Long id){
		
		return userService.findById(id);
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public void save(User user){
		user.setPassword(Md5Util.encode(user.getPassword()));
		userService.save(user);
	}
}
