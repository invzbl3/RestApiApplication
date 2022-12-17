package com.test.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author invzbl3 on 12/16/2022
 * @project RestApiApplication
 */
@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication()
                .withUser("user").password("user").authorities("ROLE_USER")
                .and()
                .withUser("admin").password("admin").authorities("ROLE_USER","ROLE_ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/all").access("hasRole('ROLE_USER') " +
                        "or hasRole('ROLE_ADMIN')") // +
                .antMatchers("/find/{id}").access("hasRole('ROLE_USER')")
                // +- (it works, but restrictions on roles don't work properly)
                .antMatchers("/add").access("hasRole('ROLE_ADMIN')")
                // +- (it works, but restrictions on roles don't work properly)
                .antMatchers("/update/{id}").access("hasRole('ROLE_ADMIN')")
                // +- (it works, but restrictions on roles don't work properly)
                .antMatchers("/delete/{id}").access("hasRole('ROLE_ADMIN')")
                // +- (it works, but restrictions on roles don't work properly)
                .antMatchers("/homePage").access("hasRole('ROLE_USER') " +
                        "or hasRole('ROLE_ADMIN')")
                //
                .antMatchers("/userPage").access("hasRole('ROLE_USER')")
                //
                .antMatchers("/adminPage").access("hasRole('ROLE_ADMIN')")
                //
                .and()
                .csrf().disable()
                .formLogin().loginPage("/loginPage")
                .defaultSuccessUrl("/homePage")
                .failureUrl("/loginPage?error")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/loginPage?logout");
    }
}