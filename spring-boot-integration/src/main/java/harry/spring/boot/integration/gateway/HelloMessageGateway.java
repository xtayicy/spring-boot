package harry.spring.boot.integration.gateway;

import org.springframework.integration.annotation.MessagingGateway;

/**
 * 
 * @author harry
 *
 */
@MessagingGateway(defaultRequestChannel = "outputChannel")
public interface HelloMessageGateway {
	void echo(String message);
}
