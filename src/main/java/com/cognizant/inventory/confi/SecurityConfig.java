package com.cognizant.inventory.confi;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("cognizant").password("{noop}admin").authorities("ADMIN")
				.and()
				.withUser("purchaseAdmin").password("{noop}purchase").authorities("PURCHASEADMIN")
				.and()
				.withUser("salesAdmin").password("{noop}sales").authorities("SALESADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		 http.httpBasic().and().authorizeRequests()
			.antMatchers("/cognizant/purchase/**").hasAuthority("PURCHASEADMIN")
			.antMatchers("/cognizant/sales/**").hasAuthority("SALESADMIN")
			.antMatchers("/cognizant").hasAuthority("ADMIN")
			 .and().csrf().disable();
	}
}
