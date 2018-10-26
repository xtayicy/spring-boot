package harry.spring.boot.acutator.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * @author harry
 *
 */
@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
public class ServiceProperties {
	/**
	 * Name of the service.
	 */
	private String name = "World";

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
