package harry.spring.boot.mybatis.xml;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import harry.spring.boot.mybatis.xml.dao.UserMapper;
import harry.spring.boot.mybatis.xml.entity.User;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
	@Autowired
    private UserMapper userMapper;
	
	@Test
    public void testInsert() {
		User user = new User().setUsername(UUID.randomUUID().toString())
                .setPassword("nicai").setCreateTime(new Date());
        userMapper.insert(user);
    }
	
	@Test
    public void testUpdateById() {
        User updateUser = new User().setId(4)
                .setPassword("wobucai");
        userMapper.updateById(updateUser);
    }
	
	@Test
    public void testSelectById() {
        System.out.println(userMapper.selectById(4));
    }
	
	@Test
    public void testSelectByUsername() {
        System.out.println(userMapper.selectByUsername("0ae8ea7c-1738-40fb-a6f7-8b4c5d70c626"));
    }
	
	@Test
    public void testSelectByIds() {
        List<User> users = userMapper.selectByIds(Arrays.asList(4, 5));
        System.out.println("users：" + users.size());
    }
	
	@Test
    public void testDeleteById() {
        userMapper.deleteById(5);
    }
}

