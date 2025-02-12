package harry.spring.boot.redis.service.api;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import harry.spring.boot.redis.entity.Student;

@CacheConfig(cacheNames = "student")
public interface StudentService {
	int add(Student student);
	
	@CachePut(key = "#p0.no")
    Student update(Student student);
    
    @CacheEvict(key = "#p0", allEntries = true)
    void deleteByNo(String no);
    
    @Cacheable(key = "#p0")
    Student queryStudentByNo(String no);
}
