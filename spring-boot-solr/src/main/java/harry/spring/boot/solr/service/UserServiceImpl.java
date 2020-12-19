package harry.spring.boot.solr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import harry.spring.boot.solr.entity.User;
import harry.spring.boot.solr.repository.UserRepository;
import harry.spring.boot.solr.service.api.UserService;

/**
 * 
 * @author Harry
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}
}
