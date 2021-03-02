package com.rafinha.webstats.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Rafał").password("{noop}password").roles("USER", "ADMIN")
                .and().withUser("user1").password("{noop}secret1").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and().authorizeRequests()
                .antMatchers("/teams/**").hasRole("USER")
                .antMatchers("/users/**").hasRole("USER")
                .antMatchers("/**").hasRole("ADMIN")
                .and().csrf().disable().headers().frameOptions().disable();
    }
}