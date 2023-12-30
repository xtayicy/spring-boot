package harry.spring.boot.mybatis.xml.dao;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import harry.spring.boot.mybatis.xml.entity.User;

public interface UserMapper {
	int insert(User user);

    int updateById(User user);

    int deleteById(@Param("id") Integer id); // 生产请使用标记删除，除非有点想不开，嘿嘿。

    User selectById(@Param("id") Integer id);

    User selectByUsername(@Param("username") String username);

    List<User> selectByIds(@Param("ids")Collection<Integer> ids);
}

