package harry.spring.boot.neo4j.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import harry.spring.boot.neo4j.entity.User;

/**
 * 
 * @author Harry
 *
 */
public interface UserMapper{
	@Select("match (u:user) return u.username as username,u.password as password")
	List<User> getAllUser();
	
	@Select("match (u:user{username:'${username}'}) return u.username as username,u.password as password")
	User findByUsername(@Param("username") String username);
	
	@Insert("create(u:user{username:'${user.username}',password:'${user.password}'})")
	void save(@Param("user") User user);
}
