package harry.spring.boot.shiro.authentication.mapper;

import org.apache.ibatis.annotations.Mapper;

import harry.spring.boot.shiro.authentication.entity.User;

@Mapper
public interface UserMapper {
	User findByUsername(String userName);
}
