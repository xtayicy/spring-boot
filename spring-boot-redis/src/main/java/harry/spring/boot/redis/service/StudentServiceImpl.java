package harry.spring.boot.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import harry.spring.boot.redis.entity.Student;
import harry.spring.boot.redis.mapper.StudentMapper;
import harry.spring.boot.redis.service.api.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentMapper studentMapper;

	@Override
	public int add(Student student) {
		return studentMapper.add(student);
	}

	@Override
	public Student update(Student student) {
		studentMapper.update(student);
		return studentMapper.queryStudentByNo(student.getNo());
	}

	@Override
	public void deleteByNo(String no) {
		studentMapper.deleteByNo(no);
	}

	@Override
	public Student queryStudentByNo(String no) {
		return studentMapper.queryStudentByNo(no);
	}

}
