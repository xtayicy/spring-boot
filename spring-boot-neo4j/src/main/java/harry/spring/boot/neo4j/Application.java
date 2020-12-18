package harry.spring.boot.neo4j;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Harry
 *
 */
@MapperScan("harry.spring.boot.neo4j.mapper")
@SpringBootApplication
public class Application{
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
}