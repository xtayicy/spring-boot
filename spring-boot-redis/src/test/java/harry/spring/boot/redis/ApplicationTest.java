package harry.spring.boot.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import harry.spring.boot.redis.entity.Student;
import harry.spring.boot.redis.service.api.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
	@Autowired
    private StudentService studentService;
    
    @Test
    public void test() throws Exception {
    	Student student1 = this.studentService.queryStudentByNo("1");
        System.out.println("学号" + student1.getNo() + "的学生姓名为：" + student1.getName());
        
        student1.setName("harry");
        studentService.update(student1);
        
        Student student2 = this.studentService.queryStudentByNo("1");
        System.out.println("学号" + student2.getNo() + "的学生姓名为：" + student2.getName());
    }
}
