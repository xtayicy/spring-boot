package harry.spring.boot.integration.service;

import harry.spring.boot.integration.properties.ServiceProperties;

import org.springframework.stereotype.Service;

/**
 * 
 * @author harry
 *
 */
@Service
public class HelloService {
	private final ServiceProperties configuration;

	public HelloService(ServiceProperties configuration) {
		this.configuration = configuration;
	}

	public String getHelloMessage(String name) {
		return this.configuration.getGreeting() + " " + name;
	}
}
