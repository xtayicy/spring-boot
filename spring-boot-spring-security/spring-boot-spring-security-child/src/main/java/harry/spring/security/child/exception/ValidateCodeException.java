package harry.spring.security.child.exception;

import org.springframework.security.core.AuthenticationException;

public class ValidateCodeException extends AuthenticationException{

	public ValidateCodeException(String msg) {
		super(msg);
	}
	
}
