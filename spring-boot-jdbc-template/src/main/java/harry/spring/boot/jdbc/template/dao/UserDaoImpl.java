package harry.spring.boot.jdbc.template.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

	@Override
	public List<User> listAllUser() {
		List<User> list = jdbcTemplate.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                String id = rs.getString("id");
                String username = rs.getString("username");
                user.setId(Long.valueOf(id));
                user.setUsername(username);

                return user;
            }
        });

		return list;
	}

	@Override
	public void updateUserById(User user) {
		jdbcTemplate.update("update user set username=? where id=?", user.getUsername(),user.getId() );
	}

	@Override
	public User queryUserById(User user) {
		
		return jdbcTemplate.queryForObject("select * from user where id = ?", new BeanPropertyRowMapper<User>(User.class), user.getId());
	}

	@Override
	public void deleteUserById(User user) {
		jdbcTemplate.update("delete from user where id=?", user.getId());
	}
	
}
