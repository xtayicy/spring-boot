package harry.spring.boot.solr.repository;

import java.util.List;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import harry.spring.boot.solr.entity.User;

/**
 * 
 * @author Harry
 *
 */
public interface UserRepository extends SolrCrudRepository<User,Long>{
	@Query(value = "*:*")
    List<User> findAll();
}
