package harry.spring.boot.integration.endpoint;

import harry.spring.boot.integration.service.HelloService;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.util.StreamUtils;

/**
 * http://www.infoq.com/cn/articles/microframeworks1-spring-boot
 * @author harry
 *
 */
@MessageEndpoint
public class HelloEndpoint {
	private final HelloService helloService;

	public HelloEndpoint(HelloService helloService) {
		this.helloService = helloService;
	}
	
	@ServiceActivator
	public String read(File input) throws Exception {
		System.out.println("HelloEndpoint->read");
		FileInputStream in = new FileInputStream(input);
		String name = new String(StreamUtils.copyToByteArray(in));
		in.close();
		
		return this.helloService.getHelloMessage(name);
	}
}
