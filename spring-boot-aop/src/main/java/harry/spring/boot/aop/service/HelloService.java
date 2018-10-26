package harry.spring.boot.aop.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author harry
 *
 */
@Component
public class HelloService {
	@Value("${name}")
	private String name;
	
	public String getHelloMessage() {
		return "Hello " + this.name;
	}
}
