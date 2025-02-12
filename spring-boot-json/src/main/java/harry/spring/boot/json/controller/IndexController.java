package harry.spring.boot.json.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import harry.spring.boot.json.entity.User;

@RestController
public class IndexController {
	@Autowired
	ObjectMapper mapper;
	
	@RequestMapping("/getUser")
	public User getUser() {
	    User user = new User();
	    user.setUserName("harry");
	    user.setBirthday(new Date());
	    
	    return user;
	}
	
	@RequestMapping("/serialization")
	public String serialization() {
	    try {
	        User user = new User();
	        user.setUserName("harry");
	        user.setBirthday(new Date());
	        String str = mapper.writeValueAsString(user);
	        
	        return str;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return null;
	}
	
	@RequestMapping("/readJsonString")
	public String readJsonString() {
	    try {
	        String json = "{\"name\":\"harry\",\"age\":30}";
	        JsonNode node = this.mapper.readTree(json);
	        String name = node.get("name").asText();
	        int age = node.get("age").asInt();
	        
	        return name + " " + age;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return null;
	}
	
	@RequestMapping("/readJsonAsObject")
	public String readJsonAsObject() {
	    try {
	        String json = "{\"userName\":\"harry\",\"age\":33}";
	        User user = mapper.readValue(json, User.class);
	        String name = user.getUserName();
	        int age = user.getAge();
	        
	        return name + " " + age;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return null;
	}
}
