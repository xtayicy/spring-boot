package harry.spring.boot.shiro.authentication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import harry.spring.boot.shiro.authentication.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testFindByUsername() {
		System.out.println(userMapper.findByUsername("harry"));
	}
}
