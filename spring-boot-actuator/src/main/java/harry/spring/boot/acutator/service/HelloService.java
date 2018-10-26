package harry.spring.boot.acutator.service;

import harry.spring.boot.acutator.property.ServiceProperties;

import org.springframework.stereotype.Component;

/**
 * 
 * @author harry
 *
 */
@Component
public class HelloService {
	private final ServiceProperties configuration;
	
	public HelloService(ServiceProperties configuration) {
		this.configuration = configuration;
	}

	public String getHelloMessage() {
		return "Hello " + this.configuration.getName();
	}
}
