package com.test.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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
                .withUser("user").password("user").authorities("ROLE_USER")
                .and()
                .withUser("admin").password("admin").authorities("ROLE_USER","ROLE_ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/all")
                .access("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')") // +
                .antMatchers("/find/{id}")
                .access("hasAuthority('ROLE_ADMIN')")
                // +- (it works, but restrictions on roles don't work properly)
                .antMatchers("/add")
                .access("hasAuthority('ROLE_ADMIN')")
                // +- (it works, but restrictions on roles don't work properly)
                .antMatchers("/update/{id}")
                .access("hasAuthority('ROLE_ADMIN')")
                // +- (it works, but restrictions on roles don't work properly)
                .antMatchers("/delete/{id}")
                .access("hasAuthority('ROLE_ADMIN')")
                // +- (it works, but restrictions on roles don't work properly)
                .antMatchers("/homePage")
                .access("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
                //
                .antMatchers("/userPage")
                .access("hasAuthority('ROLE_USER')")
                //
                .antMatchers("/adminPage")
                .access("hasAuthority('ROLE_ADMIN')")
                //
                .anyRequest()
                .authenticated()
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
                .loginPage("/loginPage")
                .defaultSuccessUrl("/homePage")
                .failureUrl("/loginPage?error")
                .usernameParameter("username")
                .passwordParameter("password");
    }
}