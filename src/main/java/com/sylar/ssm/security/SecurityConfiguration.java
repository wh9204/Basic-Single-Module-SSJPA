package com.sylar.ssm.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    /**
     * 配置user-detail服务
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth)throws Exception{
        // 基于内存的用户存储、认证
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN","USER")
                .and()
                .withUser("user").password("user").roles("USER");
    }

    /**
     * 拦截请求
     */
    @Override
    public void configure(HttpSecurity http)throws Exception{
        http.authorizeRequests()
                .antMatchers("/","/css/**","/js/**").permitAll()   //任何人都可以访问
                .antMatchers("/admin/**").access("hasRole('ADMIN')")     //持有user权限的用户可以访问
                .antMatchers("/user/**").hasAuthority("ROLE_USER")
                .and().formLogin()
                .loginPage("/login").usernameParameter("username").passwordParameter("password")
                .and().exceptionHandling().accessDeniedPage("/loginfail");
          }
    /**
     * 拦截请求
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {

    }

}
