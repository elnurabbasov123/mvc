//package com.example.mvc.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SpringSecurityConfig {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    void authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
//         builder.jdbcAuthentication().dataSource(dataSource);
//    }
//}
