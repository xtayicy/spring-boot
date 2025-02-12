package harry.spring.boot.shiro.authentication.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import harry.spring.boot.shiro.authentication.entity.Permission;

@Mapper
public interface UserPermissionMapper {
	List<Permission> findByUsername(String username);
}
