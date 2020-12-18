package harry.spring.boot.neo4j.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import harry.spring.boot.neo4j.entity.User;
import harry.spring.boot.neo4j.mapper.UserMapper;
import harry.spring.boot.neo4j.util.Md5Util;

/**
 * 
 * @author Harry
 *
 */
@RestController
public class UserController {
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/users")
	public List<User> users(){
		List<User> users = userMapper.getAllUser();
		
		return users;
	}
	
	@RequestMapping("/user/{username}")
	public User user(@PathVariable("username") String username){
		User user = userMapper.findByUsername(username);
		
		return user;
	}
	
	@RequestMapping("/save")
	public void save(User user){
		user.setPassword(Md5Util.encode(user.getPassword()));
		userMapper.save(user);
	}
}
