package harry.shiro.jwt.authentication;

import org.apache.shiro.authc.AuthenticationToken;

public class JWTToken implements AuthenticationToken{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String token;

    private String exipreAt;

	public JWTToken(String token) {
		super();
		this.token = token;
	}

	public JWTToken() {
		super();
	}

	@Override
	public Object getPrincipal() {
		return token;
	}

	@Override
	public Object getCredentials() {
		return token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getExipreAt() {
		return exipreAt;
	}

	public void setExipreAt(String exipreAt) {
		this.exipreAt = exipreAt;
	}
}
