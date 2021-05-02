package com.vaesco.springboot.backend.apirest.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/v1/clientes","/api/v1/busquedas/clientes/**","/api/v1/uploads/img/**").permitAll()
		.antMatchers(HttpMethod.GET,"/api/v1/clientes/**").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.POST,"/api/v1/clientes/upload").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.POST,"/api/v1/clientes").hasRole("ADMIN")
		.antMatchers("/api/v1/clientes/**").hasRole("ADMIN")
		.anyRequest().authenticated();
	}

	
	
}
