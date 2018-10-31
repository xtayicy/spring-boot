package harry.spring.boot.jpa.repository;

import harry.spring.boot.jpa.entity.Tag;

import java.util.List;

/**
 * 
 * @author harry
 *
 */
public interface TagRepository {
	List<Tag> findAll();
}
