package harry.SpringBoot.start;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * @author harry
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContextLoadTest {
	@Test
	public void contextLoads() {
		System.out.println("hello");
	}
}
