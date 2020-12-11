package harry.spring.boot.webflux.configuration;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import harry.spring.boot.webflux.handler.Handler;

/**
 * 
 * @author Harry
 *O
 */
@Configuration
public class RoutingConfiguration {
	@Bean
	public RouterFunction<ServerResponse> monoRoutingFunction(Handler handler){
		
		return route(GET("/user/Harry").and(accept(APPLICATION_JSON)),handler::getUser);
	}
}