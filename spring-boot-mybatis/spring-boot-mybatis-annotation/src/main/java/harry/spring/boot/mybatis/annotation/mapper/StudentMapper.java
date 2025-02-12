package harry.spring.boot.mybatis.annotation.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import harry.spring.boot.mybatis.annotation.entity.Student;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;

@Mapper
public interface StudentMapper {
	@Insert("insert into student(no,name,sex) values(#{no},#{name},#{sex})")
    int add(Student student);
    
    @Update("update student set name=#{name},sex=#{sex} where no=#{no}")
    int update(Student student);
    
    @Delete("delete from student where no=#{no}")
    int deleteByNo(String no);
    
    @Select("select * from student where no=#{no}")
    @Results(id = "student",value= {
        @Result(property = "no", column = "no", javaType = String.class),
        @Result(property = "name", column = "name", javaType = String.class),
        @Result(property = "sex", column = "sex", javaType = String.class)
    })
    Student queryStudentByNo(String no);
}
