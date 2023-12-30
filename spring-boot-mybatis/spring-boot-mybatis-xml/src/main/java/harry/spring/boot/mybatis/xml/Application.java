package harry.spring.boot.mybatis.xml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "harry.spring.boot.mybatis.xml.dao")
public class Application {

}
