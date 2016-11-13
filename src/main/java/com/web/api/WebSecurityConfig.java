package com.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * Created by xingding on 2016/9/16.
 */
@Configuration
@EnableWebSecurity //开启spring security功能
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**").antMatchers("/css/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //解决嵌入页面"Refused to display 'http://......' in a frame because it set 'X-Frame-Options' to 'DENY'.错误
        http.headers().frameOptions().disable();
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated() // 指定/不需要任何认证
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll();
    }

    /**
     * 在内存中创建一个用户
     * 用户名：user
     * 密码：password
     * 角色：user
     * @param builder
     * @throws Exception
     */
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication().withUser("user").password("password").roles("USER");
    }
}
