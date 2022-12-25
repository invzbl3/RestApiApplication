package com.test.application.web.config;

import com.test.application.data.config.AuthenticationSuccessHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author invzbl3 on 12/18/2022
 * @project RestApiApplication
 */
@Configuration
@EnableWebMvc
@ComponentScan
@EnableWebSecurity
@Order(1000)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    AuthenticationSuccessHandlerImpl successHandler;

    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
        dap.setUserDetailsService(userDetailsService);
        dap.setPasswordEncoder(new BCryptPasswordEncoder());

        return dap;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2-console/**",
                        "/",
                        "/**/*.css",
                        "/**/*.js").permitAll()
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/customer/**").access("hasRole('CUSTOMER')")
                .anyRequest().authenticated()
                .and().formLogin().successHandler(successHandler);
        http.logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true);
        http.headers().frameOptions().disable();
        http.csrf().disable();
    }
}