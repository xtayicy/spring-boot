package harry.spring.boot.webflux.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.ServerResponse.BodyBuilder;

import harry.spring.boot.webflux.entity.User;
import reactor.core.publisher.Mono;

/**
 * 
 * @author Harry
 *
 */
@Component
public class Handler{
	public Mono<ServerResponse> getUser(ServerRequest request){
		Mono<User> user = request.bodyToMono(User.class);
		BodyBuilder ok = ServerResponse.ok();
		Mono<ServerResponse> syncBody = ok.syncBody(user);
		
		return syncBody;
	}
}
