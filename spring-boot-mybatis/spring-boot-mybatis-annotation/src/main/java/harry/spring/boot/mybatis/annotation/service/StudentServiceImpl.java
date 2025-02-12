package harry.spring.boot.mybatis.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import harry.spring.boot.mybatis.annotation.entity.Student;
import harry.spring.boot.mybatis.annotation.mapper.StudentMapper;
import harry.spring.boot.mybatis.annotation.service.api.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentMapper studentMapper;

	@Override
	public int add(Student student) {
		return studentMapper.add(student);
	}

	@Override
	public int update(Student student) {
		return studentMapper.update(student);
	}

	@Override
	public int deleteByNo(String no) {
		return studentMapper.deleteByNo(no);
	}

	@Override
	public Student queryStudentByNo(String no) {
		return studentMapper.queryStudentByNo(no);
	}

}
