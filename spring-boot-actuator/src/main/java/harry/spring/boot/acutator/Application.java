package harry.spring.boot.acutator;

import harry.spring.boot.acutator.property.ServiceProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Definition of Actuator
 * An actuator is a manufacturing term that refers to a mechanical device for moving or controlling
 * something. Actuators can generate a large amount of motion from a small change.
 * 
 * For security purposes, all actuators other than /health and /info are disabled by default. 
 * The management.endpoints.web.exposure.include property can be used to enable the actuators.
 * 
 * If Spring Security is on the classpath and no other WebSecurityConfigurerAdapter is present, 
 * all actuators other than /health and /info are secured by Spring Boot auto-configuration. 
 * If you define a custom WebSecurityConfigurerAdapter, 
 * Spring Boot auto-configuration will back off and you will be in full control of actuator access rules.
 * 
 *  Note
 *	Before setting the management.endpoints.web.exposure.include, 
 *	ensure that the exposed actuators do not contain sensitive information and/or are secured by placing them behind
 *	a firewall or by something like Spring Security.
 *
 *  Since Spring Boot relies on Spring Security’s defaults, 
 *  CSRF(Cross-Site-Request-Forgery) protection is turned on by default. 
 *  This means that the actuator endpoints that require a POST (shutdown and loggers endpoints), 
 *  PUT or DELETE will get a 403 forbidden error when the default security configuration is in use.
 *  
 *  Note
 *	We recommend disabling CSRF protection completely only if you are creating a service that is used by non-browser clients.
 *	Additional information about CSRF protection can be found in https://docs.spring.io/spring-security/site/docs/5.1.1.RELEASE/reference/htmlsingle/.
 * @author harry
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties.class)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
