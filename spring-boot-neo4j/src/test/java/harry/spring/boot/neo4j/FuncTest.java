package harry.spring.boot.neo4j;

import java.io.IOException;

import org.junit.Test;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;

/**
 * 
 * @author Harry
 *
 */
@DataNeo4jTest
public class FuncTest {
	@Test
	public void sqlSessionFactory() throws IOException{
		/*SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("Mybatis-config.xml"));
		System.out.println(sqlSessionFactory);*/
	}
	
	@Test
	public void test() {
	}
}
