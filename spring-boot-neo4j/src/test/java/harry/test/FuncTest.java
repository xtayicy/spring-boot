package harry.test;

import org.junit.Test;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.data.neo4j.core.Neo4jClient;

/**
 * 
 * @author Harry
 *
 */
public class FuncTest {
	@Test
	public void test() {
		Driver driver = GraphDatabase.driver("neo4j://localhost:7687", AuthTokens.basic("neo4j", "neo4j"));
		Neo4jClient client = Neo4jClient.create(driver);
		System.out.println(client);
	}
}
