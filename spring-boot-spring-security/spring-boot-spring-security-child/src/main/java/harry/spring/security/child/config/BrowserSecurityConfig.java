package harry.spring.security.child.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import harry.spring.security.child.custom.password.UserDetailService;
import harry.spring.security.child.filter.SmsCodeFilter;
import harry.spring.security.child.filter.ValidateCodeFilter;
import harry.spring.security.child.handler.CustomAuthenticationAccessDeniedHandler;
import harry.spring.security.child.handler.CustomAuthenticationFailureHandler;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private ValidateCodeFilter validateCodeFilter;
	
	@Autowired
    private CustomAuthenticationFailureHandler authenticationFailureHandler;
	
	@Autowired
    private DataSource dataSource;
	
	@Autowired
    private UserDetailService userDetailService;
	
	@Autowired
    private SmsCodeFilter smsCodeFilter;
	
	@Autowired
    private SmsAuthenticationConfig smsAuthenticationConfig;
	
	@Autowired
    private CustomAuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.exceptionHandling()
        	.accessDeniedHandler(authenticationAccessDeniedHandler)
        	.and()
			.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class) // 添加验证码校验过滤器
			.addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class)
			.formLogin() // 表单登录
	        // http.httpBasic() // HTTP Basic
	        .loginPage("/login.html") 
	        .loginProcessingUrl("/login")
	        .failureHandler(authenticationFailureHandler) // 处理登录失败
	        .and()
	        .rememberMe()
            .tokenRepository(persistentTokenRepository()) // 配置 token 持久化仓库
            .tokenValiditySeconds(3600) // remember 过期时间，单为秒
            .userDetailsService(userDetailService) // 处理自动登录逻辑
            .and()
	        .authorizeRequests() // 授权配置
	        .antMatchers("/login.html","/css/login.css","/code/image","/code/sms").permitAll()
	        .anyRequest()  // 所有请求
	        .authenticated()
	        .and().csrf().disable()
	        .apply(smsAuthenticationConfig); // 将短信验证码认证配置加到 Spring Security 中 // 都需要认证
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        jdbcTokenRepository.setCreateTableOnStartup(false);
        return jdbcTokenRepository;
    }
}
