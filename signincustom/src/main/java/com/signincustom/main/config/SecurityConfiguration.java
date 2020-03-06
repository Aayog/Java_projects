package com.signincustom.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/static/**","/css/*").permitAll()
								.antMatchers("/index","/").hasRole("ADMIN")
								.anyRequest().authenticated()
								.and()
								.formLogin().loginPage("/login").permitAll()		
							    .defaultSuccessUrl("/dash",true)
								.and().rememberMe().rememberMeCookieName("my-info")
							    .tokenValiditySeconds(24 * 60 * 60);
		http.sessionManagement().maximumSessions(1);
	}

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("igctesting123@gmail.com").password(new BCryptPasswordEncoder().encode("12345")).roles("ADMIN");
	}

}
