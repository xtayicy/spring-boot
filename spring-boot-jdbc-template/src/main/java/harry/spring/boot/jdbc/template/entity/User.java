package harry.spring.boot.jdbc.template.entity;

public class User {
	public Long id;
	public String username;
	
	public User() {
		super();
	}
	
	public User(Long id) {
		super();
		this.id = id;
	}

	public User(String username) {
		super();
		this.username = username;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + "]";
	}
}
