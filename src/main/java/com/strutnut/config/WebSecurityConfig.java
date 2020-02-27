package com.strutnut.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭spring security自带的csrf
        http.csrf().disable().
                authorizeRequests().
                //预请求放行
                        antMatchers(HttpMethod.OPTIONS, "/**").permitAll().
                //来自以下方式的请求都需要通过权限检验
                        antMatchers(HttpMethod.GET).authenticated().
                antMatchers(HttpMethod.POST).authenticated().
                antMatchers(HttpMethod.DELETE).authenticated().
                antMatchers(HttpMethod.PUT).authenticated().and()
                //禁用spring security使用session认证的方式
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


    }
}
