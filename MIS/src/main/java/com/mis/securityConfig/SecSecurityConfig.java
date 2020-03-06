package com.mis.securityConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@ComponentScan("com.mis")
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	    http.csrf().disable()
	      .authorizeRequests()
	      .antMatchers("/sign-in").permitAll()
	      .anyRequest().authenticated()
	      .antMatchers("/dashboard").hasRole("ADMIN")
	      .and().formLogin().loginPage("/sign-in").successForwardUrl("/dashboard")
	      .failureUrl("/sign-in?error=true")
	      ;
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
          .withUser("sanlama").password("sanlama123").roles("ADMIN");
    }
}
