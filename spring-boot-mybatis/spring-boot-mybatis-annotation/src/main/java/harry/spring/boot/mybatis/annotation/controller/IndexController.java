package harry.spring.boot.mybatis.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import harry.spring.boot.mybatis.annotation.entity.Student;
import harry.spring.boot.mybatis.annotation.service.api.StudentService;

@RestController
public class IndexController {
	@Autowired
    private StudentService studentService;
	
	@RequestMapping("/add")
	public String add(String no,String name,String sex) {
		studentService.add(new Student(no,name,sex));
		
		return "success";
	}
    
    @RequestMapping("/query")
    public Student queryStudentByNo(String no) {
        return this.studentService.queryStudentByNo(no);
    }
    
    @RequestMapping("/update")
	public String update(String no,String name,String sex) {
		studentService.update(new Student(no,name,sex));
		
		return "success";
	}
    
    @RequestMapping("/delete")
	public String delete(String no) {
		studentService.deleteByNo(no);
		
		return "success";
	}
}
