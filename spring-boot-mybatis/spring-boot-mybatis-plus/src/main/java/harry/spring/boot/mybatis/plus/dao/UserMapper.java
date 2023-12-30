package harry.spring.boot.mybatis.plus.dao;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import harry.spring.boot.mybatis.plus.entity.User;

public interface UserMapper extends BaseMapper<User>{
	default User selectByUsername(@Param("username") String username) {
        return selectOne(new QueryWrapper<User>().eq("username", username));
    }
}
