package harry.spring.boot.acutator.contributor;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * http://localhost:8080/actuator/info
 * @author harry
 *
 */
@Component
public class HelloInfoContributor implements InfoContributor {
	@Override
	public void contribute(Builder builder) {
		System.out.println("HelloInfoContributor->contribute");
		builder.withDetail("example", Collections.singletonMap("someKey", "someValue"));
	}
}
