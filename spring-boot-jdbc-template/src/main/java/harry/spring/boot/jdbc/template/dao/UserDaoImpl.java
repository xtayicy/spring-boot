package harry.spring.boot.jdbc.template.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import harry.spring.boot.jdbc.template.dao.api.UserDao;
import harry.spring.boot.jdbc.template.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void insertUser(User user) {
		jdbcTemplate.update("insert user(username) values(?)",user.getUsername());
	}
	
}
