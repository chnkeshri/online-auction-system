//package com.example.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Value("${spring.security.user.name}")
//    private String username;
//
//    @Value("${spring.security.user.password}")
//    private String password;
//    
//    
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser(username)
//                .password(password)
//                ;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic()
//                .and()
//                .authorizeRequests()
//                    .anyRequest().authenticated() 
//                .and()
//                
//                .csrf().disable(); 
//    } 
//}