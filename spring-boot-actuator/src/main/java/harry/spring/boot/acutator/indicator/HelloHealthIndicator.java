package harry.spring.boot.acutator.indicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * 
 * @author harry
 *
 */
public class HelloHealthIndicator implements HealthIndicator {
	@Override
	public Health health() {
		System.out.println("HelloHealthIndicator->health");
		return Health.up().withDetail("counter", 42).build();
	}
}
