package harry.spring.boot.neo4j;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Harry
 *
 */
@SpringBootApplication
public class Application implements ApplicationRunner{
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Application.run()");
	}
}
