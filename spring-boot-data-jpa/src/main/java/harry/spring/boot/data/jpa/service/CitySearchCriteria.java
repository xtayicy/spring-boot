package harry.spring.boot.data.jpa.service;

import java.io.Serializable;

/**
 * 
 * @author harry
 *
 */
import org.springframework.util.Assert;

/**
 * 
 * @author harry
 *
 */
public class CitySearchCriteria implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2056077658509885397L;
	private String name;

	public CitySearchCriteria() {
	}

	public CitySearchCriteria(String name) {
		Assert.notNull(name, "Name must not be null");
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
