package com.OnlineStore.OnlineStore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.OnlineStore.OnlineStore.services.JpaUserDetailsService;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	// Cuando se crea un usuario automaticamente el campo password se encripta
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
		build.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
	}
	// Definiendo que requiere autorizacion para acceder y que rol necesita
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/css/**", "/js/**", "/images/**").permitAll()
		.antMatchers("registrationForm").hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin().loginPage("/login")
		.permitAll().and().logout().permitAll();
	}
}
