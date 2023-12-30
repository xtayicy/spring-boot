package harry.spring.boot.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "harry.spring.boot.mybatis.plus.dao")
public class Application {

}
