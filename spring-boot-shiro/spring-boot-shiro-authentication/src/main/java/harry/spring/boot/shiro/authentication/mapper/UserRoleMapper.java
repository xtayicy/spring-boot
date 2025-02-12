package harry.spring.boot.shiro.authentication.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import harry.spring.boot.shiro.authentication.entity.Role;

@Mapper
public interface UserRoleMapper {
	List<Role> findByUsername(String username);
}
