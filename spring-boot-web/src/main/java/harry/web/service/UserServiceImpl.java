package harry.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import harry.web.entity.User;
import harry.web.service.api.UserService;

/**
 * 
 * @author Harry
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Override
	public List<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<User>();
		User user_1 = new User("Harry","123");
		User user_2 = new User("Marry","456");
		users.add(user_1);
		users.add(user_2);
		
		return users;
	}
}
