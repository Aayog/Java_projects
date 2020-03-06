package com.mis.misfinal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Sandroid on 3/29/2018.
 */

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/static/**","/assets/**", "/bower_components/**", "/sign-up","/sign-in","/createAcount").permitAll()
                .antMatchers("/index","/").hasRole("ADMIN")
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/sign-in")
                .successForwardUrl("/index").failureUrl("/sign-in?error=true");

        http.logout()
                .logoutUrl("/log-out").logoutSuccessUrl("/sign-in?logout");

        /*http.exceptionHandling().accessDeniedPage("/403");*/
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("sanlama21@gmail.com").password(new BCryptPasswordEncoder().encode("sanlama"))
                .roles("ADMIN","USER")
                .and()
                .withUser("igctesting123@gmail.com").password(new BCryptPasswordEncoder().encode("12345"))
                .roles("USER");
    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }*/
}
