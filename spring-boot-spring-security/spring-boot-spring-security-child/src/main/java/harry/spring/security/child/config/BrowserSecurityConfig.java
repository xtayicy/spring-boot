package harry.spring.security.child.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import harry.spring.security.child.filter.ValidateCodeFilter;
import harry.spring.security.child.handler.CustomAuthenticationFailureHandler;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private ValidateCodeFilter validateCodeFilter;
	
	@Autowired
    private CustomAuthenticationFailureHandler authenticationFailureHandler;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class) // 添加验证码校验过滤器
			.formLogin() // 表单登录
	        // http.httpBasic() // HTTP Basic
	        .loginPage("/login.html") 
	        .loginProcessingUrl("/login")
	        .failureHandler(authenticationFailureHandler) // 处理登录失败
	        .and()
	        .authorizeRequests() // 授权配置
	        .antMatchers("/login.html","/css/login.css","/code/image").permitAll()
	        .anyRequest()  // 所有请求
	        .authenticated()
	        .and().csrf().disable();; // 都需要认证
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
