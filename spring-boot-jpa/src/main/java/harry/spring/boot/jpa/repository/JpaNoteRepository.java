package harry.spring.boot.jpa.repository;

import harry.spring.boot.jpa.entity.Note;

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
public class JpaNoteRepository implements NoteRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Note> findAll() {
		return this.entityManager.createQuery("SELECT n FROM Note n", Note.class)
				.getResultList();
	}

}
