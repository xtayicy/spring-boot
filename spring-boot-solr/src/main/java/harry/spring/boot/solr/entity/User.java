package harry.spring.boot.solr.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * 
 * @author Harry
 *
 */
@SolrDocument(collection = "harry_new_core")
public class User {
	@Id
    @Indexed
	private Long id;
	
	@Indexed(name="username",type="string")
	private String username;
	
	@Indexed(name="password",type="string")
	private String password;

	public User(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}
