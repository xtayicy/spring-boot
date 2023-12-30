package harry.spring.boot.mybatis.plus;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import harry.spring.boot.mybatis.plus.dao.UserMapper;
import harry.spring.boot.mybatis.plus.entity.User;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
	@Autowired
    private UserMapper userMapper;
	
	@Test
    public void testInsert() {
        User user = new User().setUsername(UUID.randomUUID().toString())
                .setPassword("nicai").setCreateTime(new Date())
                .setDeleted(0); // 一般情况下，是否删除，可以全局枚举下。
        userMapper.insert(user);
    }
	
	@Test
    public void testUpdateById() {
        User updateUser = new User().setId(7)
                .setPassword("wobucai");
        userMapper.updateById(updateUser);
    }
	
	@Test
    public void testSelectById() {
        System.out.println(userMapper.selectById(7));
    }
	
	@Test
    public void testSelectByUsername() {
        System.out.println(userMapper.selectByUsername("1f3045d6-26c6-46ec-87d2-002918b53392"));
    }
}

