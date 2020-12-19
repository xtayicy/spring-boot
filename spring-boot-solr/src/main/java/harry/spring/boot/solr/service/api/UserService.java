package harry.spring.boot.solr.service.api;

import java.util.List;

import harry.spring.boot.solr.entity.User;

/**
 * 
 * @author Harry
 *
 */
public interface UserService{
	User findById(Long id);
	
	void save(User user);
	
	List<User> findAll();
}
