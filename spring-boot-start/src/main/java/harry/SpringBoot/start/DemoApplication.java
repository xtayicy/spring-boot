package harry.SpringBoot.start;

import harry.SpringBoot.start.config.UserConfig;
import harry.SpringBoot.start.entity.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  
 * @author harry
 *
 */
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
