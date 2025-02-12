package spring.boot.mybatis.annotation.service.api;

import spring.boot.mybatis.annotation.entity.Student;

public interface StudentService {
	int add(Student student);
    int update(Student student);
    int deleteByNo(String no);
    Student queryStudentByNo(String no);
}
