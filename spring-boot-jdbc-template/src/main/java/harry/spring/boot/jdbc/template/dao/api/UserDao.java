package harry.spring.boot.jdbc.template.dao.api;

import java.util.List;

import harry.spring.boot.jdbc.template.entity.User;

public interface UserDao {
	public void insertUser(User user);
	
	public List<User> listAllUser();
	
	public User queryUserById(User user);
	
	public void updateUserById(User user);
	
	public void deleteUserById(User user);
}
