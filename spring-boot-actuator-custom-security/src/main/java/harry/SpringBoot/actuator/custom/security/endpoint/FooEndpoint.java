package harry.SpringBoot.actuator.custom.security.endpoint;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author harry
 *
 */
@Component
@RestControllerEndpoint(id = "foo")
public class FooEndpoint {
	@GetMapping("/foo")
	public ResponseEntity<String> echo(@RequestParam("text") String text) {
		return ResponseEntity.ok().header("foo", text).body(text);
	}
}
