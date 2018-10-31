package harry.spring.boot.jpa.repository;

import harry.spring.boot.jpa.entity.Note;

import java.util.List;

/**
 * 
 * @author harry
 *
 */
public interface NoteRepository {
	List<Note> findAll();
}
