package harry.spring.boot.neo4j;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Harry
 *
 */
@SpringBootApplication
public class Application implements AutoCloseable {
	private Driver driver;

	public Application(String uri, String username, String password) {
		driver = GraphDatabase.driver(uri, AuthTokens.basic(username, password));
	}

	public static void main(String[] args) {
		Application application = new Application("bolt://localhost:7687", "neo4j", "neo4j");
		application.sendMsg("hello");
	}

	private void sendMsg(String msg) {
		System.out.println(driver.session());
		/*
		 * try (Session session = driver.session()) {
		 * 
		 * }
		 */
	}

	@Override
	public void close() throws Exception {
		driver.close();
	}
}
