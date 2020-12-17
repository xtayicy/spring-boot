package harry.spring.boot.neo4j.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import harry.spring.boot.neo4j.entity.User;

/**
 * 
 * @author Harry
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(@Param("username") String username);
}
