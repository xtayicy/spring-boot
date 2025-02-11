package spring.boot.jdbc.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import harry.spring.boot.jdbc.template.Application;
import harry.spring.boot.jdbc.template.dao.api.UserDao;
import harry.spring.boot.jdbc.template.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
	@Autowired
	UserDao userDao;
	
	@Test
	public void test() {
		User user = new User();
		user.setUsername("marry");
		userDao.insertUser(user);
	}
}
