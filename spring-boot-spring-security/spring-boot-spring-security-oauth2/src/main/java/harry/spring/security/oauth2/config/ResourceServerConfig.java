package harry.spring.security.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import harry.spring.security.oauth2.filter.SmsCodeFilter;
import harry.spring.security.oauth2.handler.CustomAuthenticationFailureHandler;
import harry.spring.security.oauth2.handler.CustomAuthenticationSucessHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	@Autowired
    private CustomAuthenticationSucessHandler authenticationSucessHandler;
    @Autowired
    private CustomAuthenticationFailureHandler authenticationFailureHandler;
    
    @Autowired
    private SmsAuthenticationConfig smsAuthenticationConfig;
    
    @Autowired
    private SmsCodeFilter smsCodeFilter;
    
	@Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class) // 添加短信验证码校验过滤器
        	.formLogin() // 表单登录
                .loginProcessingUrl("/login") // 处理表单登录 URL
                .successHandler(authenticationSucessHandler) // 处理登录成功
                .failureHandler(authenticationFailureHandler) // 处理登录失败
            .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/code/sms").permitAll()
                .anyRequest()  // 所有请求
                .authenticated() // 都需要认证
            .and()
                .csrf().disable()
                .apply(smsAuthenticationConfig);;
    }
}
