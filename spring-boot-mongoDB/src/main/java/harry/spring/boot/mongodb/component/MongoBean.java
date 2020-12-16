package harry.spring.boot.mongodb.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Harry
 *
 */
@Component
public class MongoBean {
	private MongoTemplate mongoTemplate;
	
	@Autowired
	public MongoBean(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
}
