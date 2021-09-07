package com.example.bdz.config;

import com.example.bdz.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author zhn
 * @Date 2021/9/3 21:00
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    LoginFailureHandler failureHandler;
    @Autowired
    LoginSuccessHandler successHandler;
    @Autowired
    UserLogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    CaptchaFilter captchaFilter;
    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    JwtAccessDeniedHandler jwtAccessDeniedHandler;
    @Autowired
    UserDetailServiceImpl detailService;
    @Bean
    JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        return new JwtAuthenticationFilter(authenticationManager());
    }
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    private static final String[] URL_WHITELIST={
            "/login",
            //"/logout",
            "/captcha",
            "/favicon.ico"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        //登录配置
        http.formLogin().successHandler(successHandler).failureHandler(failureHandler);
        //退出配置
        http.logout().logoutSuccessHandler(logoutSuccessHandler);
        //禁用session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //配置拦截规则
        http.authorizeRequests().antMatchers(URL_WHITELIST).permitAll().anyRequest().authenticated();
        //异常处理器
        http.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).accessDeniedHandler(jwtAccessDeniedHandler);
        //配置自定义过滤器
        http.addFilterBefore(captchaFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilter(jwtAuthenticationFilter());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detailService);
    }
}
