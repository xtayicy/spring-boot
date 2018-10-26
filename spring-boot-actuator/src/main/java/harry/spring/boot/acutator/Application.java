package harry.spring.boot.acutator;

import harry.spring.boot.acutator.property.ServiceProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 
 * @author harry
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties.class)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
