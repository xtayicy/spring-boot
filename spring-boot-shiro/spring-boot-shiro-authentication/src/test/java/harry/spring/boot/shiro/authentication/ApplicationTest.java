package harry.spring.boot.shiro.authentication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import harry.spring.boot.shiro.authentication.entity.Permission;
import harry.spring.boot.shiro.authentication.entity.Role;
import harry.spring.boot.shiro.authentication.mapper.UserMapper;
import harry.spring.boot.shiro.authentication.mapper.UserPermissionMapper;
import harry.spring.boot.shiro.authentication.mapper.UserRoleMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Autowired
	private UserPermissionMapper userPermissionMapper;
	
	@Test
	public void testUserFindByUsername() {
		System.out.println(userMapper.findByUsername("harry"));
	}
	
	@Test
	public void testFindRoleByUsername() {
		for (Role role : userRoleMapper.findByUsername("harry")) {
			System.out.println(role);
		}
	}
	
	@Test
	public void testFindPermissionByUsername() {
		for (Permission permission : userPermissionMapper.findByUsername("harry")) {
			System.out.println(permission);
		}
	}
}
