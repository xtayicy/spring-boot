package harry.SpringBoot.actuator.custom.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 
 * @author harry
 *
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		return new InMemoryUserDetailsManager(User.withDefaultPasswordEncoder()
				.username("user").password("password").authorities("ROLE_USER")
				.build(), User.withDefaultPasswordEncoder().username("beans")
				.password("beans").authorities("ROLE_BEANS").build(), User
				.withDefaultPasswordEncoder().username("admin")
				.password("admin").authorities("ROLE_ACTUATOR", "ROLE_USER")
				.build());
	}
}
