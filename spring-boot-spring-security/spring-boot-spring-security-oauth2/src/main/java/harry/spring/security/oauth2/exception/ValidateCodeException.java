package harry.spring.security.oauth2.exception;

import org.springframework.security.core.AuthenticationException;

public class ValidateCodeException extends AuthenticationException{
	public ValidateCodeException(String msg) {
		super(msg);
	}
}
