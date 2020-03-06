package com.myshowbooking.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.myshowbooking.main.userservice.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserService userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/static/**","/css/*","/img/**","/js/*","/login").permitAll()
								.antMatchers("/dash").hasRole("ADMIN")
								.antMatchers("/","/index").anonymous()
								.anyRequest().authenticated()
								.and()
								.formLogin().loginPage("/login").permitAll()
								.successHandler(loginSuccessHandler())
								.failureHandler(loginFailureHandler())
							    .and()
							    .logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout");		
	}

	protected AuthenticationFailureHandler loginFailureHandler() {
		return (request,response,authentication)->response.sendRedirect("/login?error=true");
	}

	protected AuthenticationSuccessHandler loginSuccessHandler() {
		
		return (request,response,authentication)->response.sendRedirect("/dash");
	}

	@Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

}
