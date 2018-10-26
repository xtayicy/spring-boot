package harry.spring.boot.aop;

import harry.spring.boot.aop.service.HelloService;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private HelloService helloService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.helloService.getHelloMessage());
	}
}
