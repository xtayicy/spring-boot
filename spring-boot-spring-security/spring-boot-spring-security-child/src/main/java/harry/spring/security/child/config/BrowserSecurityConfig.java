package harry.spring.security.child.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.formLogin() // 表单登录
	        // http.httpBasic() // HTTP Basic
	        .loginPage("/login.html") 
	        .loginProcessingUrl("/login")
	        .and()
	        .authorizeRequests() // 授权配置
	        .antMatchers("/login.html","/css/login.css").permitAll()
	        .anyRequest()  // 所有请求
	        .authenticated()
	        .and().csrf().disable();; // 都需要认证
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
