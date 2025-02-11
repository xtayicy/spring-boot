package spring.boot.jdbc.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import harry.spring.boot.jdbc.template.Application;
import harry.spring.boot.jdbc.template.dao.api.UserDao;
import harry.spring.boot.jdbc.template.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
	@Autowired
	UserDao userDao;
	
	@Test
	public void testInsert() {
		User user = new User("Lisa");
		userDao.insertUser(user);
	}
	
	@Test
	public void testListAllUser(){
		for (User user : userDao.listAllUser()) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testQueryUser() {
		System.out.println(userDao.queryUserById(new User(5L)));
	}
	
	@Test
	public void testUpdateUser() {
		User user = userDao.queryUserById(new User(5L));
		user.setUsername("expired");
		userDao.updateUserById(user);
	}
	
	@Test
	public void testDeleteUser() {
		userDao.deleteUserById(new User(5L));
	}
}
