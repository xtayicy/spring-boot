package harry.spring.boot.neo4j;

import org.junit.Test;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;

/**
 * 
 * @author Harry
 *
 */
@DataNeo4jTest
public class FuncTest {
	private Driver driver;
	
	@Test
	public void test() {
		driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "password"));
		Neo4jClient client = Neo4jClient.create(driver);
		Neo4jTemplate neo4jTemplate = new Neo4jTemplate(client);
		System.out.println(neo4jTemplate);
		//driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "password"));
		/*Neo4jClient client = Neo4jClient.create(driver);
		System.out.println(client);*/
		/*try (Session session = driver.session()) {
		    Result result = session.run("CREATE (n) RETURN n");
		    System.out.println(result.single().get(0));
		}*/
		
		driver.close();
	}
}
