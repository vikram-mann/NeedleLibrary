package org.needlelibrary.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class Auth extends WebSecurityConfigurerAdapter 
{
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		
		http.httpBasic().and().authorizeRequests()
			.antMatchers("/user/**").hasAnyAuthority("ADMIN", "LIBRARIAN", "USER")
			.antMatchers("/librarian/**").hasAuthority("LIBRARIAN")
			.antMatchers("/").permitAll()
			.and().formLogin();
		
		http
        .logout(logout -> logout                                            
            .logoutSuccessUrl("/")                        
            .invalidateHttpSession(true)                                 
        );


	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}

}
