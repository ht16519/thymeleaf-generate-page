//package com.xh.security.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @Name SecurityConfig
// * @Description
// * @Author wen
// * @Date 2019-04-01
// */
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("css/**", "js/**", "fonts/**", "/index").permitAll()
//                .antMatchers("users/**").hasRole("ADMIN")
//                .and()
//                .formLogin()
//                .loginPage("/login").failureUrl("/login-error");
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
//    }
//}
