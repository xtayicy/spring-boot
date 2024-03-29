package harry.spring.boot.jpa.repository;

import harry.spring.boot.jpa.entity.Tag;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author harry
 *
 */
@Repository
public class JpaTagRepository implements TagRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Tag> findAll() {
		return this.entityManager.createQuery("SELECT t FROM Tag t", Tag.class)
				.getResultList();
	}
	
}
