package harry.spring.boot.ant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author harry
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Spring Boot Ant Example");
	}
}
