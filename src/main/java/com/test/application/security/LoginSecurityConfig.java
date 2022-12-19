package com.test.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author invzbl3 on 12/16/2022
 * @project RestApiApplication
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication()
                .withUser("user").password("user").password("{noop}user")
                .authorities("ROLE_USER")
                .and()
                .withUser("admin").roles("admin").password("{noop}admin")
                .authorities("ROLE_USER", "ROLE_ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/all").permitAll()
                .antMatchers(HttpMethod.GET, "/api/employee/find/**").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.POST, "/api/employee/add").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/employee/update/**").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/employee/delete/**").hasAuthority("ROLE_ADMIN")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/loginPage?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/api/page/loginPage")
                .defaultSuccessUrl("/homePage")
                .failureUrl("/api/page/loginPage?error")
                .usernameParameter("username")
                .passwordParameter("password");
    }
}