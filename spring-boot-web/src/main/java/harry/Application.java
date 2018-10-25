package harry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <code>@Configuration</code> tags the class as a source of bean definitions for the application context.
 * <code>@EnableAutoConfiguration</code> tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
 * <code>@ComponentScan</code> tells Spring to look for other components, configurations, and services in the harry package, allowing it to find the controllers.
 * @author harry
 *
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
