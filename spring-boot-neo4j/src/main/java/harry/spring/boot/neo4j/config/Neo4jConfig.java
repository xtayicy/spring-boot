package harry.spring.boot.neo4j.config;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.AbstractNeo4jConfig;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * 
 * @author Harry
 *
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "harry.spring.boot.neo4j.repository")
//@EnableTransactionManagement
public class Neo4jConfig extends AbstractNeo4jConfig{
	
	@Bean
	public Neo4jTemplate neo4jTemplate(Driver driver){
		
		return new Neo4jTemplate(Neo4jClient.create(driver));
	}
	
	@Bean
	public Driver driver() {
		return GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "password"));
	}

	/*@Override
	@Bean
	protected DatabaseSelectionProvider databaseSelectionProvider() {
		return DatabaseSelectionProvider.createStaticDatabaseSelectionProvider("mysql");
	}*/
}
