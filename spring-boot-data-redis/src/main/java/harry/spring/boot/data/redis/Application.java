package harry.spring.boot.data.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * 
 * @author harry
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner{
	@Autowired
	private StringRedisTemplate template;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ValueOperations<String, String> ops = this.template.opsForValue();
		String key = "spring.boot.redis.test";
		if (!this.template.hasKey(key)) {
			ops.set(key, "foo");
		}
		
		System.out.println("Found key " + key + ", value=" + ops.get(key));
	}
}
