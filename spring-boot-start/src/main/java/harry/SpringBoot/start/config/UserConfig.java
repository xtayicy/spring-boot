package harry.SpringBoot.start.config;

import harry.SpringBoot.start.entity.User;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author harry
 *
 */
@Configuration
public class UserConfig {
	@Bean
	public User user(){
		return new User("tom","pwd");
	}
	
	/*public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(UserConfig.class);
		ctx.refresh();
		User user = ctx.getBean(User.class);
		System.out.println(user);
		ctx.close();
	}*/
}
